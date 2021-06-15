package ayds.zeus.wikipediadata


interface WikipediaService {

    fun getArtistInfo(artistName : String): WikipediaArticle?
}