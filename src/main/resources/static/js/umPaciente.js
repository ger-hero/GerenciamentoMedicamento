$(document).ready(function () {
        event.preventDefault();
        console.log(getIdFromUrl());
        listaPacienteId(getIdFromUrl());
        getRegistroPaciente(getIdFromUrl());
        getMedicamentosPaciente(getIdFromUrl());
});


function getIdFromUrl(){
    var url = window.location.href;
    var id = url.substring(url.lastIndexOf('/') + 1);
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

function getMedicamentosPaciente(id) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getMedicamentos/" + id,
        //data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {	
        	formatBotoesMedicamento(data)
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

function insertRegisto(id, remedio, turno) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/insertRegistro/" + id +"/"+ remedio +"/"+ turno,
        //data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {	
        	getRegistroPaciente(id);
            //getMedicamentosPaciente(id);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
    
}

function formatInformacao(json){
	// Painel infos
	panel = $('.perfil');
	panel.html(
				'<div class="informacoes">' +
					'<div class="foto"><img src="' + json.imagem + '\">' + '</div>' +
					'<div class="infos">' +
						'<div class="icone">' +
							'<i class="fa fa-user-circle fa-2x"></i>' +
						'</div>' +
						'<div class="dados">' +
							'<div class="nome"><strong>Nome: </strong>' + json.nome + '</div>' +
							'<div class="ala"><strong>Ala: </strong>' + json.ala + '</div>' +
						'</div>' +
						'<div class="doencas"></div>' +
					'</div>' +
				'</div>');
	
	doencas = $('.perfil .informacoes .doencas');
	$.each(json.doencas, function(idx, objP){
		doencas.append('<div class="doenca doenca-' + idx + '\">' +
							'<div class="doenca-nome">' +
								'<div><strong>Doença:</strong></div>' +
								'<div>' + objP.nome + '</div>' +
							'</div>' +
							'<div class="doenca-descricao">' +
								'<div><strong>Descrição:</strong></div>' +
								'<div>' + objP.exemplo + '</div>' +
							'</div>' +
							'<div class="doenca-agressividade">' +
								'<div><strong>Agressividade:</strong></div>' +
								'<div id="icone"></div>' +
							'</div>' +
						'</div>');
		doencaIcone = $('.doenca-agressividade #icone');
		if(objP.agressivo){
			doencaIcone.append('<i class="fas fa-exclamation-circle icone--agressivo"></i>');
		}else{
			doencaIcone.append('<i class="fas fa-times icone--nagressivo" ></i>');
		}
		
		// Fim painel infos
	});	
	//$.each(json.doencas, function(idx, objP){
	//	alert(objP.doenca);
	//});
	//modalFooter.html('<a href="/paciente/' +  json.id + '\"' +  'class="btn btn-success"><i class="fas fa-edit"></i></a>');
}	

function formatTabelaRegistros(json){
	registrosRemedios = $('#historicoRemedios');
	limpaTabela();
	$.each(json, function(idx, objRegistro){
		registrosRemedios.append('<tr><td>' + objRegistro.data + '</td>' + '<td>' + objRegistro.manha + '</td>' + '<td>' + objRegistro.tarde  + '</td>' + '<td>' + objRegistro.noite  + '</td></tr>');
	});
}

function formatBotoesMedicamento(json){
	console.log(json);
	aplicacaoMedicamentos = $('.medicacoes');
	$.each(json, function(idx, objMedicacao){
		//remedio = "'remediotal'";
		remedio = "'" + objMedicacao.remedio+"'";
		turno = "'" + objMedicacao.turno+"'";
		aplicacaoMedicamentos.append('<div class="carta-medicacao">' +
								   		'<div class="nome">' + objMedicacao.doenca + '</div>' +
								   		'<div class="remedio">' + objMedicacao.remedio + '</div>' +
								   		'<div class="botao">' +
								   			'<a href="javascript:void(0);" class="btn btn-red"  onclick="insertRegisto(' + objMedicacao.idPaciente +","+remedio+","+turno+ ')">Medicar</a>' +
								   		'</div>' + 
								   '</div>');
	});	
}

function limpaTabela(){
	$("#historicoRemedios").find("tr:gt(0)").remove()
}














