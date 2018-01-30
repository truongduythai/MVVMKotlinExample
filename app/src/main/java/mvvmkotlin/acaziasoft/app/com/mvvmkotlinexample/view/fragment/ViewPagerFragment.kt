package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.databinding.ActivityFragmentViewpagerBinding
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.ResultsItem
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.adapter.ItemFragmentViewPager

/**
 * Created by duyth on 1/30/2018.
 */
class ViewPagerFragment : BaseFragment() {
    var fragments = ArrayList<Fragment>()
    var binding: ActivityFragmentViewpagerBinding? = null
    var users: ArrayList<ResultsItem>? = null

    val TAG: String = javaClass.simpleName

    companion object {
        fun newInstance(users: ArrayList<ResultsItem>): ViewPagerFragment {
            val fragment = ViewPagerFragment()
            fragment.users = users
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_fragment_viewpager, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment(users!!)
        val adapter = ItemFragmentViewPager(childFragmentManager, fragments)
        binding!!.viewPager.adapter = adapter
    }

    private fun initFragment(list: ArrayList<ResultsItem>) {
        for (i in 1..5) {
            fragments.add(ItemFragment.newInstance(list))
        }
    }

}