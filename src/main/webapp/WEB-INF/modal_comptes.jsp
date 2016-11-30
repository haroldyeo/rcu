<div class="modal-dialog ">
			
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
	  <div class="col-md-5">Nom et prénoms:</div><div class="col-md-7 bold"><span  data-bind="text: nom" ></span>&nbsp;<span  data-bind="text: prenoms"></span></div>
	  
	  <div class="col-md-5">Date de naissance:</div><div class="col-md-7 bold" data-bind="text: dateNaissance"> </div>
	  <div class="col-md-5">Lieu de naissance:</div><div class="col-md-7 bold" data-bind="text: lieuNaissance">  </div>
	  <div class="col-md-5">Adresse:</div><div class="col-md-7 bold" data-bind="text: adresse"> </div>
	  
	  <div class="col-md-5">Pièce d'identité:</div><div class="col-md-7 bold" data-bind="text: piece"> </div>
	  <div class="col-md-5">Type de pièce:</div><div class="col-md-7 bold" data-bind="text: typePiece"> </div>
	</div>
	<div class="row">
	  <div class="col-md-12 color-orange" style="margin-top:15px"><h4>Comptes</h4></div>
	</div>
						
	<div class="row">
		<table class="table table-bordered" >
			<tbody data-bind="foreach: {data: vm.comptes, as:'c'}">
				<tr>
					<td width="35%">N° compte: <strong data-bind="text: c.id"></strong></td>
					<td>
						<!-- ko if: (c.telFixe != null && c.telFixe.length > 0) -->
							Fixe: <strong data-bind="text: c.telFixe"></strong> <br />
						<!-- /ko  -->
						
						<!-- ko if: (c.telMobile != null && c.telMobile.length > 0) -->
							Mobile: <strong data-bind="text: c.telMobile"></strong> <br />
						<!-- /ko  -->
						
						<!-- ko if: (c.aviso!=null && c.aviso.length > 0) -->
							Aviso: <strong data-bind="text: c.aviso"></strong> <br />
						<!-- /ko  -->
						
						<!-- ko if: (c.orangeMoney != null && c.orangeMoney.length > 0) -->
							OM: <strong data-bind="text: c.orangeMoney"></strong> <br />
						<!-- /ko  -->
						
					
					</td> 
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