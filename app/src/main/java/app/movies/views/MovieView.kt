package app.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.movies.Actor
import app.movies.Movie
import app.movies.MovieDetails
import app.movies.MovieViewModel
import app.movies.getBestMovies

@Composable
fun MovieView(navController: NavController, viewModel: MovieViewModel = remember { MovieViewModel() }, title: String) {

    if (title == "") {
        navController.popBackStack()
        return
    }
    val movie = getBestMovies().find { it.title == title }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        MovieTitle(movie!!)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        ) {
            MovieCover(movie)
            MovieDescription(movie)
        }

        MovieDetailsOptions(viewModel)

        when (viewModel.selectedMovieDetails) {
            MovieDetails.Scenes -> DisplayScenes(movie!!.scenes_images)
            MovieDetails.Actors -> DisplayActors(movie!!.cast)
            MovieDetails.MovieClips -> DisplayClips(movie!!.movie_clips)
        }
    }
}

@Composable
fun MovieTitle(movie: Movie) {
    Text(
        text = movie.title,
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    )
}

@Composable
fun MovieCover(movie: Movie) {
    Image(
        painter = painterResource(id = movie.cover),
        contentDescription = movie.title,
        modifier = Modifier
            .height(250.dp)
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun MovieDescription(movie: Movie) {
    Text(
        text = movie.description,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}


@Composable
fun MovieDetailsOptions(viewModel: MovieViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        MovieDetailsOption(
            text = "Scenes",
            isSelected = viewModel.selectedMovieDetails == MovieDetails.Scenes
        ) {
            viewModel.setDetailsToScenes()
        }
        MovieDetailsOption(
            text = "Actors",
            isSelected = viewModel.selectedMovieDetails == MovieDetails.Actors
        ) {
            viewModel.setDetailsToActors()
        }
        MovieDetailsOption(
            text = "Clips",
            isSelected = viewModel.selectedMovieDetails == MovieDetails.MovieClips
        ) {
            viewModel.setDetailsToMovieClips()
        }
    }
}

@Composable
fun MovieDetailsOption(text: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) pastelColor(MaterialTheme.colorScheme.primary) else pastelColor(MaterialTheme.colorScheme.background)

    Box(
        modifier = Modifier
            .clickable { onClick() }
            .background(color = backgroundColor)
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .width(75.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = text, style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)
        }
    }
}

@Composable
private fun pastelColor(color: Color): Color {
    // You can customize the pastel effect by adjusting the alpha value
    return color.copy(alpha = 0.5f)
}
@Composable
fun DisplayScenes(scenes: List<Int>) {
    LazyVerticalGrid(columns = GridCells.Fixed(3),
        modifier = Modifier.height(280.dp)) {
        items(scenes) { sceneResourceId ->
            Image(
                painter = painterResource(id = sceneResourceId),
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .size(110.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun DisplayActors(actors: List<Actor>) {
    LazyColumn(modifier = Modifier.height(280.dp)) {
        items(actors) { actor ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = actor.image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(80.dp)
                        .width(64.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = actor.name,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun DisplayClips(Movies: List<Int>){

}
