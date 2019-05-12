$(document).ready(function () {
        event.preventDefault();
        listaPacienteId(getIdFromUrl());
        getRegistroPaciente(getIdFromUrl());
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

function getRegistroPaciente(id) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getRegitroHistorico/" + id,
        //data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	formatTabelaRegistros(data)
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

function formatInformacao(json){
	//alert(json.nome)
	//console.log(json.doencas);
	panel = $('.perfil');
	//panel-nome = $('.nome');
	panel.html('<div class="foto"><img src="' + json.imagem + '\">' + '</div>' +
				'<div class="linha"><div class="icone"><i class="fa fa-chevron-right"></i></div></div>' +
				'<div class="informacoes">' +
					'<div class="dados">' +
						'<div class="nome"><strong>Nome: </strong>' + json.nome + '</div>' +
						'<div class="ala"><strong>Ala: </strong>' + json.ala + '</div>' +
					'</div>' +
				'<div class="doencas">' + json.doencas[0].exemplo + '</div>' +
				'</div>');
	//modalFooter.html('<a href="/paciente/' +  json.id + '\"' +  'class="btn btn-success"><i class="fas fa-edit"></i></a>');
}	

function formatTabelaRegistros(json){
	console.log(json);
}












