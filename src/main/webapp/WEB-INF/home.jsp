<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Bienvenue</title>
		<link rel="stylesheet" href="/rcudemo/bootstrap/css/bootstrap.css" ></link>
		<script src="/rcudemo/bootstrap/js/bootstrap.min.js" ></script>
		<script src="/rcudemo/jquery/jquery.min.js" ></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<style>
			.searchTable tr td{
				padding: 5px;
			}
		</style>
		
	</head>
	
	
	
		
	<body>
		
  		<div align="center" id="mainDiv" class="container-fluid">
  				<h2>Référentiel Client Unique</h2>
  				
<!-- --------	Table search options -->
			<table class="searchTable">
				<tr>
					<td>Nom: </td> <td><input type="text" id="txtNom"></td>
					<td>Prénoms:</td> <td><input type="text" id="txtPrenom"></td>
					<td>Téléphone: </td> <td><input type="text" id="txtPhone"></td>
					
				</tr>
				<tr>
					<td>Adresse: </td> <td><input type="text" id="txtAdresse"></td>
					<td>Date de naissance: </td> <td><input type="text" id="txtDob"></td>
					<td>Lieu de naissance: </td> <td><input type="text" id="txtLob"></td>
					<td></td>
				</tr>
			</table>

<!-- --------	Table data -->


  				
  		</div>
  </body>
  
</html>