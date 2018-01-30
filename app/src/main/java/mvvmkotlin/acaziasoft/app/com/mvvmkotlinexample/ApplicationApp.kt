package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager.FontManager

/**
 * Created by duyth on 1/29/2018.
 */
class ApplicationApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        FontManager.init(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}