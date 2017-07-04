package tests;

import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import io.gatling.core.Predef._

import scala.concurrent.duration._

class RestSimulation extends Simulation {

    val testTimeSecs = 90 seconds
    val rampUpTimeSecs = 60 seconds
    val noOfUsers = 1000
    val baseURL : String = "http://localhost:8080"

    val scn = scenario("RestSimulation")
          .exec(
              http("/location")
                .get("")
                .check(status.is(200))
          )
    val httpConf = http.baseURL(baseURL)

    setUp(scn.inject(rampUsers(noOfUsers) over rampUpTimeSecs).protocols(httpConf))
}