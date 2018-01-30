package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by duyth on 1/29/2018.
 */
class ApiClient {
    companion object {
        var retrofit: Retrofit? = null

        fun getClient(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(AppConfig.api)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!
        }

        fun getService(): ApiInterfaces {
            return getClient().create(ApiInterfaces::class.java)
        }
    }
}
