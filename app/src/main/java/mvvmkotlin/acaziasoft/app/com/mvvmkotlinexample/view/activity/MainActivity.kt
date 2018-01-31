package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment.HomeFragment
import java.util.*

class MainActivity : BaseActivity() {
    private var fragments: Stack<Fragment>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        pushFragment(HomeFragment.newInstance(), -1)
    }

    private fun init() {
        if (fragments == null)
            fragments = Stack()
        initData(this, fragments!!)
    }
}
