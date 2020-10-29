package fr.loicknuchel.typedapi.models

import fr.loicknuchel.typedapi.OpenApiFactory.Formats._
import fr.loicknuchel.typedapi.models.utils.Markdown
import fr.loicknuchel.typedapi.testingutils.BaseSpec
import play.api.libs.json.{JsSuccess, Json}

class ParameterSpec extends BaseSpec {
  describe("Parameter") {
    it("should parse and serialize") {
      val json = Json.parse(ParameterSpec.jsonStr)
      json.validate[Parameter] shouldBe JsSuccess(ParameterSpec.value)
      Json.toJson(ParameterSpec.value) shouldBe json
    }
  }
}

object ParameterSpec {
  val jsonStr: String =
    s"""{
       |  "name": "id",
       |  "in": "path",
       |  "description": "an id",
       |  "required": true,
       |  "schema": ${SchemaSpec.jsonStr}
       |}""".stripMargin
  val value: Parameter = Parameter(
    name = "id",
    in = Parameter.Location.Path,
    deprecated = None,
    description = Some(Markdown("an id")),
    required = Some(true),
    allowEmptyValue = None,
    style = None,
    explode = None,
    allowReserved = None,
    schema = Some(SchemaSpec.value),
    example = None)
}
