package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 


/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("LicitacaoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface LicitacaoDAO extends JpaRepository<Licitacao, java.lang.String> {

  /**
   * Obtém a instância de Licitacao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Licitacao entity WHERE entity.id = :id")
  public Licitacao findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Licitacao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Licitacao entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);


    
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE entity.fk_licitacao.id = :id AND (entity.descricao like concat('%',coalesce(:search,''),'%') OR entity.respostaFinal like concat('%',coalesce(:search,''),'%') OR entity.statusPergunta like concat('%',coalesce(:search,''),'%'))")
  public Page<Pergunta> findPerguntaGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE entity.fk_licitacao.id = :id AND (:data_cadastro is null OR entity.data_cadastro = :data_cadastro) AND (:descricao is null OR entity.descricao like concat('%',:descricao,'%')) AND (:data_publicacao is null OR entity.data_publicacao = :data_publicacao) AND (:respostaFinal is null OR entity.respostaFinal like concat('%',:respostaFinal,'%')) AND (:statusPergunta is null OR entity.statusPergunta like concat('%',:statusPergunta,'%'))")
  public Page<Pergunta> findPerguntaSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="data_cadastro") java.util.Date data_cadastro, @Param(value="descricao") java.lang.String descricao, @Param(value="data_publicacao") java.util.Date data_publicacao, @Param(value="respostaFinal") java.lang.String respostaFinal, @Param(value="statusPergunta") java.lang.String statusPergunta, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE entity.fk_licitacao.id = :id")
  public Page<Pergunta> findPergunta(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.criador_pergunta FROM Pergunta entity WHERE entity.fk_licitacao.id = :id")
  public Page<User> listUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Pergunta entity WHERE entity.fk_licitacao.id = :instanceId AND entity.criador_pergunta.id = :relationId")
  public int deleteUser(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.pergunta_associada FROM Pergunta entity WHERE entity.fk_licitacao.id = :id AND (entity.pergunta_associada.descricao like concat('%',coalesce(:search,''),'%') OR entity.pergunta_associada.respostaFinal like concat('%',coalesce(:search,''),'%') OR entity.pergunta_associada.statusPergunta like concat('%',coalesce(:search,''),'%'))")
  public Page<Pergunta> listPergunta_2GeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.pergunta_associada FROM Pergunta entity WHERE entity.fk_licitacao.id = :id AND (:data_cadastro is null OR entity.pergunta_associada.data_cadastro = :data_cadastro) AND (:descricao is null OR entity.pergunta_associada.descricao like concat('%',:descricao,'%')) AND (:data_publicacao is null OR entity.pergunta_associada.data_publicacao = :data_publicacao) AND (:respostaFinal is null OR entity.pergunta_associada.respostaFinal like concat('%',:respostaFinal,'%')) AND (:statusPergunta is null OR entity.pergunta_associada.statusPergunta like concat('%',:statusPergunta,'%'))")
  public Page<Pergunta> listPergunta_2SpecificSearch(@Param(value="id") java.lang.String id, @Param(value="data_cadastro") java.util.Date data_cadastro, @Param(value="descricao") java.lang.String descricao, @Param(value="data_publicacao") java.util.Date data_publicacao, @Param(value="respostaFinal") java.lang.String respostaFinal, @Param(value="statusPergunta") java.lang.String statusPergunta, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.pergunta_associada FROM Pergunta entity WHERE entity.fk_licitacao.id = :id")
  public Page<Pergunta> listPergunta_2(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Pergunta entity WHERE entity.fk_licitacao.id = :instanceId AND entity.pergunta_associada.id = :relationId")
  public int deletePergunta_2(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Licitacao entity WHERE entity.numero_processo like concat('%',coalesce(:search,''),'%') OR entity.nome like concat('%',coalesce(:search,''),'%') OR entity.descricao like concat('%',coalesce(:search,''),'%') OR entity.responsavelTecnico like concat('%',coalesce(:search,''),'%') OR entity.statusLicitacao like concat('%',coalesce(:search,''),'%')")
  public Page<Licitacao> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Licitacao entity WHERE (:numero_processo is null OR entity.numero_processo like concat('%',:numero_processo,'%')) AND (:nome is null OR entity.nome like concat('%',:nome,'%')) AND (:descricao is null OR entity.descricao like concat('%',:descricao,'%')) AND (:data_abertura is null OR entity.data_abertura = :data_abertura) AND (:previsao_encerramento is null OR entity.previsao_encerramento = :previsao_encerramento) AND (:data_encerramento is null OR entity.data_encerramento = :data_encerramento) AND (:responsavelTecnico is null OR entity.responsavelTecnico like concat('%',:responsavelTecnico,'%')) AND (:statusLicitacao is null OR entity.statusLicitacao like concat('%',:statusLicitacao,'%'))")
  public Page<Licitacao> specificSearch(@Param(value="numero_processo") java.lang.String numero_processo, @Param(value="nome") java.lang.String nome, @Param(value="descricao") java.lang.String descricao, @Param(value="data_abertura") java.util.Date data_abertura, @Param(value="previsao_encerramento") java.util.Date previsao_encerramento, @Param(value="data_encerramento") java.util.Date data_encerramento, @Param(value="responsavelTecnico") java.lang.String responsavelTecnico, @Param(value="statusLicitacao") java.lang.String statusLicitacao, Pageable pageable);
  
  /**
   * Foreign Key criador_licitacao
   * @generated
   */
  @Query("SELECT entity FROM Licitacao entity WHERE entity.criador_licitacao.id = :id")
  public Page<Licitacao> findLicitacaosByCriador_licitacao(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key gerencia
   * @generated
   */
  @Query("SELECT entity FROM Licitacao entity WHERE entity.gerencia.id = :id")
  public Page<Licitacao> findLicitacaosByGerencia(@Param(value="id") java.lang.String id, Pageable pageable);

}
