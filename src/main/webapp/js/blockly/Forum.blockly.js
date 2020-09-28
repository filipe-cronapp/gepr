window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Forum = window.blockly.js.blockly.Forum || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Forum.fecharModalResposta = function() {
 var item, anexosPergunta, descricao, i, length, lista, perguntaId, retorno, texto, x, anexos;
  this.cronapi.screen.hideModal("modalResposta");
  this.cronapi.screen.changeValueOfField("msgCarregando", '');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Forum.abrirModalArquivos = function(length2, anexos) {
 var item, anexosPergunta, descricao, i, length, lista, perguntaId, retorno, texto;
  this.cronapi.screen.createScopeVariable('anexos', null);
  if (length2 > '0') {
    this.cronapi.screen.changeValueOfField('anexos', anexos);
    this.cronapi.screen.showModal("modalArquivos");
  }
}

/**
 * Bloco
 */
window.blockly.js.blockly.Forum.tratarDadosPergunta = function(perguntaId) {
 var item, anexosPergunta, descricao, i, length, lista, retorno, texto, x, anexos;
  this.cronapi.screen.createScopeVariable('pergunta', null);
  this.cronapi.screen.createScopeVariable('anexosPergunta', null);
  this.cronapi.screen.createScopeVariable('respostas', null);
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Forum:obterDadosPergunta', function(sender_retorno) {
      retorno = sender_retorno;
    this.cronapi.screen.changeValueOfField('pergunta', this.cronapi.object.getObjectField(retorno, 'pergunta')[0]);
    this.cronapi.screen.changeValueOfField('respostas', this.cronapi.object.getObjectField(retorno, 'respostas'));
    anexosPergunta = this.cronapi.object.getObjectField(retorno, 'anexos');
    for (var i_index in anexosPergunta) {
      i = anexosPergunta[i_index];
      i.push(i.slice(-1)[0].split('/').slice(-1)[0].split('.').slice(-1)[0].toUpperCase());
    }
    this.cronapi.screen.changeValueOfField('anexosPergunta', anexosPergunta);
  }.bind(this), perguntaId);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Forum.abrirModalResposta = function() {
 var item, anexosPergunta, descricao, i, length, lista, perguntaId, retorno, texto, x, anexos;
  this.cronapi.screen.createScopeVariable('idResposta', null);
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Forum:retornaUID', function(sender_item) {
      item = sender_item;
    this.cronapi.screen.changeValueOfField('idResposta', item);
    this.cronapi.screen.showModal("modalResposta");
  }.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Forum.copiarDescricao = function(descricao) {
 var item, anexosPergunta, i, length, lista, perguntaId, retorno, texto, x, anexos;
  this.cronapi.screen.changeValueOfField("resposta_final", descricao);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Forum.publicarResposta = function(perguntaId) {
 var item, anexosPergunta, descricao, i, length, lista, retorno, texto, x, anexos;
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Forum:publicarResposta', function(sender_item) {
      item = sender_item;
    this.blockly.js.blockly.Forum.tratarDadosPergunta(perguntaId);
    this.cronapi.util.callServerBlocklyNoReturn('blockly.Pergunta:gerarRelatorioAoPublicar', perguntaId);
  }.bind(this), perguntaId);
}
