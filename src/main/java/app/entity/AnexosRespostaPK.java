package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;


/**
* @generated
*
**/
public class AnexosRespostaPK implements Serializable {

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
  private RespostaPK resposta;
  
  /**
   * Construtor
   * @generated
   */
  public AnexosRespostaPK(){
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
  public AnexosRespostaPK setId(java.lang.String id){
    this.id = id;
    return this;
  }
  /**
   * Obtém resposta
   * return resposta
   * @generated
   */
  public RespostaPK getResposta(){
    return this.resposta;
  }
  
  /**
   * Define resposta
   * @param resposta resposta
   * @generated
   */
  public AnexosRespostaPK setResposta(RespostaPK resposta){
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
    AnexosRespostaPK object = (AnexosRespostaPK)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    if (resposta != null ? !resposta.equals(object.resposta) : object.resposta != null) return false;
    return true;
  }
  
  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    result = 31 * result + ((resposta == null) ? 0 : resposta.hashCode());
    return result;
  }

}
