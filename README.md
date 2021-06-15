


firebase stuff

Skip to main content
Firebase logo
Project Overview
Build
Authentication, Firestore Database, Realtime Database, Storage, Hosting, Functions and Machine Learning
Authentication
Firestore Database
Realtime Database
Storage
Hosting
Functions
Machine Learning
Release and monitor
Crashlytics, Performance, Test Lab and App Distribution
Analytics
Dashboard, Realtime, Events, Conversions, Audiences, Funnels, Custom Definitions, Latest Release, Retention and DebugView
Dashboard
Realtime
Events
Conversions
Audiences
Funnels
Custom Definitions
Latest Release
Retention
DebugView
Engage
Predictions, A/B Testing, Cloud Messaging, In-App Messaging, Remote Config, Dynamic Links and AdMob
Predictions
A/B Testing
Cloud Messaging
In-App Messaging
Remote Config
Dynamic Links
AdMob
Extensions
Billing plan:Blaze
Pay as you go

healthguardian

Go to docs
healthguardian
Build
Firestore
Reads
(current)
1K
+82.2%
4
2.8K
5.6K
May 17
May 18
May 19
May 20
May 21
May 22
May 23
Writes
(current)
28
-15.2%
0
153
306
May 17
May 18
May 19
May 20
May 21
May 22
May 23
This week
Last week
Storage
Storage
(current)
30.6MB
May 17
May 18
May 19
May 20
May 21
May 22
May 23
This week
Last week
Store and sync app data in milliseconds

Authentication
Authenticate and manage users

Hosting
Deploy web apps in seconds
See all Build features
Keep tabs on your app's quality

Crashlytics
Prioritise and fix stability issues



Add Firebase SDK
Instructions for Gradle
|
The Google services plugin for Gradle loads the google-services.json file that you just downloaded. Modify your build.gradle files to use the plugin.

Project-level build.gradle (<project>/build.gradle):



buildscript {
  repositories {
    // Check that you have the following line (if not, add it):
    google()  // Google's Maven repository
  }
  dependencies {
    ...
    // Add this line
    classpath 'com.google.gms:google-services:4.3.8'
  }
}

allprojects {
  ...
  repositories {
    // Check that you have the following line (if not, add it):
    google()  // Google's Maven repository
    ...
  }
}
Java
Kotlin
App-level build.gradle (<project>/<app-module>/build.gradle):




apply plugin: 'com.android.application'
// Add this line
apply plugin: 'com.google.gms.google-services'

dependencies {
  // Import the Firebase BoM
  implementation platform('com.google.firebase:firebase-bom:28.0.1')

  // Add the dependency for the Firebase SDK for Google Analytics
  // When using the BoM, don't specify versions in Firebase dependencies
  implementation 'com.google.firebase:firebase-analytics'

  // Add the dependencies for any other desired Firebase products
  // https://firebase.google.com/docs/android/setup#available-libraries
}
By using the Firebase Android BoM, your app will always use compatible Firebase library versions. Learn more
Finally, press 'Sync now' in the bar that appears in the IDE:

Next steps






