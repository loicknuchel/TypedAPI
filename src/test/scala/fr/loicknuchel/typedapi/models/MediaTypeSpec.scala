package fr.loicknuchel.typedapi.models

import fr.loicknuchel.typedapi.OpenApiFactory.Formats._
import fr.loicknuchel.typedapi.models.utils.TODO
import fr.loicknuchel.typedapi.testingutils.BaseSpec
import play.api.libs.json.{JsSuccess, Json}

class MediaTypeSpec extends BaseSpec {
  describe("MediaType") {
    it("should parse and serialize") {
      val json = Json.parse(MediaTypeSpec.jsonStr)
      json.validate[MediaType] shouldBe JsSuccess(MediaTypeSpec.value)
      Json.toJson(MediaTypeSpec.value) shouldBe json
    }
  }
}

object MediaTypeSpec {
  val jsonStr: String =
    s"""{
       |  "schema": ${SchemaSpec.jsonStr}
       |}""".stripMargin
  val value: MediaType = MediaType(
    schema = Some(SchemaSpec.value),
    example = None,
    examples = Option.empty[Map[String, TODO]],
    encoding = Option.empty[TODO],
    extensions = Option.empty[TODO])
}
