# gradle library repo

java library 를 위한 multi module 입니다.

https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry


### 준비
Github Personal access token 을 발급받고, github username 과 함께 환경변수(.zshrc 등)로 저장해야합니다.

### 사용법

build.gradle.kts 파일에 아래와 같이 작성합니다.

```kotlin
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/disdong123/gradle-plugin-repo")
        credentials {
            username = System.getenv("DISDONG_USERNAME")
            password = System.getenv("DISDONG_TOKEN")
        }
    }
    mavenCentral()
}

dependencies {
    implementation("kr.disdong:ytdl-core-kt:0.0.1")
}
```


### 배포
```
./gradlew publish
```


### TODO
- test
- workflows