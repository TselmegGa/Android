const conn = require('../database/connection')
const jwt = require('jsonwebtoken')
const settings = require('../config/config')
const sql = require('mssql')
const privateKey = settings.secretkey

var loginUser = (req, res, next) => {
  conn.then(pool =>{
    return pool.request()
    .input('input', req.body.email)
    .query('SELECT id, first_name, last_name, email, location from dbo.[User] where email = @input')
  }).then(result =>{
    let user = result.recordset[0].email == req.body.email ? result.recordset[0] : null
    if(user == null){
      return res.status(400).send("Unknown user")
    }
    try {
      if(req.body.password == result.recordset[0].password){
        let token = jwt.sign(user, privateKey, {expiresIn: "60m"})
        res.status(200).json({token: token})
      }
      }catch{
        res.status(500).send()
      }
 }).catch(err =>{
   res.status(err.code).json(err)
 })
}

var authenticate = (req, res, next) => {
  let authHeader = req.headers['authorization']
  let token = authHeader && authHeader.split(' ')[1]
  if(token == null) return res.status(401).send()

  jwt.verify(token, privateKey, (err, user) =>{
    if(err) return res.status(403).send()
    req.user = user
    next()
  })
}

var registerUser = (req, res, next) => {
  conn.then(pool =>{
   return pool.request()
      .input('firstname', req.body.firstname)
      .input('lastname', req.body.lastname)
      .input('email', req.body.email)
      .input('password', req.body.password)
      .input('location', req.body.location)
      .query('insert into dbo.[User] values (@firstname, @lastname, @email, @password, @location)')
 }).then(result =>{
   res.status(200).json({ result:result.recordset})
 }).catch(err =>{
   res.status(err.code).json(err)
 })

}
module.exports = {
loginUser: loginUser,
authenticate: authenticate,
registerUser: registerUser
}
