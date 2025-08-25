# Make Your Ganesha (Android, Jetpack Compose)

A modular Android app to create and share your own Ganesha idol and pandal.

## Build & Run
- Open in Android Studio
- Sync Gradle/SDK
- Run on device/emulator

## Share
- Floating Share button captures the current screen and opens a chooser (WhatsApp/Facebook prioritized)

## Structure
- `app/src/main/java/com/example/makeyourganesha`
  - `core/` (ui theme, data store, viewmodel, share)
  - `feature/` (home, start, puja, settings, profile, connect, creation preview)