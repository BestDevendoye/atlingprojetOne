package org.example

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class OpensourceOrange extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources()
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")

	val headers_0 = Map(
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7",
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache",
		"Proxy-Connection" -> "keep-alive")

	val headers_1 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7",
		"Cache-Control" -> "max-age=0",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "none",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Google Chrome";v="105", "Not)A;Brand";v="8", "Chromium";v="105"""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> """"Windows"""")

	val headers_2 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Google Chrome";v="105", "Not)A;Brand";v="8", "Chromium";v="105"""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> """"Windows"""")

	val headers_4 = Map(
		"Accept" -> "*/*",
		"If-Modified-Since" -> "Tue, 16 Mar 2021 07:33:42 GMT",
		"If-None-Match" -> """"08f5ab0361ad71:0"""",
		"Proxy-Connection" -> "Keep-Alive",
		"User-Agent" -> "Microsoft-CryptoAPI/10.0")

	val headers_5 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7",
		"Cache-Control" -> "max-age=0",
		"Origin" -> "https://computer-database.gatling.io",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Google Chrome";v="105", "Not)A;Brand";v="8", "Chromium";v="105"""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> """"Windows"""")



		// login
	val search= exec(http("login")
			.get("/computers")
			.headers(headers_1))
		.pause(3)
		// search
		.exec(http("search")
			.get("/computers?f=ACE")
			.headers(headers_2))
		.pause(3)
		.exec(http("searchCuomputers")
			.get("/computers/381")
			.headers(headers_2))
		.pause(3)
		// EDIT
	val edit = exec(http("edit")
			.post("/computers/381")
			.headers(headers_5)
			.formParam("name", "ACE")
			.formParam("introduced", "2002-01-01")
			.formParam("discontinued", "2022-12-12")
			.formParam("company", "5"))
  val admin = scenario("Admin").exec(search,edit)
	val users = scenario("Users").exec(edit)

	 setUp(admin.inject(rampUsers(10).during(10)),
		 users.inject(rampUsers(4).during(10))).protocols(httpProtocol)


}