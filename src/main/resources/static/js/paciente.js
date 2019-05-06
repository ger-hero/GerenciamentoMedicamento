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

function formatData(json){
	let imageTeste = 0;
	paciente = $('#pacientesTable');
	$.each(json, function(idx, objP){
		paciente.append('<tr><td>' + objP.id + '</td>' + '<td>' + objP.nome + '</td>' + '<td>' + objP.ala + '</td>' +  '<td>' + '<img src="data:image/png;base64, ' + objP.imagem + '\">' + '</td>' +  '</tr>')
		imageTeste = imageTeste + 1;
		console.log(objP.imagem);
		if(imageTeste >= 1){
			return false;
		}
	});
	
//	paciente = $('.panel .carta .titulo');
//	$.each(json, function(idx, objP){
//		paciente.append('<div class="teste">' + objP.nome + '</div>')
//	});
	
	let teste = 0;
	paciente = $('.panel');
	$.each(json, function(idx, objP){
		paciente.append('<div class="carta">' + '<a href="#">' + '<div class="imagem">' + '<img src="images/adulto-cabelo-cara-220453.jpg"/>' +'</div>' + '</a>' + '<div class="titulo">' + objP.nome+ '</div>' +'</div>')
		teste = teste + 1;
//		if(teste >= 4){
//			return false;
//		}
	});
	
	
}