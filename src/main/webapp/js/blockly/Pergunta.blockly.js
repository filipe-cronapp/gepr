window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Pergunta = window.blockly.js.blockly.Pergunta || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pergunta.carregarFonteRespondentes = function() {

  console.log(this.cronapi.screen.quantityRecords("Pergunta"));
  this.cronapi.screen.load("UserGridCombo");
  this.cronapi.myfunctions.clearTempRows("PerguntaRespondentesGrid");
  console.log(this.cronapi.screen.quantityRecords("Pergunta"));
}

/**
 * Pergunta
 */
window.blockly.js.blockly.Pergunta.validarCamposGrid = function() {

  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("cronapi.server('blockly.Pergunta.buscarResponsavelTecnico').attr().run(Pergunta.active.fk_licitacao)"))) {
    if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("PerguntaRespondentesGrid.active.id"))) {
      this.cronapi.util.throwException(this.cronapi.util.createException('Você precisa adicionar ao menos um respondente.'));
    }
  }
}
