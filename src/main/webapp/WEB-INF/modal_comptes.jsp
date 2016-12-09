<div class="modal-dialog modal-lg">
			
   <!-- Modal content-->
   <div class="modal-content" data-bind="with: agentSelected">
     <div class="modal-header">
       <button type="button" class="close" data-dismiss="modal">&times;</button>
       <h3 class="modal-title color-orange" data-bind=""> Client: <span  data-bind="text: nom" ></span>&nbsp;<span  data-bind="text: prenoms"></span></h3>
     </div>
     
     <div class="modal-body" style="padding: 0px 50px" >
     
	<div class="row">
	  <div class="col-md-12 color-orange"><h4>Informations personnelles</h4></div>
	</div>
	<div class="row">
	  <div class="col-md-3">Nom et prénoms:</div><div class="col-md-7 bold"><span  data-bind="text: nom" ></span>&nbsp;<span  data-bind="text: prenoms"></span></div>
	  
	  <div class="col-md-3">Date de naissance:</div><div class="col-md-7 bold" data-bind="text: dateNaissance"> </div>
	  <div class="col-md-3">Lieu de naissance:</div><div class="col-md-7 bold" data-bind="text: lieuNaissance">  </div>
	  <div class="col-md-3">Adresse:</div><div class="col-md-7 bold" data-bind="text: adresse"> </div>
	  
	  <div class="col-md-3">Pièce d'identité:</div><div class="col-md-7 bold" data-bind="text: piece"> </div>
	  <div class="col-md-3">Type de pièce:</div><div class="col-md-7 bold" data-bind="text: typePiece"> </div> 
	  <div class="col-md-3">Compte contribuable:</div><div class="col-md-7 bold" data-bind="text: compteContri"> </div>
	</div>
	<div class="row">
	  <div class="col-md-12 color-orange" style="margin-top:15px"><h4>Comptes</h4></div>
	</div>
						
	<div class="row">
		<table class="table table-bordered" >
			<thead>
				<tr>
					<th>N° de compte</th>
					<th>Numéro</th>
					<th>Type de compte</th>
					<th>Source</th>
					<th>Statut</th>
				</tr>
			</thead>
			<tbody data-bind="foreach: {data: vm.comptes, as:'c'}">
				
				<tr>
					<td width="25%"><strong data-bind="text: c.id"></strong></td>
					<td>
						<span data-bind="text: c.typeService"></span>: <strong data-bind="text: c.numero"></strong> <br />
					</td> 
					<td data-bind="text: c.typeCompte"></td>
					<td data-bind="text: c.systemSourceCode"></td>
					<td data-bind="text: c.statut"></td>
				</tr>
				
			</tbody>
		</table>
	</div>
   	
    
     </div>
     
     <div class="modal-footer">
       <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
     </div>
   </div>

 </div>