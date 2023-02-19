plugins {
    `java-library`
}

publishing {
    publications {
        register<MavenPublication>("ytdlCoreKt") {
            group = "kr.disdong"
            artifactId = "ytdl-core-kt"
            version = "0.0.1"
            from(components["java"])
        }
    }
}