function onSubmit(nom, prenoms, tel, adresse, dateNaissance, lieuNaissance){

	  var v_url="find.jsp?ajax=true&controle=true";
	  var v_type= "POST";
	  $.ajax({
		  type: v_type,
		  url: v_url,
		  data: {
			    test: JSON.stringify({
				      nom: nom,
				      prenoms: prenoms,
				      tel: tel,
				      adresse: adresse,
				      dateNaissance: dateNaissance,
				      lieuNaissance: lieuNaissance
			      }),
		    },
		  dataType: 'text',
		  success: function(response){
			  $("#dataTable").html(response);
		  },
		  error: function(e){
		  alert('Une Erreur est survenue!');
		  }		
	  });
  }


function onSubmitDetails(id){

//	  var v_url="find2.jsp?ajax=true&controle=true";
	var v_url="find2";
	  var v_type= "POST";
	  $.ajax({
		  type: v_type,
		  url: v_url,
//		  data: "test",
		  data : {
				id : id
			},
		  dataType: 'text',
		  success: function(response){
			  $("#myModal").html(response);
		  },
		  error: function(e){
		  alert('Une Erreur est survenue!');
		  }		
	  });
}