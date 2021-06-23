package ayds.zeus.zeus2wikipediadata

import ayds.zeus.zeus2wikipediadata.entity.WikipediaArticle


interface WikipediaService {

    fun getArtistInfo(artistName : String): WikipediaArticle?
}