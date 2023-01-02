plugins {
    java
}

group = "me.zeroest"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}