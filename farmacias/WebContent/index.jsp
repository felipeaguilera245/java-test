<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<title>Farmacias</title>

<script src="/farmacias/js/jquery-3.2.1.min.js"></script>
<script src="/farmacias/js/dataTables.responsive.min.js"></script>
<link href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" />
<link href="/farmacias/js/bootstrap.min.css" rel="stylesheet"
	media="all">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css"
	rel="stylesheet" />


<style>
td {
	padding: 2px;
}
</style>

</head>

<body>

	<div class="container .m-t-5">

		<div class="row p-3">

			<div class="col-lg-2 col-md-2">Comuna:</div>

			<div class="col-lg-2 col-md-2">

				<select id="comune_select">
					<option value="-1" selected>Seleccione...</option>
				</select>

			</div>
		</div>

		<div class="row p-3">

			<div class="col-lg-2 col-md-2">Farmacia:</div>

			<div class="col-lg-2 col-md-2">

				<select id="pharma_select">
					<option value="-1" selected>Seleccione...</option>

				</select>

			</div>

		</div>

		<div class="row p-3">

			<div class="col-lg-2 col-md-2 m-t-5">
				<button class="btn btn-success" id="search_pharma">Buscar</button>
			</div>

		</div>

	</div>

	<div class="col-lg-12 col-md-12 p-5">

		<table id="pharma_table" style="display: none;">
			<thead>
				<tr style="background-color: yellowgreen;">
					<th>Nombre</th>
					<th>Dirección</th>
					<th>Teléfono</th>
					<th>Latitud</th>
					<th>Longitud</th>
				</tr>
			</thead>

		</table>

	</div>



</body>

<script
	src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>

<script src="js/pharma.js"></script>

</html>


