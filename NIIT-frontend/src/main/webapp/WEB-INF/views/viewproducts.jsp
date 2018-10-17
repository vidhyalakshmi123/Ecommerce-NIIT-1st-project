<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		Product Details<br>
		<div class="panel-info">
			<div class="panel panel-heading">Product Details</div>
			<div class="panel panel-body">
			<c:url value="/cart/addtocart/${productObj.productid}" var="url"></c:url>
			<form action="${url }" >
			<img src="<c:url value='/resources/images/${productObj.productid}.jpg'></c:url>" width="30%" height="30%"><br>
			<b>Product Name:</b>${productObj.productname }<br>
			<b>Product Desc:</b>${productObj.productdescription }<br>
			<b>Price:</b>${productObj.productprice }<br>
			<b>Quantity:</b>${productObj.productquantity }<br>
			<b>Category:</b>${productObj.categoryid}<br>
			<c:if test="${productObj.productquantity==0 }">
			<button class="btn btn-lg"><span class="glyphicon glyphicon-shopping-cart" ></span></button>
			</c:if>
			<c:if test="${productObj.productquantity>0 }">
			<security:authorize access="hasRole('ROLE_USER')">
			Enter Quantity:<input type="number" min="1" max="${productObj.productquantity }" name="requestedQuantity">
			<button class="btn btn-primary btn-lg" type="submit"><span class="glyphicon glyphicon-shopping-cart" ></span>Add To Cart</button>
			</security:authorize>
			</c:if>
			</form>
			</div>
		</div>
	</div>
	<a href="<c:url value='/all/getallproducts'></c:url>">Browse all products</a>
	<jsp:include page="footer.jsp"/>
</body>
</html>