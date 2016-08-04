<%@ include file="taglibs.jsp" %>
		
<!-- Modal -->
		<!-- Trigger the modal with a button -->
<!-- 			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button> -->
			
			<!-- Modal -->
			<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Détails client</h4>
			      </div>
			      <div class="modal-body">
			        <table class="detailsTable" style="width: 70%">
			        
			        	<c:forEach items="${dataAgents}" var="ag">
			        		<c:if test="${ag.id == id_selected})">
			        			<tr>
									<td>Nom: </td> <td><input type="text"  readonly="readonly"></td>
								</tr>
								<tr>
									<td>Prénoms:</td> <td><input type="text"  readonly="readonly"></td>
								</tr>
								<tr>
									<td>Téléphone: </td> <td><input type="text"  readonly="readonly"></td>
								</tr>
								<tr>
									<td>Adresse: </td> <td><input type="text"  readonly="readonly"></td>
								</tr>
								<tr>
									<td>Date de naissance: </td> <td><input type="text"  readonly="readonly"></td>
								</tr>
								<tr>
									<td>Lieu de naissance: </td> <td><input type="text"  readonly="readonly"></td>
								</tr>
			        		</c:if>
			        	</c:forEach>	
					</table>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
			      </div>
			    </div>
			
			  </div>
			</div>