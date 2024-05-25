package Models;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CRUD {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaBasica");
    private EntityManager em = emf.createEntityManager();

    // MÉTODOS CRUD

    // LISTAR
    public List<Employees> seleccionarTodo() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employees> cq = cb.createQuery(Employees.class);
        Root<Employees> registro = cq.from(Employees.class);
        CriteriaQuery<Employees> todos = cq.select(registro);
        TypedQuery<Employees> lista = em.createQuery(todos);
        return lista.getResultList();
    }

    // INSERTAR
    public void insertar(Employees e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    // BUSCAR POR ID
    public Employees buscar(int id) {
        em.getTransaction().begin();
        Employees e = em.find(Employees.class, id);
        em.getTransaction().commit();
        return e;
    }

    // ACTUALIZAR
    public void actualizar(Employees e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        em.getTransaction().begin();
        Employees e = em.find(Employees.class, id);
        if (e != null) {
            em.remove(e);
            em.getTransaction().commit();
            return true;
        } else {
            em.getTransaction().rollback();
            return false;
        }
    }
}
