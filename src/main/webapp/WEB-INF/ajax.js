
//function onSubmit(nom, prenoms, tel, adresse, dateNaissance, lieuNaissance, piece, typepiece){
//
//	var data = {nom: nom,
//		      prenoms: prenoms,
//		      tel: tel,
//		      adresse: adresse,
//		      dateNaissance: dateNaissance,
//		      lieuNaissance: lieuNaissance,
//		      piece: piece};
//	
//	$.post("home", 	data, function(response){
//		alert(response);
//		  $("#inputAgents").val(response);
//	  }).fail(function(){
//		  alert('Une Erreur est survenue!');
//	  });
//  }



function onSubmitDetails(id){
	var data = {id:id};
	$.post("find2", data, function(response){
		  $("#myModal").html(response);
	  }).fail(function(){
		  alert('Une Erreur est survenue!');
	  });

}


