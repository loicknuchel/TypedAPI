package fr.loicknuchel.typedapi.models

import fr.loicknuchel.typedapi.OpenApiUtils
import fr.loicknuchel.typedapi.errors.OpenApiError
import fr.loicknuchel.typedapi.models.utils.{HasValidation, Js, TODO}

/**
 * @see "https://spec.openapis.org/oas/v3.0.2#media-type-object"
 */
final case class MediaType(schema: Option[Schema],
                           example: Option[Js],
                           examples: Option[Map[String, TODO]],
                           encoding: Option[TODO],
                           extensions: Option[TODO]) extends HasValidation {
  def getErrors(s: Schemas): List[OpenApiError] = {
    OpenApiUtils.validate(schema, example, s)
  }
}
