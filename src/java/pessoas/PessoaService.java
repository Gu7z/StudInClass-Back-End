package pessoas;

import java.util.ArrayList;
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
@Path("pessoas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaService {

    @PersistenceContext(unitName = "pjlp4up")
    private EntityManager entityManager;

    public PessoaService() {
    }

    @GET
    public List<Pessoa> getProdutos() {
        Query query = entityManager.createQuery("SELECT p FROM Pessoa p");
        return query.getResultList();
    }
    
    @GET 
    @Path("turma/{turma}")
    public List<Pessoa> getFromTurma(@PathParam("turma") String turma){
        Query query = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.turma = :turma");
        query.setParameter("turma", turma);
        return query.getResultList();
    }

    @POST
    public Pessoa adicionar(Pessoa pessoa) {
        entityManager.persist(pessoa);
        return pessoa;
    }

    @PUT
    @Path("{id}")
    public Pessoa atualizar(@PathParam("id") Integer id, Pessoa pessoaAtualizado) {
        Pessoa pessoaEncontrada = getPessoa(id);
        pessoaEncontrada.setNome(pessoaAtualizado.getNome());
        pessoaEncontrada.setturma(pessoaAtualizado.getturma());
        entityManager.merge(pessoaEncontrada);
        return pessoaEncontrada;
    }

    @DELETE
    @Path("{id}")
    public Pessoa excluir(@PathParam("id") Integer id) {
        Pessoa pessoa = getPessoa(id);
        entityManager.remove(pessoa);
        return pessoa;
    }
    
    @GET
    @Path("{id}")
    public Pessoa getPessoa(@PathParam("id") Integer id) {
        return entityManager.find(Pessoa.class, id);
    }

}