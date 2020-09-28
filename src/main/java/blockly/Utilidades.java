package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Utilidades {

public static final int TIMEOUT = 300;

/**
 *
 * @param chave
 * @return Var
 */
// Descreva esta função...
public static Var buscarDadosUsuario(Var chave) throws Exception {
 return new Callable<Var>() {

   private Var dadosUsuario = Var.VAR_NULL;

   public Var call() throws Exception {
    dadosUsuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u from User u where u.login = :login"),Var.valueOf("login",chave));
    return cronapi.database.Operations.getField(dadosUsuario, Var.valueOf("this[0].name"));
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void limpaAnexosPergunta() throws Exception {
  new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var diretorios = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var k = Var.VAR_NULL;
   private Var registro = Var.VAR_NULL;
   private Var removido = Var.VAR_NULL;

   public Var call() throws Exception {
    lista = cronapi.io.Operations.listFiles(blockly.Pergunta.obterPastaAnexosPergunta(), Var.valueOf("directories"));
    diretorios = cronapi.list.Operations.newList();
    for (Iterator it_j = lista.iterator(); it_j.hasNext();) {
        j = Var.valueOf(it_j.next());
        cronapi.list.Operations.addLast(diretorios,cronapi.list.Operations.getLast((cronapi.list.Operations.getListFromText(j,Var.valueOf("/")))));
    } // end for
    for (Iterator it_k = diretorios.iterator(); it_k.hasNext();) {
        k = Var.valueOf(it_k.next());
        registro = cronapi.database.Operations.query(Var.valueOf("app.entity.AnexosPergunta"),Var.valueOf("select a from AnexosPergunta a where a.pergunta = :pergunta"),Var.valueOf("pergunta",k));
        if (cronapi.logic.Operations.isNullOrEmpty(registro).getObjectAsBoolean()) {
            removido = cronapi.io.Operations.fileRemoveAllFolder(Var.valueOf(blockly.Pergunta.obterPastaAnexosPergunta().toString() + cronapi.io.Operations.fileSeparator().toString() + k.toString()));
        }
    } // end for
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void limpaAnexosResposta() throws Exception {
  new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var diretorios = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var k = Var.VAR_NULL;
   private Var registro = Var.VAR_NULL;
   private Var removido = Var.VAR_NULL;

   public Var call() throws Exception {
    lista = cronapi.io.Operations.listFiles(blockly.Forum.obterPastaAnexosResposta(), Var.valueOf("directories"));
    diretorios = cronapi.list.Operations.newList();
    for (Iterator it_j = lista.iterator(); it_j.hasNext();) {
        j = Var.valueOf(it_j.next());
        cronapi.list.Operations.addLast(diretorios,cronapi.list.Operations.getLast((cronapi.list.Operations.getListFromText(j,Var.valueOf("/")))));
    } // end for
    for (Iterator it_k = diretorios.iterator(); it_k.hasNext();) {
        k = Var.valueOf(it_k.next());
        registro = cronapi.database.Operations.query(Var.valueOf("app.entity.AnexosResposta"),Var.valueOf("select a from AnexosResposta a where a.resposta = :resposta"),Var.valueOf("resposta",k));
        if (cronapi.logic.Operations.isNullOrEmpty(registro).getObjectAsBoolean()) {
            removido = cronapi.io.Operations.fileRemoveAllFolder(Var.valueOf(blockly.Forum.obterPastaAnexosResposta().toString() + cronapi.io.Operations.fileSeparator().toString() + k.toString()));
        }
    } // end for
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterDataAtual() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    System.out.println(cronapi.dateTime.Operations.getNowNoHour().getObjectAsString());
    return cronapi.dateTime.Operations.getNowNoHour();
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterIdUsuarioLogado() throws Exception {
 return new Callable<Var>() {

   private Var dadosUsuario = Var.VAR_NULL;

   public Var call() throws Exception {
    dadosUsuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u from User u where u.login = :login"),Var.valueOf("login",cronapi.util.Operations.getCurrentUserName()));
    return cronapi.database.Operations.getField(dadosUsuario, Var.valueOf("this[0].id"));
   }
 }.call();
}

/**
 *
 * @param perguntaId
 * @return Var
 */
// Descreva esta função...
public static Var verificarUsuarioCompradorAoPublicar(Var perguntaId) throws Exception {
 return new Callable<Var>() {

   private Var retorno = Var.VAR_NULL;
   private Var funcao = Var.VAR_NULL;
   private Var x = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;

   public Var call() throws Exception {
    retorno = Var.VAR_FALSE;
    try {
         funcao = cronapi.database.Operations.query(Var.valueOf("app.entity.Role"),Var.valueOf("select r.id from Role r where r.user = :user"),Var.valueOf("user",Var.valueOf(obterIdUsuarioLogado())));
     } catch (Exception x_exception) {
          x = Var.valueOf(x_exception);
         System.out.println(x.getObjectAsString());
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Ocorreu um erro inesperado."));
     } finally {
         if (cronapi.logic.Operations.isNullOrEmpty(funcao).negate().getObjectAsBoolean()) {
            for (Iterator it_i = funcao.iterator(); it_i.hasNext();) {
                i = Var.valueOf(it_i.next());
                if (Var.valueOf(Var.valueOf(i.equals(Var.valueOf("Compradores"))).getObjectAsBoolean() || Var.valueOf(i.equals(Var.valueOf("Administrators"))).getObjectAsBoolean()).getObjectAsBoolean()) {
                    retorno = Var.VAR_TRUE;
                }
            } // end for
        }
    }
    return retorno;
   }
 }.call();
}

}

