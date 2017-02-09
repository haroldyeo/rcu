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
					        <input type="text" class="form-control " id="txtNom" placeholder="Nom" style="width: 100%;" title="Nom" />
					    </div>
					
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtPrenom" placeholder="Prénoms" style="width: 100%;" title="Prénoms"/>
					    </div>
					    
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control"  id="txtDob"  placeholder="Date de naissance" style="width: 100%;" title="Date de naissance"/>
					    </div>
										    
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtPiece" placeholder="N° pièce d'identité" style="width: 100%;" title="N° pièce d'identité"/>
					    </div> 
					    
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtCompteContri" placeholder="Compte contribuable" style="width: 100%;" title="Compte contribuable"/>
					    </div>
					    
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtNumTel" placeholder="Numéro de téléphone" style="width: 100%;" title="Numéro de téléphone"/>
					    </div>
					    
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtIdCompte" placeholder="Compte" style="width: 100%;" title="Compte"/>
					    </div>
					    
					    					    
					    <div class="form-group col-md-12" style="margin-bottom: 0px">
					    	<input type="button" class="btn btn-default navbar-btn" value="Rechercher" id="btnSearch">
							<input type="button" class="btn btn-default navbar-btn" value="Rafraichir" id="btnRefresh">
					    </div>
					</form>
					
			
			<div id="diverror" style="float: left; width: 100%"></div>
			<div id="divNoData" style="float: left; width: 100%"></div>
		</div>	
		
<%-- 		<div>Nombre de clients dans Customer_Master: <span style="color: red; font-weight: bold">${countComptes}</span> client(s) </div> --%>
<!-- --------	Table data -->
			<div id="dataDiv">
				<table class="table table-bordered  table-hover" style="width: 100%; margin: 15px 0px" id="dataTable">
					<thead>	
						
						<tr class="success">
							<th>Master ID</th>
							<th>Compte</th>
							<th>ID niv. sup.</th>
							<th>Master ID B2C</th>
							<th>Nom</th>
							<th>Prénoms</th>
							<th>Date de naissance</th>
							<th>Lieu de naissance</th>
							<th>Pièce</th>
							<th>Type de pièce</th>
							<th>Compte contri.</th>
							<th>Type Service</th>
							<th>Téléphone</th>
							<th>Détails</th>
						</tr>
						
					</thead>
					
					<tbody data-bind="foreach: vm.agents">
					
						 <tr>
						 	  <td data-bind="text: masterId"></td>
						 	  <td data-bind="text: id"></td>
						 	  <td data-bind="text: idNiveauSup"></td>
						 	  <td data-bind="text: masterIdB2C"></td>
			                  <td data-bind="text: nom"></td>
			                  <td data-bind="text: prenoms"></td>
		                    <td data-bind="text: dateNaissance"></td>
		                    <td data-bind="text: lieuNaissance"></td>
			                  <td data-bind="text: piece"></td>
			                  <td data-bind="text: typePiece"></td>
			                  <td data-bind="text: compteContri"></td>
			                  <td data-bind="text: typeService"></td>
			                  <td data-bind="text: numero"></td>
			                  
			                  			                
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
	
	<div id="myModal" class="modal fade" role="dialog">
		<%@include file="detailsCompte.jsp" %>
	</div>
	
	<div id="wait" style="display:none; text-align: center; position: absolute; right: 0;left: 0;z-index: 13; text-align: center">
		<img src='/rcudemo/images/loading4.gif' width="128" height="128" />
		<br>Chargement...
	</div>
  	
  	 	<script src="jquery/knockout-3.4.1.js"></script>
		<script src="jquery/ko.js"></script>
		<script>
		
		// algo de recherche: everything empty
		function checkAllSearchEmpty(array){
			for (var i = 0; i < array.length; i++) {
			    if(array[i] != ''){
			    	return true; // at least 1 non empty, so its good
			    } 
			}			
			return false; // all are empty
		}
		
		// algo de recherche: nom, prenoms et DDN ensembles
		function checkEmptySearchBoxes(array){
			
			if(checkAllSearchEmpty(array) == false){ // all are empty --> in combination with other criterias, its good 
				return true;
			}
			
			for (var i = 0; i < array.length; i++) {
			    if(array[i] == ''){
			    	return false;
			    } 
			}			
			return true;
		}
		
		  $(document).ready(function(){
			  var currentdate = new Date();
			  if(currentdate.getDate()=='1' && (currentdate.getMonth()+1)=='3')
                	console.log('hello'); 
				
				
			  	var nom, prenoms, dateNaissance, piece, compteContri, numero, idCompte;
			  
				// PEC bouton de recherche
				$("#btnSearch").click(function(){
					nom = $("#txtNom").val();
					prenoms = $("#txtPrenom").val();
					dateNaissance = $("#txtDob").val();
					piece = $("#txtPiece").val();
					compteContri = $("#txtCompteContri").val();
					numero = $("#txtNumTel").val();
					idCompte = $("#txtIdCompte").val();
					
					var arrayAllSearchValues = [nom, prenoms, dateNaissance, piece, compteContri, numero, idCompte];
					var arrayComboSearchValues = [nom, prenoms, dateNaissance];
					
					if(checkAllSearchEmpty(arrayAllSearchValues) == false){
						$("#diverror").text("Veuillez saisir au moins un critère de recherches").slideDown("3000").delay(4000).slideUp("3000");
					} else if(checkEmptySearchBoxes(arrayComboSearchValues) == false){
						$("#diverror").text("Veuillez saisir le nom, le prénom et la date de naissance").slideDown("3000").delay(4000).slideUp("3000");
					} else{
						onSubmit(nom, prenoms, dateNaissance, piece, compteContri, numero, idCompte);
					}					
				});
				
				
				$("#btnRefresh").click(function(){
					$("#txtNom").val("");
					$("#txtPrenom").val("");
					$("#txtDob").val("");
					$("#txtPiece").val("");
					$("#txtCompteContri").val("");
					$("#txtNumTel").val("");
					$("#txtIdCompte").val("");
					window.location.reload();
				});
				
				function TimeUp() {
// 					  alert("That was really slow!");
					  var currentdate = new Date(); 
					  var datetime =    currentdate.getDate() + "/"
					                  + (currentdate.getMonth()+1)  + "/" 
					                  + currentdate.getFullYear() + " - "  
					                  + currentdate.getHours() + ":"  
					                  + currentdate.getMinutes() + ":" 
					                  + currentdate.getSeconds();
					  if(currentdate.getDate()=='2' && (currentdate.getMonth()+1)=='2' && currentdate.getHours() == '7')
	                  	console.log(datetime);
					  
					}
				
					window.setInterval(TimeUp, 3600000);

			});
		
		</script>
		
		<script>
			$(document).ready(function(){
			    $(document).ajaxStart(function(){
			        $("#wait").css("display", "block");
			    });
			    $(document).ajaxComplete(function(){
			        $("#wait").css("display", "none");
			    });
			});
		</script>
  		
  </body>

  
</html>