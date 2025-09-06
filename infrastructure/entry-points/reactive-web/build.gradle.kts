plugins {
    id("java-library")
    kotlin("jvm")
    id("io.spring.dependency-management")
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    implementation(project(":domain:model"))
    implementation(project(":domain:usecase"))
    implementation(project(":infrastructure:driven-adapters"))

    implementation("org.springframework.boot:spring-boot-starter-webflux:3.3.1")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.3.1")
    implementation("io.projectreactor:reactor-core:3.6.8")
    implementation("org.springframework:spring-context:6.0.14")
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.2.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.1")
}
