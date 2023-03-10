plugins {
    java
}

group = "me.zeroest"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":car-domain"))

    // Mongo embedded
//    implementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo:4.3.3")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}