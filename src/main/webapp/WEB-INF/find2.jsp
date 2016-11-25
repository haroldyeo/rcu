<%@ include file="taglibs.jsp" %>
		
<!-- Modal -->
		<!-- Trigger the modal with a button -->
<!-- 			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button> -->
			
			<!-- Modal -->
			
			  <div class="modal-dialog modal-lg">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h3 class="modal-title color-orange">Client: ${agent.nom} ${agent.prenoms}</h3>
			      </div>
			      
			      <div class="modal-body" style="padding: 0px 50px">
			      
					<div class="row">
					  <div class="col-md-12 color-orange"><h4>Informations personnelles</h4></div>
					</div>
					<div class="row">
					  <div class="col-md-3">Nom et prénoms:</div><div class="col-md-9 bold"> ${agent.nom} ${agent.prenoms}</div>
					  
					  <div class="col-md-3">Date de n.:</div><div class="col-md-9 bold"> ${agent.dateNaissance}</div>
					  <div class="col-md-3">Lieu de n.:</div><div class="col-md-9 bold"> ${agent.lieuNaissance} </div>
					  <div class="col-md-3">Adresse:</div><div class="col-md-9 bold"> ${agent.adresse} </div>
					  
					  <div class="col-md-3">Pièce d'identité:</div><div class="col-md-9 bold">${agent.piece} </div>
					  <div class="col-md-3">Type de pièce:</div><div class="col-md-9 bold"> ${agent.typePiece} </div>
					</div>
					<div class="row">
					  <div class="col-md-12 color-orange" style="margin-top:15px"><h4>Comptes</h4></div>
					</div>
					<!-- <div class="row">
					  
					  <div class="col-md-2">Mobile:</div><div class="col-md-10 bold">${agent.telMobile}</div>
					  <div class="col-md-2">Fixe:</div><div class="col-md-10 bold">${agent.telFixe}</div>
					  
					  <div class="col-md-2">Aviso:</div><div class="col-md-10 bold">${agent.aviso}</div>
					  <div class="col-md-2" style="margin-bottom:15px">Orange Money:</div><div class="col-md-10 bold">${agent.orangeMoney}</div>
					  
					  
					  
					</div> -->
								      	
			     
			      </div>
			      
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
			      </div>
			    </div>
			
			  </div>
		       	