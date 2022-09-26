package org.example

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://www.gstatic.com")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptEncodingHeader("gzip, deflate")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")

	val headers_0 = Map(
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7",
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache",
		"Proxy-Connection" -> "keep-alive")

	val headers_3 = Map(
		"A-IM" -> "x-bm,gzip",
		"Accept-Encoding" -> "gzip, deflate",
		"If-None-Match" -> "Cl848Z2AB0eeYQZfjKMDHYYLqVxqHx6FamabXWP7WaDPzoCiVyBqpYDpCP7U92wmPy1zJyveyBDR/pYQekstfZMzePwb1163yCsZm8FC5ARzxTVrSvEV9xNn5JF8vtbjcxABGiBMYfNdOnOuece4zFFVV9vMiDLRVSITJMHSaa1asptjCSAB",
		"Proxy-Connection" -> "keep-alive")

	val headers_5 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
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

	val headers_6 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Accept-Language" -> "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7",
		"Sec-Fetch-Dest" -> "style",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """"Google Chrome";v="105", "Not)A;Brand";v="8", "Chromium";v="105"""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> """"Windows"""")

	val headers_8 = Map(
		"Accept" -> "*/*",
		"Accept-Language" -> "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7",
		"Sec-Fetch-Dest" -> "script",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """"Google Chrome";v="105", "Not)A;Brand";v="8", "Chromium";v="105"""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> """"Windows"""")

    val uri1 = "https://www.rahulshettyacademy.com/dropdownsPractise"
    val uri2 = "http://clientservices.googleapis.com/chrome-variations/seed"

	val scn = scenario("RecordedSimulation")
		// login
		.exec(http("request_0")
			.get("/generate_204")
			.headers(headers_0))
		.pause(120)
		.exec(http("request_1")
			.get("/generate_204")
			.headers(headers_0))
		.pause(121)
		.exec(http("request_2")
			.get("/generate_204")
			.headers(headers_0))
		.pause(184)
		.exec(http("request_3")
			.get(uri2 + "?osname=win&channel=stable&milestone=105")
			.headers(headers_3))
		.pause(111)
		.exec(http("request_4")
			.get("/generate_204")
			.headers(headers_0))
		.pause(5)
		.exec(http("request_5")
			.get(uri1 + "/")
			.headers(headers_5)
			.resources(http("request_6")
			.get(uri1 + "/css/2.css?version=09012018120022%22")
			.headers(headers_6),
            http("request_7")
			.get(uri1 + "/css/1.css?version=09012018120022%22")
			.headers(headers_6),
            http("request_8")
			.get(uri1 + "/WebResourcef130.js?d=zQoiTf-a8dSjZDmxKIl0UM41B5v0EM7-DrQgBMD5yZmynAAXItYgQNGgEx03DCllzJomGJ3lqzngFeeHhOyO7_qFb541&t=636776725224055265")
			.headers(headers_8)
			.check(status.is(404)),
            http("request_9")
			.get(uri1 + "/ScriptResource7b6d.js?d=UDtsLiXigH4W0KzHLhG4o8aysYpunNHqYqvU58O_8GrGhtLTJdxatMINghqyyN3Aayb95QPmtnmWE9plvB--2SJ-xGq2IJqxEk_eyoSyds6ruxkze9tl3x_IXQjkzDxu_Rxf3Vfy45-zIQdp84jZwz01eC81&t=ffffffff999c3159")
			.headers(headers_8)
			.check(status.is(404)),
            http("request_10")
			.get(uri1 + "/ScriptResourcec9df.axd?d=6gODQGsgkUWZ3DtLHHMJC65iRKi8flD6IBsu_pkENZg10Hj266qpfHE-6ORXlcfYKLpsK9pJJRPTkTJEqcb5SWDgB3NNr9mWVxDxWT7bpn29XV2x3srY5XsWR5BXaXC41X6Md00XRQUiM6-glrtsM-l2UZcVlALlhY1PkSQSRRM2jSdh0&t=3169528")
			.headers(headers_8)
			.check(status.is(404)),
            http("request_11")
			.get(uri1 + "/ScriptResource8590.js?d=0CPkAvnFFwn6lo9t0Mqh6EFAp1y8gaFMqD4WckgWU4VSkAg28dvWzqrHtt7gPPoKbICQILGDQESAxC0V_6igGIcUMWpyCVahfBdYfEPWoNlkvQOat3DmB2HGCaIY-AP2NhyFrvI_DSPaKuTkUSiOw_JGnbiUtpLY18rt98VHml83VGJg0&t=ffffffff999c3159")
			.headers(headers_8)
			.check(status.is(404)),
            http("request_12")
			.get(uri1 + "/ScriptResourceb384.axd?d=e_mWhnFBFzx34IP76yR15wTe5dWsTfJhsPedYDDCNMuFgtXwL1ipB1WZTrYVOiWuzGgWKVY43y5ivZN3R_17e3Ia4c_YjJf3OOzMrq0GWaVwR3n8sCbF8Wt7-rJ4oMKvDPF372Zny0QywYAOLXFJus-cK341&t=3169528")
			.headers(headers_8)
			.check(status.is(404)),
            http("request_13")
			.get(uri1 + "/ScriptResource5e80.axd?d=ySOlp7wgzI71wEG9W9xy5TmwZjC-v3lVoh7S2CKJcNtdMIECKY-B5ObjAsL6jcOcDxkLxXncxd0yL32OSOrLkm1N4iOYKuqVeXmXL9sjA0WwkiBYGobb10DDl_pLWnnxWLwq4_idCn21iK-Ba00sBDokXhw1&t=3169528")
			.headers(headers_8)
			.check(status.is(404)),
            http("request_14")
			.get(uri1 + "/js/1.js?version=09012018120022")
			.headers(headers_8),
            http("request_15")
			.get(uri1 + "/js/QAClick/8.js?version=09012018120022")
			.headers(headers_8),
            http("request_16")
			.get(uri1 + "/js/4.js?version=09012018120022")
			.headers(headers_8),
            http("request_17")
			.get(uri1 + "/js/2.js?version=09012018120022")
			.headers(headers_8),
            http("request_18")
			.get(uri1 + "/js/3.js?version=09012018120022")
			.headers(headers_8)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}