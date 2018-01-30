package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.databinding.ItemRvBinding
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model.ResultsItem
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.viewmodel.ItemRvViewModel

/**
 * Created by duyth on 1/29/2018.
 */
class UserAdapter(private val users: ArrayList<ResultsItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemRvBinding>(LayoutInflater.from(parent!!.context), R.layout.item_rv, parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result: ResultsItem) {
            binding.dataUser = ItemRvViewModel(result, binding.root.context)
            binding.executePendingBindings()
        }

    }
}