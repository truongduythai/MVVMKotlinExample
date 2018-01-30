package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager.AppPreference
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.activity.BaseActivity
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.activity.SecondActivity
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.activity.ViewPagerActivity
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment.ItemFragment
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment.SecondFragment
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment.ViewPagerFragment

/**
 * Created by duyth on 1/30/2018.
 */
class HomeFragmentViewModel(val context: Context, val activity: Activity) : BaseObservable() {

    fun onClickOpenActivity() {
        context.startActivity(Intent(activity, SecondActivity::class.java))
    }

    fun onClickReplaceFragment() {
        (activity as BaseActivity).replaceTopFragment(SecondFragment.newInstance())
    }

    fun onClickAddFragment(){
        (activity as BaseActivity).pushFragment(SecondFragment.newInstance())
    }

    fun onClickViewPagerInActivity(){
        context.startActivity(Intent(activity, ViewPagerActivity::class.java))
    }

    fun onClickViewPagerInFragment(){
        (activity as BaseActivity).pushFragment(ViewPagerFragment.newInstance(AppPreference.INSTANCE.dataUser!!))
    }

    fun onClickRecyclerView(){
        (activity as BaseActivity).pushFragment(ItemFragment.newInstance(AppPreference.INSTANCE.dataUser!!))
    }
}