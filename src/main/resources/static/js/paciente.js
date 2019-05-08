$(document).ready(function () {
        event.preventDefault();
        listaPacientes();
});

function listaPacientes() {
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
            
            formatCarta(data);

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
function listaPacienteId(id) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getUmPaciente/" + id,
        //data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	formatModal(data);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}


function formatCarta(json){
	var objeto = [];
	paciente = $('.panel');
	$.each(json, function(idx, objP){
		paciente.append('<div class="carta">' + '<a href="#" class="teste" onclick="listaPacienteId(' + objP.id + ')">' + '<div class="imagem">' + '<img src="' + objP.imagem + '\">' +'</div>' + '</a>' + '<div class="titulo">' + objP.nome + '</div>' +'</div>')
//		paciente.append('<div class="carta">' + '<a href="#" class="teste" onclick="teste()">' + '<div class="imagem">' + '<img src="' + objP.imagem + '\">' +'</div>' + '</a>' + '<div class="titulo">' + objP.nome + '</div>' +'</div>')
	});
}

function formatModal(json){
	alert(json.nome)
	console.log(json.nome);
}	
	
