package ayds.zeus.wikipediadata.info

import ayds.zeus.wikipediadata.entity.WikipediaArticleImpl
import com.google.gson.Gson
import com.google.gson.JsonObject

interface WikipediaToCardResolver {
    fun getArticleFromExternalData(serviceData: String?): WikipediaArticleImpl?
}

const val SEARCH = "search"
const val QUERY = "query"
const val SNIPPET = "snippet"
const val PAGE_ID = "pageid"
const val WIKIPEDIA_PREFIX_PAGE_ID = "https://en.wikipedia.org/?curid="

internal class JsonToCardResolver: WikipediaToCardResolver {

    override fun getArticleFromExternalData(serviceData: String?): WikipediaArticleImpl? =
        try {
            serviceData?.getFirstItem()?.let { item ->
                WikipediaArticleImpl(
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