package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela ANEXO_RESPOSTA
 * @generated
 */
@Entity
@Table(name = "\"ANEXO_RESPOSTA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.AnexosResposta")
public class AnexosResposta implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "anre_cd_anexo", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "anre_tx_caminho", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.String caminho;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="resp_cd_resposta", nullable = true, referencedColumnName = "resp_cd_resposta", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "ANEXO_RESPOSTA_RESP_CD_RESPOSTA_RESPOSTA_RESP_CD_RESPOSTA", foreignKeyDefinition = "FOREIGN KEY (resp_cd_resposta) REFERENCES RESPOSTA (resp_cd_resposta) ON DELETE CASCADE"))
  
  private Resposta resposta;

  /**
   * Construtor
   * @generated
   */
  public AnexosResposta(){
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
  public AnexosResposta setId(java.lang.String id){
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
  public AnexosResposta setCaminho(java.lang.String caminho){
    this.caminho = caminho;
    return this;
  }

  /**
   * Obtém resposta
   * return resposta
   * @generated
   */
  
  public Resposta getResposta(){
    return this.resposta;
  }

  /**
   * Define resposta
   * @param resposta resposta
   * @generated
   */
  public AnexosResposta setResposta(Resposta resposta){
    this.resposta = resposta;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    AnexosResposta object = (AnexosResposta)obj;
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
