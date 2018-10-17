<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
 
</head>
<body>
<div>

<c:url value="/admin/addsupplier" var="url"></c:url>
	<form:form modelAttribute="supplier" action="${url}" method="post" >
	<table>
	<tr>
		<td colspan="2">Supplier Details</td>
		<c:if test="${!flag}">
			<form:hidden path="supplierid"></form:hidden>
		</c:if>
	</tr>
	<tr>
	<td>Supplier Name</td>
	         <c:if test="${!flag}">
				<td><form:input path="suppliername"></form:input></td>
			</c:if>
			
	</tr>
	<tr>
	<td>Supplier Address</td>
	<c:if test="${!flag}">
				<td><form:input path="supplieraddress"></form:input></td>
    </c:if>
    <td>Supplier Email</td>
    <c:if test="${!flag}">
	<td><form:input path="supplieremail"></form:input></td>
	</c:if>
    <td>Supplier Mobilenumber</td>
    <c:if test="${!flag}">
	<td><form:input path="suppliermobilenumber"></form:input></td>
	</c:if>
	</tr>
	<tr>
	<td colspan="2">
		<input type="submit" value="AddSupplier"/>
	</td>
	</tr>
</table>
<!-- Supplier Form Completed -->

<!-- Displaying the Supplier data using Table -->
<table>

	<tr bgcolor="pink">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Address</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${supp}" var="s">
		<tr bgcolor="cyan">
			<td>${s.supplierid}</td>
			<td>${s.suppliername}</td>
			<td>${s.supplieraddress}</td>
			<td>${s.supplieremail}</td>
			
		</tr>
	</c:forEach>
</table>
</form:form>
</div>
<!-- Completed Displaying Table -->


<a href="<c:url value='/all/getallsuppliers'></c:url>">Browse all products</a>
	
<jsp:include page="footer.jsp"/>

</body>
</html>
</body>

</html>

