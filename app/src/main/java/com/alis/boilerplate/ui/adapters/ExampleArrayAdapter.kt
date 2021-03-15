package com.alis.boilerplate.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import com.alis.boilerplate.databinding.ItemExampleBinding
import com.alis.boilerplate.models.ExampleData
import com.alis.boilerplate.utils.SimpleFilter

class ExampleArrayAdapter(
    context: Context,
    resource: Int,
    private val objects: MutableList<ExampleData>
) : ArrayAdapter<ExampleData>(
    context,
    resource,
    objects
), Filterable {

    override fun getCount(): Int = objects.size

    override fun getItem(position: Int): ExampleData? = objects[position]

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemExampleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        val data = objects[position]

        binding.apply {
            textExampleTitle.text = data.title
            textExampleDescription.text = data.description
        }

        return binding.root
    }

    override fun getFilter(): Filter {
        return object : SimpleFilter() {

            override fun convertResultToString(resultValue: Any?): CharSequence {
                return (resultValue as ExampleData).title
            }

            override fun performFiltering(constraint: CharSequence?): FilterResults {
                return FilterResults()
            }
        }
    }
}