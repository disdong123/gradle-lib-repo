plugins {
    `java-library`
}

publishing {
    publications {
        register<MavenPublication>("libTemplate") {
            group = "kr.disdong"
            artifactId = "lib-template"
            version = "0.0.2"
            from(components["java"])
        }
    }
}