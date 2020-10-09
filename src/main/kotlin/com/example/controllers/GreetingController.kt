package com.example.controllers

import controllers.common.ApiError
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * Greeting API Controller.
 *
 */
@RestController
@RequestMapping("greeting")
class GreetingController {

  /**
   * Greeting API GETメソッド処理.
   *
   * @param criteria リクエスト情報
   * @return レスポンス情報
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  fun greeting(@Valid criteria: RequestCriteria): Greeting {
    val hour: Int = criteria.hour
    return if (hour in 0..4) {
      Greeting("good night")
    } else if (hour in 5..15) {
      Greeting("good morning")
    } else if (16 <= hour) {
      Greeting("good night")
    } else {
      throw IllegalArgumentException("bean validation doesn't work")
    }
  }

  /**
   * Greeting API エラーハンドリング処理.
   *
   * @param e リクエストエラー情報
   * @return APIエラー情報
   */
  @ExceptionHandler(BindException::class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  fun handleBindingException(e: BindException): ApiError {
    val apiErrorDetails: List<ApiError> = e.bindingResult.fieldErrors.map {
      ApiError(
        it.defaultMessage,
        it.field
      )
    }
    return ApiError("request is invalid", "", apiErrorDetails)
  }
}