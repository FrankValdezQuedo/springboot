package cursoJava.curso.controllers;

import cursoJava.curso.dao.UsuarioDao;
import cursoJava.curso.models.Usuario;
import cursoJava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;
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
    @RequestMapping(value = "api/usuarios",method = RequestMethod.GET)
    public List<Usuario> getUsuario(@RequestHeader(value = "Authorization")String token){
        if(!validarToken(token)){return null;}
     return usuarioDao.getUsuarios();
    }

    private boolean validarToken (String token){
        String usuarioId = jwtUtil.getKey(token);
       return usuarioId != null;
    }
    @RequestMapping(value = "api/usuarios",method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }
    @RequestMapping(value = "api/usuario/{id}",method = RequestMethod.DELETE)
    public void Eliminar(@RequestHeader(value = "Authorization")String token,@PathVariable Long id){
     if(!validarToken(token)){return ;}
     usuarioDao.eliminar(id);
    }
}
