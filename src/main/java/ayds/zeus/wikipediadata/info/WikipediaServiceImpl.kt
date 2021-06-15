package ayds.zeus.wikipediadata.info

import ayds.zeus.songinfo.moredetails.model.entities.WikipediaArticle
import ayds.zeus.wikipediadata.WikipediaService
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