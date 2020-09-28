package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.CronapiSearchable;


/**
 * Classe que representa a tabela PALAVRA_CHAVE
 * @generated
 */
@Entity
@Table(name = "\"PALAVRA_CHAVE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.PalavrasChave")
public class PalavrasChave implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "pach_cd_palavra", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "pach_tx_palavra", nullable = true, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String nome;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="perg_cd_pergunta", nullable = true, referencedColumnName = "perg_cd_pergunta", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "PALAVRA_CHAVE_PERG_CD_PERGUNTA_PERGUNTA_PERG_CD_PERGUNTA", foreignKeyDefinition = "FOREIGN KEY (perg_cd_pergunta) REFERENCES PERGUNTA (perg_cd_pergunta) ON DELETE CASCADE"))
  
  private Pergunta pergunta;

  /**
   * Construtor
   * @generated
   */
  public PalavrasChave(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public PalavrasChave setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém nome
   * return nome
   * @generated
   */
  
  public java.lang.String getNome(){
    return this.nome;
  }

  /**
   * Define nome
   * @param nome nome
   * @generated
   */
  public PalavrasChave setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém pergunta
   * return pergunta
   * @generated
   */
  
  public Pergunta getPergunta(){
    return this.pergunta;
  }

  /**
   * Define pergunta
   * @param pergunta pergunta
   * @generated
   */
  public PalavrasChave setPergunta(Pergunta pergunta){
    this.pergunta = pergunta;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    PalavrasChave object = (PalavrasChave)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
