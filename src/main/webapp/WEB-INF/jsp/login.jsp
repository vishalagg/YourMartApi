<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
    <script src='https://www.google.com/recaptcha/api.js'></script>
    
</head>
<body>
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