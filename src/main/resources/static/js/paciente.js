/**
 * 
 */

$(document).ready(function () {
//    $("#pesq").click(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        limparListaPacientes();
        fire_ajax_submit();
//    });
});

function limparListaPacientes(){
	$("#pacientesTable tbody tr").remove();
}

function fire_ajax_submit() {
    var search = {}
    search["username"] = $("#username").val();
    $("#btn-search").prop("disabled", true);
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getPaciente",
        //data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);
            
            formatData(data);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
}

//get do id pelo onclick - tenho o id selecionado idclicado()
function searchViaAjaxId(id) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getUmPaciente/" + id,
        //data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	dataTeste(data);
  
            console.log("SUCCESS : ", id);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

function cliqueCarta(id){ 
	dataTeste();
};

function formatData(json){
	var objeto = [];
	let teste = 0;
	paciente = $('.panel');
	modal = $('#exampleModal .modal-body');
	$.each(json, function(idx, objP){
		paciente.append('<div class="carta">' + '<a href="#" class="teste" onclick="cliqueCarta(' + objP.id + ')">' + '<div class="imagem">' + '<img src="' + objP.imagem + '\">' +'</div>' + '</a>' + '<div class="titulo">' + objP.nome + '</div>' +'</div>')
//		paciente.append('<div class="carta">' + '<a href="#" class="teste" onclick="teste()">' + '<div class="imagem">' + '<img src="' + objP.imagem + '\">' +'</div>' + '</a>' + '<div class="titulo">' + objP.nome + '</div>' +'</div>')
		teste = teste + 1;
		objeto = teste;
		console.log(teste);
		// jogar para o modal
//		if(teste >= 4){
//			return false;
//		}
	});
}

function dataTeste(json){
	$.each(json, function(idx, objTeste){
		alert(objTeste.id, objTeste.nome);
	});
}	
	
