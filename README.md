# The [RetroBox](https://retrobox.tech) android app 📱
[![GitHub issues](https://img.shields.io/github/issues/retrobox/android?style=flat-square)](https://github.com/retrobox/android/issues) ![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/retrobox/android?style=flat-square)  
<br>
**Master build :** [![CircleCI](https://circleci.com/gh/retrobox/android/tree/master.svg?style=svg)](https://circleci.com/gh/retrobox/android/tree/master)
**Dev build :** [![CircleCI](https://circleci.com/gh/retrobox/android/tree/dev.svg?style=svg)](https://circleci.com/gh/retrobox/android/tree/dev)  

# Infos ❕

Download our app on the **Google Play Store** !

<a href="https://retrobox.tech/downloads">
    <img src="https://enlaps.io/wp-content/uploads/2018/10/get-it-on-google-play.png" alt="alt" width="200">
</a>

This app is, at this time, only available in french. We will add english support asap.

Compatible with android-api **18** to **29**.

This app contains errors trackers, analytics & performance script, by using our app, you agree with the processing of this data. Learn more about privacy [here](https://retrobox.tech/privacy).

# Preview 📷 

Preview will be avaible when a release will be available on the store.

# Build and environment needed 🔨 

### Software preparation

 To build our app you will need to install [JDK 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) and [Ruby](https://rubyinstaller.org/downloads/) installed on your computer. This app can be build on windows and linux without issue (just remove sudo before all commands for windows).

### Setup

1. Clone the repository: `git clone https://github.com/retrobox/android`
2. Install Fastlane with ```sudo gem install fastlane -NV ```
3. Add your env variables (see bottom)
4. Add the project to Android Studio

 ### Environment variables
 Please add the files to your project (see in the exemple file to know what to do)

 - `.\.env` # Google Cloud Service account key & others things
 - `.\keystore.properties` # Private keys to sign app with the .jks certificate
 - `.\google-play-key.json` # Private api key for Google Play Console access
 - `.\app\google-services.json` # Firebase api key ([doc](https://firebase.google.com/docs/android/setup))
 - `.\app\keystore_private.jks` # Private android studio certificate ([doc](https://developer.android.com/studio/publish/app-signing))

### Build

⚠️ Be aware, here are several types of build flavours :  

- devDebug # Debug the dev version (log everything)
- devRelease # (we do not use this build)
- proDebug # Debug the release version (log everything)
- proRelease # The version who will be pushed to Google Play Store

Examples :  
- build_flavor -> `debug` or `release`
- build_type -> `pro` or `dev`

*[Only in the case you want to work with Fastlane]*  
After adding all your env files, run :

- ```sudo bundle exec fastlane supply```

This will synchronize with the GPC, all metadatas.

Before making a build you need to clean gradlew with : `./gradlew clean build`

Next, just choose to the left tab "Build variants" the type of version you want to build in Android Sutdio, then run build.  
You can also use these commands :

- ```bundle exec fastlane assemble_build build_flavor:"YourBuildFlavor" build_type:"YourBuildType"```

- ```sudo ./gradlew build``` # If you want to work with gradlew CLI.

## Autonomous deploy explanation 🔄

### Fastlane ```.\fastlane```

We use Fastlane because is the easiest way to do CI/CD, this is a powerfull tool (and free !).

See more in `.\fastlane\README.md`.

### Circle CI ```.\.circleci\config.yml```

To use Circle CI put these variables in th env :

```ini
BUILD_FLAVOR=Pro
BUILD_TYPE=Release
GCLOUD_SERVICE_KEY=raw json key
GOOGLE_PLAY_KEY=raw json key
KEYSTORE=convert to base64 'keystore_upload.jks' and put the raw output here
RELEASE_KEYSTORE=keystore
RELEASE_KEY_ALIAS=your alias
RELEASE_KEY_PASSWORD=your password
RELEASE_STORE_PASSWORD=your password
```

__License :__

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/3.0/">Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License</a>.