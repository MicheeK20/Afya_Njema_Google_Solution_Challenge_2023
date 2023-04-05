# Afya_Njema_Google_Solution_Challenge_2023
To execute this project you should ensure 
1. build.gradle (Module: app) content is (following lines)
******************************************************************************************************************************************************
File head
******************************************************************************************************************************************************
    def nav_version = "2.5.3"
    def glide ="4.11.0"
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
    implementation 'androidx.activity:activity-compose:1.3.1'
    implementation "androidx.compose.ui:ui:$compose_ui_version"
    implementation "androidx.compose.ui:ui-tooling-preview:$compose_ui_version"
    implementation 'androidx.compose.material:material:1.2.0'
    implementation 'com.google.firebase:firebase-database:20.0.4'
    implementation platform('com.google.firebase:firebase-bom:31.3.0')
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("com.google.accompanist:accompanist-pager:0.17.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.17.0")
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_ui_version"
    debugImplementation "androidx.compose.ui:ui-tooling:$compose_ui_version"
    debugImplementation "androidx.compose.ui:ui-test-manifest:$compose_ui_version"
    implementation "com.github.bumptech.glide:glide:$glide"
    annotationProcessor "com.github.bumptech.glide:compiler:$glide"


******************************************************************************************************************************************************
File end
******************************************************************************************************************************************************


2. build.gradle (Project) content matches following lines:

******************************************************************************************************************************************************
File head
******************************************************************************************************************************************************
//code starts
buildscript {
    ext {
        compose_ui_version = '1.2.0'
        compose_version = '1.0.1'
        lifecycle_version = "2.4.0-beta01"
        nav_version = "2.5.3"
    }
    repositories{
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.google.gms:google-services:4.3.15'
        classpath "com.google.dagger:hilt-android-gradle-plugin:2.43.2"
        //classpath "org.jetbrains.kotlin:kotlin-ksp:1.4.0-rc-dev-experimental-20200828"
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id 'com.android.application' version '7.4.2' apply false
    id 'com.android.library' version '7.4.2' apply false
    id 'org.jetbrains.kotlin.android' version '1.7.0' apply false
    id 'com.google.gms.google-services' version '4.3.0' apply false
}
task clean(type: Delete) {
    delete rootProject.buildDir
}
//code ends
******************************************************************************************************************************************************
File end
******************************************************************************************************************************************************
3. Application is connected to Firebase and dependencies are added ( Tools > Firebase > Realtime Database >Getting started )
