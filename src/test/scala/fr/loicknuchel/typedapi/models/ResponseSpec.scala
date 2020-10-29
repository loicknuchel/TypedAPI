package fr.loicknuchel.typedapi.models

import fr.loicknuchel.typedapi.OpenApiFactory.Formats._
import fr.loicknuchel.typedapi.models.utils.{Markdown, TODO}
import fr.loicknuchel.typedapi.testingutils.BaseSpec
import play.api.libs.json.{JsSuccess, Json}

class ResponseSpec extends BaseSpec {
  describe("Response") {
    it("should parse and serialize") {
      val json = Json.parse(ResponseSpec.jsonStr)
      json.validate[Response] shouldBe JsSuccess(ResponseSpec.value)
      Json.toJson(ResponseSpec.value) shouldBe json
    }
  }
}

object ResponseSpec {
  val jsonStr: String =
    s"""{
       |  "description": "desc",
       |  "headers": {
       |    "custom": ${HeaderSpec.jsonStr}
       |  },
       |  "content": {
       |    "application/json": ${MediaTypeSpec.jsonStr}
       |  },
       |  "links": {
       |    "ref": ${LinkSpec.jsonStr}
       |  }
       |}""".stripMargin
  val value: Response = Response(
    description = Markdown("desc"),
    headers = Some(Map("custom" -> HeaderSpec.value)),
    content = Some(Map("application/json" -> MediaTypeSpec.value)),
    links = Some(Map("ref" -> LinkSpec.value)),
    extensions = Option.empty[TODO])
}
