
function onSubmit(nom, prenoms, tel, adresse, dateNaissance, lieuNaissance, piece, typepiece){

	  var v_url="find";
	  var v_type= "POST";
	  $.ajax({
		  type: v_type,
		  url: v_url,
		  data: {
				      nom: nom,
				      prenoms: prenoms,
				      tel: tel,
				      adresse: adresse,
				      dateNaissance: dateNaissance,
				      lieuNaissance: lieuNaissance,
				      piece: piece,
//				      typepiece : typepiece
			      },
		  dataType: 'text',
		  success: function(response){
			  $("#dataDiv").html(response);
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

$(document).ready(function(){
		
		$(".btnDetails").click(function(){
			var id = $(this).attr("data-id");
//			alert("sbmit");
			onSubmitDetails(id);
		});
		
		
		var nom, prenoms, tel, adresse, dateNaissance, lieuNaissance, piece;
		$("#btnSearch").click(function(){
			nom = $("#txtNom").val();
			prenoms = $("#txtPrenom").val();
			tel = $("#txtPhone").val();
			adresse = $("#txtAdresse").val();
			dateNaissance = $("#txtDob").val();
			lieuNaissance = $("#txtLob").val();
			piece = $("#txtPiece").val();
//			typepiece = $("#txtTypePiece").val();
			
			if(nom==''){
				$("#diverror").text("Le champs Nom est obligatoire").slideDown("3000").delay(4000).slideUp("3000");
			}else 
			if(prenoms==''){
				$("#diverror").text("Le champs Prénoms est obligatoire").slideDown("3000").delay(4000).slideUp("3000");
			}
			
			if(nom!='' && prenoms != ''){
				if(tel=='' && adresse=='' && dateNaissance=='' && lieuNaissance=='' && piece=='' ){
					$("#diverror").text("Saisir au moins un paramètre supplémentaire").slideDown("3000").delay(4000).slideUp("3000");
				} else {
					onSubmit(nom, prenoms, tel, adresse, dateNaissance, lieuNaissance, piece);
				}
			}
			
			
		});
		
		$("#btnRefresh").click(function(){
			$("#txtNom").val("");
			$("#txtPrenom").val("");
			$("#txtPhone").val("");
			$("#txtAdresse").val("");
			$("#txtDob").val("");
			$("#txtLob").val("");
			$("#txtPiece").val("");
//			$("#txtTypePiece").val("");
			window.location.reload();
		});
		
	});
