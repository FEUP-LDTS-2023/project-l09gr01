plugins {
    id("java")
    id("info.solidsoft.pitest") version "1.6.0"
    // id ("org.kordamp.gradle.errorprone") version "0.47.0"
}

group = "com.l09gr01.badice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
pitest {
    junit5PluginVersion = "0.12"
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.googlecode.lanterna:lanterna:3.1.1")
    testImplementation ("org.mockito:mockito-core:3.7.7")
    testImplementation ("net.jqwik:jqwik:1.5.1")
}

tasks.test {
    useJUnitPlatform()
}