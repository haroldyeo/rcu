
// viewModel object
var vm = {
	agents : ko.observable(),
	agentSelected : ko.observable(),
	comptes : ko.observableArray(),
	displayModal : function(data) {
		onSubmitDetails(data);
	}
};

// MAJ des données d'agents
function doMajAgent(data) {
	vm.agents(data);
}

// MAJ détails de l'agent
function doMajAgentSelected(data){
	vm.agentSelected(data);
//	alert(vm.agentSelected().nom +"    -    " +vm.agentSelected().prenoms);
}

//MAJ des comptes
function doMAJComptes(data) {
	vm.comptes(data);
}

// MAJ des infos des comptes

// Recherche de 1er niveau
function onSubmit(nom, prenoms, dateNaissance, piece, compteContri, numero, idCompte) {
	var data = {
		nom : nom,
		prenoms : prenoms,
		dateNaissance : dateNaissance,
		piece : piece,
		compteContri : compteContri,
		numero : numero,
		idCompte: idCompte
	};

	$.post("home", data, function(response) {
//		alert(response);
		if(response.length > 0 && response != '[]'){
			doMajAgent(JSON.parse(response));
		}else{
			doMajAgent('');
			$("#divNoData").text("Aucune donnée ne correspond aux critères de recherche").slideDown("3000").delay(4000).slideUp("3000");
		}
			
	}).fail(function() {
		alert('Une Erreur est survenue!');
	});

}


// Recherche par id pour faire afficher le popup des comptes
function onSubmitDetails(obj) {
	var data = {
		compteId : obj.id
	};
	$.post("detailsCompte", data, function(response) {
		var detailCompte = JSON.parse(response);
		var compte = detailCompte[0]; 
		doMAJComptes(compte);
		
	}).fail(function() {
		alert('Une Erreur est survenue!');
	});

	
}


// Activates knockout.js
ko.applyBindings(vm);
