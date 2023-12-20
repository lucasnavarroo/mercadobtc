apply {
    from("$rootDir/base-module.gradle")
}
dependencies {
    "implementation"(project(":core"))
    "implementation"(project(":exchanges:exchanges_domain"))
    "implementation"("com.google.code.gson:gson:2.8.9")
}

