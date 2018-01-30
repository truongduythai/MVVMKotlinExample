package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager

import io.reactivex.Observable
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.DataResponse
import retrofit2.http.GET

/**
 * Created by duyth on 1/29/2018.
 */
interface ApiInterfaces {
    @GET("api/?results=20")
    fun getData(): Observable<DataResponse>
}