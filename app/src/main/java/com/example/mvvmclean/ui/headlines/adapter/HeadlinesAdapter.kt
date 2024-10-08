package com.example.mvvmclean.ui.headlines.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mvvmclean.databinding.ItemHeadlinesViewBinding
import com.example.mvvmclean.base.BaseItemListener
import com.example.mvvmclean.base.BaseRecyclerViewAdapter
import com.example.mvvmclean.base.BaseViewHolder
import com.example.mvvmclean.domain.model.mainmodels.TopHeadlines

class HeadlinesAdapter (
    val context: Context,
    val headlines: ArrayList<TopHeadlines>,
    val clickListener: BaseItemListener<TopHeadlines>
) : BaseRecyclerViewAdapter<TopHeadlines>(headlines,clickListener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return  IntroSliderViewHolder(
            ItemHeadlinesViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return headlines.size
    }

    inner class IntroSliderViewHolder(private val mBinding: ItemHeadlinesViewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            val headLine = headlines[position]
            mBinding.topHeadline = headLine
            itemView.setOnClickListener {
                clickListener.onItemClick(headLine)
            }
            mBinding.executePendingBindings()
        }
    }

}