plugins {
    id("java")
    id ("org.kordamp.gradle.errorprone") version "0.47.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.googlecode.lanterna:lanterna:3.1.1")
    testImplementation("org.mockito:mockito-core:3.7.7")
}

tasks.test {
    useJUnitPlatform()
}