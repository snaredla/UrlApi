<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>URL API</title>
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- bootstrap library -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/appUrl.js"></script>
    </head>
    <body style="margin-top: 28px;">

        <div class="container-fluid"  >
            <div class="row" >
                <div class="col-md-12" style="color:#ff9800;margin-bottom: 50px;">
                    <h3>Enter URL </h3>
                    <div class="input-group" style="margin-top: 28px;">
                        <div class="col-md6" style="margin-bottom: 50px;">
                            <input type="text" class="form-control" id="urlInput" />
                        </div>
                        <div class="col-md6" style="margin-top: 2px;">
                            <span class="input-group-btn" style="width:0;">
                                <button id="longUrl" type="button" class="btn btn-primary btn-sub" style="background-color: #ff9800;" >Shorten a long URL</button>
                            </span>
                            <span class="input-group-btn" style="width:0;">
                                <button id="shortUrl" type="button" class="btn btn-primary btn-sub" style="background-color: #ff9800;margin-left: 10px;" >Expand a short URL</button>
                            </span>
                        </div>
                    </div>
                </div>
                <div id="error-container" class="col-md-8">
                    <div class="alert alert-dismissable alert-danger"  contenteditable="true">
                    <h4>Alert!</h4>
                    <span id="error-message"></span>                   
                </div>              
            </div>

            <div id="data-container" class="col-md-8 hidden" style="border: 3px solid #FF9800;margin-left: 14px;">  
                <div class="main-data">
                    <div class="data-head" style="width: 75%; float: left;">
                        <h4>Short Url: <span id="_shortUrl"></span></h4>
                        <h4>Long Url: <span id="_longUrl"></span></h4>
                        </div>               
                </div>      
            </div>
        </div>
    </body>

</html>
