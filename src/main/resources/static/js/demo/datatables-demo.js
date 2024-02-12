// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuario();
  $('#dataTable').DataTable();
});
async function cargarUsuario(){

  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json();
  console.log("usua :"+ usuarios);

  let listadohmtl = '';

  for(let user of usuarios){
  let usuarioshtml = '<tr><td>'+user.id+'</td><td>'+user.nombre+''+user.apellido+
  '</td><td>'+user.email+'</td><td>'+user.telefono+
  '</td><td><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';

  listadohmtl+= usuarioshtml;
  }
  document.querySelector('#dataTable tbody').outerHTML = listadohmtl;
}