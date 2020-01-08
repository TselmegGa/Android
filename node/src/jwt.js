const jwt = require('jsonwebtoken');
const moment = require('moment')
const settings = require('./config/config')
const privateKey = settings.secretkey


var sign = (data) => {
  // hier komt in het request een movie binnen.
  return token = jwt.sign(data, privateKey)

}
var verify = (token) => {
  // hier komt in het request een movie binnen.
  return decoded = jwt.verify(token, privateKey)

}
