package com.alis.boilerplate.utils

import android.widget.Filter

open class SimpleFilter : Filter() {

    override fun performFiltering(constraint: CharSequence?): FilterResults = FilterResults()

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

    }
}