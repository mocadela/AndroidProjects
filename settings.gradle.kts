//pluginManagement {
//    repositories {
//        // 修正后的阿里云源
//        maven("https://maven.aliyun.com/repository/releases")
//        maven("https://maven.aliyun.com/repository/google")
//        maven("https://maven.aliyun.com/repository/central")
//        maven("https://maven.aliyun.com/repository/gradle-plugin")
//        maven("https://maven.aliyun.com/repository/public")
//        maven("https://maven.aliyun.com/repository/jcenter")
//
//        // 华为云镜像优先
//        maven("https://mirrors.huaweicloud.com/repository/google")
//        maven("https://mirrors.huaweicloud.com/repository/jcenter")
//        maven("https://mirrors.huaweicloud.com/repository/maven-public")
//
//        // 修正后的清华源
//        maven("https://mirrors.tuna.tsinghua.edu.cn/gradle-plugin")
//        maven("https://mirrors.tuna.tsinghua.edu.cn/android/repository")
//        maven("https://mirrors.tuna.tsinghua.edu.cn/google")
//        maven("https://mirrors.tuna.tsinghua.edu.cn/maven-central")
//
//        // 官方源
//        gradlePluginPortal()
//        google()
//        mavenCentral()
//    }
//}
//
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//
//        maven("https://maven.aliyun.com/repository/releases")
//        maven("https://maven.aliyun.com/repository/google")
//        maven("https://maven.aliyun.com/repository/central")
//        maven("https://maven.aliyun.com/repository/gradle-plugin")
//        maven("https://maven.aliyun.com/repository/public")
//        maven("https://maven.aliyun.com/repository/jcenter")
//        // 与 pluginManagement 仓库配置保持一致，修正大括号
//        maven("https://mirrors.huaweicloud.com/repository/google")
//        maven("https://mirrors.huaweicloud.com/repository/jcenter")
//        maven("https://mirrors.huaweicloud.com/repository/maven-public")
//        maven("https://mirrors.tuna.tsinghua.edu.cn/gradle-plugin")
//        maven("https://mirrors.tuna.tsinghua.edu.cn/android/repository")
//        maven("https://mirrors.tuna.tsinghua.edu.cn/google")
//        maven("https://mirrors.tuna.tsinghua.edu.cn/maven-central")
//
//
//        google()
//        mavenCentral()
//    }
//}
//
//rootProject.name = "BroadcastReceiverDemo"
//include(":app")
//

pluginManagement {
    repositories {
        // 1. 阿里云 (推荐，国内最稳定)
        maven("https://maven.aliyun.com/repository/public")
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/gradle-plugin")

        // 2. 华为云 (使用正确的根路径，不要加具体的 google/jcenter 后缀)
        maven("https://mirrors.huaweicloud.com/repository/maven")

        // 3. 官方源 (作为备选)
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // 1. 阿里云
        maven("https://maven.aliyun.com/repository/public")
        maven("https://maven.aliyun.com/repository/google")

        // 2. 华为云
        maven("https://mirrors.huaweicloud.com/repository/maven")

        // 3. 官方源
        google()
        mavenCentral()
    }
}

rootProject.name = "BroadcastReceiverDemo"
include(":app")

