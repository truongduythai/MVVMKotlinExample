package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


/**
 * Created by duyth on 1/29/2018.
 */
class ItemFragmentViewPager(fm: FragmentManager, val lists: ArrayList<Fragment>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return lists[position];
    }

    override fun getCount(): Int {
        return 5;
    }
}