package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Administrators;Compradores", get = "Administrators;Compradores", execute = "Administrators;Compradores", delete = "Administrators;Compradores", put = "Administrators;Compradores")
public class Licitacao {

public static final int TIMEOUT = 300;

/**
 *
 * @param id2
 */
// Descreva esta função...
public static void encerrarLicitacao(Var id2) throws Exception {
  new Callable<Var>() {

   private Var licitacaoAtual = Var.VAR_NULL;
   private Var perguntas = Var.VAR_NULL;
   private Var x = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         licitacaoAtual = cronapi.database.Operations.query(Var.valueOf("app.entity.Licitacao"),Var.valueOf("select l from Licitacao l where l.id = :id"),Var.valueOf("id",cronapi.json.Operations.getJsonOrMapField(id2, Var.valueOf("id"))));
        perguntas = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p from Pergunta p where p.fk_licitacao = :fk_licitacao"),Var.valueOf("fk_licitacao",cronapi.json.Operations.getJsonOrMapField(id2, Var.valueOf("id"))));
     } catch (Exception x_exception) {
          x = Var.valueOf(x_exception);
         System.out.println(x.getObjectAsString());
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Ocorreu um erro inesperado."));
     } finally {
         if (Var.valueOf(cronapi.json.Operations.getJsonOrMapField(licitacaoAtual, Var.valueOf("statusLicitacao")).equals(Var.valueOf("1"))).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("Licitação já encerrada.")));
        }
        if (cronapi.logic.Operations.isNullOrEmpty(perguntas).negate().getObjectAsBoolean()) {
            for (Iterator it_i = perguntas.iterator(); it_i.hasNext();) {
                i = Var.valueOf(it_i.next());
                if (Var.valueOf(!cronapi.json.Operations.getJsonOrMapField(i, Var.valueOf("statusPergunta")).equals(Var.valueOf("3"))).getObjectAsBoolean()) {
                    cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("Esta licitação possui perguntas não publicadas.")));
                }
            } // end for
        }
        cronapi.database.Operations.updateField(licitacaoAtual, Var.valueOf("statusLicitacao"), Var.valueOf("1"));
        cronapi.database.Operations.update(Var.valueOf("app.entity.Licitacao"),licitacaoAtual);
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/logged/licitacao"));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param id_licitacao
 */
// Descreva esta função...
public static void excluirLicitacao(Var id_licitacao) throws Exception {
  new Callable<Var>() {

   private Var perguntas = Var.VAR_NULL;

   public Var call() throws Exception {
    perguntas = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p from Pergunta p where p.statusPergunta = 3 AND p.fk_licitacao = :fk_licitacao"),Var.valueOf("fk_licitacao",id_licitacao));
    if (cronapi.logic.Operations.isNullOrEmpty(perguntas).negate().getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("Existem perguntas publicadas associadas a esta licitação.")));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param id2
 */
// Descreva esta função...
public static void reabrirLicitacao(Var id2) throws Exception {
  new Callable<Var>() {

   private Var licitacaoAtual = Var.VAR_NULL;
   private Var x = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         licitacaoAtual = cronapi.database.Operations.query(Var.valueOf("app.entity.Licitacao"),Var.valueOf("select l from Licitacao l where l.id = :id"),Var.valueOf("id",id2));
        cronapi.database.Operations.updateField(licitacaoAtual, Var.valueOf("statusLicitacao"), Var.valueOf("0"));
        cronapi.database.Operations.update(Var.valueOf("app.entity.Licitacao"),licitacaoAtual);
     } catch (Exception x_exception) {
          x = Var.valueOf(x_exception);
         System.out.println(x.getObjectAsString());
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Ocorreu um erro inesperado."));
     } finally {
         cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf("Licitação reaberta com sucesso."));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/logged/licitacao"));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param nome_status
 * @return Var
 */
// Descreva esta função...
public static Var retornaIdStatusLicitacao(Var nome_status) throws Exception {
 return new Callable<Var>() {

   private Var dadosStatus = Var.VAR_NULL;

   public Var call() throws Exception {
    dadosStatus = cronapi.database.Operations.query(Var.valueOf("app.entity.StatusLicitacao"),Var.valueOf("select s from StatusLicitacao s where s.nome = :nome"),Var.valueOf("nome",nome_status));
    return cronapi.database.Operations.getField(dadosStatus, Var.valueOf("this[0].id"));
   }
 }.call();
}

/**
 *
 * @param param_data
 */
// Descreva esta função...
public static void validarCamposLicitacao(Var param_data) throws Exception {
  new Callable<Var>() {

   // param
   private Var data = param_data;
   // end
   private Var chave = Var.VAR_NULL;
   private Var usuario = Var.VAR_NULL;

   public Var call() throws Exception {
    chave = cronapi.json.Operations.getJsonOrMapField(data, Var.valueOf("responsavelTecnico"));
    if (cronapi.logic.Operations.isNullOrEmpty(chave).negate().getObjectAsBoolean()) {
        usuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u from User u where u.login = :login"),Var.valueOf("login",chave));
        if (cronapi.logic.Operations.isNullOrEmpty(usuario).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("Você precisa adicionar um usuário válido como Responsável Técnico")));
        }
    }
    if (Var.valueOf(cronapi.json.Operations.getJsonOrMapField(data, Var.valueOf("previsao_encerramento")).compareTo(cronapi.dateTime.Operations.getNowNoHour()) < 0).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("A previsão de encerramento não pode ser menor que a data atual.")));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

}

