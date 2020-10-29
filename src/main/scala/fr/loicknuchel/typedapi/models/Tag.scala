package fr.loicknuchel.typedapi.models

import fr.loicknuchel.typedapi.models.utils.{Markdown, TODO}

/**
 * @see "https://spec.openapis.org/oas/v3.0.2#tag-object"
 */
final case class Tag(name: String,
                     description: Option[Markdown],
                     externalDocs: Option[ExternalDoc],
                     extensions: Option[TODO])
