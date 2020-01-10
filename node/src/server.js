const express = require('express')
const activityRouter = require('./router/activity_router')



const app = express()
var port = process.env.PORT || 3000
app.use(express.json())
app.use('/api/activities', activityRouter)





app.listen(port, function(){
  console.log('server listening on port ' + port);
})
.on('error', function(err){
  console.log('error' + err.message)
})
app.all('*', (req,res,next)=>{
  console.log('Generating everything')
  errorObject = {
    error: "page not found",
    code: 404
  }
  next(errorObject)
})
app.use(function(err,req,res,next){
  console.error(err.stack)
  res.status(err.code).json(err)
})
