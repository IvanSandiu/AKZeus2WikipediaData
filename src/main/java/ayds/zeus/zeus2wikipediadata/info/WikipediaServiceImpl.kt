package ayds.zeus.zeus2wikipediadata.info

import ayds.zeus.zeus2wikipediadata.WikipediaService
import ayds.zeus.zeus2wikipediadata.entity.WikipediaArticle
import retrofit2.Response

internal class WikipediaServiceImpl(

    private val wikipediaApi: WikipediaAPI,
    private val wikipediaToArtistInfoResolver: WikipediaToArticleResolver

) : WikipediaService {

    override fun getArtistInfo(artistName: String): WikipediaArticle? {
        val callResponse = getArtistInfoFromService(artistName)
        return wikipediaToArtistInfoResolver.getArticleFromExternalData(callResponse.body())
    }

    private fun getArtistInfoFromService(query: String): Response<String> {
        return wikipediaApi.getArtistInfo(query).execute()
    }

}