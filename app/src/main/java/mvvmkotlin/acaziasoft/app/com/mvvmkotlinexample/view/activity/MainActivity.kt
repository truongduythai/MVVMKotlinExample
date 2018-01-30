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
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment.HomeFragment
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment.ItemFragment
import java.util.*

class MainActivity : BaseActivity() {
    private var fragments: Stack<Fragment>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        pushFragment(HomeFragment.newInstance(), 0)
    }

    private fun init() {
        if (fragments == null)
            fragments = Stack()
        initData(this, fragments!!)
    }
}
