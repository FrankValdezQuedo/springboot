package cursoJava.curso.controllers;

import cursoJava.curso.dao.UsuarioDao;
import cursoJava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
 @RequestMapping(value = "usuario/{id}")
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
    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuario(){
     return usuarioDao.getUsuarios();
    }
}
