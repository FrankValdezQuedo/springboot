// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuario();
  $('#dataTable').DataTable();
});
async function cargarUsuario(){

  const request = await fetch('api/usuarios', {
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
  let boton ='<a href="#" onclick="eliminarUsuario('+user.id+')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
  let usuarioshtml = '<tr><td>'+user.id+'</td><td>'+user.nombre+''+user.apellido+
  '</td><td>'+user.email+'</td><td>'+user.telefono+
  '</td><td>'+boton+'</td></tr>';

  listadohmtl+= usuarioshtml;
  }
  document.querySelector('#dataTable tbody').outerHTML = listadohmtl;
}

async function eliminarUsuario(id){
if(!confirm('Desea eliminar un usuario?')){
return;
}

  const request = await fetch('api/usuario/'+id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  location.reload();
}