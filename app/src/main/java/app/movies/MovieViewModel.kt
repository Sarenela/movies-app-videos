package app.movies

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

enum class MovieDetails{
    Scenes, Actors, MovieClips
}
class MovieViewModel : ViewModel() {
    var selectedMovieDetails by mutableStateOf(MovieDetails.Scenes)

    fun setDetailsToScenes(){
        selectedMovieDetails = MovieDetails.Scenes
    }

    fun setDetailsToActors(){
        selectedMovieDetails = MovieDetails.Actors
    }

    fun setDetailsToMovieClips(){
        selectedMovieDetails = MovieDetails.MovieClips
    }

}


