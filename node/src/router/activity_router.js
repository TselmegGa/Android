const express = require('express')
const router = express.Router()
const ActivityController = require('../controllers/ActivityController')
const ParticipantController = require('../controllers/ParticipantController')

// Lijst van activities
router.post('/', ActivityController.create)
router.get('/', ActivityController.getAll)
router.get('/:id', ActivityController.get)
router.put('/:id', ActivityController.update)
router.delete('/:id', ActivityController.getActivityById)


// Lijst van participants
router.get('/:id/participants', ParticipantController.getActivityById)
router.post('/:id/participants', ParticipantController.getActivityById)
router.get('/:id/participants/:id', ParticipantController.getActivityById)
router.delete('/:id/participants/:id', ParticipantController.getActivityById)

module.exports = router
