# Project Structure

## Root Level
```
TodoApp/
├── app/                    # Android application module
├── backend/               # Spring Boot backend service
├── build.gradle          # Root Gradle build configuration
├── settings.gradle       # Gradle project settings
└── gradle.properties     # Global Gradle properties
```

## Android App Structure (`app/`)
```
app/
├── build.gradle          # Android app build configuration
└── src/
    └── main/
        ├── java/         # Java source code
        ├── res/          # Android resources (layouts, strings, etc.)
        └── AndroidManifest.xml
```

## Backend Structure (`backend/`)
```
backend/
├── pom.xml              # Maven build configuration
└── src/
    └── main/
        ├── java/        # Java source code
        │   └── com/     # Package structure
        └── resources/   # Configuration files
            └── application.properties
```

## Architecture Patterns

### Android App
- **Package Structure**: Follow `com.example.todoapp` namespace
- **Resources**: Use standard Android resource organization
- **Activities/Fragments**: Standard Android UI components
- **RecyclerView**: For displaying todo lists

### Backend
- **Package Structure**: Follow `com.example` base package
- **Spring Boot Structure**:
  - Controllers for REST endpoints
  - Services for business logic
  - Repositories for data access
  - Entities for JPA models
- **Configuration**: Use `application.properties` for settings

## Naming Conventions
- **Android**: Follow Android naming conventions (camelCase for methods, PascalCase for classes)
- **Backend**: Follow Spring Boot conventions (camelCase for methods, PascalCase for classes)
- **Database**: Use snake_case for table/column names
- **REST APIs**: Use kebab-case for endpoints where appropriate