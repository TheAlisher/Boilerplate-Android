plugins {
    id(Conventions.androidFeature)
}

dependencies {

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}