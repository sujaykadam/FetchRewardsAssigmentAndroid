import com.example.fetchrewardsassigmentandroid.data.api.ApiService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitInstance {
    private val gson = GsonBuilder()
        .registerTypeAdapter(String::class.java, StringAdapter())
        .create()
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://hiring.fetch.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }
}
