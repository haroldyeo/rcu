// This is a simple *viewmodel* - JavaScript that defines the data and behavior of your UI

// viewModel object
var vm = {
	agents : ko.observableArray(),
	agentSel : ko.observable(),
	displayModal : function(data) {
		onSubmitDetails(data);
	},
	hello : ko.observable("hello")
};

// obtenir la liste d'agents initiale depuis inputAgents
var v = JSON.parse($("#inputAgents").val());
buildListAgents(v);

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
function onSubmit(nom, prenoms, tel, adresse, dateNaissance, lieuNaissance,
		piece, typepiece) {
	var data = {
		nom : nom,
		prenoms : prenoms,
		tel : tel,
		adresse : adresse,
		dateNaissance : dateNaissance,
		lieuNaissance : lieuNaissance,
		piece : piece
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
		id : obj.id
	};
	$.post("find2", data, function(response) {
		$("#myModal").html(response);
		var agentSelected = JSON.parse($("#inputDetailAgent").val());
		buildAgent(agentSelected);
	}).fail(function() {
		alert('Une Erreur est survenue!');
	});

	
}

// Activates knockout.js
ko.applyBindings(vm);
