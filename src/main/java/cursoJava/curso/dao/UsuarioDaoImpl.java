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

    public List<Usuario> getUsuario() {
        String query = "From Usuario";
        return entityManager.createQuery(query).getResultList();
    }
}
