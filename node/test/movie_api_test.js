const chai = require('chai')
const chaiHttp = require('chai-http')

// LET OP: voeg onder aan app.js toe: module.exports = app
const server = require('../src/server')

chai.should()
chai.use(chaiHttp)

const endpointToTest = '/movies'

describe('Movies API POST', () => {
  it('should return a valid id when posting a valid object', done => {
    chai
      .request(server)
      .post(endpointToTest)
      .send({
        title: 'finding nemo',
        description: 'beschrijving',
        year: 2004,
        actors: []
      })
      .end((err, res) => {
        res.should.have.status(200)
        res.body.should.be.a('object')
        res.body.result.should.have.property('title').that.is.a('string')
        res.body.result.should.have.property('description').equals('beschrijving')
        res.body.result.should.have.property('year').equals(2004)
        res.body.result.should.have.property('actors').that.is.an('array')
        res.body.result.should.not.have.property('password')
        done()
      })
  })

  it('should throw an error when the database is full', done => {
    done()
  })
})

describe('Movie API GET', () => {
  it('should return an array of Movies', done => {
    // Write your test here
    done()
  })
})

describe('Movie API PUT', () => {
  it('should return the updated Movie when providing valid input', done => {
    // Write your test here
    done()
  })
})

describe('Movie API DELETE', () => {
  it('should return http 200 when deleting a Movie with existing id', done => {
    // Write your test here
    done()
  })
})
