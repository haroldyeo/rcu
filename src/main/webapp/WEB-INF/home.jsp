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
					
			
			<div id="diverror" style="float: left; width: 100%"></div>
		</div>	
<!-- --------	Table data -->
			<div id="dataDiv">
				<div id="dataAgents" style="display: none" ></div>
				<table class="table table-bordered  table-hover" style="width: 80%; margin: 15px 0px" id="dataTable">
					<thead>
						
						<tr class="success">
							<th>Nom</th>
							<th>Prénoms</th>
							<th>Fixe</th>
							<th>Email</th>
							<th>Détails</th>
						</tr>
						
					</thead>
					
					<tbody data-bind="foreach: agents">
					
						 <tr>
			                  <td data-bind="text: nom"></td>
			                  <td data-bind="text: prenoms"></td>
			                  <td data-bind="text: telFixe"></td>
			                  <td data-bind="text: email"></td>
			                  <td><input type="button" data-bind="text: id" id="btnDetails" data-toggle="modal" data-target="#myModal" data-id="${item.id}" class="btnDetails" value="Details"/> </td>
			             </tr>
					
					</tbody>
				</table>
			</div> <!--  end data div   -->
						
		</div>
			
	</div>
	
	<input type="hidden" id="inputAgents" data='${dataAgents}'></input>

	<div id="myModal" class="modal fade" role="dialog">
  	</div>
  	
  </body>
  
  <script src="jquery/knockout-3.4.1.js"></script>
  <script src="jquery/ko.js"></script>
  <script>
  <%@ include file="java.js" %>
  </script>
  
  
  
</html>