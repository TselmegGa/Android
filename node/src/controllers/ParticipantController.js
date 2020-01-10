const conn = require('../database/connection')
const sql = require('mssql')

var getAll = (req, res) => {
  conn.then(pool =>{
   return pool.request()
   .input('id', sql.Int, req.params.id)
   .query('SELECT u.id, first_name, last_name, email, location from dbo.[User] as u INNER JOIN user_activity_junction as j ON u.id = j.user_id INNER JOIN Activity as a ON a.id = j.activity_id WHERE a.id = @id')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
   res.status(err.code).json(err)
 })

}

var get = (req, res, next) => {
  const id = req.params.user_id
  conn.then(pool =>{
   return pool.request()
      .input('input', sql.Int, id)
      .query('SELECT id, first_name, last_name, email, location from dbo.[User] where id = @input')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
   res.status(err.code).json(err)
 })
}
var create = (req, res, next) => {
  conn.then(pool =>{
   return pool.request()
      .input('user_id', req.body.id)
      .input('activity_id', req.params.id)
      .query('insert into dbo.[user_activity_junction] values (@user_id, @activity_id)')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
   res.status(err.code).json(err)
 })

}
var remove = (req, res, next) => {
  const activity_id = req.params.id
  const user_id = req.params.user_id
  conn.then(pool =>{
   return pool.request()
      .input('activity_id', sql.Int, activity_id)
      .input('user_id', sql.Int, user_id)
      .query('delete from dbo.[user_activity_junction] where user_id = @user_id AND activity_id = @activity_id')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
  res.status(err.code).json(err)
 })

}
module.exports = {
getAll: getAll,
get: get,
create: create,
remove: remove
}
