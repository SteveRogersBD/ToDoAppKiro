# Technology Stack

## Android App
- **Language**: Java
- **Build System**: Gradle
- **Target SDK**: Android 34 (API level 34)
- **Minimum SDK**: Android 24 (API level 24)
- **UI Framework**: Material Design Components
- **Key Libraries**:
  - AndroidX AppCompat
  - Material Design Components
  - ConstraintLayout
  - RecyclerView

## Backend
- **Language**: Java 17
- **Framework**: Spring Boot 3.2.0
- **Build System**: Maven
- **Database**: H2 (in-memory/file-based)
- **Key Dependencies**:
  - Spring Web (REST APIs)
  - Spring Data JPA (data persistence)
  - Spring Boot Validation
  - H2 Database

## Common Commands

### Android App
```bash
# Build the app
./gradlew build

# Install debug APK
./gradlew installDebug

# Run tests
./gradlew test

# Clean build
./gradlew clean
```

### Backend
```bash
# Run the application
./mvnw spring-boot:run

# Build JAR
./mvnw clean package

# Run tests
./mvnw test

# Clean build
./mvnw clean compile
```

## Development Environment
- **JVM Args**: -Xmx2048m for Gradle builds
- **Code Style**: Kotlin official style (configured in gradle.properties)
- **AndroidX**: Enabled for modern Android development