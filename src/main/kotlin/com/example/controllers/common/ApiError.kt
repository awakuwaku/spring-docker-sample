package controllers.common

import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable

/**
 * APIエラー情報.
 *
 * @property message エラーメッセージ
 * @property target エラー発生箇所
 * @property details エラー詳細情報
 */
class ApiError(
  val message: String? = null,

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  val target: String? = null,

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  val details: List<ApiError> = mutableListOf()
) : Serializable