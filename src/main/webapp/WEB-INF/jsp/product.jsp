<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Page Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>

<body>

  <form action="/admin/product" method="POST">
    <table border="1">
      <tr>
        <th>id</th>
        <th>Code</th>
        <th>Name</th>
        <th>mrp</th>
        <th>ssp</th>
        <th>ymp</th>
        <th>createdAt</th>
        <th>updatedAt</th>
        <th>SellerId</th>
        <th>SellerCompanyName</th>
        <th>Category</th>
        <th>Status</th>
      </tr>
      <c:forEach items="${products}" var="product">
        <tr>
          <td>${product.id}</td>
          <td>${product.code}</td>
          <td>${product.name}</td>
          <td>${product.mrp}</td>
          <td>${product.ssp}</td>
          <td>${product.ymp}</td>
          <td>${product.createdAt}</td>
          <td>${product.updatedAt}</td>
          <td>${product.seller.id}</td>
          <td>${product.seller.companyName}</td>
          <td>${product.category.name}</td>
          <td>${product.status}</td>
          <td>
          <c:if test="${product.status==1}">
            <input type="checkbox" name="cbox" value="${product.id}">
          </c:if>
          </td>
          <td>
            <a href="product/${product.id}">Details</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    <input type="submit" value="Approve">
  </form>
  
    <form action="/admin/product" method="GET">
    	<h3>Search by</h3>
	  	<input type="radio" name="searchKey" value="code" ${codeChecked}/>Code <br />
	  	<input type="radio" name="searchKey" value="name" ${nameChecked}/>Name <br />
	  	<input type="radio" name="searchKey" value="id" ${idChecked}/>Id <br />
	  	
	  	serach here:
	  	<input type="text" name="searchQuery" value="${searchQuery}">
	  	
	  	
	  	<div class="input-group mb-3">
  			<div class="input-group-prepend">
  	   	    	<label class="input-group-text" for="inputGroupSelect01">Options</label>
 			</div>
		    <select class="custom-select" id="inputGroupSelect01" name="sellerId">
    			<option value="null">Choose seller id..</option>
    			<c:forEach items="${sellerIds}" var="sellerId">
   					<option value="${sellerId}">${sellerId}</option>
   				</c:forEach>
  			</select>
	    </div>
	  	
	  	<div class="input-group mb-3">
  			<div class="input-group-prepend">
  	   	    	<label class="input-group-text" for="inputGroupSelect01">Options</label>
 			</div>
		    <select class="custom-select" id="inputGroupSelect01" name="sellerCompanyName">
    			<option value="null">Choose Company name..</option>
    			<c:forEach items="${sellerCompanyNames}" var="sellerCompanyName">
   					<option value="${sellerCompanyName}">${sellerCompanyName}</option>
   				</c:forEach>
  			</select>
	    </div>
	    
	    <div class="input-group mb-3">
  			<div class="input-group-prepend">
  	   	    	<label class="input-group-text" for="inputGroupSelect01">Options</label>
 			</div>
		    <select class="custom-select" id="inputGroupSelect01" name="category">
    			<option value="null">Choose Category..</option>
    			<c:forEach items="${categories}" var="category">
   					<option value="${category.name}">${category.name}</option>
   				</c:forEach>
  			</select>
	    </div>
	  	
	  	
	  	<h3>Choose status:</h3>
	  	<input type="radio" name="status" value="NEW" ${newChecked}/>NEW <br />
	  	<input type="radio" name="status" value="APPROVED" ${approvedChecked}/>APPROVED<br />
	  	<input type="radio" name="status" value="REVIEW" ${reviewChecked}/>REVIEW<br />
	  	<input type="radio" name="status" value="REJECTED" ${rejectedChecked}/>REJECTED <br />
	  	
	  	<h3>Sort By</h3>
	  	<input type="radio" name="sortBy" value="mrp" ${mrpChecked}/>MRP<br />
	  	<input type="radio" name="sortBy" value="ssp" ${sspChecked}/>SSP<br />
	  	<input type="radio" name="sortBy" value="ymp" ${ympChecked}/>YMP<br />
	  	<input type="radio" name="sortBy" value="createdAt" ${createdAtChecked}/>Created At<br />
	  	<input type="radio" name="sortBy" value="updatedAt" ${updatedAtChecked}/>Updated At<br />
		
		<input type="submit" value="pessMe">
 	 </form>
  	
</body>

</html>