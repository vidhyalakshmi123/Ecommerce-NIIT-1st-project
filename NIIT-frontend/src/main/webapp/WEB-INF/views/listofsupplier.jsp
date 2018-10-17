<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp"%> 
 <%@ page isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--   -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier List</title>
<script type="text/javascript">
$(document).ready(function(){
	var searchCondition='${searchCondition}'
	$('.table').DataTable({
		"lengthMenu":[[5,7,-1],[5,7,"All"]],
	    "oSearch" : {
		"sSearch" : searchCondition
		}
	})
})
</script>

</head>
<body>

<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>supplier id</th>
					<th>supplier name</th>
					<th>supplier mobilenumber</th>
					<th>supplier address</th>
					<th>supplier email</th>
				
				</tr>
			</thead>
			<tbody>
			<!-- For each object in the list, tr has to be repeated -->
			<!--  items refers to the collection of objects -->
			<!-- var is local variable ,takes objects one by one from the collection -->
			
			<c:forEach var="s" items="${supplierList}">
				<tr>
					<td><a
							href="<c:url value='/all/getsupplier/${s.supplierid }'></c:url>">${s.supplierid }</a></td>
							<td>" height="30px" width="30px"></td>
						<td><a
							href="<c:url value='/all/getsupplier/${s.supplierid }'></c:url>">${s.suppliername }</a></td>
						<td>${s.suppliermobilenumber }</td>
						<td>${s.supplieraddress }</td>
						<td>${s.supplieremail }</td>
						
						<td>
					<a href="<c:url value='/all/getsupplier/${s.supplierid}'></c:url>"><span class="glyphicon glyphicon-info-sign"></span></a>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<a href="<c:url value='/admin/deleteproduct/${s.supplierid}'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
					<a href="<c:url value='/admin/getupdateform/${s.supplierid}'></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>
					 </security:authorize>
					</td>

				</tr>
			</c:forEach>
			</tbody>
		</table>

	</div>
<jsp:include page="footer.jsp"/>

</body>
</html>