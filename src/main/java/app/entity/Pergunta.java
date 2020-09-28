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
 * Classe que representa a tabela PERGUNTA
 * @generated
 */
@Entity
@Table(name = "\"PERGUNTA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Pergunta")
public class Pergunta implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "perg_cd_pergunta", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "perg_dt_criacao", nullable = false, unique = false, insertable=true, updatable=false)
  @CronapiSearchable
  
  private java.util.Date data_cadastro;

  /**
  * @generated
  */
  @Column(name = "perg_ds_pergunta", nullable = false, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String descricao;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "perg_dt_publicacao", nullable = true, unique = false, insertable=true, updatable=false)
  @CronapiSearchable
  
  private java.util.Date data_publicacao;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="lici_cd_licitacao", nullable = false, referencedColumnName = "lici_cd_licitacao", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "PERGUNTA_LICI_CD_LICITACAO_LICITACAO_LICI_CD_LICITACAO", foreignKeyDefinition = "FOREIGN KEY (lici_cd_licitacao) REFERENCES LICITACAO (lici_cd_licitacao) ON DELETE CASCADE"))
  
  private Licitacao fk_licitacao;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fotr_cd_forca_trabalho", nullable = false, referencedColumnName = "fotr_cd_forca_trabalho", insertable=true, updatable=true)
  
  private User criador_pergunta;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="perg_cd_pai", nullable = true, referencedColumnName = "perg_cd_pergunta", insertable=true, updatable=true)
  
  private Pergunta pergunta_associada;

  /**
  * @generated
  */
  @Column(name = "perg_tx_questionamento", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String subQuestionamento;

  /**
  * @generated
  */
  @Column(name = "perg_tx_resp_final", nullable = true, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String respostaFinal;

  /**
  * @generated
  */
  @Column(name = "stpe_in_status", nullable = false, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String statusPergunta;

  /**
   * Construtor
   * @generated
   */
  public Pergunta(){
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
  public Pergunta setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém data_cadastro
   * return data_cadastro
   * @generated
   */
  
  public java.util.Date getData_cadastro(){
    return this.data_cadastro;
  }

  /**
   * Define data_cadastro
   * @param data_cadastro data_cadastro
   * @generated
   */
  public Pergunta setData_cadastro(java.util.Date data_cadastro){
    this.data_cadastro = data_cadastro;
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
  public Pergunta setDescricao(java.lang.String descricao){
    this.descricao = descricao;
    return this;
  }

  /**
   * Obtém data_publicacao
   * return data_publicacao
   * @generated
   */
  
  public java.util.Date getData_publicacao(){
    return this.data_publicacao;
  }

  /**
   * Define data_publicacao
   * @param data_publicacao data_publicacao
   * @generated
   */
  public Pergunta setData_publicacao(java.util.Date data_publicacao){
    this.data_publicacao = data_publicacao;
    return this;
  }

  /**
   * Obtém fk_licitacao
   * return fk_licitacao
   * @generated
   */
  
  public Licitacao getFk_licitacao(){
    return this.fk_licitacao;
  }

  /**
   * Define fk_licitacao
   * @param fk_licitacao fk_licitacao
   * @generated
   */
  public Pergunta setFk_licitacao(Licitacao fk_licitacao){
    this.fk_licitacao = fk_licitacao;
    return this;
  }

  /**
   * Obtém criador_pergunta
   * return criador_pergunta
   * @generated
   */
  
  public User getCriador_pergunta(){
    return this.criador_pergunta;
  }

  /**
   * Define criador_pergunta
   * @param criador_pergunta criador_pergunta
   * @generated
   */
  public Pergunta setCriador_pergunta(User criador_pergunta){
    this.criador_pergunta = criador_pergunta;
    return this;
  }

  /**
   * Obtém pergunta_associada
   * return pergunta_associada
   * @generated
   */
  
  public Pergunta getPergunta_associada(){
    return this.pergunta_associada;
  }

  /**
   * Define pergunta_associada
   * @param pergunta_associada pergunta_associada
   * @generated
   */
  public Pergunta setPergunta_associada(Pergunta pergunta_associada){
    this.pergunta_associada = pergunta_associada;
    return this;
  }

  /**
   * Obtém subQuestionamento
   * return subQuestionamento
   * @generated
   */
  
  public java.lang.String getSubQuestionamento(){
    return this.subQuestionamento;
  }

  /**
   * Define subQuestionamento
   * @param subQuestionamento subQuestionamento
   * @generated
   */
  public Pergunta setSubQuestionamento(java.lang.String subQuestionamento){
    this.subQuestionamento = subQuestionamento;
    return this;
  }

  /**
   * Obtém respostaFinal
   * return respostaFinal
   * @generated
   */
  
  public java.lang.String getRespostaFinal(){
    return this.respostaFinal;
  }

  /**
   * Define respostaFinal
   * @param respostaFinal respostaFinal
   * @generated
   */
  public Pergunta setRespostaFinal(java.lang.String respostaFinal){
    this.respostaFinal = respostaFinal;
    return this;
  }

  /**
   * Obtém statusPergunta
   * return statusPergunta
   * @generated
   */
  
  public java.lang.String getStatusPergunta(){
    return this.statusPergunta;
  }

  /**
   * Define statusPergunta
   * @param statusPergunta statusPergunta
   * @generated
   */
  public Pergunta setStatusPergunta(java.lang.String statusPergunta){
    this.statusPergunta = statusPergunta;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Pergunta object = (Pergunta)obj;
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
