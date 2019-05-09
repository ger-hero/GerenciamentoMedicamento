$(document).ready(function () {
        event.preventDefault();
        listaPacienteId(getIdFromUrl());
});


function getIdFromUrl(){
    var url = window.location.href;
    var id = url.substring(url.lastIndexOf('/') + 1);
    console.log(id);
    return id;
}

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
        	formatInformacao(data)
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

function formatInformacao(json){
	//alert(json.nome)
	//console.log(json.nome);
	panel = $('.panel .nome');
	//panel-nome = $('.nome');
	panel.html('<strong>Nome: </strong>' + json.nome);
	//modalFooter.html('<a href="/paciente/' +  json.id + '\"' +  'class="btn btn-success"><i class="fas fa-edit"></i></a>');
}	













