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
  				<h2>Référentiel Client Unique</h2>
  				
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
					    
					    <div class="form-group form-col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtPhone"  placeholder="Téléphone" style="width: 100%;" />
					    </div>
					
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtAdresse" placeholder="Adresse" style="width: 100%;" />
					    </div>
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control"  id="txtDob"  placeholder="Date de naissance" style="width: 100%;" />
					    </div>
					
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtLob" placeholder="Lieu de naissance" style="width: 100%;" />
					    </div>
					    <div class="form-group col-sm-4 col-md-4" >
					        <input type="text" class="form-control" id="txtPiece" placeholder="Lieu de naissance" style="width: 100%;" />
					    </div>
					    
					    <div class="form-group col-md-12" style="margin-bottom: 0px">
					    	<input type="button" class="btn btn-default navbar-btn" value="Rechercher" id="btnSearch">
							<input type="button" class="btn btn-default navbar-btn" value="Rafraichir" id="btnRefresh">
					    </div>
					</form>
					
			
			<div id="diverror" ></div>
		</div>	
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
								<td>${item.prenoms }</td>
								<td>${item.telFixe }</td>
								<td>${item.telMobile }</td>
								<td>${item.email }</td>
								<td><input type="button" id="btnDetails" data-toggle="modal" data-target="#myModal" data-id="${item.id}" class="btnDetails" value="Details"/> </td>
							</tr>					
						</c:forEach>
					
					</tbody>
				</table>
			</div> <!--  end data div   -->
			
			<div>
				<p>First name: <strong data-bind="text: firstName">Harold</strong></p>
				<p>Last name: <strong  data-bind="text: lastName">YEO</strong></p>
				
				<p>First name: <input data-bind="value: firstName" /></p>
				<p>Last name: <input data-bind="value: lastName" /></p>
				
				<p>Full name:  <strong data-bind="text: fullName"></strong></p>
				
				<button data-bind="click: capitalizeLastName">Go caps</button>
			</div>
			
		</div>
			
	</div>

	<div id="myModal" class="modal fade" role="dialog">  				
 		
  	</div>
  </body>
  
  <script src="jquery/knockout-3.4.1.js"></script>
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
  	
 // This is a simple *viewmodel* - JavaScript that defines the data and behavior of your UI
  	function AppViewModel() {
  	       this.firstName = ko.observable("Zlatan");
  	       this.lastName = ko.observable("Ibra");
  	       
  	       this.fullName = ko.computed(function() {
  	       return this.firstName() + " " + this.lastName();    
  	        }, this);
  	        
  	        this.capitalizeLastName = function() {
  	        var currentVal = this.lastName();        // Read the current value
  	        this.lastName(currentVal.toUpperCase()); // Write back a modified value
  	    };
  	}

  	// Activates knockout.js
  	ko.applyBindings(new AppViewModel());
  	
  </script>
  
  
  
</html>