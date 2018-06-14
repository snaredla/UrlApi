package urlapi

import grails.transaction.Transactional
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.ContentType
import static groovyx.net.http.Method.*
import grails.converters.JSON 

@Transactional
class UrlProcessService {
    /*
     * Initializing constant parameters
     */
    def apiUrl='https://www.googleapis.com'
    def apiPath= '/urlshortener/v1/url'
    def apiKey='AIzaSyBzKPazZRVDCZHrDU6_NpdXbM1hACuz3_I'
    
    /*
     * Single Method to by pass the requests for Post and Get
     * It accepts url and type and return the results, before by passing the req it will validate in current db
     */
    
    def processUrl(String _url,String _type) { 
        def data=[success : false, shortUrl: null,longUrl:null]        
        def entry=UrlEntry.createCriteria().get(){   //verifieng whether given url is exist in db
            eq("${_type}",_url)
        }
       
        if(!entry){
            if(_type=="longUrl")
            data= postRequest(_url)  
            if(_type=="shortUrl")
            data= getRequest(_url)          
            if(data.status){
                def urlInstance=new UrlEntry(data.resData)
                urlInstance.save(flush:true)               
            }
        }
        else{
            data.resData=[shortUrl:entry.shortUrl,longUrl:entry.longUrl]                  
            data.status=true           
        }
        return data
    }
    
    /*
     * Method to get the shorten url for given longUrl
     * It tkes longUrl and return the corresponding shortUrl along with the status
     */
    def postRequest(String _url){ 
        def data=[:]
        try{  
            def http = new HTTPBuilder( apiUrl )
            http.request(POST) {
                uri.path =apiPath
            
                data.resData=    uri.query = [ key:apiKey]    
                requestContentType = ContentType.JSON                
                body=[ longUrl: _url]
                response.success = { resp, res ->
                    data.resData=[shortUrl:res.id,longUrl:res.longUrl]                         
                    data.status=true    
                }
                response.failure = { resp, res -> 
                    data.resData=res
                    data.status=false    
                }
            }
        }
        catch(e){           
            data.resData=e.getMessage()
             data.status=false   
        }
       
        return data
    }
    
    /*
     * Method to get the longUrl url for given shortUrl
     * It accepts shortUrl and return the corresponding longUrl along owth the status
     */
    def getRequest(String _url){
        def data=[:]
        try{
            def http = new HTTPBuilder( apiUrl )
            http.request(GET) {
                uri.path = apiPath
                uri.query = [ key:apiKey, shortUrl: _url ]            
                response.success = { resp, res ->
                    data.resData=[shortUrl:res.id,longUrl:res.longUrl]                    
                    data.status=true    
                }
                response.failure = { resp, res ->  
                    data.resData=res 
                    data.status=false    
                }
            }
        }
        catch(e){              
            data.resData=e.getMessage()
             data.status=false   
        }
        return data
    }
}

