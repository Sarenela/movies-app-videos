package app.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.movies.Actor
import app.movies.R
import app.movies.Movie
import app.movies.MovieDetails
import app.movies.MovieViewModel
import app.movies.getBestMovies

@Composable
fun MovieView(navController: NavController, viewModel: MovieViewModel = remember { MovieViewModel() }, title: String){

    if (title == "") {
        navController.popBackStack()
        return
    }

    val movie = getBestMovies().find { it.title == title }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // app.movies.Movie Details Header
        MovieDetailsHeader(movie!!)

        // app.movies.Movie Details Options (Scenes or Actors)
        MovieDetailsOptions(viewModel)

        // Display Scenes or Actors based on selection
        when (viewModel.selectedMovieDetails) {
            MovieDetails.Scenes -> DisplayScenes(movie!!.scenes_images)
            MovieDetails.Actors -> DisplayActors(movie!!.cast)
        }
    }
}

@Composable
fun MovieDetailsHeader(selectedMovie: Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { /* Handle back button click */ }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        }
        Text(text = selectedMovie.title, style = MaterialTheme.typography.titleLarge)
        // Add any other header elements as needed
    }
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
            text = "Details",
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
    }
}

@Composable
fun MovieDetailsOption(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
            )
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = text, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun DisplayScenes(scenes: List<Int>) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(scenes) { sceneResourceId ->
            Image(
                painter = painterResource(id = sceneResourceId),
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun DisplayActors(actors: List<Actor>) {
    LazyColumn {
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
                        .size(48.dp)
                        .clip(RoundedCornerShape(24.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = actor.name,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
