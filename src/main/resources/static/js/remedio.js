/**
 * 
 */

$(document).ready(function () {
    $("#pesq").click(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        limparListaRemedios();
        fire_ajax_submit();
    });
});
function limparListaRemedios(){
	$("#remediosTable tbody tr").remove();
}

function fire_ajax_submit() {
    var search = {}
    search["username"] = $("#username").val();
    $("#btn-search").prop("disabled", true);
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getRemedios",
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
	medicamento = $('#remediosTable');
	$.each(json, function(idx, objM){
		medicamento.append('<tr><td>' + objM.id + '</td>' + '<td>' + objM.nome + '</td>' + '<td>' + objM.indicacao  + '</td>' + '<td>' + objM.manha  + '</td>' + '<td>' + objM.tarde + '</td>' + '<td>' + objM.noite + '</td></tr>')
	});
}