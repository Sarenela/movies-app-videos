package app.movies


data class Actor (val image: Int, val name: String)

data class Movie(val title: String, val description: String, val cover: Int, val cast: List<Actor>, val scenes_images: List<Int>)

fun getBestMovies():List<Movie>{
    return listOf(
        Movie(
            title = "Coraline",
            description = "'Coraline' is a dark fantasy film about a young girl who discovers a parallel world that seems perfect at first but hides sinister secrets. As she navigates this mysterious realm, Coraline must confront the dark forces threatening her and her loved ones",
            cast = listOf(Actor( R.drawable.coraline, ""), Actor( R.drawable.coraline, "")),
            cover = R.drawable.coraline,
            scenes_images = listOf(
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline)),
        Movie(
            title = "Everything Everywhere all at once",
            description = "'Coraline' is a dark fantasy film about a young girl who discovers a parallel world that seems perfect at first but hides sinister secrets. As she navigates this mysterious realm, Coraline must confront the dark forces threatening her and her loved ones",
            cast = listOf(Actor( R.drawable.coraline, ""), Actor( R.drawable.coraline, "")),
            cover = R.drawable.coraline,
            scenes_images = listOf(
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,)),
        Movie(
            title = "Beetlejuice",
            description = "'Coraline' is a dark fantasy film about a young girl who discovers a parallel world that seems perfect at first but hides sinister secrets. As she navigates this mysterious realm, Coraline must confront the dark forces threatening her and her loved ones",
            cast = listOf(Actor( R.drawable.coraline, ""), Actor( R.drawable.coraline, "")),
            cover = R.drawable.coraline,
            scenes_images = listOf(
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline,
                R.drawable.coraline)
        )
    )
}