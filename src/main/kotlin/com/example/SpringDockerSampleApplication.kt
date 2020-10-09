package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Spring Boot起動アプリケーション.
 */
@SpringBootApplication
class SpringDockerSampleApplication

/**
 * Spring Boot起動アプリケーション メインファンクション.
 *
 * @param args 実行時引数
 */
fun main(args: Array<String>) {
  runApplication<SpringDockerSampleApplication>(*args)
}
