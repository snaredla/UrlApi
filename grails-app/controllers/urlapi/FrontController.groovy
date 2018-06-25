package urlapi
import grails.converters.JSON 
class FrontController {
    def urlProcessService
    /*
     * Render the gsp page to capture user i/p
     */
    def index() { }  
   
    /*
     * method to call service to get the result from the api
     */
    def processUrl(){
        def result = [operationStatus : "fail", responseData: null]
        if(!params.type || !params.url) {   
            render result as JSON
            return
        }
        try{
            def responseData = urlProcessService.processUrl(params.url,params.type)           
            if(responseData.status){
                result.operationStatus = "success"              
                result.responseData = responseData.resData
            }else{  
                result.errdata=responseData
                result.responseData = "Failed to get Info for URL: ${params.url}, try after some time"
            }
			
        }catch(Exception e){        
            result.errdata=responseData
            result.responseData = "Failed to get Info for URL: ${params.url}, try after some time"
        }
		
        render result as JSON
    }
}
