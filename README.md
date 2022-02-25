# spring-docker-sample
Spring Boot Kotlin の Docker Build Sample


# 前提
-   JDK
    - [Eclipse Temurin (17.0.x)](https://adoptium.net/)
-   Kotlin
    - [Kotlin (1.6.10)](https://kotlinlang.org/)
-   Build Tool
    - [Gradle (7.4)](https://gradle.org/)
-   Framework
    - [Spring Boot (2.6.4.RELEASE)](https://spring.io/projects/spring-boot)
    - [Spring REST Docs (2.0.6.RELEASE)](https://spring.io/projects/spring-restdocs)
-   IDE
    - [Eclipse (2021‑03)](http://www.eclipse.org/home/index.php) + [Spring Tools](https://marketplace.eclipse.org/content/spring-tool-suite-sts-eclipse)
    - [IntelliJ IDEA CE (2021.3)](https://www.jetbrains.com/ja-jp/idea/download/)


# 利用方法
以下コマンドにて実行する。
  ```shell
  ./gradlew clean bootJar && \
  docker-compose build && \
  docker-compose up -d --force-recreate
  ```

