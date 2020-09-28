package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Pergunta {

public static final int TIMEOUT = 300;

/**
 *
 * @param fk_licitacao
 * @return Var
 */
// Descreva esta função...
public static Var buscarResponsavelTecnico(Var fk_licitacao) throws Exception {
 return new Callable<Var>() {

   private Var chave_rt = Var.VAR_NULL;
   private Var usuario = Var.VAR_NULL;

   public Var call() throws Exception {
    chave_rt = cronapi.database.Operations.query(Var.valueOf("app.entity.Licitacao"),Var.valueOf("select l.responsavelTecnico from Licitacao l where l.id = :id"),Var.valueOf("id",fk_licitacao));
    chave_rt = cronapi.list.Operations.getFirst(chave_rt);
    if (cronapi.logic.Operations.isNullOrEmpty(chave_rt).negate().getObjectAsBoolean()) {
        usuario = blockly.Utilidades.buscarDadosUsuario(chave_rt);
    } else {
        usuario = Var.valueOf("\n");
    }
    return usuario;
   }
 }.call();
}

/**
 *
 * @param fk_licitacao
 * @return Var
 */
// Descreva esta função...
public static Var buscarResponsavelTecnico2(Var fk_licitacao) throws Exception {
 return new Callable<Var>() {

   private Var chave_rt = Var.VAR_NULL;
   private Var usuario = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(fk_licitacao.getObjectAsString());
    chave_rt = cronapi.database.Operations.query(Var.valueOf("app.entity.Licitacao"),Var.valueOf("select l.responsavelTecnico from Licitacao l where l.id = :id"),Var.valueOf("id",fk_licitacao));
    chave_rt = cronapi.list.Operations.getFirst(chave_rt);
    if (cronapi.logic.Operations.isNullOrEmpty(chave_rt).negate().getObjectAsBoolean()) {
        usuario = blockly.Utilidades.buscarDadosUsuario(chave_rt);
    } else {
        usuario = Var.valueOf("\n");
    }
    return usuario;
   }
 }.call();
}

/**
 *
 * @param rows
 */
// Descreva esta função...
public static void dispararEmails(Var rows) throws Exception {
  new Callable<Var>() {

   private Var respondentes = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var email_respondente = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(rows).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("Selecione as perguntas para reenviar alerta aos respondentes.")));
    } else {
        for (Iterator it_i = rows.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            if (Var.valueOf(Var.valueOf(cronapi.json.Operations.getJsonOrMapField(i, Var.valueOf("statusPergunta")).equals(Var.valueOf("2"))).getObjectAsBoolean() || Var.valueOf(cronapi.json.Operations.getJsonOrMapField(i, Var.valueOf("statusPergunta")).equals(Var.valueOf("3"))).getObjectAsBoolean()).getObjectAsBoolean()) {
                cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("Você não pode disparar e-mail para perguntas já respondidas ou publicadas.")));
            }
        } // end for
        cronapi.util.Operations.scheduleExecution(() -> {
          try {
            for (Iterator it_i = rows.iterator(); it_i.hasNext();) {
                i = Var.valueOf(it_i.next());
                respondentes = cronapi.database.Operations.query(Var.valueOf("app.entity.PerguntaRespondentes"),Var.valueOf("select p.user from PerguntaRespondentes p where p.pergunta = :pergunta"),Var.valueOf("pergunta",cronapi.json.Operations.getJsonOrMapField(i, Var.valueOf("id"))));
                for (Iterator it_j = respondentes.iterator(); it_j.hasNext();) {
                    j = Var.valueOf(it_j.next());
                    email_respondente = cronapi.json.Operations.getJsonOrMapField(j, Var.valueOf("email"));
                    if (cronapi.logic.Operations.isNullOrEmpty(email_respondente).negate().getObjectAsBoolean()) {
                        cronapi.email.Operations.sendEmail(Var.valueOf("caroline.santos@cronapp.io"), email_respondente, Var.VAR_NULL, Var.VAR_NULL, Var.valueOf("GEPR - Pergunta pendente"), Var.valueOf("Você tem perguntas aguardando resposta"), Var.valueOf("<p style=\"text-align:center;font-weight:bold;\">Pergunta pendente!</p>\n<p style=\"text-align:center;\">Existem perguntas associadas ao seu usuário aguardando uma resposta.</p>\n<h3 style=\"text-align:center;\"><a href=\"\" target=\"_blank\">Visualizar</a></h3>"), Var.VAR_NULL, Var.valueOf("smtp.office365.com"), Var.valueOf("587"), Var.valueOf("caroline.santos@cronapp.io"), Var.valueOf("Intelfuturo@10"), Var.valueOf("TLS"));
                    }
                } // end for
            } // end for
          } catch(Exception e) {
            throw new RuntimeException(e);
          }
         }, Var.valueOf(1), Var.VAR_NULL, Var.valueOf("SECONDS"));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param id_pergunta
 */
