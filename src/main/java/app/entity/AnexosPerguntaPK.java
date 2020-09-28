package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;


/**
* @generated
*
**/
public class AnexosPerguntaPK implements Serializable {

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
  private PerguntaPK pergunta;
  
  /**
   * Construtor
   * @generated
   */
  public AnexosPerguntaPK(){
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
  public AnexosPerguntaPK setId(java.lang.String id){
    this.id = id;
    return this;
  }
  /**
   * Obtém pergunta
   * return pergunta
   * @generated
   */
  public PerguntaPK getPergunta(){
    return this.pergunta;
  }
  
  /**
   * Define pergunta
   * @param pergunta pergunta
   * @generated
   */
  public AnexosPerguntaPK setPergunta(PerguntaPK pergunta){
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
    AnexosPerguntaPK object = (AnexosPerguntaPK)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    if (pergunta != null ? !pergunta.equals(object.pergunta) : object.pergunta != null) return false;
    return true;
  }
  
  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    result = 31 * result + ((pergunta == null) ? 0 : pergunta.hashCode());
    return result;
  }

}
