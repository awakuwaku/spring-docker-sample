# spring-docker-sample
Spring Boot Kotlin の Docker Build Sample


# 前提
-   JDK
    - [OpenJDK (11.0.x)](http://openjdk.java.net/)
-   Kotlin
    - [Kotlin (1.5.0)](https://kotlinlang.org/)
-   Build Tool
    - [Gradle (7.1)](https://gradle.org/)
-   Framework
    - [Spring Boot (2.5.1.RELEASE)](https://spring.io/projects/spring-boot)
    - [Spring REST Docs (2.0.5.RELEASE)](https://spring.io/projects/spring-restdocs)
-   IDE
    - [Eclipse (2021‑03)](http://www.eclipse.org/home/index.php) + [Spring Tools](https://marketplace.eclipse.org/content/spring-tool-suite-sts-eclipse)
    - [IntelliJ IDEA CE (2021.1)](https://www.jetbrains.com/ja-jp/idea/download/)


# 利用方法
以下コマンドにて実行する。
  ```shell
  ./gradlew clean bootJar && \
  docker-compose build && \
  docker-compose up -d --force-recreate
  ```

