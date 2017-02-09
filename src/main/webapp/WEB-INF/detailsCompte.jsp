<div class="modal-dialog modal-lg">
			
   <!-- Modal content-->
   <div class="modal-content" data-bind="foreach: {data: vm.comptes, as:'c'}">
     <div class="modal-header">
       <button type="button" class="close" data-dismiss="modal">&times;</button>
       <h3 class="modal-title color-orange" data-bind=""> Détails compte: <span  data-bind="text: c.id"></span></h3>
     </div>
     
     <div class="modal-body" style="padding: 0px 50px" >
     			
			<table class="table table-bordered  table-hover" style="width: 70%; margin: 15px auto" id="dataTable">
										
					<tbody class="detailsTable">
					
						 <tr>
						 	<td width="35%">Master ID</td>
			                <td data-bind="text: masterId"></td>
			             </tr>
			             <tr>
						 	<td width="35%">Compte ID</td>
			                <td data-bind="text: id"></td>
			             </tr>
						 <tr>
						 	<td width="35%">Nom</td>
			                <td data-bind="text: nom"></td>
			             </tr>
			             <tr>
						 	<td>Prénoms</td>
			                <td data-bind="text: prenoms"></td>
			             </tr>
			             <tr>
						 	<td>Date de naissance</td>
			                <td data-bind="text: dateNaissance"></td>
			             </tr>
			             <tr>
						 	<td>Lieu de naissance</td>
			                <td data-bind="text: lieuNaissance"></td>
			             </tr>
			             <tr>
						 	<td>Pièce</td>
			                <td data-bind="text: piece"></td>
			             </tr>
			             <tr>
						 	<td>Type de pièce</td>
			                <td data-bind="text: typePiece"></td>
			             </tr>
			             <tr>
						 	<td>Compte contribuable</td>
			                <td data-bind="text: compteContri"></td>
			             </tr>
			             <tr>
						 	<td>Numéro</td>
			                <td data-bind="text: numero"></td>
			             </tr>
			             <tr>
						 	<td>Type de service</td>
			                <td data-bind="text: typeService"></td>
			             </tr>
			             <tr>
						 	<td>Type de compte</td>
			                <td data-bind="text: typeCompte"></td>
			             </tr>
			             <tr>
						 	<td>Statut</td>
			                <td data-bind="text: statut"></td>
			             </tr>
			             
			             <tr>
						 	<td>Systeme source code</td>
			                <td data-bind="text: source"></td>
			             </tr>
			             <tr>
						 	<td>Master ID B2C</td>
			                <td data-bind="text: masterIdB2C"></td>
			             </tr>
					
					</tbody>
				</table>
			
    
     </div>
     
     <div class="modal-footer">
       <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
     </div>
   </div>
   
   <script type="text/javascript">
   		$('.detailsTable tr td:nth-child(2)').css('font-weight','bold');
   </script>

 </div>