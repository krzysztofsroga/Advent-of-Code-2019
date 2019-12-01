plugins {
    kotlin("jvm") version "1.3.61"
}

group = "krzysztofsroga"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://www.jitpack.io") {
        name = "jitpack"
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2")
//    implementation("com.github.kittinunf.fuel:fuel:2.2.+")
    implementation(group = "com.github.kittinunf.fuel", name = "fuel", version = "-SNAPSHOT")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}