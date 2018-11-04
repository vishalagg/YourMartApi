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
            			<td><b>Id</b></td>
            			<td>:  ${seller.id}</td>
            		</tr>
            		<tr>
            			<td><b>Name</b></td>
            			<td>:  ${seller.ownerName}</td>
            		</tr>
            		<tr>
            			<td><b>Company</b></td>
            			<td>:  ${seller.companyName}</td>
            		</tr>
            		<tr>
            			<td><b>Status</b></td>
            			<td> 
            				:  <c:if test="${seller.statusId==1}">NEED APPROVAL</c:if>
                               <c:if test="${seller.statusId==2}">APPROVED</c:if>
                               <c:if test="${seller.statusId==3}">REJECTED</c:if>
            			</td>
            		</tr>
            		<tr>
            			<td><b>Email</b></td>
            			<td>:  ${seller.email}</td>
            		</tr>
            		<tr>
            			<td><b>GST Number</b></td>
            			<td>:  ${seller.gstNumber}</td>
            		</tr>
            		<tr>
            			<td><b>Contact No.</b></td>
            			<td>:  ${seller.phone}</td>
            		</tr>
            		<tr>
            			<td><b>Address</b></td>
            			<td>:  ${seller.address}</td>
            		</tr>
            		
            	</table>
            
            </div>
        
        <div class="col-md-4">
        	<div style="padding-top:30px;">
        	<form action="/admin/seller/${sellerId}">
        		<div class="input-group mb-3">
  					<div class="input-group-prepend">
  					  <label class="input-group-text" for="inputGroupSelect01">Status</label>
  					</div>
 					<select class="custom-select" id="inputGroupSelect01" name="status">
 					    <option value="1">NEED APPROVAL</option>
    					<option value="2">APPROVED</option>
   						<option value="3">REJECT</option>
				   </select>
				</div>
				<input type="submit" value="submit" class="btn">
				</form>
        	</div>
        </div>
   </div> 
   
   </div>    
	
  
  	
</body>

</html>