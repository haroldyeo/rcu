<%@ include file="taglibs.jsp" %>
		
<!-- Modal -->
		<!-- Trigger the modal with a button -->
<!-- 			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button> -->
			
			<!-- Modal -->
			
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Détails client</h4>
			      </div>
			      <div class="modal-body">
			        <table class="detailsTable" style="width: 70%">
			        
					        		<tr>
								<td>Nom: </td> <td><label>${agent.nom}</label></td>
							</tr>
							<tr>
								<td>Prénoms:</td> <td>${agent.prenoms}</td>
							</tr>
							<tr>
								<td>Téléphone: </td> <td>${agent.telFixe}</td>
							</tr>
							<tr>
								<td>Adresse: </td> <td>${agent.adresse}</td>
							</tr>
							<tr>
								<td>Date de naissance: </td> <td>${agent.dateNaissance}</td>
							</tr>
							<tr>
								<td>Lieu de naissance: </td> <td>${agent.lieuNaissance}</td>
							</tr>
					</table>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
			      </div>
			    </div>
			
			  </div>
		       	