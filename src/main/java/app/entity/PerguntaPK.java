package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;


/**
* @generated
*
**/
public class PerguntaPK implements Serializable {

  /**
  * @generated
  */
  private static final long serialVersionUID = 1L;
  
  /**
   * @generated
   */
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
  
  /**
   * @generated
   */
  private java.lang.String fk_licitacao;
  
  /**
   * Construtor
   * @generated
   */
  public PerguntaPK(){
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
  public PerguntaPK setId(java.lang.String id){
    this.id = id;
    return this;
  }
  /**
   * Obtém fk
   * return fk
   * @generated
   */
  public java.lang.String getFk(){
    return this.fk_licitacao;
  }
  
  /**
   * Define fk
   * @param fk fk
   * @generated
   */
  public PerguntaPK setFk(java.lang.String fk){
    this.fk_licitacao = fk;
    return this;
  }
  
  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    PerguntaPK object = (PerguntaPK)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    if (fk_licitacao != null ? !fk_licitacao.equals(object.fk_licitacao) : object.fk_licitacao != null) return false;
    return true;
  }
  
  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    result = 31 * result + ((fk_licitacao == null) ? 0 : fk_licitacao.hashCode());
    return result;
  }

}
