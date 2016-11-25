<%@ include file="taglibs.jsp" %>
		
			
			<!-- Modal -->
			
			  <div class="modal-dialog ">
			
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
					  <div class="col-md-5">Nom et prénoms:</div><div class="col-md-7 bold"> ${agent.nom} ${agent.prenoms}</div>
					  
					  <div class="col-md-5">Date de naissance:</div><div class="col-md-7 bold"> ${agent.dateNaissance}</div>
					  <div class="col-md-5">Lieu de naissance:</div><div class="col-md-7 bold"> ${agent.lieuNaissance} </div>
					  <div class="col-md-5">Adresse:</div><div class="col-md-7 bold"> ${agent.adresse} </div>
					  
					  <div class="col-md-5">Pièce d'identité:</div><div class="col-md-7 bold">${agent.piece} </div>
					  <div class="col-md-5">Type de pièce:</div><div class="col-md-7 bold"> ${agent.typePiece} </div>
					</div>
					<div class="row">
					  <div class="col-md-12 color-orange" style="margin-top:15px"><h4>Comptes</h4></div>
					</div>
					
					<div class="row" style="padding: 10px 0px">
						Master ID: <strong>${masterId}</strong>
					</div>
					
					<div class="row">
						<table class="table table-bordered" >
							<c:forEach items="${comptes}" var="a">
							<tr>
								<td width="35%">N° compte: <strong>${a.id}</strong></td>
								<td>
									<c:if test="${!empty a.telFixe}">Fixe: <strong>${a.telFixe}</strong> <br /></c:if> 
									<c:if test="${!empty a.telMobile}">Mobile: <strong>${a.telMobile}</strong> <br /></c:if> 
						  			<c:if test="${!empty a.aviso}">Aviso: <strong>${a.aviso}</strong> <br /></c:if> 
						  			<c:if test="${!empty a.orangeMoney}">OM: <strong>${a.orangeMoney}</strong> <br /></c:if> 
									<!-- WIMAX TO BE ADDED -->
								</td>
							</tr>
<!-- 							<tr> -->
								
<!-- 							</tr> -->
							</c:forEach>
						</table>
					
					</div>      	
			     
			      </div>
			      
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
			      </div>
			    </div>
			
			  </div>
		       	