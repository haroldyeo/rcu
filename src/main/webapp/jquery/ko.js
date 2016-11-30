
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
function onSubmit(nom, prenoms, dateNaissance, lieuNaissance, piece, typePiece) {
	var data = {
		nom : nom,
		prenoms : prenoms,
		dateNaissance : dateNaissance,
		lieuNaissance : lieuNaissance,
		piece : piece,
		typePiece : typePiece
	};

	$.post("home", data, function(response) {
		doMajAgent(JSON.parse(response));
	}).fail(function() {
		alert('Une Erreur est survenue!');
	});

}


// Recherche par id pour faire afficher le popup de details
function onSubmitDetails(obj) {
	var data = {
		compteId : obj.id
	};
	$.post("findComptes", data, function(response) {
		var agentAndComptes = JSON.parse(response);
		var agent = agentAndComptes[0];  doMajAgentSelected(agent);
		var comptes = agentAndComptes[1]; doMAJComptes(comptes);
		
	}).fail(function() {
		alert('Une Erreur est survenue!');
	});

	
}


// Activates knockout.js
ko.applyBindings(vm);
