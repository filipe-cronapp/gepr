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
@Repository("PerguntaDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface PerguntaDAO extends JpaRepository<Pergunta, java.lang.String> {

  /**
   * Obtém a instância de Pergunta utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Pergunta entity WHERE entity.id = :id")
  public Pergunta findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Pergunta utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Pergunta entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM AnexosPergunta entity WHERE entity.pergunta.id = :id")
  public Page<AnexosPergunta> findAnexosPergunta(@Param(value="id") java.lang.String id, Pageable pageable);
    
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM PalavrasChave entity WHERE entity.pergunta.id = :id AND (entity.nome like concat('%',coalesce(:search,''),'%'))")
  public Page<PalavrasChave> findPalavrasChaveGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM PalavrasChave entity WHERE entity.pergunta.id = :id AND (:nome is null OR entity.nome like concat('%',:nome,'%'))")
  public Page<PalavrasChave> findPalavrasChaveSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="nome") java.lang.String nome, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM PalavrasChave entity WHERE entity.pergunta.id = :id")
  public Page<PalavrasChave> findPalavrasChave(@Param(value="id") java.lang.String id, Pageable pageable);
    
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE entity.pergunta_associada.id = :id AND (entity.descricao like concat('%',coalesce(:search,''),'%') OR entity.respostaFinal like concat('%',coalesce(:search,''),'%') OR entity.statusPergunta like concat('%',coalesce(:search,''),'%'))")
  public Page<Pergunta> findPerguntaGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE entity.pergunta_associada.id = :id AND (:data_cadastro is null OR entity.data_cadastro = :data_cadastro) AND (:descricao is null OR entity.descricao like concat('%',:descricao,'%')) AND (:data_publicacao is null OR entity.data_publicacao = :data_publicacao) AND (:respostaFinal is null OR entity.respostaFinal like concat('%',:respostaFinal,'%')) AND (:statusPergunta is null OR entity.statusPergunta like concat('%',:statusPergunta,'%'))")
  public Page<Pergunta> findPerguntaSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="data_cadastro") java.util.Date data_cadastro, @Param(value="descricao") java.lang.String descricao, @Param(value="data_publicacao") java.util.Date data_publicacao, @Param(value="respostaFinal") java.lang.String respostaFinal, @Param(value="statusPergunta") java.lang.String statusPergunta, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE entity.pergunta_associada.id = :id")
  public Page<Pergunta> findPergunta(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM PerguntaRespondentes entity WHERE entity.pergunta.id = :id")
  public Page<PerguntaRespondentes> findPerguntaRespondentes(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Resposta entity WHERE entity.pergunta.id = :id")
  public Page<Resposta> findResposta(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.user FROM PerguntaRespondentes entity WHERE entity.pergunta.id = :id")
  public Page<User> listUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM PerguntaRespondentes entity WHERE entity.pergunta.id = :instanceId AND entity.user.id = :relationId")
  public int deleteUser(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.respondente FROM Resposta entity WHERE entity.pergunta.id = :id")
  public Page<User> listUser_2(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Resposta entity WHERE entity.pergunta.id = :instanceId AND entity.respondente.id = :relationId")
  public int deleteUser_2(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE entity.descricao like concat('%',coalesce(:search,''),'%') OR entity.respostaFinal like concat('%',coalesce(:search,''),'%') OR entity.statusPergunta like concat('%',coalesce(:search,''),'%')")
  public Page<Pergunta> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE (:data_cadastro is null OR entity.data_cadastro = :data_cadastro) AND (:descricao is null OR entity.descricao like concat('%',:descricao,'%')) AND (:data_publicacao is null OR entity.data_publicacao = :data_publicacao) AND (:respostaFinal is null OR entity.respostaFinal like concat('%',:respostaFinal,'%')) AND (:statusPergunta is null OR entity.statusPergunta like concat('%',:statusPergunta,'%'))")
  public Page<Pergunta> specificSearch(@Param(value="data_cadastro") java.util.Date data_cadastro, @Param(value="descricao") java.lang.String descricao, @Param(value="data_publicacao") java.util.Date data_publicacao, @Param(value="respostaFinal") java.lang.String respostaFinal, @Param(value="statusPergunta") java.lang.String statusPergunta, Pageable pageable);
  
  /**
   * Foreign Key fk_licitacao
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE entity.fk_licitacao.id = :id")
  public Page<Pergunta> findPerguntasByFk_licitacao(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key criador_pergunta
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE entity.criador_pergunta.id = :id")
  public Page<Pergunta> findPerguntasByCriador_pergunta(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key pergunta_associada
   * @generated
   */
  @Query("SELECT entity FROM Pergunta entity WHERE entity.pergunta_associada.id = :id")
  public Page<Pergunta> findPerguntasByPergunta_associada(@Param(value="id") java.lang.String id, Pageable pageable);

}
