<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--   -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Header</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
  <style>
  .sidebar {
  margin: 0;
  padding: 0;
  width: 200px;
  background-color:#010733;
  position: fixed;
  height: 100%;
  overflow: auto;																																													
}

 .sidebar a {
  display: block;
  color: blue;
  padding: 16px;
  text-decoration: none;
} 
 
.sidebar a.active {
  background-color: #4a994e;
  color: white;
}

.sidebar a:hover:not(.active) {
  background-color: #091954;
  color: white;
}

div.content {
  margin-left: 200px;
  padding: 1px 16px;
  height: 1000px;
}

@media screen and (max-width: 700px) {
  .sidebar {
    width: 100%;
    height: auto;
    position: relative;
  }
  .sidebar a {float: left;}
  div.content {margin-left: 0;}
}
</style>
</head>
<body>
<nav class="navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header"  style="background-color:#091954;width:180px;margin-left:0">
    </div>
    <ul class="nav navbar-nav" >
      <li><a href="<c:url value='/'></c:url>">Home</a></li>
      <li><a href="<c:url value='/all/getallproducts'></c:url>">Browse All Products</a></li>
      <li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Select By Category<span class="caret"></span></a>
					
				<ul class="dropdown-menu">
				<c:forEach items="${categories }" var="category">
				<li><a href="<c:url value='/all/searchByCategory?searchCondition=${category.categoryname }'></c:url>">${category.categoryname }</a>
				</li>
				</c:forEach>
				<li>
				<a href="<c:url value='/all/searchByCategory?searchCondition=All'></c:url>">All</a>
				</li>
				</ul>
			   </li>

      <li><a href="<c:url value='/Aboutus'></c:url>">About us</a></li>
      <li><a href="<c:url value='/contactus'></c:url>">Contact us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <security:authorize access="hasRole('ROLE_ADMIN')">
      <li><a href="<c:url value='/admin/getproductform'></c:url>">Add Product</a></li>
      <li><a href="<c:url value='/all/getcategoryform'></c:url>">Add Category</a></li>
      <li><a href="<c:url value='/all/getsupplierform'></c:url>">Add Supplier</a></li>
       </security:authorize>
        <security:authorize access="hasRole('ROLE_USER')">
			   <li><a href="<c:url value='/cart/getcart'></c:url>"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
			   </security:authorize>
			  <c:if test="${pageContext.request.userPrincipal.name==null }">
      <li><a href="<c:url value='/all/registrationform'></c:url>"><span class="glyphicon glyphicon-user"></span>SignUp</a></li>
      <li><a href="<c:url value='/login'></c:url>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name!=null }">
				<li><a href="#">Welcome ${pageContext.request.userPrincipal.name }</a></li>
				<li><a href="<c:url value='/j_spring_security_logout'></c:url>">Sign out</a></li>
			    </c:if>
    </ul>
  </div>
</nav>
</body>
</html>