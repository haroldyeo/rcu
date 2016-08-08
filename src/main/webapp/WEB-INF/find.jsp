<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>

<table class="table table-bordered  table-hover" style="width: 80%; margin: 15px 0px" id="dataTable">
	<thead>		
		<tr class="success">
			<th>Nom</th>
			<th>Prénoms</th>
			<th>Fixe</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>Détails</th>
		</tr>
		
	</thead>
	
	<tbody>
	
		<c:forEach items="${dataAgents}" var="item">
			<tr>
				<td>${item.nom }</td>
				<td>${item.prenom }</td>
				<td>${item.telFixe }</td>
				<td>${item.telMobile }</td>
				<td>${item.email }</td>
				<td><input type="button" id="btnDetails" data-toggle="modal" data-target="#myModal" data-id="${item.id}" class="btnDetails" value="Details"/> </td>
			</tr>					
		</c:forEach>
	
	</tbody>
</table>
<script>
 <%@ include file="java.js" %>
  	$(document).ready(function(){
  		
  		$(".btnDetails").click(function(){
  			var id = $(this).attr("data-id");
  			onSubmitDetails(id);
  			});
  		});
</script>  		
  	

