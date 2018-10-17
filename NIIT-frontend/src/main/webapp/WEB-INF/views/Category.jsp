			
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>

<html>
<head>
 <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <title>Category</title>
</head>
<body>
<div>

<c:url value="/admin/addcategory" var="url"></c:url>

	<form:form modelAttribute="Category" action="${url }" method="post">
	<table>
			<tr>
				<td></td>
				<!-- user need not give value for id, auto generation -->
				<td><form:hidden path="categoryid"></form:hidden></td>
			</tr>
			<tr>
				<td>Enter Category Name
				</td>
				<td><form:input path="categoryname"></form:input></td>
				<form:errors path="categoryname" cssStyle="color:red"></form:errors>
			</tr>
			<tr>
		</tr>
			<tr>
			<td>Enter Parent Category</td>
			<td><form:textarea path="parentcategory"></form:textarea>
			<form:errors path="parentcategory" cssStyle="color:red"></form:errors>
			</td></tr>
</td></tr>
			<tr><td>
			
			<tr>
			<td></td>
			
			<td><input type="submit" value="Add Category"></td>
			</tr>


</form:form>
	</div>
	<a href="<c:url value='/all/getallproducts'></c:url>">Browse all products</a>
	
<jsp:include page="footer.jsp"/>

</body>
</html>