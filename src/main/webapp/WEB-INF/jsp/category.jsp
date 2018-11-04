<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous">
    <style>
        body {
            font-family: 'Raleway', sans-serif;
        }
        button {
        	cursor : pointer;
        	background-color: white;
        	border: 0px;
        	outline:none !important;
        }

        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            color: hsla(0,0%,100%,.75);
            background-color: #24292e;
            text-align: center;
            padding-top:11px;
            padding-bottom:11px;
        }
    </style>
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
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                	<form action="/admin/seller" method="GET">
                    	<button type="submit" class="nav-link">Sellers</a>
                	</form>
                </li>
                <li class="nav-item">
                	<form action="/admin/product" method="GET">
                    	<button type="submit" class="nav-link">Products</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/admin/category" method="GET">
						<button type="submit" class="nav-link">Category</button>
					</form>
                </li>
            </ul>
            <form action="/admin/logout" method="POST">
            <button type="submit">
                signout
                <i class="fas fa-sign-out-alt"></i>
            </button>
            </form>
        </div>
    </nav>
	
	 <div class="container">

        <div class="row">
            <div class="col-md-8">
            	<table class="table">
			      <tr>
			        <th>id</th>
			        <th>Name</th>
			        <th>Edit</th>
			      </tr>
      				<c:forEach items="${categories}" var="category">
			        <tr>
			          <td>${category.id}</td>
			          <td>${category.name}</td>
			          <td><button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal"><i class="far fa-edit"></i></button></td>
			        </tr>
			        
			        
			         <!-- Modal -->
					  <div class="modal fade" id="myModal" role="dialog">
					    <div class="modal-dialog modal-sm">
					      <div class="modal-content">
					        <div class="modal-header">
					        Edit
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					        </div>
					        <div class="modal-body">
					        <form action="category/edit/${category.id}" method="POST">
  								<div class="form-group">
						          <label>Name</label>
						          <input type="text" value="${category.name}" name="name" class="form-control">
						          <button type="submit" class="btn btn-primary">Submit</button>
					          	</div>
					         </form> 
					        </div>
					        <div class="modal-footer">
					          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					        </div>
					      </div>
					    </div>
					  </div>
			      </c:forEach>
			    </table>
            </div>
            <div class="col-md-4">
            </div>
        </div>
    
    <div class="footer">
         Made with <i class="fas fa-heart"></i>
    </div>
  	
</body>

</html>