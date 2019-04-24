/**
 * 
 */

$(document).ready(function () {

    $("#pesq").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        limparListaPacientes();
        fire_ajax_submit();

    });

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
	paciente = $('#pacientesTable');
	$.each(json, function(idx, objP){
		paciente.append('<tr><td>' + objP.id + '</td>' + '<td>' + objP.nome + '</td>' + '<td>' + objP.ala + '</td></tr>')
	});
}