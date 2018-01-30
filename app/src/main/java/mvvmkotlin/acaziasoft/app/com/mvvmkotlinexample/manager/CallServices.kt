package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.ViewInterfaces

/**
 * Created by duyth on 1/29/2018.
 */
class CallServices {
    companion object {
        fun getData(service: ViewInterfaces.onService) {
            ApiClient.getService().getData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { t -> service.service(t, true) },
                            { t -> service.service(t.toString(), false) }
                    )
        }
    }
}