
package br.com.supote.supoteinfotec.model.etities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name="situacao")

public class Situacao implements Serializable{
   private static final long serialVersionUID = 1L;
  
   @Id
   @GeneratedValue
   @Column(name="idSituacao",nullable=false)
   private Integer idSistuacao;
   @Column(name="descricao", unique=true, nullable=false, length = 10)
   private String descricao;
   
   @OneToOne(mappedBy = "situacao", fetch = FetchType.LAZY)
   @ForeignKey(name = "PessoaDescrcao")
   private List<Pessoa> pessoa;
   
  
    public Situacao() {
    }

    public void setIdSistuacao(Integer idSistuacao) {
        this.idSistuacao = idSistuacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdSistuacao() {
        return idSistuacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.idSistuacao != null ? this.idSistuacao.hashCode() : 0);
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
        final Situacao other = (Situacao) obj;
        if (this.idSistuacao != other.idSistuacao && (this.idSistuacao == null || !this.idSistuacao.equals(other.idSistuacao))) {
            return false;
        }
        return true;
    }
   
}
