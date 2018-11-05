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
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light" style="box-shadow: 1px 1px #888888c5;padding-bottom: 1px;padding-top:2px;">

        <!-- <a class="navbar-brand" href="#">myMart</a> -->
        <a class="navbar-brand" href="#">
            <img src="https://images.all-free-download.com/images/graphiclarge/shopping_cart_vector_graphics_558084.jpg" width="45" height="50"
                width: "50" alt="mart">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/admin/home">Home
                    </a>
                    <hr style="margin:-1px" />
                </li>
                <li class="nav-item">
                    <form style="padding-left:1px;margin-right:0px;" action="/admin/seller" method="GET">
                        <button type="submit" class="nav-link">Seller</button>
                    </form>
                    <hr style="margin:-1px;width:65px;" />
                </li>
                <li class="nav-item">
                    <form action="/admin/product" method="GET">
                        <button style="padding-left:0px" type="submit" class="nav-link">Products</button>
                    </form>
                    <hr style="margin:-1px;width:80px;border-color:black;" />
                </li>
                <li class="nav-item">
                    <form action="/admin/category" method="GET">
                        <button type="submit" class="nav-link">Category</button>
                    </form>
                    <hr style="margin:-1px;width:80px;" />
                </li>

                <li style="display :box;width:35rem;">
                    <form action="/admin/product" method="GET">
                        <!--Hidden Fields-->
                        <div class="hide" style="">
                            <input type="radio" name="status" value="NEW" ${newChecked}/>
                            <input type="radio" name="status" value="APPROVED" ${approvedChecked}/>
                            <input type="radio" name="status" value="REVIEW" ${reviewChecked}/>
                            <input type="radio" name="status" value="REJECTED" ${rejectedChecked}/>

                            <input type="radio" name="sortBy" value="mrp" ${mrpChecked}/>
                            <input type="radio" name="sortBy" value="ssp" ${sspChecked}/>
                            <input type="radio" name="sortBy" value="ymp" ${ympChecked}/>
                            <input type="radio" name="sortBy" value="createdAt" ${createdAtChecked}/>
                            <input type="radio" name="sortBy" value="updatedAt" ${updatedAtChecked}/>
                        </div>

                        <div class="input-group mb-3" style="margin-top:50px">

                            <div class="input-group-prepend">
                                <select class="btn btn-outline-secondary" name="searchKey" class="custom-select" id="inputGroupSelect01">
                                    <option ${nameSelected} value="name">Name</option>
                                    <option ${codeSelected} value="code">Code</option>
                                    <option ${idSelected} value="id">Id</option>
                                </select>
                            </div>
                            <input type="text" name="searchQuery" class="form-control" aria-label="Text input with dropdown button" value="${searchQuery}">
                        </div>

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

                <form action="/admin/product" method="POST" style="padding-top:50px;">
                    <table class="table table-sm">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>Code</th>
                                <th>Name</th>
                                <th>MRP</th>
                                <th>SSP</th>
                                <th>YMP</th>
                                <th>Seller Id</th>
                                <th>Seller's Company Name</th>
                                <th>Category</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <c:forEach items="${products}" var="product">
                            <a href="seller/${product.id}">
                                <tr <c:if test="${product.status==1}">class="table-primary"</c:if>
                                    <c:if test="${product.status==2}">class="table-success"</c:if>
                                    <c:if test="${product.status==3}">class="table-info"</c:if>
                                    <c:if test="${product.status==4}">class="table-danger"</c:if> >
                                    <td>${product.id}</td>
                                    <td>${product.code}</td>
                                    <td>${product.name}</td>
                                    <td>${product.mrp}</td>
                                    <td>${product.ssp}</td>
                                    <td>${product.ymp}</td>
                                    <td>${product.seller.id}</td>
                                    <td>${product.seller.companyName}</td>
                                    <td>${product.category.id}</td>
                                    <td>
                                        <c:if test="${product.status==1}">NEW</c:if>
                                        <c:if test="${product.status==2}">APPROVED</c:if>
                                        <c:if test="${product.status==3}">REVIEW</c:if>
                                        <c:if test="${product.status==4}">REJECTED</c:if>
                                    </td>

                                    <td>
                                        <a href="product/${product.id}">
                                            <i class="far fa-edit"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <c:if test="${product.status==1}">
                                            <input type="checkbox" name="cbox" value="${product.id}">
                                        </c:if>
                                    </td>
                                </tr>
                            </a>
                        </c:forEach>
                    </table>
                    <input type="submit" class="btn btn-secondary" value="Approve Selected">
                </form>

                <nav aria-label="Page navigation example" style="margin-top:50px;">
                    <ul class="pagination">

                        <c:forEach begin="0" end="${paginationSize}" varStatus="loop">
                            <li class="page-item">
                                <form action="/admin/product" method="GET">
                                    <input type="submit" class="page-link" name="offset" value="${loop.index+1}" />

                                    <div class="hide" style="">
                                        <input type="radio" name="status" value="NEED_APPROVAL" ${needApprovalChecked}/>
                                        <input type="radio" name="status" value="APPROVED" ${approvedChecked}/>
                                        <input type="radio" name="status" value="REJECTED" ${rejectedChecked}/>

                                        <input type="radio" name="sortBy" value="id" ${idChecked}/>
                                        <input type="radio" name="sortBy" value="createdAt" ${createdAtChecked}/>
                                    </div>



                                    <select class="hide" name="searchKey" class="custom-select" id="inputGroupSelect01">
                                        <option ${companySelected} value="COMPANY_NAME">Company</option>
                                        <option ${ownerSelected} value="OWNER_NAME">Owner</option>
                                        <option ${phoneSelected} value="PHONE">Phone</option>
                                    </select>
                                    <input type="text" name="searchQuery" class="hide" value="${searchQuery}">
                                </form>
                            </li>
                        </c:forEach>

                    </ul>
                </nav>


            </div>
            <div class="col-md-4">
                <div style="padding-top:30px;padding-left:30px;">
                    <form action="/admin/product" method="GET">

						<div class="row">
                            <div class="col-md-6">
                                <h5>Choose status:</h5>
                                <input type="radio" name="status" value="NEW_CHECKED" ${newChecked}/>NEW
                                <br />
                                <input type="radio" name="status" value="APPROVED" ${approvedChecked}/>APPROVED
                                <br />
                                <input type="radio" name="status" value="REVIEW" ${reviewChecked}/>REVIEW
                                <br />
                                <input type="radio" name="status" value="REJECTED" ${rejectedChecked}/>REJECTED
                            </div>
                            <div class="col-md-6">
                                <h5>Sort By:</h5>
        
                                <input type="radio" name="sortBy" value="mrp" ${mrpChecked}/>MRP
                                <br />
                                <input type="radio" name="sortBy" value="ssp" ${sspChecked}/>SSP
                                <br />
                                <input type="radio" name="sortBy" value="ymp" ${ympChecked}/>YMP
                                <br />
                                <input type="radio" name="sortBy" value="createdAt" ${createdAtChecked}/>Registration time
                                <br />
                                <input type="radio" name="sortBy" value="updatedAt" ${updatedAtChecked}/>UpdatedAt
                                <br />
                            </div>
                            
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="inputGroupSelect01">Seller Id</label>
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
                                <label class="input-group-text" for="inputGroupSelect01">Company Names</label>
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
                                <label class="input-group-text" for="inputGroupSelect01">Category</label>
                            </div>
                            <select class="custom-select" id="inputGroupSelect01" name="category">
                                <option value="null">Choose Category..</option>
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.name}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>


                        <input type="submit" class="btn" value="submit">

                        <select class="hide" name="searchKey" class="custom-select" id="inputGroupSelect01">
                            <option ${nameSelected} value="name">Name</option>
                            <option ${codeSelected} value="code">Code</option>
                            <option ${idSelected} value="id">Id</option>
                        </select>

                        <input type="text" name="searchQuery" class="hide" value="${searchQuery}">

                    </form>
                </div>
            </div>
        </div>
    </div>
	<div class="footer">
         Made with <i class="fas fa-heart"></i>
    </div>

</body>

</html>