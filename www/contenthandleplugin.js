var exec = require('cordova/exec');
var contentHandlePlugin = {
    getWebUrl:function(success,fail) {
    return cordova.exec(success,fail,"ContentHandlePlugin","getShareWebUrl",[]);
   },
   isAppActiveWithShareIntent:function(success,fail) {
     cordova.exec(success,fail,"ContentHandlePlugin","isShareIntent",[]);
  }
};
module.exports = contentHandlePlugin;