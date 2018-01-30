package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager

import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.ResultsItem

enum class AppPreference {
    INSTANCE;

    var dataUser: ArrayList<ResultsItem>? = null

    fun setDataUsers(data: ArrayList<ResultsItem>) {
        this.dataUser = data
    }
}