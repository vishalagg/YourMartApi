<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Page Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
</head>
<body>
  Sellers page :
  
  ${sellers[0].email}
  
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
      <td><input type="checkbox" name="cbox"></td>
      <td><a href="seller/${seller.id}">Details</a></td>
    </tr>
  </c:forEach>
</table>
  
</body>
</html>