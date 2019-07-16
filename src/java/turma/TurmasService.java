package turma;

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
@Path("turmas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TurmasService {
    @PersistenceContext(unitName = "pjlp4up")
    private EntityManager entityManager;
    
     public TurmasService() {
    }

    @GET
    public List<Turma> getTurmas() {
        Query query = entityManager.createQuery("SELECT t FROM Turma t");
        return query.getResultList();
    }
    
    @POST
    public Turma adicionar(Turma turma) {
        entityManager.persist(turma);
        return turma;
    }
    
    @PUT
    @Path("{id}")
    public Turma atualizar(@PathParam("id") Integer id, Turma turmaAtualizada) {
        Turma turmaEncontrada = getTurma(id);
        turmaEncontrada.setNome(turmaAtualizada.getNome());
        entityManager.merge(turmaEncontrada);
        return turmaEncontrada;
    }

    @DELETE
    @Path("{id}")
    public Turma excluir(@PathParam("id") Integer id) {
        Turma turma = getTurma(id);
        entityManager.remove(turma);
        return turma;
    }
    
    @GET
    @Path("{id}")
    public Turma getTurma(@PathParam("id") Integer id) {
        return entityManager.find(Turma.class, id);
    }

}
