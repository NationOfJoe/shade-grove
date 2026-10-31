# Sunward Grove

A hex-forest strategy game of light and shade for 2–4 players, with bots and pass-and-play. This repo packages the game as an Android app.

## Get the APK

Every push to `main` runs the **Build APK** workflow, which:

1. builds a signed release APK, and
2. publishes it on the repo's **Releases** page as `SunwardGrove-<build>.apk`.

Open the latest release on your phone, download the APK and tap it to install. Android will ask you to allow installs from your browser the first time. Later builds install over the earlier one and keep your saved game.

You can also run the workflow by hand from the **Actions** tab (Run workflow).

## How it's built

- `app/src/main/assets/index.html` is the whole game: one self-contained HTML file.
- `MainActivity.java` shows it full screen in a WebView, with local storage on so a game in progress survives closing the app.
- The app needs no network to play. It uses the internet only to fetch its fonts, and falls back to system fonts when offline.

To update the game, replace `index.html` and push.

## Build locally

Open the folder in Android Studio, or with Gradle 8.14 and the Android SDK installed run:

```
gradle assembleRelease
```

The APK lands in `app/build/outputs/apk/release/`.

## Signing key

`keystore/sunward-release.jks` is a fixed key so every build can update the installed app. It is fine for personal sideloading. Replace it with a key stored in GitHub secrets before publishing to Google Play.
