// Call the dataTables jQuery plugin
$(document).ready(function() {
cargarUsuario();
  $('#dataTable').DataTable();
});
async function cargarUsuario(){

  const request = await fetch('usuario', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json();
  console.log(usuarios);

  document.querySelector('#dataTable tbody').outerHTML = '<tr><td>Tiger Nixon</td><td>System Architect</td><td>Edinburgh</td><td>61</td><td><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';

}