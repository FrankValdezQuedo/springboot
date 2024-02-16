// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuario();
  $('#dataTable').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario(){
 document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}
async function cargarUsuario(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization':localStorage.token
             }
  });
  const usuarios = await request.json();

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
function getHeaders(){
return {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization':localStorage.token
   }
}

async function eliminarUsuario(id){
if(!confirm('Desea eliminar un usuario?')){
return;
}

  const request = await fetch('api/usuario/'+id, {
    method: 'DELETE',
    headers: getHeaders()
  });
  location.reload();
}