package fr.loicknuchel.typedapi.models

import fr.loicknuchel.typedapi.OpenApiFactory.Formats._
import fr.loicknuchel.typedapi.models.utils.Markdown
import fr.loicknuchel.typedapi.testingutils.BaseSpec
import play.api.libs.json.{JsSuccess, Json}

class PathItemSpec extends BaseSpec {
  describe("PathItem") {
    it("should parse and serialize") {
      val json = Json.parse(PathItemSpec.jsonStr)
      json.validate[PathItem] shouldBe JsSuccess(PathItemSpec.value)
      Json.toJson(PathItemSpec.value) shouldBe json
    }
  }
}

object PathItemSpec {
  val jsonStr: String =
    """{
      |  "summary": "s",
      |  "description": "d",
      |  "get": {
      |    "responses": {}
      |  }
      |}""".stripMargin
  val value: PathItem = PathItem(
    summary = Some("s"),
    description = Some(Markdown("d")),
    parameters = None,
    servers = None,
    get = Some(PathItem.Operation(None, None, None, None, None, None, None, None, Map(), None, None, None, None)),
    put = None,
    post = None,
    delete = None,
    options = None,
    head = None,
    patch = None,
    trace = None,
    extensions = None)
}
