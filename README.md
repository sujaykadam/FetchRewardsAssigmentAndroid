# Fetch Rewards Assignment Android App

## Overview
This is a native Android application written in Kotlin that retrieves data from [https://hiring.fetch.com/hiring.json](https://hiring.fetch.com/hiring.json) and displays a list of items grouped by `listId`. The app demonstrates clean architecture, modern Android development practices, and a user-friendly UI.

## Features
- Fetches data from a remote API using Retrofit
- Displays items grouped by `listId`
- Sorts items first by `listId`, then by `name`
- Filters out items where `name` is blank or null
- Easy-to-read, nested list UI using RecyclerView
- MVVM architecture with ViewModel and LiveData
- Supports latest Android OS and tools

## Requirements
- **Android Studio Giraffe or newer** (recommended: Hedgehog or latest stable)
- **Android SDK 35** (compileSdk and targetSdk)
- **Minimum SDK:** 26 (Android 8.0)
- **Kotlin:** 2.0.21
- **Gradle:** 8.11.1

## Getting Started

### 1. Clone the repository
```sh
git clone git@github.com:sujaykadam/AndroidStudioProjects.git
cd FetchRewardsAssigmentAndroid
```

### 2. Open in Android Studio
- Open the project in Android Studio.
- Let Gradle sync and download dependencies.

### 3. Build & Run
- Connect an Android device or start an emulator (API 26+).
- Click **Run** (▶️) in Android Studio, or use:
  ```sh
  ./gradlew assembleDebug
  ```

## Project Structure
- `app/src/main/java/com/example/fetchrewardsassigmentandroid/`
  - `data/api/` — Retrofit API service and instance
  - `data/model/` — Data model (`Item.kt`)
  - `viewmodels/` — `ItemViewModel` for data handling
  - `adapters/` — RecyclerView adapters for grouped and item lists
  - `utils/` — Utility classes (e.g., custom Gson adapters)
  - `MainActivity.kt` — Main UI logic
- `app/src/main/res/layout/` — XML layouts for activity and list items

## Data Handling Logic
- **Fetching:** Uses Retrofit to fetch a list of items from the API.
- **Filtering:** Removes items where `name` is blank or null.
- **Sorting:**
  - First by `listId` (ascending)
  - Then by `name` (natural order, numbers sorted numerically if present)
- **Grouping:** Groups items by `listId` for display.
- **Display:**
  - Outer RecyclerView: Each group (`listId`)
  - Inner RecyclerView: Items for that group

## Dependencies
- [Retrofit 2.12.0](https://square.github.io/retrofit/)
- [Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson)
- [AndroidX RecyclerView](https://developer.android.com/jetpack/androidx/releases/recyclerview)
- [AndroidX Lifecycle (ViewModel, LiveData)](https://developer.android.com/jetpack/androidx/releases/lifecycle)
- [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Material Components](https://material.io/develop/android)

## Notes
- The app requires internet access (`INTERNET` permission is declared in the manifest).
- The API base URL is `https://hiring.fetch.com/`.
- The app uses ViewBinding for type-safe UI code.

## TODO
- Add unit and instrumented tests for ViewModel, adapters, and API integration.
- Improve UI/UX and add more user feedback.
- Add error handling for network failures.
