const chai = require('chai')
const chaiHttp = require('chai-http')

// LET OP: voeg onder aan app.js toe: module.exports = app
const server = require('../src/server')

chai.should()
chai.use(chaiHttp)

const endpointToTest = '/api/login'
const endpointToActivity = '/api/activities'

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
        console.log(res.body)
        res.body.should.have.property('token').that.is.a('string')
        done()
      })
  })
  it('should return a error when posting a invalid login request', done => {
    done()
  })

})

describe('Activity API GET', () => {
  it('should return an array of Activities', done => {
    chai.request(server.server)
      .post(endpointToTest)
      .set('Content-Type', 'application/json')
      .send({
        email: 'tom@tom.com',
        password: 123456
      })
      .end((err, res) => {
        chai.request(server.server)
        .get(endpointToActivity)
        .set('Content-Type', 'application/json')
        .set('Authorization', 'Bearer '+ res.body.token)
        .end((err, res) => {

          res.should.have.status(200)
          console.log(res.body)
          res.body.should.have.property('result').that.is.a('array')
          done()
        })
      })


  })
})
describe('Activity API GET by id', () => {
  it('should return an array of Activities', done => {
    chai.request(server.server)
      .post(endpointToTest)
      .set('Content-Type', 'application/json')
      .send({
        email: 'tom@tom.com',
        password: 123456
      })
      .end((err, res) => {
        chai.request(server.server)
        .get(endpointToActivity +"/17")
        .set('Content-Type', 'application/json')
        .set('Authorization', 'Bearer '+ res.body.token)
        .end((err, res) => {

          res.should.have.status(200)
          console.log(res.body)
          res.body.should.have.property('result').that.is.a('array')
          done()
        })
      })


  })
})


describe('Activity API PUT', () => {
  it('should return the updated Activity when providing valid input', done => {
    // Write your test here

    done()
  })
})

describe('Activity API DELETE', () => {
  it('should return http 200 when deleting a Activity with existing id', done => {
    // Write your test here
    done()
  })
})
