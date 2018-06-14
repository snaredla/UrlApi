$(document).ready(function() {
    $("#error-container").addClass('hidden');
    $("#data-container").addClass('hidden');
    $(".btn-sub").click(function(e) {      
        e.preventDefault();
        var _url = $("#urlInput").val(),_type=this.id;        
        if (!_url)
            showErrorUrl();
        else
            getUrlInfo(_url,_type);
    });
});

function getUrlInfo(_url,_type) {    
    $.getJSON("./front/processUrl?url="+_url+"&type="+_type, function(data) {        
        if (data.operationStatus   == "success") {
           showData(data.responseData);
        } else {
            showError(data.responseData);
        }
    });
}


function showData(responseData) {
    $("#urlInput").val("");
    $("#error-container").addClass('hidden');
    $("#data-container").removeClass('hidden');
    $("#data-container-footer").removeClass('hidden');
    $("#_shortUrl").html(responseData.shortUrl);
    $("#_longUrl").html(responseData.longUrl);
    
    
}


function showError(responseData) {
    $("#urlInput").val("");
    $("#data-container").addClass('hidden');
    $("#error-container").removeClass('hidden');
    $("#error-message").html(responseData);
}
function showErrorUrl() {
    $("#urlInput").val("");
    $("#data-container").addClass('hidden');
    $("#error-container").removeClass('hidden');
    $("#error-message").html("Please enter a valid URL ");
}