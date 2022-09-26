package breweries
import  io.gatling.http.Predef._
import  io.gatling.core.Predef._

class Openbreweries extends  Simulation{

  val httpconf = http.baseUrl("https://api.openbrewerydb.org")
  val feeder = csv("C:/Users/daoud/IdeaProjects/Gatling-maven/src/test/resources/boodies/data.csv").circular


  val scn = scenario("Test All breweries")
    .feed(feeder)
    .exec(http("get all breweries").get("/breweries").check(status.is(200),substring("micro").exists))
    .pause(5)
    .exec(http("get single breweries").get("/breweries/#{name}").check(status.is(200),bodyString.saveAs("Reponsebody")))
    .exec { session =>
          print(session("Reponsebody").as[String])
           session
    }

  setUp(scn.inject(atOnceUsers(1))).protocols(httpconf)

}
