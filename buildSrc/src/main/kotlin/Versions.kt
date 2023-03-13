import org.gradle.api.JavaVersion
import org.gradle.jvm.toolchain.JavaLanguageVersion

object Versions {
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val compileSdk = 33
    const val targetSdk = 33
    const val minSdk = 24

    val javaCompileVersion = JavaVersion.VERSION_11
    val javaLanguageVersion: JavaLanguageVersion = JavaLanguageVersion.of(11)
}