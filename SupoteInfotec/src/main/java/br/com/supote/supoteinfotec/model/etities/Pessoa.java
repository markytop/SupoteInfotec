
package br.com.supote.supoteinfotec.model.etities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;
        
   // criar tabela no banco
    @Id
    @GeneratedValue
    @Column(name="IdPessoa", nullable=false)
    private Integer idPessoa;
    @Column (name="Nome",nullable=false, length = 80)
    private String nome;
    @Column (name="Email",nullable=false, length = 80)
    private String email;
    @Column (name="Telefone",nullable=false, length = 15)
    private String telefone;
    @Column (name="DataInicial",nullable=false, length = 12)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAbertura;    

    public Pessoa() {
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

   
    
}
