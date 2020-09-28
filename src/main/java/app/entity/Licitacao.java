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
 * Classe que representa a tabela LICITACAO
 * @generated
 */
@Entity
@Table(name = "\"LICITACAO\"" ,uniqueConstraints=@UniqueConstraint(columnNames={
"lici_nr_processo" }))
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Licitacao")
public class Licitacao implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "lici_cd_licitacao", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "lici_nr_processo", nullable = false, unique = true, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String numero_processo;

  /**
  * @generated
  */
  @Column(name = "lici_nm_licitacao", nullable = false, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String nome;

  /**
  * @generated
  */
  @Column(name = "lici_ds_licitacao", nullable = true, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String descricao;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "lici_dt_abertura", nullable = true, unique = false, insertable=true, updatable=false)
  @CronapiSearchable
  
  private java.util.Date data_abertura;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "lici_dt_previsao", nullable = false, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.util.Date previsao_encerramento;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "lici_dt_encerramento", nullable = true, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.util.Date data_encerramento;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fotr_cd_forca_trabalho", nullable = false, referencedColumnName = "fotr_cd_forca_trabalho", insertable=true, updatable=true)
  
  private User criador_licitacao;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="orga_cd_orgao", nullable = false, referencedColumnName = "orga_cd_orgao", insertable=true, updatable=true)
  
  private Gerencia gerencia;

  /**
  * @generated
  */
  @Column(name = "lici_tx_chave_resp", nullable = true, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String responsavelTecnico;

  /**
  * @generated
  */
  @Column(name = "stli_in_status", nullable = false, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String statusLicitacao;

  /**
   * Construtor
   * @generated
   */
  public Licitacao(){
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
  public Licitacao setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém numero_processo
   * return numero_processo
   * @generated
   */
  
  public java.lang.String getNumero_processo(){
    return this.numero_processo;
  }

  /**
   * Define numero_processo
   * @param numero_processo numero_processo
   * @generated
   */
  public Licitacao setNumero_processo(java.lang.String numero_processo){
    this.numero_processo = numero_processo;
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
  public Licitacao setNome(java.lang.String nome){
    this.nome = nome;
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
  public Licitacao setDescricao(java.lang.String descricao){
    this.descricao = descricao;
    return this;
  }

  /**
   * Obtém data_abertura
   * return data_abertura
   * @generated
   */
  
  public java.util.Date getData_abertura(){
    return this.data_abertura;
  }

  /**
   * Define data_abertura
   * @param data_abertura data_abertura
   * @generated
   */
  public Licitacao setData_abertura(java.util.Date data_abertura){
    this.data_abertura = data_abertura;
    return this;
  }

  /**
   * Obtém previsao_encerramento
   * return previsao_encerramento
   * @generated
   */
  
  public java.util.Date getPrevisao_encerramento(){
    return this.previsao_encerramento;
  }

  /**
   * Define previsao_encerramento
   * @param previsao_encerramento previsao_encerramento
   * @generated
   */
  public Licitacao setPrevisao_encerramento(java.util.Date previsao_encerramento){
    this.previsao_encerramento = previsao_encerramento;
    return this;
  }

  /**
   * Obtém data_encerramento
   * return data_encerramento
   * @generated
   */
  
  public java.util.Date getData_encerramento(){
    return this.data_encerramento;
  }

  /**
   * Define data_encerramento
   * @param data_encerramento data_encerramento
   * @generated
   */
  public Licitacao setData_encerramento(java.util.Date data_encerramento){
    this.data_encerramento = data_encerramento;
    return this;
  }

  /**
   * Obtém criador_licitacao
   * return criador_licitacao
   * @generated
   */
  
  public User getCriador_licitacao(){
    return this.criador_licitacao;
  }

  /**
   * Define criador_licitacao
   * @param criador_licitacao criador_licitacao
   * @generated
   */
  public Licitacao setCriador_licitacao(User criador_licitacao){
    this.criador_licitacao = criador_licitacao;
    return this;
  }

  /**
   * Obtém gerencia
   * return gerencia
   * @generated
   */
  
  public Gerencia getGerencia(){
    return this.gerencia;
  }

  /**
   * Define gerencia
   * @param gerencia gerencia
   * @generated
   */
  public Licitacao setGerencia(Gerencia gerencia){
    this.gerencia = gerencia;
    return this;
  }

  /**
   * Obtém responsavelTecnico
   * return responsavelTecnico
   * @generated
   */
  
  public java.lang.String getResponsavelTecnico(){
    return this.responsavelTecnico;
  }

  /**
   * Define responsavelTecnico
   * @param responsavelTecnico responsavelTecnico
   * @generated
   */
  public Licitacao setResponsavelTecnico(java.lang.String responsavelTecnico){
    this.responsavelTecnico = responsavelTecnico;
    return this;
  }

  /**
   * Obtém statusLicitacao
   * return statusLicitacao
   * @generated
   */
  
  public java.lang.String getStatusLicitacao(){
    return this.statusLicitacao;
  }

  /**
   * Define statusLicitacao
   * @param statusLicitacao statusLicitacao
   * @generated
   */
  public Licitacao setStatusLicitacao(java.lang.String statusLicitacao){
    this.statusLicitacao = statusLicitacao;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Licitacao object = (Licitacao)obj;
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
