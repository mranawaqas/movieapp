# Studio Ghibli Movies App

An Android application that displays a list of Studio Ghibli movies using a free API, with the ability to mark favorites and persist them locally.

## API Used

**Studio Ghibli API** - https://ghibliapi.vercel.app/films
- Free API with no authentication required
- Provides comprehensive movie data including:
   - Movie title and original title
   - Movie poster images
   - Release dates, directors, producers
   - Plot descriptions and ratings

## Architecture Overview

The app follows **MVVM (Model-View-ViewModel)** architecture with **Clean Architecture** principles:

### Data Layer
- **API Service**: Retrofit interface for network calls to Studio Ghibli API (https://ghibliapi.vercel.app/)
- **Database**: Room database for local persistence of favorite movies
- **Repository**: Single source of truth that coordinates between API and local database
- **Kotlin Serialization**: JSON parsing with kotlinx.serialization

### Domain Layer
- **Models**: Data classes for `Movie` and `FavoriteMovie` entities
- **Repository Interface**: Abstracts data sources

### Presentation Layer
- **ViewModels**: Handle UI logic and state management using StateFlow
- **UI Screens**: XML layouts with ViewBinding for movie list and details
- **Navigation**: Navigation Component for screen transitions

### Dependency Injection
- **Hilt**: Provides dependencies throughout the app
- **Modules**: Separate modules for Network and Database dependencies

## Coroutine Usage

The app follows coroutine best practices throughout:

### Repository Layer
- **Suspend Functions**: All database and network operations use suspend functions
```kotlin
suspend fun getMovies(): List<Movie> = apiService.getMovies()
suspend fun addToFavorites(movie: Movie) = favoriteMovieDao.insertFavorite(movie.toFavoriteMovie())
```

### ViewModel Layer
- **ViewModelScope**: All coroutines launched in viewModelScope for automatic cancellation
- **Exception Handling**: Proper try-catch blocks with error state emission
```kotlin
viewModelScope.launch {
    try {
        _uiState.value = UiState.Loading
        val movies = repository.getMovies()
        _uiState.value = UiState.Success(movies)
    } catch (e: Exception) {
        _uiState.value = UiState.Error(e.message)
    }
}
```

### Database Operations
- **Flow**: Room returns Flow<List<T>> for reactive updates
- **StateFlow**: ViewModels expose StateFlow for UI observation

## How to Run the Project

### Prerequisites
- **JDK 17**: Required for building the project
- Android Studio Hedgehog (2023.1.1) or later
- Android SDK 24+ (Android 7.0)
- Kotlin 1.9.20+

### CommandsToFixJDK
```kotlin
export JAVA_HOME=$(/usr/libexec/java_home -v 17)
export PATH=$JAVA_HOME/bin:$PATH  
```

### Setup Steps
1. **Ensure JDK 17 is installed**
   - Check your JDK version: `java -version`
   - If needed, install JDK 17 and configure it in Android Studio
   - In Android Studio: File → Project Structure → SDK Location → JDK Location

2. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd MoviesApp
   ```

3. **Open in Android Studio**
   - Open Android Studio
   - Choose "Open an existing project"
   - Navigate to the MoviesApp directory

4. **Sync the project**
   - Android Studio will automatically sync Gradle dependencies
   - Wait for the sync to complete
   - Ensure JDK 17 is selected in the project settings

5. **Run the app**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press Shift+F10
   - The app will install and launch automatically

## How Favorites are Persisted

### Database Schema
```kotlin
@Entity(tableName = "movies")
@Serializable
data class Movie(
    @PrimaryKey
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("original_title")
    val originalTitle: String,
    @SerialName("image")
    val image: String,
    @SerialName("description")
    val description: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("director")
    val director: String,
    @SerialName("producer")
    val producer: String,
    @SerialName("running_time")
    val runningTime: String,
    @SerialName("rt_score")
    val rtScore: String,
    val isFavorite: Boolean = false
)
```

### Persistence Flow
1. **Adding Favorites**: When user clicks the favorite button, movie data is saved to Room database with `isFavorite = true`
2. **Removing Favorites**: Favorite status is updated to `false` in the database
3. **Reactive Updates**: UI automatically updates through Flow/StateFlow when favorites change
4. **Data Survival**: Favorites persist through app restarts and device reboots
5. **Status Merging**: When movies are fetched from API, favorite status is merged from the database to ensure UI consistency

### Database Operations
- **Room Database**: SQLite database with Room ORM
- **DAO (Data Access Object)**: Defines database operations (MovieDao)
- **KSP**: Kotlin Symbol Processing for Room code generation (faster than KAPT)
- **Flow Queries**: Reactive database queries that emit updates automatically
- **Database Migrations**: Handled automatically for schema changes

## AI Assistance vs Self-Implementation

### AI-Assisted Components:
- **Project Setup**: Gradle configuration and dependency setup

### Self-Implemented Features:
- **Business Logic**: Movie filtering, favorites management logic
- **State Management**: Custom StateFlow implementation for UI states
- **Navigation Flow**: Screen navigation and parameter passing using Navigation Component
- **UI Polish**: Custom styling, animations, and user experience refinements
- **Architecture Decisions**: MVVM pattern implementation and layer separation
- **Favorite Status Sync**: Merging favorite status from database with API movies
