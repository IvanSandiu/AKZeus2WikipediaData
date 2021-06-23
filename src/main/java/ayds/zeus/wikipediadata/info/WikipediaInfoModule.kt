package ayds.zeus.wikipediadata.info


import ayds.zeus.wikipediadata.WikipediaService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

internal object WikipediaInfoModule {

    private const val WIKIPEDIA_URL = "https://en.wikipedia.org/w/"
    private val wikipediaAPIretrofit = Retrofit.Builder()
            .baseUrl(WIKIPEDIA_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    private val wikipediaInfoAPI = wikipediaAPIretrofit.create(WikipediaAPI::class.java)
    private val WIKIPEDIA_TO_ARTICLE_RESOLVER: WikipediaToArticleResolver = JsonToArticleResolver()

    val wikipediaInfoService: WikipediaService = WikipediaServiceImpl(
            wikipediaInfoAPI,
            WIKIPEDIA_TO_ARTICLE_RESOLVER
    )
}