package com.alish.boilerplate.presentation.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import com.alish.boilerplate.databinding.ItemFooBinding
import com.alish.boilerplate.domain.models.Foo

class FooArrayAdapter(
    context: Context,
    resource: Int,
    private val objects: MutableList<Foo>
) : ArrayAdapter<Foo>(context, resource, objects), Filterable {

    override fun getCount(): Int = objects.size

    override fun getItem(position: Int): Foo = objects[position]

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, parent)
    }

    private fun getCustomView(position: Int, parent: ViewGroup): View {
        val binding = ItemFooBinding.inflate(LayoutInflater.from(context), parent, false)

        val data = objects[position]

        binding.apply {
            textItemFoo.text = data.bar
        }

        return binding.root
    }

    override fun getFilter(): Filter {
        return object : SimpleFilter() {
            override fun convertResultToString(resultValue: Any?): CharSequence {
                return (resultValue as Foo).bar
            }
        }
    }

    open class SimpleFilter : Filter() {

        override fun performFiltering(constraint: CharSequence?): FilterResults = FilterResults()

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        }
    }
}