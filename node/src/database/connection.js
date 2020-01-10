const sql = require('mssql')
const config = {
  user: 'actgrp7',
  password: 'actgrp7',
  server: 'aei-sql.avans.nl',
  database: 'PartyDB7',
  port: 1453
}
const conn = sql.connect(config)

module.exports = conn
