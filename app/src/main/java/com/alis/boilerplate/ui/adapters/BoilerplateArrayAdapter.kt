package com.alis.boilerplate.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import com.alis.boilerplate.databinding.ItemBoilerplateBinding
import com.alis.boilerplate.models.Boilerplate
import com.alis.boilerplate.utils.SimpleFilter

class BoilerplateArrayAdapter(
    context: Context,
    resource: Int,
    private val objects: MutableList<Boilerplate>
) : ArrayAdapter<Boilerplate>(context, resource, objects), Filterable {

    override fun getCount(): Int = objects.size

    override fun getItem(position: Int): Boilerplate? = objects[position]

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getDropDownView(position, convertView, parent)
    }

    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemBoilerplateBinding.inflate(LayoutInflater.from(context), parent, false)

        val data = objects[position]

        binding.apply {
            textItemBoilerplate.text = data.foo
        }

        return binding.root
    }

    override fun getFilter(): Filter {
        return object : SimpleFilter() {
            override fun convertResultToString(resultValue: Any?): CharSequence {
                return (resultValue as Boilerplate).foo
            }
        }
    }
}