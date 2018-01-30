package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.databinding.FragmentHomeBinding
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager.AppPreference
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager.CallServices
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.DataResponse
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.ResultsItem
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.ViewInterfaces
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.viewmodel.HomeFragmentViewModel

/**
 * Created by duyth on 1/30/2018.
 */
class HomeFragment : BaseFragment(), ViewInterfaces.onService {
    var binding: FragmentHomeBinding? = null

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding!!.clickEvent = HomeFragmentViewModel(context!!, activity!!)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CallServices.getData(this)
    }

    override fun service(objects: Any, state: Boolean) {
        if (state) {
            AppPreference.INSTANCE.setDataUsers((objects as DataResponse).results as ArrayList<ResultsItem>)
        }
    }

}