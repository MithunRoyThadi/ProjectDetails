var mysql = require("mysql");

var pool = mysql.createPool({
        connectionLimit : 100,
        host     : 'sql228.main-hosting.eu.',
        //port     :  2200,
        user     : 'u364497383_lstt',
        password : 'Lst@POC',
        database : 'u364497383_poc'
    });

exports.getConnection = function(callback) {
  pool.getConnection(function(err, conn) {
    if(err) {
      return callback(err);
    }
    console.log("connection success");
    callback(err, conn);
  });
};