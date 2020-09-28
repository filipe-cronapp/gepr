package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela ANEXO_PERGUNTA
 * @generated
 */
@Entity
@Table(name = "\"ANEXO_PERGUNTA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.AnexosPergunta")
public class AnexosPergunta implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "anpe_cd_anexo", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "anpe_tx_caminho", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.String caminho;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="perg_cd_pergunta", nullable = true, referencedColumnName = "perg_cd_pergunta", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "ANEXO_PERGUNTA_PERG_CD_PERGUNTA_PERGUNTA_PERG_CD_PERGUNTA", foreignKeyDefinition = "FOREIGN KEY (perg_cd_pergunta) REFERENCES PERGUNTA (perg_cd_pergunta) ON DELETE CASCADE"))
  
  private Pergunta pergunta;

  /**
   * Construtor
   * @generated
   */
  public AnexosPergunta(){
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
  public AnexosPergunta setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém caminho
   * return caminho
   * @generated
   */
  
  public java.lang.String getCaminho(){
    return this.caminho;
  }

  /**
   * Define caminho
   * @param caminho caminho
   * @generated
   */
  public AnexosPergunta setCaminho(java.lang.String caminho){
    this.caminho = caminho;
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
  public AnexosPergunta setPergunta(Pergunta pergunta){
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
    AnexosPergunta object = (AnexosPergunta)obj;
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
