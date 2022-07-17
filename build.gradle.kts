import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.7.1"
  id("io.spring.dependency-management") version "1.0.12.RELEASE"
  kotlin("jvm") version "1.7.10"
  kotlin("plugin.spring") version "1.7.10"
  id("org.asciidoctor.jvm.convert") version "3.3.2"
  id("org.jetbrains.dokka") version "1.7.10"
  id("war")
  id("com.github.ben-manes.versions") version "0.42.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
  mavenCentral()
}

dependencies {
  // Kotlin
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  // Util
  implementation("com.jayway.jsonpath:json-path:2.7.0")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
  // Spring Boot
  implementation("org.springframework.boot:spring-boot-starter-web")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  implementation("org.springframework.boot:spring-boot-starter-aop")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  // Spring Boot Test
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.security:spring-security-test")
  // Spring REST Docs
  testImplementation("org.springframework.restdocs:spring-restdocs-core:2.0.6.RELEASE")
  testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc:2.0.6.RELEASE")
}

//////////////////////////////////////
// JUnit Test Target
//////////////////////////////////////
tasks.withType<Test> {
  useJUnitPlatform()
  exclude("**/*$*")
}

//////////////////////////////////////
// Kotlin Compile
//////////////////////////////////////
tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "17"
  }
}

//////////////////////////////////////
// Asciidoctor
//////////////////////////////////////
val snippetsDir by extra { file("$buildDir/generated-snippets") }
tasks {
  test {
    outputs.dir(snippetsDir)
  }

  asciidoctor {
    inputs.dir(snippetsDir)
    sourceDir("src/main/asciidoc")
    dependsOn(test)
  }
}

//////////////////////////////////////
// Generate Jar
//////////////////////////////////////
tasks.withType<Jar> {
  enabled = true
}

//////////////////////////////////////
// Generate War
//////////////////////////////////////
tasks.withType<War> {
  enabled = true
}
