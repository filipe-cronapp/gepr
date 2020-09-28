package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Forum {

public static final int TIMEOUT = 300;

/**
 *
 * @param perguntaId
 * @param resposta
 * @param respostaId
 */
// Descreva esta função...
public static void adicionarResposta(Var perguntaId, Var resposta, Var respostaId) throws Exception {
  new Callable<Var>() {

   private Var x = Var.VAR_NULL;
   private Var anexos = Var.VAR_NULL;
   private Var k = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(resposta).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Não pode inserir um valor vazio."));
    } else {
        try {
             anexos = cronapi.io.Operations.listFiles(Var.valueOf(Var.valueOf(obterPastaAnexosResposta()).toString() + cronapi.io.Operations.fileSeparator().toString() + respostaId.toString()), Var.valueOf("files"));
            cronapi.database.Operations.insert(Var.valueOf("app.entity.Resposta"),Var.valueOf("pergunta",perguntaId),Var.valueOf("respondente",blockly.Utilidades.obterIdUsuarioLogado()),Var.valueOf("data_resposta",cronapi.dateTime.Operations.getNowNoHour()),Var.valueOf("id",respostaId),Var.valueOf("descricao",resposta));
            for (Iterator it_k = anexos.iterator(); it_k.hasNext();) {
                k = Var.valueOf(it_k.next());
                cronapi.database.Operations.insert(Var.valueOf("app.entity.AnexosResposta"),Var.valueOf("resposta",respostaId),Var.valueOf("caminho",k));
            } // end for
            cronapi.database.Operations.execute(Var.valueOf("app.entity.Pergunta"), Var.valueOf("update Pergunta set statusPergunta = :statusPergunta where id = :id"),Var.valueOf("statusPergunta",Var.valueOf("1")),Var.valueOf("id",perguntaId));
         } catch (Exception x_exception) {
              x = Var.valueOf(x_exception);
             System.out.println(x.getObjectAsString());
            cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Ocorreu um erro inesperado."));
         } finally {
             enviarEmailAlertaResposta(perguntaId);
            cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/logged/forum"), cronapi.list.Operations.newList(Var.valueOf("param0",perguntaId)));
        }
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param perguntaId
 * @param respostaFinal
 */
// Descreva esta função...
public static void adicionarRespostaFinal(Var perguntaId, Var respostaFinal) throws Exception {
  new Callable<Var>() {

   private Var x = Var.VAR_NULL;
   private Var perguntaAtual = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(respostaFinal).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Não pode inserir um valor vazio."));
    } else {
        try {
             perguntaAtual = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p from Pergunta p where p.id = :id"),Var.valueOf("id",perguntaId));
            cronapi.database.Operations.updateField(perguntaAtual, Var.valueOf("respostaFinal"), respostaFinal);
            cronapi.database.Operations.update(Var.valueOf("app.entity.Pergunta"),perguntaAtual);
            cronapi.database.Operations.updateField(perguntaAtual, Var.valueOf("statusPergunta"), Var.valueOf("2"));
            cronapi.database.Operations.update(Var.valueOf("app.entity.Pergunta"),perguntaAtual);
         } catch (Exception x_exception) {
              x = Var.valueOf(x_exception);
             System.out.println(x.getObjectAsString());
            cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Ocorreu um erro inesperado."));
         } finally {
             cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/logged/forum"), cronapi.list.Operations.newList(Var.valueOf("param0",perguntaId)));
        }
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param perguntaId
 * @param respostaFinal
 */
// Descreva esta função...
public static void adicionarRespostaFinalBackup(Var perguntaId, Var respostaFinal) throws Exception {
  new Callable<Var>() {

   private Var x = Var.VAR_NULL;
   private Var perguntaAtual = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(respostaFinal).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Não pode inserir um valor vazio."));
    } else {
        try {
             perguntaAtual = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p from Pergunta p where p.id = :id"),Var.valueOf("id",perguntaId));
            cronapi.database.Operations.updateField(perguntaAtual, Var.valueOf("respostaFinal"), respostaFinal);
            cronapi.database.Operations.update(Var.valueOf("app.entity.Pergunta"),perguntaAtual);
            cronapi.database.Operations.updateField(perguntaAtual, Var.valueOf("statusPergunta"), Var.valueOf("2"));
            cronapi.database.Operations.update(Var.valueOf("app.entity.Pergunta"),perguntaAtual);
         } catch (Exception x_exception) {
              x = Var.valueOf(x_exception);
             System.out.println(x.getObjectAsString());
            cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Ocorreu um erro inesperado."));
         }
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param perguntaId
 * @param subQuestionamento
 */
// Descreva esta função...
public static void adicionarSubQuestionamento(Var perguntaId, Var subQuestionamento) throws Exception {
  new Callable<Var>() {

   private Var x = Var.VAR_NULL;
   private Var perguntaAtual = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(subQuestionamento).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Não pode inserir um valor vazio."));
    } else {
        try {
             perguntaAtual = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p from Pergunta p where p.id = :id"),Var.valueOf("id",perguntaId));
            cronapi.database.Operations.updateField(perguntaAtual, Var.valueOf("subQuestionamento"), subQuestionamento);
            cronapi.database.Operations.update(Var.valueOf("app.entity.Pergunta"),perguntaAtual);
         } catch (Exception x_exception) {
              x = Var.valueOf(x_exception);
             System.out.println(x.getObjectAsString());
            cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Ocorreu um erro inesperado."));
         } finally {
             enviarEmailParaRespondentesSubQuest(perguntaId);
            cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/logged/forum"), cronapi.list.Operations.newList(Var.valueOf("param0",perguntaId)));
        }
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param caminho_anexo
 */
// Descreva esta função...
public static void downloadArquivo(Var caminho_anexo) throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.io.Operations.fileDownload(caminho_anexo);
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param id_pergunta
 */
// Descreva esta função...
public static void enviarEmailAlertaResposta(Var id_pergunta) throws Exception {
  new Callable<Var>() {

   private Var comprador = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var email_respondente = Var.VAR_NULL;

   public Var call() throws Exception {
    comprador = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p.criador_pergunta from Pergunta p where p.id = :id"),Var.valueOf("id",id_pergunta));
    for (Iterator it_j = comprador.iterator(); it_j.hasNext();) {
        j = Var.valueOf(it_j.next());
        email_respondente = cronapi.json.Operations.getJsonOrMapField(j, Var.valueOf("email"));
        if (cronapi.logic.Operations.isNullOrEmpty(email_respondente).negate().getObjectAsBoolean()) {
            cronapi.email.Operations.sendEmail(Var.valueOf("caroline.santos@cronapp.io"), email_respondente, Var.VAR_NULL, Var.VAR_NULL, Var.valueOf("GEPR - Nova Resposta"), Var.valueOf("Pergunta tem nova resposta!"), Var.valueOf("<p style=\"text-align:center;font-weight:bold;\">Nova resposta!</p>\n<p style=\"text-align:center;\">Sua pergunta no sistema GEPR tem uma nova resposta.</p>\n<h3 style=\"text-align:center;\"><a href=\"\" target=\"_blank\">Visualizar</a></h3>"), Var.VAR_NULL, Var.valueOf("smtp.office365.com"), Var.valueOf("587"), Var.valueOf("caroline.santos@cronapp.io"), Var.valueOf("Intelfuturo@10"), Var.valueOf("TLS"));
        }
    } // end for
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param id_pergunta
 */
// Descreva esta função...
public static void enviarEmailParaRespondentesSubQuest(Var id_pergunta) throws Exception {
  new Callable<Var>() {

   private Var comprador = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var email_respondente = Var.VAR_NULL;

   public Var call() throws Exception {
    comprador = cronapi.database.Operations.query(Var.valueOf("app.entity.PerguntaRespondentes"),Var.valueOf("select p.user from PerguntaRespondentes p where p.pergunta = :pergunta"),Var.valueOf("pergunta",id_pergunta));
    for (Iterator it_j = comprador.iterator(); it_j.hasNext();) {
        j = Var.valueOf(it_j.next());
        email_respondente = cronapi.json.Operations.getJsonOrMapField(j, Var.valueOf("email"));
        if (cronapi.logic.Operations.isNullOrEmpty(email_respondente).negate().getObjectAsBoolean()) {
            cronapi.email.Operations.sendEmail(Var.valueOf("caroline.santos@cronapp.io"), email_respondente, Var.VAR_NULL, Var.VAR_NULL, Var.valueOf("GEPR - Pergunta Atualizada"), Var.valueOf("Existem mudanças em uma pergunta associada ao seu usuário."), Var.valueOf("<p style=\"text-align:center;font-weight:bold;\">Pergunta atualizada!</p>\n<p style=\"text-align:center;\">Existem mudanças em uma pergunta associada ao seu usuário.</p>\n<h3 style=\"text-align:center;\"><a href=\"\" target=\"_blank\">Visualizar</a></h3>"), Var.VAR_NULL, Var.valueOf("smtp.office365.com"), Var.valueOf("587"), Var.valueOf("caroline.santos@cronapp.io"), Var.valueOf("Intelfuturo@10"), Var.valueOf("TLS"));
        }
    } // end for
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
public static Var obterDadosPergunta(Var perguntaId) throws Exception {
 return new Callable<Var>() {

   private Var x = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var dadosPergunta = Var.VAR_NULL;
   private Var anexosPergunta = Var.VAR_NULL;
   private Var dadosRespostas = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         dadosPergunta = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select \np.descricao, \npa.id, \npa.descricao, \np.subQuestionamento, \np.respostaFinal, \np.statusPergunta\nfrom Pergunta p left join p.pergunta_associada pa where p.id = :id"),Var.valueOf("id",perguntaId));
        anexosPergunta = cronapi.database.Operations.query(Var.valueOf("app.entity.AnexosPergunta"),Var.valueOf("select a.id, a.caminho from AnexosPergunta a where a.pergunta = :pergunta"),Var.valueOf("pergunta",perguntaId));
        dadosRespostas = cronapi.database.Operations.query(Var.valueOf("app.entity.Resposta"),Var.valueOf("select r from Resposta r where r.pergunta = :pergunta"),Var.valueOf("pergunta",perguntaId));
     } catch (Exception x_exception) {
          x = Var.valueOf(x_exception);
         System.out.println(x.getObjectAsString());
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Ocorreu um erro inesperado."));
     } finally {
         item = cronapi.map.Operations.createObjectMapWith(Var.valueOf("pergunta",dadosPergunta) , Var.valueOf("anexos",anexosPergunta) , Var.valueOf("respostas",dadosRespostas));
    }
    return item;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterPastaAnexosResposta() throws Exception {
 return new Callable<Var>() {

   private Var perguntaId = Var.VAR_NULL;
   private Var x = Var.VAR_NULL;
   private Var pasta = Var.VAR_NULL;
   private Var respostaId = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var caminho_destino = Var.VAR_NULL;

   public Var call() throws Exception {
    return Var.valueOf(cronapi.io.Operations.fileAppDir().toString() + cronapi.io.Operations.fileSeparator().toString() + Var.valueOf("anexos").toString() + cronapi.io.Operations.fileSeparator().toString() + Var.valueOf("resposta").toString());
   }
 }.call();
}

/**
 *
 * @param perguntaId
 * @return Var
 */
// Descreva esta função...
public static Var publicarResposta(Var perguntaId) throws Exception {
 return new Callable<Var>() {

   private Var x = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         cronapi.database.Operations.execute(Var.valueOf("app.entity.Pergunta"), Var.valueOf("update Pergunta set data_publicacao = :data_publicacao, statusPergunta = :statusPergunta where id = :id"),Var.valueOf("data_publicacao",cronapi.dateTime.Operations.getNowNoHour()),Var.valueOf("statusPergunta",Var.valueOf("3")),Var.valueOf("id",perguntaId));
     } catch (Exception x_exception) {
          x = Var.valueOf(x_exception);
         System.out.println(x.getObjectAsString());
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Ocorreu um erro inesperado."));
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
public static Var retornaUID() throws Exception {
 return new Callable<Var>() {

   private Var perguntaId = Var.VAR_NULL;
   private Var x = Var.VAR_NULL;
   private Var pasta = Var.VAR_NULL;
   private Var respostaId = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var caminho_destino = Var.VAR_NULL;
   private Var dadosPergunta = Var.VAR_NULL;
   private Var anexosPergunta = Var.VAR_NULL;
   private Var dadosRespostas = Var.VAR_NULL;
   private Var resposta = Var.VAR_NULL;
   private Var anexos = Var.VAR_NULL;
   private Var k = Var.VAR_NULL;
   private Var caminho_anexo = Var.VAR_NULL;
   private Var retorno = Var.VAR_NULL;
   private Var funcao = Var.VAR_NULL;
   private Var respostaFinal = Var.VAR_NULL;

   public Var call() throws Exception {
    return cronapi.util.Operations.generateUUID();
   }
 }.call();
}

/**
 *
 * @param perguntaId
 * @param respostaId
 */
// Descreva esta função...
public static void uploadArquivoResposta(Var perguntaId, Var respostaId) throws Exception {
  new Callable<Var>() {

   private Var pasta = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var caminho_destino = Var.VAR_NULL;

   public Var call() throws Exception {
    pasta = cronapi.io.Operations.folderCreate(Var.valueOf(obterPastaAnexosResposta()), respostaId);
    cronapi.util.Operations.upload(Var.valueOf("Selecione um ou mais arquivos"), Var.valueOf("*"), Var.VAR_NULL, Var.valueOf("true"), (sender_item) -> {
        item = Var.valueOf(sender_item);
        for (Iterator it_i = item.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            caminho_destino = Var.valueOf(Var.valueOf(obterPastaAnexosResposta()).toString() + cronapi.io.Operations.fileSeparator().toString() + respostaId.toString());
            i = cronapi.io.Operations.fileMove(i, caminho_destino);
            if (i.getObjectAsBoolean()) {
                System.out.println(Var.valueOf("abc").getObjectAsString());
                cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("msgCarregando"), Var.valueOf("√ Carregado com sucesso!"));
            }
        } // end for
    });
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
public static Var verificarAddRespostaFinal(Var perguntaId) throws Exception {
 return new Callable<Var>() {

   private Var x = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var retorno = Var.VAR_NULL;
   private Var funcao = Var.VAR_NULL;
   private Var respostaFinal = Var.VAR_NULL;

   public Var call() throws Exception {
    retorno = Var.VAR_FALSE;
    try {
         funcao = cronapi.database.Operations.query(Var.valueOf("app.entity.Role"),Var.valueOf("select r.id from Role r where r.user = :user"),Var.valueOf("user",blockly.Utilidades.obterIdUsuarioLogado()));
        respostaFinal = cronapi.database.Operations.query(Var.valueOf("app.entity.Pergunta"),Var.valueOf("select p.respostaFinal from Pergunta p where p.id = :id"),Var.valueOf("id",perguntaId));
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
                    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.list.Operations.getFirst(respostaFinal)).negate().getObjectAsBoolean()) {
                        retorno = Var.VAR_FALSE;
                    }
                }
            } // end for
        }
    }
    return retorno;
   }
 }.call();
}

}

