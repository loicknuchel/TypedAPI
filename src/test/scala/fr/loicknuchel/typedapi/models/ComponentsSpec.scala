package fr.loicknuchel.typedapi.models

import fr.loicknuchel.typedapi.OpenApiFactory.Formats._
import fr.loicknuchel.typedapi.models.utils.TODO
import fr.loicknuchel.typedapi.testingutils.BaseSpec
import play.api.libs.json.{JsSuccess, Json}

class ComponentsSpec extends BaseSpec {
  describe("Components") {
    it("should parse and serialize") {
      val json = Json.parse(ExternalDocSpec.jsonStr)
      json.validate[ExternalDoc] shouldBe JsSuccess(ExternalDocSpec.value)
      Json.toJson(ExternalDocSpec.value) shouldBe json
    }
  }
}

object ComponentsSpec {
  val jsonStr: String =
    s"""{
       |  "schemas": {
       |    "User": ${SchemaSpec.jsonStr}
       |  }
       |}""".stripMargin
  val value: Components = Components(
    schemas = Some(Schemas("User" -> SchemaSpec.value)),
    responses = Option.empty[TODO],
    parameters = Option.empty[TODO],
    examples = Option.empty[TODO],
    requestBodies = Option.empty[TODO],
    headers = Option.empty[TODO],
    securitySchemes = Option.empty[TODO],
    links = Option.empty[TODO],
    callbacks = Option.empty[TODO],
    extensions = Option.empty[TODO])
}
