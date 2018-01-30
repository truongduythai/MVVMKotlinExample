package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.databinding.ActivityFragmentViewpagerBinding
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager.AppPreference
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager.CallServices
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.DataResponse
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.ResultsItem
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.ViewInterfaces
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.adapter.ItemFragmentViewPager
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment.ItemFragment
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.viewmodel.ActivityFragmentViewModel

/**
 * Created by duyth on 1/30/2018.
 */
class ViewPagerActivity : BaseActivity() {
    var fragments = ArrayList<Fragment>()
    val TAG: String = javaClass.simpleName
    var binding: ActivityFragmentViewpagerBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fragment_viewpager)
        initFragment(AppPreference.INSTANCE.dataUser!!)
        val adapter = ItemFragmentViewPager(supportFragmentManager,fragments)
        binding!!.viewPager.adapter = adapter
    }

    private fun initFragment(list: ArrayList<ResultsItem>) {
        for (i in 1..5) {
            fragments.add(ItemFragment.newInstance(list))
        }
    }

}