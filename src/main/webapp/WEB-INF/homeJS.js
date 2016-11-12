$(document).ready(function(){
		
		$(".btnDetais").click(function(){
			alert();
			var id = $(this).attr("data-id");
			alert(id);
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