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

}
