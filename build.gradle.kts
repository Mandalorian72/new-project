plugins {
    id("java")
}

group = "com.atb.loyalty"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.codeborne:selenide:7.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("com.typesafe:config:1.4.2")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")
}

tasks.test {
    useJUnitPlatform()
}