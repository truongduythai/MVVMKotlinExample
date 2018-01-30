package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.viewmodel

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.ResultsItem

/**
 * Created by duyth on 1/29/2018.
 */
class ItemRvViewModel(val user: ResultsItem, val context: Context) : BaseObservable() {
    val name: String
        get() {
            return user.name!!.first + " " + user.name.last
        }

    val email: String
        get() {
            return user.email!!
        }

    val location: String
        get() {
            return user.location!!.street + " " + user.location.state + " " + user.location.city
        }

    val picture: String
        get() {
            return user.picture?.thumbnail!!
        }

    companion object {
        @JvmStatic
        @BindingAdapter("bind:imageUrl")
        fun loadImage(view: ImageView, url: String) {
            Glide.with(view.context).asBitmap().load(url).into(view)
        }
    }

}