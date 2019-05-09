$(document).ready(function () {
        event.preventDefault();
       
});


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
	
}