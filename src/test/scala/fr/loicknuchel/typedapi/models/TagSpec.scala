package fr.loicknuchel.typedapi.models

import fr.loicknuchel.typedapi.OpenApiFactory.Formats._
import fr.loicknuchel.typedapi.models.utils.{Markdown, TODO}
import fr.loicknuchel.typedapi.testingutils.BaseSpec
import play.api.libs.json.{JsSuccess, Json}

class TagSpec extends BaseSpec {
  describe("Tag") {
    it("should parse and serialize") {
      val json = Json.parse(TagSpec.jsonStr)
      json.validate[Tag] shouldBe JsSuccess(TagSpec.value)
      Json.toJson(TagSpec.value) shouldBe json
    }
  }
}

object TagSpec {
  val jsonStr: String =
    s"""{
      |  "name": "public",
      |  "description": "Public API",
      |  "externalDocs": ${ExternalDocSpec.jsonStr}
      |}""".stripMargin
  val value: Tag = Tag(
    name = "public",
    description = Some(Markdown("Public API")),
    externalDocs = Some(ExternalDocSpec.value),
    extensions = Option.empty[TODO])
}
