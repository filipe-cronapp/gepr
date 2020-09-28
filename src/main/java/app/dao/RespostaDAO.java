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
@Repository("RespostaDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface RespostaDAO extends JpaRepository<Resposta, java.lang.String> {

  /**
   * Obtém a instância de Resposta utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Resposta entity WHERE entity.id = :id")
  public Resposta findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Resposta utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Resposta entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM AnexosResposta entity WHERE entity.resposta.id = :id")
  public Page<AnexosResposta> findAnexosResposta(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key respondente
   * @generated
   */
  @Query("SELECT entity FROM Resposta entity WHERE entity.respondente.id = :id")
  public Page<Resposta> findRespostasByRespondente(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key pergunta
   * @generated
   */
  @Query("SELECT entity FROM Resposta entity WHERE entity.pergunta.id = :id")
  public Page<Resposta> findRespostasByPergunta(@Param(value="id") java.lang.String id, Pageable pageable);

}
