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
					        <input type="text" class="form-control"  id="txtDob"  placeholder="Date de naissance (jj/MM/yyyy)" style="width: 100%;" title="Date de naissance" maxlength="10"/>
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
							<input type="button" class="btn btn-default navbar-btn" value="Rafraichir" id="btnRefresh">
							<input type="button" class="btn btn-default navbar-btn" value="Rechercher" id="btnSearch">
					    </div>
					</form>
					
					<div id="#" style="float: left; text-align:left; width: 100%">
						<span style="text-align: center"><strong>Critères de rapprochement</strong> </span><br/>
						<div style="width: 50%; float: left">
								A = NOM,PRÉNOM,DATE NAISSANCE, LIEU NAISSANCE <br/>
								B = NOM,PRÉNOM, PIÈCE IDENTITÉ <br/>
								C = NOM,PRÉNOM, NUMÉRO TÉLÉPHONE <br/>
								D = PRÉNOM, NOM, DATE NAISSANCE, LIEU NAISSANCE <br/>
								E = PRÉNOM, NOM, PIÈCE IDENTITÉ <br/>	
						</div>
						<div style="width: 50%; float: left">
								F = PRÉNOM, NOM, NUMÉRO TÉLÉPHONE <br/>
								G = NOM, DATE NAISSANCE, NUMÉRO TÉLÉPHONE <br/>
								H = NOM, NUMÉRO TÉLÉPHONE <br/>
								I = PIÈCE IDENTITÉ, NUMÉRO TÉLÉPHONE
						</div>
								
					</div>
					
					
			
					<div id="diverror" style="float: left; width: 100%"></div>
					<div id="divNoData" style="float: left; width: 100%"></div>
				</div>	
			</div>
</div>
<%-- 		<div>Nombre de clients dans Customer_Master: <span style="color: red; font-weight: bold">${countComptes}</span> client(s) </div> --%>
<!-- --------	Table data -->
			<div id="dataDiv">
				<table class="table table-bordered  table-hover" style="width: 80%; margin: 15px auto" >
					<thead>	
						
						<tr class="success">
							<th>MASTER ID</th>
							<th>COMPTE</th>
							<th>RES ID</th>
							<th>ID NIV. SUP.</th>
							<th>NOM</th>
							<th>PRENOMS</th>
							<th>DATE NAISSANCE</th>
							<th>LIEU NAISSANCE</th>
							<th>PIECE</th>
							<th>MASTER ID B2C</th>
							<th>COMPTE CONTRI.</th>
							<th>TYPE SERVICE</th>
							<th>TELEPHONE</th>							
							<th>TYPE DE COMPTE</th>
						</tr>
						
					</thead>
					
					<tbody data-bind="foreach: vm.agents">
					
						 <tr>
						 	  <td data-bind="text: masterId"></td>
						 	  <td data-bind="text: 	id"></td> 
						 	  <td data-bind="text: resId"></td>
						 	  <td data-bind="text: idNiveauSup"></td>
			                  <td data-bind="text: nom"></td>
			                  <td data-bind="text: prenoms"></td>
		                    <td data-bind="text: dateNaissance"></td>
		                    <td data-bind="text: lieuNaissance"></td>
			                  <td data-bind="text: piece"></td>
			                  <td data-bind="text: masterIdB2C"></td>
			                  <td data-bind="text: compteContri"></td>
			                  <td data-bind="text: typeService"></td>
			                  <td data-bind="text: numero"></td>
			                  <td data-bind="text: typeCompte"></td>
			                  
			                  			                
<!-- 			                  <td> -->
<!-- 			                  	<input type="button" data-bind="click: vm.displayModal.bind(id)" id="btnDetails" -->
<!-- 			                  	data-toggle="modal" data-target="#myModal" class="btnDetails" value="Details"/>  -->
<!-- 			                  </td> -->
			             </tr>
					
					</tbody>
				</table>
				
				<div class="col-md-12 text-center">
				      <ul class="pagination pagination-lg pager" id="myPager"></ul>
			      </div>
				
			</div> <!--  end data div   -->	
		
			

	
	<div id="myModal" class="modal fade" role="dialog">
		<%@include file="detailsCompte.jsp" %>
	</div>
	
	<div id="wait" style="display:none; text-align: center; position: absolute; left: 50%; top:40%; z-index: 13; text-align: center;">
		<img src='/rcudemo/images/loading4.gif' width="128" height="128" />
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
			
		function validateDate(testdate) {
		    var date_regex = /^\d{2}\/\d{2}\/\d{4}$/ ;
		    var date_regex_2 = /^\d{2}\/\d{2}\/\d{2}$/ ;
		    return date_regex.test(testdate) ? date_regex.test(testdate) : date_regex_2.test(testdate);
		}
		
		  $(document).ready(function(){
			  
				// Formattage de la date
				$("#txtDob").keyup(function(event){
					var keyId = event.keyCode;
						var v = $(this).val();
						var l = v.length;
						if(l == 2 && keyId != 8){
							$(this).val(v.concat('/'));
						}if(l == 5 && keyId != 8 ){	
							$(this).val(v.concat('/'));
						}	
					});
													
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
					
					if($("#txtDob").val()!='' && !validateDate($("#txtDob").val()))
						$("#diverror").text("formats de date: jj/MM/aa ou jj/MM/aaaa ").slideDown("3000").delay(4000).slideUp("3000");
					else if(checkAllSearchEmpty(arrayAllSearchValues) == false){
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