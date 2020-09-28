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
@Repository("GerenciaDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface GerenciaDAO extends JpaRepository<Gerencia, java.lang.String> {

  /**
   * Obtém a instância de Gerencia utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Gerencia entity WHERE entity.id = :id")
  public Gerencia findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Gerencia utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Gerencia entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);


    
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Licitacao entity WHERE entity.gerencia.id = :id AND (entity.numero_processo like concat('%',coalesce(:search,''),'%') OR entity.nome like concat('%',coalesce(:search,''),'%') OR entity.descricao like concat('%',coalesce(:search,''),'%') OR entity.responsavelTecnico like concat('%',coalesce(:search,''),'%') OR entity.statusLicitacao like concat('%',coalesce(:search,''),'%'))")
  public Page<Licitacao> findLicitacaoGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Licitacao entity WHERE entity.gerencia.id = :id AND (:numero_processo is null OR entity.numero_processo like concat('%',:numero_processo,'%')) AND (:nome is null OR entity.nome like concat('%',:nome,'%')) AND (:descricao is null OR entity.descricao like concat('%',:descricao,'%')) AND (:data_abertura is null OR entity.data_abertura = :data_abertura) AND (:previsao_encerramento is null OR entity.previsao_encerramento = :previsao_encerramento) AND (:data_encerramento is null OR entity.data_encerramento = :data_encerramento) AND (:responsavelTecnico is null OR entity.responsavelTecnico like concat('%',:responsavelTecnico,'%')) AND (:statusLicitacao is null OR entity.statusLicitacao like concat('%',:statusLicitacao,'%'))")
  public Page<Licitacao> findLicitacaoSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="numero_processo") java.lang.String numero_processo, @Param(value="nome") java.lang.String nome, @Param(value="descricao") java.lang.String descricao, @Param(value="data_abertura") java.util.Date data_abertura, @Param(value="previsao_encerramento") java.util.Date previsao_encerramento, @Param(value="data_encerramento") java.util.Date data_encerramento, @Param(value="responsavelTecnico") java.lang.String responsavelTecnico, @Param(value="statusLicitacao") java.lang.String statusLicitacao, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Licitacao entity WHERE entity.gerencia.id = :id")
  public Page<Licitacao> findLicitacao(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM User entity WHERE entity.gerencia.id = :id")
  public Page<User> findUser_2(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.criador_licitacao FROM Licitacao entity WHERE entity.gerencia.id = :id")
  public Page<User> listUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Licitacao entity WHERE entity.gerencia.id = :instanceId AND entity.criador_licitacao.id = :relationId")
  public int deleteUser(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Gerencia entity WHERE entity.nome like concat('%',coalesce(:search,''),'%')")
  public Page<Gerencia> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Gerencia entity WHERE (:nome is null OR entity.nome like concat('%',:nome,'%'))")
  public Page<Gerencia> specificSearch(@Param(value="nome") java.lang.String nome, Pageable pageable);
  
}
