dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://artifactory.appodeal.com/appodeal")
    }
}
rootProject.name = "Qmon"
include(":app")
