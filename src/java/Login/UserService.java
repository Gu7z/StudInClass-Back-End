package Login;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserService {
    @PersistenceContext(unitName = "pjlp4up")
    private EntityManager entityManager;
    
    public UserService() {
    }
    
    @GET
    public List<User> getUser() {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }
    
    
    @POST
    public List<User> logar(User user) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.nome = :nome AND u.senha = :senha");
        query.setParameter("nome", user.getNome());
        query.setParameter("senha", user.getsenha());
        return query.getResultList();
    }

}
