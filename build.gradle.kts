plugins {
    kotlin("jvm") version "1.5.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val kotestVersion = "4.6.1"
val mockkVersion = "1.12.0"

dependencies {
    implementation(kotlin("stdlib"))

    // logging
    implementation("io.github.microutils:kotlin-logging:1.12.5")

    // mock & kotest
    testImplementation("io.mockk:mockk:1.10.6")
    testImplementation("io.kotest:kotest-assertions-core:4.4.3")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("org.junit.jupiter:junit-jupiter")

    // apache log4j2
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
    testImplementation("org.apache.logging.log4j:log4j-core:2.14.1")
    testImplementation("org.apache.logging.log4j:log4j-api:2.14.1")


}

tasks.withType<Test> {
    useJUnitPlatform()
}
