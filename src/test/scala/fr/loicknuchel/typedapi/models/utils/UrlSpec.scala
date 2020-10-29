package fr.loicknuchel.typedapi.models.utils

import fr.loicknuchel.typedapi.errors.OpenApiError
import fr.loicknuchel.typedapi.testingutils.BaseSpec

class UrlSpec extends BaseSpec {
  describe("Url") {
    it("should validate correct urls") {
      Url.from("https://gospeak.io") shouldBe Right(Url("https://gospeak.io"))
      Url.from("http://gospeak.io/toto.json?q=test#h2") shouldBe Right(Url("http://gospeak.io/toto.json?q=test#h2"))
    }
    it("should fail on invalid values") {
      Url.from("abc") shouldBe Left(OpenApiError.badFormat("abc", "Url", "https://..."))
    }
  }
}
