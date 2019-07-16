package turma;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turma", schema = "public")
public class Turma implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    
    public Turma() {
    }
    
    public Turma(String nome, Integer id) {
        this.id = id;
        this.nome = nome;
    }
    
    public Integer getId() {
        return id;
    }
     
      public String getNome() {
        return nome;
    }
      
    public void setId(Integer id) {
        this.id = id;
    }
     
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
