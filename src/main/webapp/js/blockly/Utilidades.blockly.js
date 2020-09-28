window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Utilidades = window.blockly.js.blockly.Utilidades || {};

/**
 * Utilidades
 */
window.blockly.js.blockly.Utilidades.alterarCorGridEStatus = function() {

  this.cronapi.util.executeJavascriptNoReturn('var listTR = document.querySelectorAll(\".k-grid tbody tr\");\n\nlistTR.forEach(function(item){\n    var dataTD = item.cells[4].textContent.substr(4).substr(0,19);\n    var statusTD = item.cells[5].te' +
   'xtContent;\n    \n    if(new Date() > new Date(dataTD) && statusTD == \'0\'){\n        item.style.backgroundColor = \"red\";\n        item.style.color = \"white\";\n        item.cells[5].innerHTML= \"' +
   'Atrasada\";\n    } else if (Math.floor((new Date(dataTD) - new Date()) / ( 1000 * 60 * 60 * 24)) <= 2 && statusTD == \'0\') {\n        item.style.backgroundColor = \"orange\";\n        item.cells[5].i' +
   'nnerHTML= \"Aberta\";\n    } else if (statusTD == \'1\') {\n        item.style.backgroundColor = \"#e0e0e0\";\n        item.cells[5].innerHTML= \"Encerrada\";\n    } else if (Math.floor((new Date(data' +
   'TD) - new Date()) / ( 1000 * 60 * 60 * 24)) >= 2 && statusTD == \'0\') {\n        item.cells[5].innerHTML= \"Aberta\";\n    }\n});\n\n');
}
