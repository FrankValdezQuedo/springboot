package cursoJava.curso.dao;

import cursoJava.curso.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional

public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override

    public List<Usuario> getUsuarios() {
        String query = "From Usuario";
        List<Usuario> usuarios = entityManager.createQuery(query, Usuario.class).getResultList();
        return  usuarios;
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
    entityManager.merge(usuario);
    }

    @Override
    public boolean verificarCredenciales(Usuario usuario) {
        String query = "From Usuario WHERE email = :email AND password = :password";
        List<Usuario> lista =  entityManager.createQuery(query)
                .setParameter("email",usuario.getEmail())
                .setParameter("password",usuario.getPassword())
                .getResultList();
        if(lista.isEmpty()){
            return false;
        }else {
            return true;
        }
    }


}
