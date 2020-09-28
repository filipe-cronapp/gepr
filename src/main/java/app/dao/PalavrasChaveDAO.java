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
@Repository("PalavrasChaveDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface PalavrasChaveDAO extends JpaRepository<PalavrasChave, java.lang.String> {

  /**
   * Obtém a instância de PalavrasChave utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM PalavrasChave entity WHERE entity.id = :id")
  public PalavrasChave findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de PalavrasChave utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM PalavrasChave entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM PalavrasChave entity WHERE entity.nome like concat('%',coalesce(:search,''),'%')")
  public Page<PalavrasChave> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM PalavrasChave entity WHERE (:nome is null OR entity.nome like concat('%',:nome,'%'))")
  public Page<PalavrasChave> specificSearch(@Param(value="nome") java.lang.String nome, Pageable pageable);
  
  /**
   * Foreign Key pergunta
   * @generated
   */
  @Query("SELECT entity FROM PalavrasChave entity WHERE entity.pergunta.id = :id")
  public Page<PalavrasChave> findPalavrasChavesByPergunta(@Param(value="id") java.lang.String id, Pageable pageable);

}
