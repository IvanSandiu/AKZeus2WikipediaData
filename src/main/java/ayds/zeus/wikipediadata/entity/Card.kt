package ayds.zeus.wikipediadata.entity

const val WIKIPEDIA_LOGO = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Wikipedia-logo-v2-es.png"
const val SOURCE_WIKIPEDIA = 1

interface Card {
    val descripcion: String
    val url: String
    val source: Int
    val sourceLogo: String
}

data class CardImpl(
    override val descripcion: String,
    override val url: String,
    override val source: Int = SOURCE_WIKIPEDIA,
    override val sourceLogo: String = WIKIPEDIA_LOGO
): Card

object EmptyCard : Card {
    override val descripcion: String = ""
    override val url: String = ""
    override val source: Int = 0
    override val sourceLogo: String = ""
}