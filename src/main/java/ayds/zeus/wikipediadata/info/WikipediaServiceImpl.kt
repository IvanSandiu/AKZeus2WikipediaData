package ayds.zeus.wikipediadata.info

import ayds.zeus.wikipediadata.WikipediaService
import ayds.zeus.wikipediadata.entity.WikipediaArticleImpl
import retrofit2.Response

internal class WikipediaServiceImpl(

    private val wikipediaApi: WikipediaAPI,
    private val wikipediaToArtistInfoResolver: WikipediaToCardResolver

) : WikipediaService {

    override fun getArtistInfo(artistName: String): WikipediaArticleImpl? {
        val callResponse = getArtistInfoFromService(artistName)
        return wikipediaToArtistInfoResolver.getArticleFromExternalData(callResponse.body())
    }

    private fun getArtistInfoFromService(query: String): Response<String> {
        return wikipediaApi.getArtistInfo(query).execute()
    }

}