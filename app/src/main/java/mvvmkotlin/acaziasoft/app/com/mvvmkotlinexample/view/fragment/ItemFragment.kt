package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.databinding.FragmentItemBinding
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.ResultsItem
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.adapter.UserAdapter


/**
 * Created by duyth on 1/29/2018.
 */
class ItemFragment : Fragment() {
    val TAG: String = javaClass.simpleName
    var items: ArrayList<ResultsItem>? = null

    var binding: FragmentItemBinding? = null

    companion object {
        fun newInstance(items: ArrayList<ResultsItem>): ItemFragment {
            var fragment = ItemFragment()
            fragment.items = items
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentItemBinding>(inflater, R.layout.fragment_item, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.rvUser.layoutManager = LinearLayoutManager(activity)
        binding!!.rvUser.setHasFixedSize(true)
        binding!!.rvUser.adapter = UserAdapter(items!!);
    }

}