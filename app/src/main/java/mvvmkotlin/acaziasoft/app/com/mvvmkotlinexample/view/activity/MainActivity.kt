package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager.CallServices
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.DataResponse
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.ResultsItem
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.ViewInterfaces
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.adapter.ItemFragmentViewPager
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment.ItemFragment

class MainActivity : AppCompatActivity(), ViewInterfaces.onService {

    val TAG: String = javaClass.simpleName

    var fragments = ArrayList<Fragment>()
    var adapter: ItemFragmentViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        CallServices.getData(this)
    }

    private fun initFragment(list: ArrayList<ResultsItem>) {
        for (i in 1..5) {
            fragments.add(ItemFragment.newInstance(list))
        }
    }

    private fun initView() {
        viewPager.offscreenPageLimit = 3
    }

    override fun service(objects: Any, state: Boolean) {
        if (state) {
            initFragment((objects as DataResponse).results as ArrayList<ResultsItem>)
            adapter = ItemFragmentViewPager(supportFragmentManager, fragments)
            viewPager.adapter = adapter
        } else
            Log.d(TAG, objects.toString())
    }
}
