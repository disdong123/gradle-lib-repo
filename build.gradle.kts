@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `maven-publish`
    alias(libs.plugins.kotlin.jvm)
}

allprojects {
    group = "kr.disdong"
    version = "0.0.1"

    repositories {
        // Use Maven Central for resolving dependencies.
        mavenCentral()
    }
}

subprojects {
    val libs = rootProject.libs

    apply(plugin = "maven-publish")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        implementation(libs.kotlin.reflect)
        implementation(libs.kotlin.stdlib.jdk8)

        // Use the Kotlin JUnit 5 integration.
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

        // Use the JUnit 5 integration.
        testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    }

    configure<PublishingExtension> {
        repositories {
            maven {
                url = uri("https://maven.pkg.github.com/disdong123/gradle-lib-repo")
                credentials {
                    username = project.findProperty("gpr.user") as String? ?: System.getenv("DISDONG_USERNAME")
                    password = project.findProperty("gpr.key") as String? ?: System.getenv("DISDONG_TOKEN")
                }
            }
        }
    }

    tasks.named<Test>("test") {
        // Use JUnit Platform for unit tests.
        useJUnitPlatform()
    }
}




