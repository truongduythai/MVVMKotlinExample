package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.activity

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R
import java.util.*


/**
 * Created by duyth on 11/30/2017.
 */

open class BaseActivity : AppCompatActivity() {
    private var fragments: Stack<Fragment>? = null
    private val TAG = javaClass.simpleName
    private var activity: Activity? = null

    fun initData(activity: Activity, fragments: Stack<Fragment>) {
        this.fragments = fragments
        this.activity = activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_up, R.anim.hold)
    }

    @JvmOverloads
    fun pushFragment(fragment: Fragment, animateIn: Int = R.anim.slide_up) {
        fragments!!.push(fragment)
        val ft = supportFragmentManager.beginTransaction()
        if (animateIn != -1) {
            ft.setCustomAnimations(animateIn, 0, 0, R.anim.slide_down)
        }
        try {
            try {
                ft.add(R.id.layout_main, fragment, fragment.javaClass.name)
                        .addToBackStack(fragment.javaClass.simpleName).commitAllowingStateLoss()
                supportFragmentManager.executePendingTransactions()
            } catch (e: Exception) {
                Log.e(TAG, e.message)
            }

        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }

    }

    @JvmOverloads
    fun popFragment(animateOut: Int = R.anim.slide_down, depth: Int = 1) {
        var depth = depth
        if (this == null) {
            return
        }
        if (depth < 1) {
            return
        }
        val currentFragment = if (fragments!!.isEmpty()) null else fragments!!.peek()

        if (fragments!!.size < 2) {
            onfinish(R.anim.slide_down)
            return
        }

        while (depth > 0) {
            if (!fragments!!.empty())
                fragments!!.pop()
            depth--
            if (fragments!!.size < 2) {
                break
            }
        }

        val fragment = fragments!!.peek()
        val ft = supportFragmentManager.beginTransaction()
        if (currentFragment != null) {
            if (animateOut != -1) {
                ft.setCustomAnimations(0, animateOut)
            }
            ft.remove(currentFragment)
        }
        ft.replace(R.id.layout_main, fragment, fragment.javaClass.name)
                .addToBackStack(null).commitAllowingStateLoss()
        if (this == null) {
            return
        }

        supportFragmentManager.executePendingTransactions()
    }

    @JvmOverloads
    fun replaceTopFragment(fragment: Fragment, animateIn: Int) {
        if (fragments!!.isEmpty()) {
            pushFragment(fragment, animateIn)
            return
        }
        val currentFragment = fragments!!.pop()
        fragments!!.add(fragment)
        supportFragmentManager
                .beginTransaction().setCustomAnimations(R.anim.slide_up, 0)
                .remove(currentFragment)
                .add(R.id.layout_main, fragment, fragment.javaClass.name)
                .addToBackStack(null).commit()
        supportFragmentManager.executePendingTransactions()
    }

    @JvmOverloads
    fun replaceTopFragment(fragment: Fragment) {
        replaceTopFragment(fragment, R.anim.slide_down)
    }

    override fun onBackPressed() {
        if (fragments != null) {
            if (fragments!!.size > 1) {
                popFragment(R.anim.slide_down, 1)
                return
            } else
                checkBackstack()
        } else
            checkBackstack()

    }

    private fun checkBackstack() {
        onfinish(R.anim.slide_down)
    }

    fun onfinish(animationOut: Int) {
        finish()
        overridePendingTransition(R.anim.hold, animationOut)
    }

}
