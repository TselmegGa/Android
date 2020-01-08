const express = require('express')
const router = express.Router()

router.post('login', async (req, res) = > {
  const user = users.find(user => user.name = req.body.name)
  if(user == null){
    return res.status(400).send("Unknown user")
  }
  try {
    res.send("success")
  }catch{
    res.status(500).send()
  }
})

module.exports = router
