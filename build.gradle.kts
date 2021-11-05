plugins {
    java
    application
}

group = "org.buckeyesolar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

}

application {
    mainClass.set("org.buckeyesolar.BuckeyeTelemetry")
}

dependencies {
    // Dependencies for web server
    implementation("io.undertow:undertow-core:2.2.12.Final")
    implementation("io.undertow:undertow-servlet:2.2.12.Final")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}