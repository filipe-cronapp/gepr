package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela RESPOSTA
 * @generated
 */
@Entity
@Table(name = "\"RESPOSTA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Resposta")
public class Resposta implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "resp_cd_resposta", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "resp_ds_resposta", nullable = false, unique = false, insertable=true, updatable=false)
  
  private java.lang.String descricao;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fotr_cd_forca_trabalho", nullable = true, referencedColumnName = "fotr_cd_forca_trabalho", insertable=true, updatable=true)
  
  private User respondente;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="perg_cd_pergunta", nullable = true, referencedColumnName = "perg_cd_pergunta", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "RESPOSTA_PERG_CD_PERGUNTA_PERGUNTA_PERG_CD_PERGUNTA", foreignKeyDefinition = "FOREIGN KEY (perg_cd_pergunta) REFERENCES PERGUNTA (perg_cd_pergunta) ON DELETE CASCADE"))
  
  private Pergunta pergunta;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "resp_dt_cadastro", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date data_resposta;

  /**
   * Construtor
   * @generated
   */
  public Resposta(){
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
  public Resposta setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém descricao
   * return descricao
   * @generated
   */
  
  public java.lang.String getDescricao(){
    return this.descricao;
  }

  /**
   * Define descricao
   * @param descricao descricao
   * @generated
   */
  public Resposta setDescricao(java.lang.String descricao){
    this.descricao = descricao;
    return this;
  }

  /**
   * Obtém respondente
   * return respondente
   * @generated
   */
  
  public User getRespondente(){
    return this.respondente;
  }

  /**
   * Define respondente
   * @param respondente respondente
   * @generated
   */
  public Resposta setRespondente(User respondente){
    this.respondente = respondente;
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
  public Resposta setPergunta(Pergunta pergunta){
    this.pergunta = pergunta;
    return this;
  }

  /**
   * Obtém data_resposta
   * return data_resposta
   * @generated
   */
  
  public java.util.Date getData_resposta(){
    return this.data_resposta;
  }

  /**
   * Define data_resposta
   * @param data_resposta data_resposta
   * @generated
   */
  public Resposta setData_resposta(java.util.Date data_resposta){
    this.data_resposta = data_resposta;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Resposta object = (Resposta)obj;
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
