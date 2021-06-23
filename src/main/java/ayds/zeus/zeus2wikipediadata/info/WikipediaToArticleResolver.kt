package ayds.zeus.zeus2wikipediadata.info

import ayds.zeus.zeus2wikipediadata.entity.WikipediaArticle
import com.google.gson.Gson
import com.google.gson.JsonObject

interface WikipediaToArticleResolver {
    fun getArticleFromExternalData(serviceData: String?): WikipediaArticle?
}

const val SEARCH = "search"
const val QUERY = "query"
const val SNIPPET = "snippet"
const val PAGE_ID = "pageid"
const val WIKIPEDIA_PREFIX_PAGE_ID = "https://en.wikipedia.org/?curid="

internal class JsonToArticleResolver: WikipediaToArticleResolver {

    override fun getArticleFromExternalData(serviceData: String?): WikipediaArticle? =
        try {
            serviceData?.getFirstItem()?.let { item ->
                WikipediaArticle(
                    item.getArtistInfo(), item.getUrl()
                )
            }
        } catch (e: Exception) {
            null
        }

    private fun String?.getFirstItem(): JsonObject{
        val jobj = Gson().fromJson(this, JsonObject::class.java)
        val query = jobj[QUERY].asJsonObject
        val search = query[SEARCH].asJsonArray
        return search[0].asJsonObject
    }

    private fun JsonObject.getArtistInfo():String{
        return this[SNIPPET].asString.replace("\\n", "\n")
    }

    private fun JsonObject.getUrl(): String{
        val pageID = this[PAGE_ID]
        return "${WIKIPEDIA_PREFIX_PAGE_ID}$pageID"
    }
}