const express = require('express')
const router = express.Router()
const ActivityController = require('../controllers/ActivityController')
const ParticipantController = require('../controllers/ParticipantController')


// Lijst van activities
router.post('/', ActivityController.create)
router.get('/', ActivityController.getAll)
router.get('/:id', ActivityController.get)
router.put('/:id', ActivityController.update)
router.delete('/:id', ActivityController.remove)


// Lijst van participants
router.get('/:id/participants', ParticipantController.getAll)
router.post('/:id/participants', ParticipantController.create)
router.get('/:id/participants/:user_id', ParticipantController.get)
router.delete('/:id/participants/:user_id', ParticipantController.remove)

module.exports = router
