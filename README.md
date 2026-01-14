# OpuS OS

<div align="center">

**An AI-native Android fork where Claude Opus operates at the system level**

[![Twitter](https://img.shields.io/badge/Twitter-@opus__os-1DA1F2?style=flat&logo=twitter&logoColor=white)](https://x.com/opus_os)
[![Community](https://img.shields.io/badge/Community-@opus__os-1DA1F2?style=flat&logo=twitter&logoColor=white)](https://x.com/opus_os)

</div>

---

## What is OpuS OS?

**OpuS is an AI-native Android fork where Claude Opus is embedded at the system level, not as an app.** The operating system itself becomes the primary intelligent interface, enabling natural language control, context-aware operations, and privacy-first architecture.

Unlike traditional Android where AI exists as a separate application layer, OpuS integrates Claude Opus directly into the system services, framework, and UI components. This allows for:

- **System-level intelligence** — Opus can control settings, manage resources, and understand device context
- **Natural language OS control** — Interact with your device through conversational commands
- **Full system context awareness** — Opus understands battery, storage, active apps, and system state
- **Privacy-first architecture** — Local processing by default, with optional cloud integration

## Key Features

### 🎯 System-Level Integration
Claude Opus operates as a system service, not an app. Toggle Wi-Fi, Bluetooth, battery saver, and display settings through natural language commands or direct system controls.

### 💬 Natural Language OS Control
Control your device through conversational commands:
- "Turn on battery saver"
- "Lower brightness"
- "Enable do not disturb"
- "Show me system status"

### 🧠 Full System Context Awareness
Opus maintains awareness of:
- Current active applications
- Battery level and charging status
- Storage usage and availability
- System resource allocation

### 🔒 Privacy-First Architecture
- **Local processing** by default — all AI operations run on-device
- **Optional cloud processing** — requires explicit user consent
- **Transparent data handling** — clear controls and explanations

### 🎨 Experimental UI
A calm, system-level aesthetic with:
- Dark theme optimized for extended use
- Android green (#4CAF50) and Opus orange (#FF9800) accents
- Minimal, focused interface design
- Smooth transitions and animations

## Architecture

This demo app showcases OpuS OS concepts using a clean, modular architecture:

```
┌─────────────────────────────────────┐
│           UI Layer                  │
│  (Compose Screens & Components)     │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│        ViewModel Layer              │
│  (State Management & UI Logic)      │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│        Domain Layer                 │
│  (Use Cases & Business Logic)       │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│        Data Layer                   │
│  (Repositories & Data Sources)      │
└─────────────────────────────────────┘
```

**Tech Stack:**
- **Kotlin** + **Coroutines** + **Flow** for asynchronous operations
- **Jetpack Compose** for declarative UI
- **MVVM** architecture pattern
- **Hilt** for dependency injection
- **Material 3** design system

## Installation

### Prerequisites

Before building OpuS OS demo, ensure you have:

1. **Android Studio Hedgehog (2023.1.1) or later**
   - Download from [developer.android.com/studio](https://developer.android.com/studio)
   - Ensure Android SDK 35 (Android 15) is installed

2. **JDK 17 or later**
   ```bash
   java -version  # Should show 17 or higher
   ```

3. **Git** (for cloning the repository)
   ```bash
   git --version
   ```

4. **At least 8GB RAM** (16GB recommended for smooth builds)

### Building from Source

#### Step 1: Clone the Repository

```bash
git clone https://github.com/android/architecture-samples.git
cd architecture-samples
```

#### Step 2: Configure Gradle

The project uses Gradle with version catalogs. Verify your `gradle.properties`:

```properties
# AndroidX package structure to make it clearer which packages are bundled with the
# Android operating system, and which are packaged with your app's APK
android.useAndroidX=true

# Kotlin code style for this project: "official" or "obsolete":
kotlin.code.style=official

# Enables namespacing of each library's R class so that its R class includes only the
# resources declared in the library itself and none from the library's dependencies,
# thereby reducing the size of the R class for that library
android.nonTransitiveRClass=true
```

#### Step 3: Sync and Build

1. Open Android Studio
2. Select **File → Open** and navigate to the `architecture-samples` directory
3. Wait for Gradle sync to complete (may take 5-10 minutes on first run)
4. Build the project: **Build → Make Project** (Ctrl+F9 / Cmd+F9)

#### Step 4: Run on Device or Emulator

**Option A: Physical Device**
1. Enable **Developer Options** on your Android device:
   - Go to Settings → About Phone
   - Tap "Build Number" 7 times
2. Enable **USB Debugging**:
   - Settings → Developer Options → USB Debugging
3. Connect device via USB
4. Run: **Run → Run 'app'** (Shift+F10 / Ctrl+R)

**Option B: Android Emulator**
1. **Tools → Device Manager**
2. Create a new virtual device (recommended: Pixel 7, API 35)
3. Start the emulator
4. Run: **Run → Run 'app'**

### Advanced: Building with Custom Configuration

#### Build Variants

The project supports multiple build variants:

```bash
# Debug build (default)
./gradlew assembleDebug

# Release build (requires signing configuration)
./gradlew assembleRelease
```

#### Enabling ProGuard/R8

For release builds, R8 is enabled by default. To customize:

1. Edit `app/proguard-rules.pro`
2. Add your specific rules
3. Build release variant

#### Running Tests

```bash
# Unit tests
./gradlew test

# Instrumented tests (requires device/emulator)
./gradlew connectedAndroidTest

# All tests
./gradlew check
```

### Troubleshooting

**Gradle sync fails:**
- Check internet connection (Gradle downloads dependencies)
- Invalidate caches: **File → Invalidate Caches → Invalidate and Restart**
- Delete `.gradle` folder in project root and resync

**Build errors:**
- Ensure JDK 17+ is set in **File → Project Structure → SDK Location**
- Clean project: **Build → Clean Project**
- Rebuild: **Build → Rebuild Project**

**Emulator won't start:**
- Enable virtualization in BIOS (Intel VT-x / AMD-V)
- Allocate more RAM to emulator in AVD settings (4GB+ recommended)

**App crashes on launch:**
- Check logcat: **View → Tool Windows → Logcat**
- Ensure device/emulator runs API 21+ (Android 5.0+)

## Usage

### Navigating the Demo

1. **Swipe vertically** to navigate between demo screens:
   - **Hero** — Home screen with "Ask Opus" button
   - **System Level** — System settings and controls
   - **Natural Language** — Command input interface
   - **Context Aware** — System status and context
   - **Privacy** — Privacy controls and settings

2. **Interact with features:**
   - Tap "Ask Opus" to see interaction states
   - Toggle system settings (Wi-Fi, Bluetooth, etc.)
   - Enter natural language commands
   - View system context information

### Example Commands

Try these natural language commands in the Natural Language screen:

- `Turn on battery saver`
- `Lower brightness`
- `Enable do not disturb`
- `Turn on Wi-Fi`
- `Enable Bluetooth`

## Development

### Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/android/architecture/blueprints/todoapp/
│   │   │   ├── opus/              # OpuS OS demo components
│   │   │   │   ├── MainViewModel.kt
│   │   │   │   ├── PhoneContainer.kt
│   │   │   │   └── screens/       # Screen components
│   │   │   ├── domain/            # Domain layer
│   │   │   │   ├── UIScreen.kt
│   │   │   │   └── usecase/       # Use cases
│   │   │   ├── data/              # Data layer
│   │   │   │   └── SystemRepository.kt
│   │   │   └── di/               # Dependency injection
│   │   └── res/                  # Resources
│   ├── test/                     # Unit tests
│   └── androidTest/             # Instrumented tests
└── build.gradle.kts
```

### Contributing

This is a demo application showcasing OpuS OS concepts. For contributions:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Code Style

- Follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use `ktlint` or Android Studio's built-in formatter
- Maintain clean architecture boundaries
- Write tests for new features

## Limitations

This is a **high-fidelity demo**, not a production Android system:

- ❌ No real backend or API integration
- ❌ No actual Claude Opus API calls
- ❌ All logic is mocked and deterministic
- ❌ No persistence (data resets on app restart)
- ❌ No real OS-level hooks or system modifications

The demo focuses on **architecture, state management, and UX clarity** rather than production functionality.

## License

```
Copyright 2024 OpuS OS Contributors

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```

## Community

<div align="center">

**Stay connected with OpuS OS**

[![Twitter](https://img.shields.io/badge/Official_Twitter-@opus__os-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://x.com/opus_os)

[![Community](https://img.shields.io/badge/Community_X-@opus__os-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://x.com/opus_os)

</div>

---

**OpuS OS** — *Experimental. Calm. System-level.*
