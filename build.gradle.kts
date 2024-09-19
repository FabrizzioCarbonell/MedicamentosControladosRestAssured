plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Dependencias para JUnit
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Dependencias para RestAssured
    testImplementation("io.rest-assured:rest-assured:5.3.0")

    // Dependencia de GSON para archivos JSON
    implementation("com.google.code.gson:gson:2.11.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Test>("EquivalencePartitioning"){
    useJUnitPlatform{
        includeTags("EquivalencePartitioning")
    }
}

tasks.register<Test>("BoundaryValues"){
    useJUnitPlatform{
        includeTags("BoundaryValues")
    }
}
