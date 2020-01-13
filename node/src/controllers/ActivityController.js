const conn = require('../database/connection')
const sql = require('mssql')

var getAll = (req, res) => {
  conn.then(pool =>{
   return pool.request()
       .query('SELECT * from dbo.Activity')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
   res.status(err.code).json(err)
 })
}

var get = (req, res, next) => {
  const id = req.params.id
  conn.then(pool =>{
   return pool.request()
      .input('input', sql.Int, id)
      .query('SELECT * from dbo.Activity where id = @input')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
   res.status(err.code).json(err)
 })
}

var create = (req, res, next) => {
  conn.then(pool =>{
   return pool.request()
      .input('name', req.body.name)
      .input('description', req.body.description)
      .input('starttime', req.body.starttime)
      .input('endtime', req.body.endtime)
      .input('max', sql.Int, req.body.max)
      .input('admin_id', sql.Int, req.user.id)
      .query('insert into dbo.Activity values (@name, @description, @starttime, @endtime, @max, @admin_id)')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
   res.status(err.code).json(err)
 })

}
var remove = (req, res, next) => {
  const id = req.params.id
  conn.then(pool =>{
   return pool.request()
      .input('input', sql.Int, id)
      .query('delete from dbo.Activity where id = @input')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
  res.status(err.code).json(err)
 })

}
var update = (req, res, next) => {
  const id = req.params.id
  conn.then(pool =>{
   return pool.request()
      .input('name', req.body.name)
      .input('description', req.body.description)
      .input('starttime', req.body.starttime)
      .input('endtime', req.body.endtime)
      .input('max', sql.Int, req.body.max)
      .input('id', sql.Int, id)
      .query('update dbo.Activity set name = @name, description = @description, starttime = @starttime, endtime = @endtime, max = @max where id = @id')
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
remove: remove,
update: update
}
