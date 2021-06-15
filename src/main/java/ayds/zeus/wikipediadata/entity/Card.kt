package ayds.zeus.wikipediadata.entity

interface Card {
    val descripcion: String
    val url: String
    var isLocallyStoraged:Boolean
    var source: Int
    var sourceLogo: String
}

data class CardImpl(
    override val descripcion: String,
    override val url: String,
    override var isLocallyStoraged: Boolean = false,
    override var source: Int,
    override var sourceLogo: String
): Card

object EmptyCard : Card {
    override val descripcion: String = ""
    override val url: String = ""
    override var isLocallyStoraged: Boolean = false
    override var source: Int = 0
    override var sourceLogo: String = ""
}