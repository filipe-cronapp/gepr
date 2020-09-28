package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Classe que representa a tabela USUARIO
 * @generated
 */
@Entity
@Table(name = "\"USUARIO\"" ,uniqueConstraints=@UniqueConstraint(columnNames={
"usua_cd_chave" ,"fotr_cd_forca_trabalho" }))
@XmlRootElement
@CronappSecurity(post = "Administrators", delete = "Administrators", put = "Administrators")
@JsonFilter("app.entity.User")
public class User implements Serializable {
  /**
  * Variável privada para verificação da criptofrafia
  *
  * @generated
  */
  private static final String ENCRYPT = "$2a$10$";

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "fotr_cd_forca_trabalho", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "usua_cd_chave", nullable = false, unique = true, insertable=true, updatable=true)
  
  private java.lang.String login;

  /**
  * @generated
  */
  @Column(name = "usua_nm_usuario", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.String name;

  /**
  * @generated
  */
  @Column(name = "usua_tx_email", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String email;

  /**
  * @generated
  */
  @Column(name = "usua_tx_senha", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.String password;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="orga_cd_orgao", nullable = true, referencedColumnName = "orga_cd_orgao", insertable=true, updatable=true)
  
  private Gerencia gerencia;

  /**
   * Construtor
   * @generated
   */
  public User(){
  }


  /**
   * Obtém login
   * return login
   * @generated
   */
  
  public java.lang.String getLogin(){
    return this.login;
  }

  /**
   * Define login
   * @param login login
   * @generated
   */
  public User setLogin(java.lang.String login){
    this.login = login;
    return this;
  }

  /**
   * Obtém name
   * return name
   * @generated
   */
  
  public java.lang.String getName(){
    return this.name;
  }

  /**
   * Define name
   * @param name name
   * @generated
   */
  public User setName(java.lang.String name){
    this.name = name;
    return this;
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
  public User setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém email
   * return email
   * @generated
   */
  
  public java.lang.String getEmail(){
    return this.email;
  }

  /**
   * Define email
   * @param email email
   * @generated
   */
  public User setEmail(java.lang.String email){
    this.email = email;
    return this;
  }

  /**
   * Obtém password
   * return password
   * @generated
   */
  
  public java.lang.String getPassword(){
    return this.password;
  }

  /**
   * Define password
   * @param password password
   * @generated
   */
  public User setPassword(java.lang.String password){
    password = password.startsWith(ENCRYPT) ? password : new BCryptPasswordEncoder().encode(password);
    this.password = password;
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
  public User setGerencia(Gerencia gerencia){
    this.gerencia = gerencia;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    User object = (User)obj;
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
