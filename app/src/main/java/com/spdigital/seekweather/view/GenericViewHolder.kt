package com.spdigital.seekweather.view

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class GenericViewHolder<out V : ViewDataBinding>(private val viewDataBinding: V) :
    RecyclerView.ViewHolder(viewDataBinding.root) {

    fun getBinding(): V {
        return viewDataBinding
    }

}