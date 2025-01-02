package com.demo.task;
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class Application2Gatling extends Simulation {

  // HTTP configuration for both endpoints
  val httpProtocol = http
    .baseUrl("http://localhost:8089")  // This should point to Application 2
    .acceptHeader("application/json")
    .userAgentHeader("Mozilla/5.0")

  // Scenario for simulating calls to both endpoints (RestTemplate and FeignClient)
  val scn = scenario("Simulate User Endpoints")
    .exec(
      // Simulate a call to the RestTemplate endpoint
      http("Get User By ID via RestTemplate")
        .get("/api/user/getUserByIdRestTemplate/1")  // Endpoint of Application 2
        .check(status.is(200))
    )
    .pause(1)  // Pause for 1 second between requests
    .exec(
      // Simulate a call to the FeignClient endpoint
      http("Get User By ID via FeignClient")
        .get("/api/user/getUserByIdFeign/1")  // Endpoint of Application 2
        .check(status.is(200))
    )
    .pause(1)

  // Setting up the load simulation
  setUp(
    scn.inject(
      atOnceUsers(5),  
      rampUsers(20) during (30 seconds)  
    ).protocols(httpProtocol)
  )
}
