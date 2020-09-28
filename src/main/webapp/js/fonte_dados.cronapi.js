(function() {
 'use strict';
 
 var getDatasource = function(ds) {
 if (typeof ds == 'string') {
 return window[ds];
 } else {
 return ds;
 }
 };
 
 this.cronapi = this.cronapi || {};
 
 /**
 * @categoryName Minhas Funções
 */
 this.cronapi.myfunctions = this.cronapi.myfunctions || {};
 
 /**
 * @type function
 * @name Limpar registros temporarios
 * @nameTags fieldNameFromScreen
 * @description Limpar registros temporarios
 * @param {ObjectType.STRING} datasource
 * @multilayer true
 */
 this.cronapi.myfunctions.clearTempRows = function(/** @type {ObjectType.OBJECT} @blockType datasource_from_screen*/ datasource) {
 let ds = getDatasource(datasource); 
 ds.data.forEach(d => { if (d.__status === "inserted") ds.removeSilent(d) })
 };
 
 
 
 
}).bind(window)();