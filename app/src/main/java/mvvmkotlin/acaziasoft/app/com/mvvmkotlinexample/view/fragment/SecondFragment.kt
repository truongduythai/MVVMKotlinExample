package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.databinding.FragmentSecondBinding

/**
 * Created by duyth on 1/30/2018.
 */
class SecondFragment : BaseFragment() {

    var binding: FragmentSecondBinding? = null

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        return binding!!.root
    }
}