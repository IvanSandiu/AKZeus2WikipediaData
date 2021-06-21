package ayds.zeus.wikipediadata

import ayds.zeus.wikipediadata.entity.WikipediaArticle


interface WikipediaService {

    fun getArtistInfo(artistName : String): WikipediaArticle?
}