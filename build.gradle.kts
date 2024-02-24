import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	kotlin("plugin.jpa") version "1.9.22"
}

group = "com.wilsoncooked"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	maven {
		url = uri("https://oss.jfrog.org/artifactory/oss-snapshot-local")
	}
}

dependencies {
	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// Web
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	// Webflux
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	// Jackson
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// Kotlin
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	// Apollo
	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:15.0.0")
	implementation(("com.graphql-java-kickstart:graphql-java-tools:13.0.3"))
	implementation("com.graphql-java:graphql-java-extended-scalars:20.0")

	// Logging
	implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("com.graphql-java-kickstart:graphql-spring-boot-starter-test:15.0.0")
	testImplementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("io.mockk:mockk:1.12.0")
	testImplementation("com.ninja-squad:springmockk:3.0.1")

	// Database
	runtimeOnly("org.postgresql:postgresql")

	// Devtools
	developmentOnly("org.springframework.boot:spring-boot-devtools")


}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

sourceSets {
	test {
		java {
			setSrcDirs(listOf("src/test/intg", "src/test/unit"))
		}
	}
}