package cursoJava.curso.controllers;

import cursoJava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
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
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setNombre("Frank");
        usuario.setApellido("Valdez");
        usuario.setEmail("frank@gmail.com");
        usuario.setTelefono("923949332");
        usuario.setPassword("1232");

        Usuario usuario1 = new Usuario();
        usuario1.setNombre("lucho");
        usuario1.setApellido("Valdez");
        usuario1.setEmail("frank@gmail.com");
        usuario1.setTelefono("923949332");
        usuario1.setPassword("1232");

        usuarios.add(usuario);
        usuarios.add(usuario1);

        return usuarios;
    }
}
