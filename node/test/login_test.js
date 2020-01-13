const chai = require('chai')
const chaiHttp = require('chai-http')

// LET OP: voeg onder aan app.js toe: module.exports = app
const server = require('../src/server')

chai.should()
chai.use(chaiHttp)

const endpointToTest = '/api/login'

describe('Login API POST', () => {
  it('should return a valid token when posting a valid login request', done => {
    chai.request(server.server)
      .post(endpointToTest)
      .set('Content-Type', 'application/json')
      .send({
        email: 'tom@tom.com',
        password: 123456
      })
      .end((err, res) => {

        res.should.have.status(200)
        res.body.should.have.property('token').that.is.a('string')
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
