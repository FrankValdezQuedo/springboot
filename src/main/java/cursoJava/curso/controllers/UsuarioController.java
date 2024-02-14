package cursoJava.curso.controllers;

import cursoJava.curso.dao.UsuarioDao;
import cursoJava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
 @RequestMapping(value = "api/usuario/{id}",method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){
     Usuario usuario = new Usuario();
     usuario.setId(id);
     usuario.setNombre("Frank");
     usuario.setApellido("Valdez");
     usuario.setEmail("frank@gmail.com");
     usuario.setTelefono("923949332");
     usuario.setPassword("1232");
 return usuario;
 }
    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuario(){
     return usuarioDao.getUsuarios();
    }
    @RequestMapping(value = "api/usuario/{id}",method = RequestMethod.DELETE)
    public void Eliminar(@PathVariable Long id){
     usuarioDao.eliminar(id);
    }
}
