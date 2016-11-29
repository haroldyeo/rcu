
// viewModel object
var vm = {
	agents : ko.observable(),
	agentSelected : ko.observable(),
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
	$.post("find2", data, function(response) {
//		$("#myModal").html(response);
//		$("#inputDetailAgent").val(response);
//		alert($("#inputDetailAgent").val());
		var agentSelected = JSON.parse(response);
		doMajAgentSelected(agentSelected);
	}).fail(function() {
		alert('Une Erreur est survenue!');
	});

	
}

//ko.bindingHandlers.modal = {
//	    init: function (element, valueAccessor) {
//	        $(element).modal({
//	            show: false
//	        });
//
//	        var value = valueAccessor();
//	        if (ko.isObservable(value)) {
//	            $(element).on('hide.bs.modal', function() {
//	               value(false);
//	            });
//	        }
//
//	    },
//	    update: function (element, valueAccessor) {
//	        var value = valueAccessor();
//	        if (ko.utils.unwrapObservable(value)) {
//	            $(element).modal('show');
//	        } else {
//	            $(element).modal('hide');
//	        }
//	    }
//	}

// Activates knockout.js
ko.applyBindings(vm);
