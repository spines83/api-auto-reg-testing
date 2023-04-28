
plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("java")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

val springdocVersion = "1.6.9"
extra["snakeyaml.version"] = "1.32"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testcontainers:postgresql:1.17.3")
    runtimeOnly("org.postgresql:postgresql")
    // Spring
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("org.springdoc:springdoc-openapi-webmvc-core:${springdocVersion}")

    // Infrastructure
    implementation("org.flywaydb:flyway-core")


    // Test
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named<Jar>("jar") {
    enabled = false
}
