plugins {
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("io.micronaut.application") version "2.0.6"
}

version = "0.1"
group = "acebuddy"

repositories {
    mavenCentral()
}

micronaut {
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("acebuddy.*")
    }
}

dependencies {
    annotationProcessor("info.picocli:picocli-codegen")

    compileOnly("org.graalvm.nativeimage:svm")

    implementation("com.github.docker-java:docker-java-core:3.2.12")
    implementation("com.github.docker-java:docker-java-transport-zerodep:3.2.12")
    implementation("info.picocli:picocli")
    implementation("io.lindstrom:m3u8-parser:0.21")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut.picocli:micronaut-picocli")

    runtimeOnly("ch.qos.logback:logback-classic")

    testImplementation("io.micronaut:micronaut-http-client")
}


application {
    mainClass.set("acebuddy.command.AcebuddyCommand")
}

java {
    sourceCompatibility = JavaVersion.toVersion("1.8")
    targetCompatibility = JavaVersion.toVersion("1.8")
}



