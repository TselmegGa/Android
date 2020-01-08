const conn = require('../database/connection')
const sql = require('mssql')
var getAll = (req, res) => {
  conn.then(pool =>{
   return pool.request()
       .query('SELECT * from dbo.Gebruiker')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
   console.log(err)
 })

}

var get = (req, res, next) => {

  const id = req.params.movieId
  conn.then(pool =>{
   return pool.request()
      .input('input', sql.Int, id)
      .query('SELECT * from dbo.Boek where ISBN = @input')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
   console.log(err)
 })
}

var create = (req, res, next) => {
  // hier komt in het request een movie binnen.
  const movie = req.body

}
var remove = (req, res, next) => {
  // hier komt in het request een movie binnen.
  const movie = req.body

}
var update = (req, res, next) => {
  // hier komt in het request een movie binnen.
  const movie = req.body

}
module.exports = {
getAll: getAll,
get: get,
create: create,
remove: remove,
update: update
}
