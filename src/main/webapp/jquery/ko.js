// This is a simple *viewmodel* - JavaScript that defines the data and behavior of your UI

// viewModel object
var vm = {
	agents : ko.observableArray(),
	agentSel : ko.observable(),
	displayModal : function(data) {
		onSubmitDetails(data);
	}
};

// obtenir la liste d'agents initiale depuis inputAgents
var dataInput = $("#inputAgents").val();
var dataParsed;
if(dataInput != ''){
	dataParsed = JSON.parse(dataInput);
}

if(dataParsed != '')
	buildListAgents(dataParsed);

// MAJ des données d'agents
function buildListAgents(data) {
	vm.agents(data);
}

// MAJ détails de l'agent
function buildAgent(data){
	vm.agentSel(data);
//	alert(vm.agentSel().nom +"    -    " +vm.agentSel().prenoms);
}

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
		buildListAgents(JSON.parse(response));
	}).fail(function() {
		alert('Une Erreur est survenue!');
	});

}


// Recherche par id pour faire afficher le popup de details
function onSubmitDetails(obj) {
	var data = {
		compteId : obj.id
	};
	$.post("find2", data, function(response) {
		$("#myModal").html(response);
//		var agentSelected = JSON.parse($("#inputDetailAgent").val());
//		buildAgent(agentSelected);
	}).fail(function() {
		alert('Une Erreur est survenue!');
	});

	
}

// Activates knockout.js
ko.applyBindings(vm);