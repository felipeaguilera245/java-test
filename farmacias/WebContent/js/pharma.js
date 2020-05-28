var table;

$(document).ready(function() {

	getComuneList();
	getPharmaList();

});

$("#search_pharma").click(function() {

	// console.log("search");

	getPharma();

});

function getComuneList() {

	$.ajax({
		method : 'GET',
		async : true,
		url : "/farmacias/api/pharma/comune"
	}).done(
			function(response) {

				$("#comune_select").append(response.options);

				$("#comune_select").append(
						"<option value='-1' selected> Seleccione...</option>");

			});

	$('#comune_select').select2({
		multiple : false,
		placeholder : "Buscar ...",
		width : "100%"
	})

}

function getPharmaList() {

	$.ajax({
		method : 'GET',
		async : true,
		url : "/farmacias/api/pharma/pharma_names"
	}).done(
			function(response) {

				$("#pharma_select").append(response.pharma_options);

				$("#pharma_select").append(
						"<option value='-1' selected> Seleccione...</option>");

			});

	$('#pharma_select').select2({
		multiple : false,
		placeholder : "Buscar ...",
		width : "100%"
	})

}

function getPharma() {

	var pharma_array = null;

	var comune_select = $("#comune_select").val();

	var pharma_select = $("#pharma_select").val();

	$.ajax(
			{
				method : 'GET',
				async : false,
				url : "/farmacias/api/pharma/list/" + comune_select + "/"
						+ pharma_select
			}).done(function(response) {

		pharma_array = response.pharma_results;

		$("#pharma_table").show();

		if (pharma_array.length > 0) {

			table = $('#pharma_table').DataTable({
				data : pharma_array,
				'columnDefs' : [ {
					"targets" : 0,
					"render" : function(url, type, full) {
						return full.local_nombre;
					}
				}, {
					"targets" : 1,
					"render" : function(url, type, full) {
						return full.local_direccion;
					}
				}, {
					"targets" : 2,
					"render" : function(url, type, full) {
						return full.local_telefono;
					}
				}, {
					"targets" : 3,
					"render" : function(url, type, full) {
						return full.local_lat;
					}
				}, {
					"targets" : 4,
					"render" : function(url, type, full) {
						return full.local_lng;
					}
				} ],
				'columns' : [ {
					'data' : null
				}, {
					'data' : null
				} ]
			});

		} else {

			$("#pharma_table").html("Sin resultados");

		}

		table.destroy();

	});

}
