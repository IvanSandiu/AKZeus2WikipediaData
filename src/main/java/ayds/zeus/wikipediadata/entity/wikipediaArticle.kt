package ayds.zeus.wikipediadata.entity

const val WIKIPEDIA_LOGO = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Wikipedia-logo-v2-es.png"


interface WikipediaArticle {
    val descripcion: String
    val url: String
    val sourceLogo: String
}

data class WikipediaArticleImpl(
    override val descripcion: String,
    override val url: String,
    override val sourceLogo: String = WIKIPEDIA_LOGO
): WikipediaArticle

