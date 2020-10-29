package fr.loicknuchel.typedapi.models

import fr.loicknuchel.typedapi.OpenApiFactory.Formats._
import fr.loicknuchel.typedapi.models.utils.Markdown
import fr.loicknuchel.typedapi.testingutils.BaseSpec
import play.api.libs.json.{JsSuccess, Json}

class HeaderSpec extends BaseSpec {
  describe("Header") {
    it("should parse and serialize") {
      val json = Json.parse(HeaderSpec.jsonStr)
      json.validate[Header] shouldBe JsSuccess(HeaderSpec.value)
      Json.toJson(HeaderSpec.value) shouldBe json
    }
  }
}

object HeaderSpec {
  val jsonStr: String =
    s"""{
       |  "description": "Header desc",
       |  "schema": ${SchemaSpec.jsonStr}
       |}""".stripMargin
  val value: Header = Header(
    description = Some(Markdown("Header desc")),
    schema = Some(SchemaSpec.value))
}
