package ayds.zeus.wikipediadata

import ayds.zeus.wikipediadata.entity.Card


interface WikipediaService {

    fun getArtistInfo(artistName : String): Card?
}