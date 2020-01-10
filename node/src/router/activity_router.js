const express = require('express')
const router = express.Router()
const ActivityController = require('../controllers/ActivityController')
const ParticipantController = require('../controllers/ParticipantController')
const auth = require('../controllers/AuthController')

// Lijst van activities
router.post('/', auth.authenticate, ActivityController.create)
router.get('/', auth.authenticate, ActivityController.getAll)
router.get('/:id', auth.authenticate, ActivityController.get)
router.put('/:id', auth.authenticate, ActivityController.update)
router.delete('/:id', auth.authenticate, ActivityController.remove)


// Lijst van participants
router.get('/:id/participants', auth.authenticate, ParticipantController.getAll)
router.post('/:id/participants', auth.authenticate, ParticipantController.create)
router.get('/:id/participants/:user_id', auth.authenticate, ParticipantController.get)
router.delete('/:id/participants/:user_id', auth.authenticate, ParticipantController.remove)

module.exports = router
