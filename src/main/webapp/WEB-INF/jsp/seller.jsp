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

  <form action="/admin/seller" method="POST">
    <table border="1">
      <tr>
        <th>id</th>
        <th>Company Name</th>
        <th>Owner Name</th>
        <th>Status</th>
        <th></th>
        <th></th>
      </tr>
      <c:forEach items="${sellers}" var="seller">
        <tr>
          <td>${seller.id}</td>
          <td>${seller.companyName}</td>
          <td>${seller.ownerName}</td>
          <td>${seller.statusId}</td>
          <td>
          <c:if test="${seller.statusId==1}">
            <input type="checkbox" name="cbox" value="${seller.id}">
          </c:if>
          </td>
          <td>
            <a href="seller/details">Details</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    <input type="submit" value="Approve">
  </form>
  
	 
	
    
  
    <form action="/admin/seller" method="GET">
    	<h3>Search by</h3>
	  	<input type="radio" name="searchKey" value="COMPANY_NAME" ${companyChecked}/>Company Name <br />
	  	<input type="radio" name="searchKey" value="OWNER_NAME" ${ownerChecked}/>Owner Name <br />
	  	<input type="radio" name="searchKey" value="PHONE" ${phoneChecked}/>Phone Number <br />
	  	
	  	serach here:
	  	<input type="text" name="searchQuery" value="${searchQuery}">
	  	
	  	<h3>Choose status:</h3>
	  	<input type="radio" name="status" value="NEED_APPROVAL" ${needApprovalChecked}/>NEED_APPROVAL <br />
	  	<input type="radio" name="status" value="APPROVED" ${approvedChecked}/>APPROVED<br />
	  	<input type="radio" name="status" value="REJECTED" ${rejectedChecked}/>REJECTED <br />
	  	
	  	<h3>Sort By</h3>
	  	<input type="radio" name="sortBy" value="id" ${idChecked}/>Seller ID<br />
	  	<input type="radio" name="sortBy" value="createdAt" ${createdAtChecked}/>Registration Time<br />
		
		<input type="submit" value="pessMe">
 	 </form>
  	
</body>

</html>