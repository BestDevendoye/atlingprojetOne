package computers

import io.gatling.http.Predef._
import  io.gatling.core.Predef._


class Datafeeder extends  Simulation{


  val feeder = csv("./src/test/resources/boodies/data.csv")

  val scn = scenario("Feeder csv")
      feed(feeder)
        .exec { session => println("name :"+session("name").as[String])
                           println("job :"+session("job").as[String])
             session
              }

  setUp(scn.inject(atOnceUsers(1)))
}