// Descreva esta função...
public static void enviarEmailParaRespondentes(Var id_pergunta) throws Exception {
  new Callable<Var>() {

   private Var respondentes = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var email_respondente = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.util.Operations.scheduleExecution(() -> {
      try {
        respondentes = cronapi.database.Operations.query(Var.valueOf("app.entity.PerguntaRespondentes"),Var.valueOf("select p.user from PerguntaRespondentes p where p.pergunta = :pergunta"),Var.valueOf("pergunta",id_pergunta));
        for (Iterator it_j = respondentes.iterator(); it_j.hasNext();) {
            j = Var.valueOf(it_j.next());
            email_respondente = cronapi.json.Operations.getJsonOrMapField(j, Var.valueOf("email"));
            if (cronapi.logic.Operations.isNullOrEmpty(email_respondente).negate().getObjectAsBoolean()) {
                cronapi.email.Operations.sendEmail(Var.valueOf("caroline.santos@cronapp.io"), email_respondente, Var.VAR_NULL, Var.VAR_NULL, Var.valueOf("GEPR - Nova Pergunta"), Var.valueOf("Você tem uma Nova Pergunta!"), Var.valueOf("<p style=\"text-align:center;font-weight:bold;\">Você tem uma Nova Pergunta!</p>\n<p style=\"text-align:center;\">Você foi adicionado como respondente em uma pergunta no GEPR, acesse para responder.</p>\n<h3 style=\"text-align:center;\"><a href=\"\" target=\"_blank\">Visualizar</a></h3>"), Var.VAR_NULL, Var.valueOf("smtp.office365.com"), Var.valueOf("587"), Var.valueOf("caroline.santos@cronapp.io"), Var.valueOf("Intelfuturo@10"), Var.valueOf("TLS"));
            }
        } // end for
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
     }, Var.valueOf(1), Var.VAR_NULL, Var.valueOf("SECONDS"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param id_pergunta
 */
// Descreva esta função...
public static void enviarEmailParaRespondentesEdicao(Var id_pergunta) throws Exception {
  new Callable<Var>() {

   private Var respondentes = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var email_respondente = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.util.Operations.scheduleExecution(() -> {
      try {
        respondentes = cronapi.database.Operations.query(Var.valueOf("app.entity.PerguntaRespondentes"),Var.valueOf("select p.user from PerguntaRespondentes p where p.pergunta = :pergunta"),Var.valueOf("pergunta",id_pergunta));
        for (Iterator it_j = respondentes.iterator(); it_j.hasNext();) {
            j = Var.valueOf(it_j.next());
            email_respondente = cronapi.json.Operations.getJsonOrMapField(j, Var.valueOf("email"));
            if (cronapi.logic.Operations.isNullOrEmpty(email_respondente).negate().getObjectAsBoolean()) {
                cronapi.email.Operations.sendEmail(Var.valueOf("caroline.santos@cronapp.io"), email_respondente, Var.VAR_NULL, Var.VAR_NULL, Var.valueOf("GEPR - Pergunta Atualizada"), Var.valueOf("Existem mudanças em uma pergunta associada ao seu usuário."), Var.valueOf("<p style=\"text-align:center;font-weight:bold;\">Pergunta atualizada!</p>\n<p style=\"text-align:center;\">Existem mudanças em uma pergunta associada ao seu usuário.</p>\n<h3 style=\"text-align:center;\"><a href=\"\" target=\"_blank\">Visualizar</a></h3>"), Var.VAR_NULL, Var.valueOf("smtp.office365.com"), Var.valueOf("587"), Var.valueOf("caroline.santos@cronapp.io"), Var.valueOf("Intelfuturo@10"), Var.valueOf("TLS"));
            }
        } // end for
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
     }, Var.valueOf(1), Var.VAR_NULL, Var.valueOf("SECONDS"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param id_pergunta
 */
// Descreva esta função...
public static void excluirPergunta(Var id_pergunta) throws Exception {
  new Callable<Var>() {

   private Var statusPergunta = Var.VAR_NULL;

   public Var call() throws Exception {
    statusPergunta = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p.statusPergunta from Pergunta p where p.id = :id"),Var.valueOf("id",cronapi.json.Operations.getJsonOrMapField(id_pergunta, Var.valueOf("id"))));
    if (Var.valueOf(cronapi.list.Operations.getFirst(statusPergunta).equals(Var.valueOf("3"))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("Você não pode excluir uma pergunta publicada.")));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param licitacao
 */
// Descreva esta função...
public static void gerarRelat_C3_B3rio(Var licitacao) throws Exception {
  new Callable<Var>() {

   private Var perguntas = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(licitacao).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Você precisa selecionar uma licitação."));
    } else {
        perguntas = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p from Pergunta p where p.fk_licitacao = :fk_licitacao AND p.statusPergunta = 3"),Var.valueOf("fk_licitacao",licitacao));
        if (cronapi.logic.Operations.isNullOrEmpty(perguntas).getObjectAsBoolean()) {
            cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Não existem perguntas publicadas para essa licitação"));
        } else {
            cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.util.openReport"), Var.valueOf("reports/relatorio-licitacao.report"), cronapi.list.Operations.newList(Var.valueOf("fk_licitacao" , licitacao)));
        }
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param perguntaId
 * @return Var
 */
// Descreva esta função...
public static Var gerarRelatorioAoPublicar(Var perguntaId) throws Exception {
 return new Callable<Var>() {

   private Var licitacao = Var.VAR_NULL;
   private Var ex = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         licitacao = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p.fk_licitacao.id from Pergunta p where p.id = :id"),Var.valueOf("id",perguntaId));
     } catch (Exception ex_exception) {
          ex = Var.valueOf(ex_exception);
         System.out.println(ex.getObjectAsString());
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Ocorreu um erro ao gerar o relatório."));
     } finally {
         cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.util.openReport"), Var.valueOf("reports/relatorio-licitacao.report"), cronapi.list.Operations.newList(Var.valueOf("fk_licitacao" , cronapi.list.Operations.getFirst(licitacao))));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterPastaAnexosPergunta() throws Exception {
 return new Callable<Var>() {

   private Var pasta = Var.VAR_NULL;
   private Var perguntaId = Var.VAR_NULL;
   private Var caminho_destino = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var movido = Var.VAR_NULL;
   private Var respondentes = Var.VAR_NULL;
   private Var id_pergunta = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var email_respondente = Var.VAR_NULL;

   public Var call() throws Exception {
    return Var.valueOf(cronapi.io.Operations.fileAppDir().toString() + cronapi.io.Operations.fileSeparator().toString() + Var.valueOf("anexos").toString() + cronapi.io.Operations.fileSeparator().toString() + Var.valueOf("pergunta").toString());
   }
 }.call();
}

/**
 *
 * @param nome_status
 * @return Var
 */
// Descreva esta função...
public static Var retornaIdStatusPergunta(Var nome_status) throws Exception {
 return new Callable<Var>() {

   private Var dadosStatus = Var.VAR_NULL;

   public Var call() throws Exception {
    dadosStatus = cronapi.database.Operations.query(Var.valueOf("app.entity.StatusPergunta"),Var.valueOf("select s from StatusPergunta s where s.nome = :nome"),Var.valueOf("nome",nome_status));
    return cronapi.database.Operations.getField(dadosStatus, Var.valueOf("this[0].id"));
   }
 }.call();
}

/**
 *
 * @param id2
 * @return Var
 */
// Descreva esta função...
public static Var retornaValorPerguntaAssociada(Var id2) throws Exception {
 return new Callable<Var>() {

   private Var descPergunta = Var.VAR_NULL;

   public Var call() throws Exception {
    descPergunta = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p.descricao from Pergunta p where p.id = :id"),Var.valueOf("id",id2));
    return descPergunta;
   }
 }.call();
}

/**
 *
 * @param perguntaId
 * @return Var
 */
// Descreva esta função...
public static Var uploadArquivoPergunta(Var perguntaId) throws Exception {
 return new Callable<Var>() {

   private Var pasta = Var.VAR_NULL;
   private Var caminho_destino = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var movido = Var.VAR_NULL;

   public Var call() throws Exception {
    pasta = cronapi.io.Operations.folderCreate(Var.valueOf(obterPastaAnexosPergunta()), perguntaId);
    cronapi.util.Operations.upload(Var.valueOf("Clique para selecionar o arquivo"), Var.valueOf("*"), Var.VAR_NULL, Var.valueOf("false"), (sender_item) -> {
        item = Var.valueOf(sender_item);
        caminho_destino = Var.valueOf(Var.valueOf(obterPastaAnexosPergunta()).toString() + cronapi.io.Operations.fileSeparator().toString() + perguntaId.toString() + cronapi.io.Operations.fileSeparator().toString() + cronapi.list.Operations.getLast((cronapi.list.Operations.getListFromText(cronapi.list.Operations.getLast(item),Var.valueOf("/")))).toString());
        movido = cronapi.io.Operations.fileMove(cronapi.list.Operations.getLast(item), caminho_destino);
        if (movido.getObjectAsBoolean()) {
            cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("AnexosPerguntaGrid.active.caminho"), caminho_destino);
        }
    });
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param id_pergunta
 */
// Descreva esta função...
public static void visualizarPergunta(Var id_pergunta) throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/logged/forum"), cronapi.list.Operations.newList(Var.valueOf("param0",cronapi.json.Operations.getJsonOrMapField(id_pergunta, Var.valueOf("id")))));
   return Var.VAR_NULL;
   }
 }.call();
}

}

