plugins {
    `java-library`
}

publishing {
    publications {
        register<MavenPublication>("libCommon") {
            group = "kr.disdong"
            artifactId = "lib-common"
            version = "0.0.1"
            from(components["java"])
        }
    }
}
