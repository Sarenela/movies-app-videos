//package app.movies.views
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import app.movies.Movie
//import app.movies.R
//
//class MainView {
//}
//
//@Composable
//fun MovieList() {
//    val movies = listOf(
//        Movie("app.movies.Movie 1", "Description 1", R.drawable.coraline, ),
//        Movie("app.movies.Movie 2", "Description 2", R.drawable.coraline),
//        Movie("app.movies.Movie 3", "Description 3", R.drawable.coraline),
//        // Add more movies as needed
//    )
//
//    LazyColumn {
//        items(movies) { movie ->
//            MyCard(
//                onClick = { /* Handle movie click */ },
//                title = movie.title,
//                description = movie.description,
//                imageResId = movie.imageResId
//            )
//        }
//    }
//}
//
//@Composable
//fun MyCard(onClick: () -> Unit, title: String, description: String, imageResId: Int) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .clickable(onClick = onClick),
//        shape = RoundedCornerShape(8.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth()
//        ) {
//            // Load the image using Coil or Glide in a real-world scenario
//            Image(
//                painter = painterResource(id = imageResId),
//                contentDescription = null, // TODO: Provide proper content description
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp) // Set an appropriate height for the image
//                    .clip(RoundedCornerShape(8.dp))
//                    .background(MaterialTheme.colorScheme.primary)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = title, style = MaterialTheme.typography.titleLarge)
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = description, style = MaterialTheme.typography.bodyLarge)
//        }
//    }
//}