const express = require('express')
const router = express.Router()
const auth = require('../controllers/AuthController')

router.post('/login', auth.loginUser)
router.post('/register', auth.registerUser)

module.exports = router
