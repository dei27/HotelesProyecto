$('#reservas').DataTable({
  "deferRender": true,
  "pagingType": "simple_numbers",
  "lengthMenu": [5, 10, 25, 50],
  "pageLength": 5,
  "language": {
	  "search": "Buscar",
	  "zeroRecords": "No tenemos lo que buscas",
    "paginate": {
      "first": "Primero",
      "last": "Último",
      "next": "Siguiente",
      "previous": "Anterior",
    },"lengthMenu": "Mostrar _MENU_ registros por página"
  },
  "dom": '<"top"f>t<"bottom-right"p><"clear">'
});

$('#huespedesLista').DataTable({
  "deferRender": true,
  "pagingType": "simple_numbers",
  "lengthMenu": [10, 25, 50, 100],
  "pageLength": 10,
  "language": {
	  "search": "Buscar",
	  "zeroRecords": "No tenemos lo que buscas",
    "paginate": {
      "first": "Primero",
      "last": "Último",
      "next": "Siguiente",
      "previous": "Anterior",
    },"lengthMenu": "Mostrar _MENU_ registros por página"
  },
  "dom": '<"top"f>t<"bottom-right"p><"clear">'
});