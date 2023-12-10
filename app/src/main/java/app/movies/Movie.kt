package app.movies


data class Actor (val image: Int, val name: String)

data class Movie(val title: String, val description: String, val cover: Int, val cast: List<Actor>, val scenes_images: List<Int>, val trailers: List<Int>)

fun getBestMovies():List<Movie>{
    return listOf(
        Movie(
            title = "Coraline",
            description = "\"Coraline\" is a dark fantasy film about a young girl who discovers a parallel world that seems perfect at first but hides sinister secrets. As she navigates this mysterious realm, Coraline must confront the dark forces threatening her and her loved ones",
            cast = listOf(
                Actor( R.drawable.coraline_dakota_fanning, "Dakota Fanning"),
                Actor( R.drawable.coraline_john_hodgman, "John Hodgman"),
                Actor( R.drawable.coraline_dawn_french, "Dawn French"),
                Actor( R.drawable.coraline_robert_bailey, "Robert Bailey Jr.")),
            cover = R.drawable.coraline_cover,
            scenes_images = listOf(
                R.drawable.coraline_scene1,
                R.drawable.coraline_scene2,
                R.drawable.coraline_scene3,
                R.drawable.coraline_scene4,
                R.drawable.coraline_scene5,
                R.drawable.coraline_scene6,
                R.drawable.coraline_scene7,
                R.drawable.coraline_scene8,
                R.drawable.coraline_scene9),
            trailers = listOf(
                R.raw.coraline1)),
        Movie(
            title = "Everything Everywhere all at once",
            description = "Mind-bending science fiction film that follows a seemingly ordinary woman who discovers the existence of parallel universes, propelling her into a cosmic adventure to save her family and the reality itself. The film is known for its inventive storytelling and visually stunning sequences.",
            cast = listOf(
                Actor( R.drawable.everything_michelle_yeoh, "Michelle Yeoh"),
                Actor( R.drawable.everything_stephanie_hsu, "Stephanie Hsu"),
                Actor( R.drawable.everything_ke_huy, "Ke Huy Quan"),
                Actor( R.drawable.everything_jamie_lee, "Jamie Lee Curtis"),
                Actor( R.drawable.everything_tallie_medel, "Tallie Medel")),
            cover = R.drawable.everything_cover,
            scenes_images = listOf(
                R.drawable.everything_scene1,
                R.drawable.everything_scene2,
                R.drawable.everything_scene3,
                R.drawable.everything_scene4,
                R.drawable.everything_scene5,
                R.drawable.everything_scene6,
                R.drawable.everything_scene7,
                R.drawable.everything_scene8,
                R.drawable.everything_scene9,),
            trailers = listOf(
                R.raw.everyhing1)),
        Movie(
            title = "Beetlejuice",
            description = "In the quirky fantasy film \"Beetlejuice,\" a recently deceased couple seeks the help of an eccentric ghost, Beetlejuice, to navigate the afterlife. As they grapple with the challenges of the supernatural realm, the film captivates with its offbeat humor and imaginative storytelling. ",
            cast = listOf(
                Actor( R.drawable.beetlejuice_michael_keaton, "Michael Keaton"),
                Actor( R.drawable.beetlejuice_winona_ryder, "Winona Ryder"),
                Actor( R.drawable.beetlejuice_alec_baldwin, "Alec Baldwin"),
                Actor( R.drawable.beetlejuice_geena_davis, "Geena Davis"),
                Actor( R.drawable.beetlejuice_annie_mcenroe, "Annie McEnroe"),
                Actor( R.drawable.beetlejuice_catherine_ohara, "Catherine O'Hara")),
            cover = R.drawable.beetlejuice_cover,
            scenes_images = listOf(
                R.drawable.beetlejuice_scene1,
                R.drawable.beetlejuice_scene2,
                R.drawable.beetlejuice_scene3,
                R.drawable.beetlejuice_scene4,
                R.drawable.beetlejuice_scene5,
                R.drawable.beetlejuice_scene6,
                R.drawable.beetlejuice_scene7,
                R.drawable.beetlejuice_scene8,
                R.drawable.beetlejuice_scene9),
            trailers = listOf(
                R.raw.beetlejuice1)
        )
    )
}