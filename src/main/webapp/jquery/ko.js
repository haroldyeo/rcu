 // This is a simple *viewmodel* - JavaScript that defines the data and behavior of your UI
  	
	
	var vm = {
		agents :  ko.observableArray(),
		displayModal : function(data){
			onSubmitDetails(data);
		}
	};
		var v = JSON.parse($("#inputAgents").val());
		constructAgents(v);
	  	
  	function constructAgents(data){
  		vm.agents(data);
  	}
  	  	
  	function onSubmit(nom, prenoms, tel, adresse, dateNaissance, lieuNaissance, piece, typepiece){
  		var data = {nom: nom,
    		      prenoms: prenoms,
    		      tel: tel,
    		      adresse: adresse,
    		      dateNaissance: dateNaissance,
    		      lieuNaissance: lieuNaissance,
    		      piece: piece};
    	
    	$.post("home", 	data, function(response){
    		alert(response);
    		constructAgents(JSON.parse(response));
    	  }).fail(function(){
    		  alert('Une Erreur est survenue!');
    	  });
  		
  	}
  	
  	function onSubmitDetails(id){
  		var data = {id:id};
  		$.post("find2", data, function(response){
  			  $("#myModal").html(response);
  		  }).fail(function(){
  			  alert('Une Erreur est survenue!');
  		  });
  	}
 

  	// Activates knockout.js
//  	ko.applyBindings(displayModal);
  	ko.applyBindings(vm);
  	