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
<!--   				<img alt="orange_logo" src="/rcudemo/images/orange_logo.PNG" height="60px"> -->
<!--   				<h2>Référentiel Client Unique</h2> -->
  				
<!-- --------	Table search options -->
			<div class="container">
				<div id="searchDiv"  class="row">
					<form id="signinForm">
						<div class="form-group col-sm-4 col-md-4">
					        <input type="text" class="form-control " id="txtNom" placeholder="Nom" style="width: 100%;" />
					    </div>
					
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtPrenom" placeholder="Prénoms" style="width: 100%;" />
					    </div>
					    
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control"  id="txtDob"  placeholder="Date de naissance" style="width: 100%;" />
					    </div>
					
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtLob" placeholder="Lieu de naissance" style="width: 100%;" />
					    </div>
					    
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtPiece" placeholder="Pièce" style="width: 100%;" />
					    </div>
					    
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtTypePiece" placeholder="Type de pièce" style="width: 100%;" />
					    </div>
					    					    
					    <div class="form-group col-md-12" style="margin-bottom: 0px">
					    	<input type="button" class="btn btn-default navbar-btn" value="Rechercher" id="btnSearch">
							<input type="button" class="btn btn-default navbar-btn" value="Rafraichir" id="btnRefresh">
					    </div>
					</form>
					
			
			<div id="diverror" style="float: left; width: 100%"></div>
		</div>	
		
<%-- 		<div>Nombre de clients dans Customer_Master: <span style="color: red; font-weight: bold">${countComptes}</span> client(s) </div> --%>
<!-- --------	Table data -->
			<div id="dataDiv">
				<table class="table table-bordered  table-hover" style="width: 80%; margin: 15px 0px" id="dataTable">
					<thead>	
						
						<tr class="success">
							<th>Compte</th>
							<th>Nom</th>
							<th>Prénoms</th>
							<th>Détails</th>
						</tr>
						
					</thead>
					
					<tbody data-bind="foreach: vm.agents">
					
						 <tr>
						 	  <td data-bind="text: id"></td>
			                  <td data-bind="text: nom"></td>
			                  <td data-bind="text: prenoms"></td>
			                  <td>
			                  	<input type="button" data-bind="click: vm.displayModal.bind(id)" id="btnDetails"
			                  	data-toggle="modal" data-target="#myModal" class="btnDetails" value="Details"/> 
			                  </td>
			             </tr>
					
					</tbody>
				</table>
			</div> <!--  end data div   -->	
		</div>
			
	</div>
	
	<input type="hidden" id="inputAgents" value='${dataAgents}'></input>

	<div id="myModal" class="modal fade" role="dialog"></div>
  	
  	 	<script src="jquery/knockout-3.4.1.js"></script>
		<script src="jquery/ko.js"></script>
		<script>
		  $(document).ready(function(){
				var nom, prenoms, dateNaissance, lieuNaissance, piece, typePiece;
				$("#btnSearch").click(function(){
					nom = $("#txtNom").val();
					prenoms = $("#txtPrenom").val();
					dateNaissance = $("#txtDob").val();
					lieuNaissance = $("#txtLob").val();
					piece = $("#txtPiece").val();
					typePiece = $("#txtTypePiece").val();
		//			typepiece = $("#txtTypePiece").val();
					
					if(nom==''){
						$("#diverror").text("Le champs Nom est obligatoire").slideDown("3000").delay(4000).slideUp("3000");
					}else 
					if(prenoms==''){
						$("#diverror").text("Le champs Prénoms est obligatoire").slideDown("3000").delay(4000).slideUp("3000");
					}
					
					if(nom!='' && prenoms != ''){
						if(dateNaissance=='' && lieuNaissance=='' && piece==''&& typePiece==''){
							$("#diverror").text("Saisir au moins un paramètre supplémentaire").slideDown("3000").delay(4000).slideUp("3000");
						} else {
							onSubmit(nom, prenoms, dateNaissance, lieuNaissance, piece, typePiece);
						}
					}
					
					
				});
				
				$("#btnRefresh").click(function(){
					$("#txtNom").val("");
					$("#txtPrenom").val("");
					$("#txtDob").val("");
					$("#txtLob").val("");
					$("#txtPiece").val("");
					$("#txtTypePiece").val("");
					window.location.reload();
				});
				
			});
		
		</script>
  		
  </body>

  
</html>