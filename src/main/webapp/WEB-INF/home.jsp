<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Bienvenue</title>
		<%@ include file="links.jsp" %>
		<link href="/rcudemo/css/style.css" rel="stylesheet" type="text/css">
		
	</head>
	
	
	
		
	<body>
		
		
  		<div align="center" id="mainDiv" class="container-fluid" style="border: 1px solid #eee; width: 90%">
  				<img alt="orange_logo" src="/rcudemo/images/orange_logo.PNG" height="60px">
  				<h2>Référentiel Client Unique</h2>
  				
<!-- --------	Table search options -->
			<div id="searchDiv">
			
				<table class="searchTable" style="width: 80%">
					<tr>
						<td>Nom*: </td> <td><input type="text" id="txtNom" class="corner10"></td>
						<td>Prénoms*:</td> <td><input type="text" id="txtPrenom"></td>
						<td>Téléphone: </td> <td><input type="text" id="txtPhone"></td>
						
					</tr>
					<tr>
						<td>Adresse: </td> <td><input type="text" id="txtAdresse"></td>
						<td>Date de naissance: </td> <td><input type="date" id="txtDob"></td>
						<td>Lieu de naissance: </td> <td><input type="text" id="txtLob"></td>
						
					</tr>
					
					<tr>
						<td>Pièce d'identité: </td> <td><input type="text" id="txtPiece"></td>
<!-- 						<td>Type de pièce d'identité: </td> <td><input type="text" id="txtTypePiece"></td> -->
						
					</tr>
					
					<tr>
						<td colspan="4"></td>
						<td><input type="button" value="Rechercher" id="btnSearch"></td>
						<td><input type="button" value="Rafraichir" id="btnRefresh"></td>
					</tr>
				</table>
			
			</div>
			<div id="diverror" ></div>
			
<!-- --------	Table data -->
	<div id="dataDiv">
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
	</div> <!--  end data div   -->
	

		<div id="myModal" class="modal fade" role="dialog">  				
  		</div>
  	</div>
  </body>
  
  <script>
  <%@ include file="java.js" %>
  	$(document).ready(function(){
  		
  		$(".btnDetails").click(function(){
  			var id = $(this).attr("data-id");
//   			alert("sbmit");
  			onSubmitDetails(id);
  		});
  		
  		
  		var nom, prenoms, tel, adresse, dateNaissance, lieuNaissance, piece;
  		$("#btnSearch").click(function(){
  			nom = $("#txtNom").val();
  			prenoms = $("#txtPrenom").val();
  			tel = $("#txtPhone").val();
  			adresse = $("#txtAdresse").val();
  			dateNaissance = $("#txtDob").val();
  			lieuNaissance = $("#txtLob").val();
  			piece = $("#txtPiece").val();
//   			typepiece = $("#txtTypePiece").val();
  			
  			if(nom==''){
  				$("#diverror").text("Le champs Nom est obligatoire").slideDown("3000").delay(4000).slideUp("3000");
  			}else 
  			if(prenoms==''){
  				$("#diverror").text("Le champs Prénoms est obligatoire").slideDown("3000").delay(4000).slideUp("3000");
  			}
  			
  			if(nom!='' && prenoms != ''){
  				if(tel=='' && adresse=='' && dateNaissance=='' && lieuNaissance=='' && piece=='' ){
  					$("#diverror").text("Saisir au moins un paramètre supplémentaire").slideDown("3000").delay(4000).slideUp("3000");
  				} else {
  					
  					onSubmit(nom, prenoms, tel, adresse, dateNaissance, lieuNaissance, piece);
  					
  				}
  			}
  			
  			
  		});
  		
  		$("#btnRefresh").click(function(){
  			$("#txtNom").val("");
  			$("#txtPrenom").val("");
  			$("#txtPhone").val("");
  			$("#txtAdresse").val("");
  			$("#txtDob").val("");
  			$("#txtLob").val("");
  			$("#txtPiece").val("");
//   			$("#txtTypePiece").val("");
  			window.location.reload();
  		});
  		
//   		$("input").blur(function(){
//   			$(this).val($(this).val().toUpperCase());
//   		});
  		
  	});
  </script>
  
</html>