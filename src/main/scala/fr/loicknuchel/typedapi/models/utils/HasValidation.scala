package fr.loicknuchel.typedapi.models.utils

import fr.loicknuchel.typedapi.errors.OpenApiError
import fr.loicknuchel.typedapi.models.Schemas

trait HasValidation {
  def getErrors(s: Schemas): List[OpenApiError]
}
