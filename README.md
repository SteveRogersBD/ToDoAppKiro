# TodoApp

A full-stack todo application with deadline notifications, featuring a native Android mobile app and a Spring Boot REST API backend.

## 🚀 Features

- **Task Management**: Create, update, and delete todo items
- **Deadline Notifications**: Smart notification system with customizable timing
- **Cross-Platform Sync**: Data synchronization between mobile and backend
- **Material Design**: Modern Android UI following Material Design principles
- **Persistent Storage**: Reliable data persistence with H2 database
- **User Preferences**: Customizable notification settings per user

## 🏗️ Architecture

### Frontend
- **Android Native App** (Java)
- Material Design Components
- Target SDK: Android 34 (API level 34)
- Minimum SDK: Android 24 (API level 24)

### Backend
- **Spring Boot 3.2.0** (Java 17)
- Spring Data JPA for data persistence
- H2 Database (in-memory/file-based)
- RESTful API design
- Comprehensive notification system

## 📁 Project Structure

```
TodoApp/
├── app/                    # Android application module
│   ├── build.gradle       # Android app build configuration
│   └── src/main/
│       ├── java/          # Java source code
│       ├── res/           # Android resources
│       └── AndroidManifest.xml
├── backend/               # Spring Boot backend service
│   ├── pom.xml           # Maven build configuration
│   └── src/main/
│       ├── java/         # Java source code
│       └── resources/    # Configuration files
├── .kiro/                # Kiro IDE specifications
│   └── specs/           # Feature specifications and designs
├── build.gradle          # Root Gradle build configuration
├── settings.gradle       # Gradle project settings
└── gradle.properties     # Global Gradle properties
```

## 🛠️ Technology Stack

### Android App
- **Language**: Java
- **Build System**: Gradle
- **UI Framework**: Material Design Components
- **Key Libraries**:
  - AndroidX AppCompat
  - ConstraintLayout
  - RecyclerView

### Backend
- **Language**: Java 17
- **Framework**: Spring Boot 3.2.0
- **Build System**: Maven
- **Database**: H2 Database
- **Key Dependencies**:
  - Spring Web (REST APIs)
  - Spring Data JPA
  - Spring Boot Validation
  - Lombok (code generation)

## 🚦 Getting Started

### Prerequisites
- Java 17 or higher
- Android Studio (for mobile app development)
- Maven 3.6+ (or use included wrapper)
- Gradle 7.0+ (or use included wrapper)

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone <your-repository-url>
   cd TodoApp
   ```

2. **Navigate to backend directory**
   ```bash
   cd backend
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```
   
   Or if Maven is installed globally:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - API Base URL: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:tododb`
     - Username: `sa`
     - Password: (leave empty)

### Android App Setup

1. **Open Android Studio**
2. **Import the project** by selecting the root `TodoApp` directory
3. **Sync the project** with Gradle files
4. **Run the app** on an emulator or physical device

## 📊 Database Schema

### Core Tables
- **todos**: Main todo items with titles, descriptions, and deadlines
- **notification_schedule**: Scheduled notifications for tasks
- **notification_history**: Track of sent notifications and user interactions
- **user_notification_preferences**: User-specific notification settings

### Notification System
The application includes a comprehensive notification system with:
- Customizable notification timing
- User preference management
- Notification history tracking
- Priority-based notifications

## 🔧 Development Commands

### Backend Commands
```bash
# Build the application
./mvnw clean package

# Run tests
./mvnw test

# Clean build
./mvnw clean compile
```

### Android Commands
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

## 📡 API Endpoints

### Todo Management
- `GET /api/todos` - Get all todos
- `POST /api/todos` - Create a new todo
- `GET /api/todos/{id}` - Get todo by ID
- `PUT /api/todos/{id}` - Update todo
- `DELETE /api/todos/{id}` - Delete todo

### Notification System
- `GET /api/notifications/schedule` - Get scheduled notifications
- `POST /api/notifications/schedule` - Schedule a notification
- `GET /api/notifications/preferences/{userId}` - Get user preferences
- `PUT /api/notifications/preferences/{userId}` - Update user preferences

## 🧪 Testing

The project includes comprehensive testing for both frontend and backend components:

- **Backend**: JUnit tests for services, repositories, and controllers
- **Android**: Unit tests and instrumentation tests

Run tests using the commands mentioned in the Development Commands section.

## 🚀 Deployment

### Backend Deployment
The Spring Boot application can be deployed to various platforms:
- **JAR Deployment**: Build with `./mvnw clean package` and run the generated JAR
- **Docker**: Create a Dockerfile for containerized deployment
- **Cloud Platforms**: Deploy to AWS, Google Cloud, or Azure

### Android Deployment
- **Debug Build**: For development and testing
- **Release Build**: Signed APK for production distribution
- **Google Play Store**: Follow Android publishing guidelines

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Support

For support and questions:
- Create an issue in the GitHub repository
- Check the documentation in the `.kiro/specs/` directory for detailed feature specifications

## 🎯 Roadmap

- [ ] Push notifications for mobile app
- [ ] User authentication and authorization
- [ ] Task categories and tags
- [ ] Collaborative todo lists
- [ ] Dark mode support
- [ ] Offline synchronization

---

**Built with ❤️ using Spring Boot and Android**