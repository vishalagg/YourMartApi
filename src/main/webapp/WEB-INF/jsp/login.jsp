<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous">
    <style>
        body {
            font-family: 'Raleway', sans-serif;
        }

        button {
            cursor: pointer;
            background-color: white;
            border: 0px;
            outline: none !important;
        }

        .hide {
            position: fixed;
            visibility: hidden;
            margin-left: 200px;
        }

        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            color: hsla(0, 0%, 100%, .75);
            background-color: #24292e;
            text-align: center;
            padding-top: 11px;
            padding-bottom: 11px;
        }
    </style>
    <script src='https://www.google.com/recaptcha/api.js'></script>
    
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light" style="box-shadow: 1px 1px #888888c5;padding-bottom: 1px;padding-top:2px;">

        <!-- <a class="navbar-brand" href="#">myMart</a> -->
        <a class="navbar-brand" href="#">
            <img src="https://images.all-free-download.com/images/graphiclarge/shopping_cart_vector_graphics_558084.jpg" width="45" height="30"
                alt="mart">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Admin Panel
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
        </div>
    </nav>
	

    <div class="container">
            ${logInError}
        <form action=""/admin/login"" method="POST">        	
            <div class="form-group">
              <label>Email address</label>
              <input type="text" class="form-control" placeholder="Enter username" name="username">
            </div>
            <div class="form-group">
              <label>Password</label>
              <input type="password" class="form-control" placeholder="Password" name="password">
            </div>
            <div class="g-recaptcha" data-sitekey="6LeJpHgUAAAAALwNMJlQc8AlJRFVRdAeJ211puxd"></div>
            <button type="submit" class="btn btn-primary">Submit</button>
            
          </form>
    </div>
    <div class="footer">
         Made with <i class="fas fa-heart"></i>
    </div>
</body>
</html>