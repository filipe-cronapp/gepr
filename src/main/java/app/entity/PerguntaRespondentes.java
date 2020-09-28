package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela RESPONDENTE_PERGUNTA
 * @generated
 */
@Entity
@Table(name = "\"RESPONDENTE_PERGUNTA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.PerguntaRespondentes")
public class PerguntaRespondentes implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "repe_cd_respondente", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="perg_cd_pergunta", nullable = true, referencedColumnName = "perg_cd_pergunta", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "RESPONDENTE_PERGUNTA_PERG_CD_PERGUNTA_PERGUNTA_PERG_CD_PERGUNTA", foreignKeyDefinition = "FOREIGN KEY (perg_cd_pergunta) REFERENCES PERGUNTA (perg_cd_pergunta) ON DELETE CASCADE"))
  
  private Pergunta pergunta;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fotr_cd_forca_trabalho", nullable = true, referencedColumnName = "fotr_cd_forca_trabalho", insertable=true, updatable=true)
  
  private User user;

  /**
   * Construtor
   * @generated
   */
  public PerguntaRespondentes(){
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
  public PerguntaRespondentes setId(java.lang.String id){
    this.id = id;
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
  public PerguntaRespondentes setPergunta(Pergunta pergunta){
    this.pergunta = pergunta;
    return this;
  }

  /**
   * Obtém user
   * return user
   * @generated
   */
  
  public User getUser(){
    return this.user;
  }

  /**
   * Define user
   * @param user user
   * @generated
   */
  public PerguntaRespondentes setUser(User user){
    this.user = user;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    PerguntaRespondentes object = (PerguntaRespondentes)obj;
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
