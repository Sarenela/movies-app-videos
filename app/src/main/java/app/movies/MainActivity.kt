package app.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.movies.ui.theme.MoviesappTheme

data class Movie(val title: String, val description: String, val imageResId: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieList()
                }
            }
        }
    }
}

@Composable
fun MovieList() {
    val movies = remember {
        listOf(
            Movie("Movie 1", "Description 1", R.drawable.coraline),
            Movie("Movie 2", "Description 2", R.drawable.coraline),
            // Add more movies as needed
        )
    }

    LazyColumn {
        items(movies) { movie ->
            ClickableMovieItem(movie = movie)
        }
    }
}

@Composable
fun ClickableMovieItem(movie: Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { /* Handle movie click */ }
    ) {
        // You can use Coil or Glide to load images, but for simplicity, I'm using painterResource
        Image(
            painter = painterResource(id = movie.imageResId),
            contentDescription = null, // TODO: Provide proper content description
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = movie.title, style = MaterialTheme.typography.titleLarge)
            Text(text = movie.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieListPreview() {
    MoviesappTheme {
        MovieList()
    }
}
