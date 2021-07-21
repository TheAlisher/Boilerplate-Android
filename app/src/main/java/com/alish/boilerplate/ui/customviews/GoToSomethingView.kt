package com.alish.boilerplate.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.alish.boilerplate.R
import com.alish.boilerplate.databinding.ViewGoToSomethingBinding

class GoToSomethingView : FrameLayout, View.OnClickListener {

    private val binding =
        ViewGoToSomethingBinding.inflate(LayoutInflater.from(context), this, true)

    private var listener: OnClickListener? = null

    constructor(context: Context) : super(context) {
        setupOnClickListener()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setupOnClickListener()
        setupAttributes(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        setupOnClickListener()
        setupAttributes(attrs)
    }

    private fun setupOnClickListener() {
        super.setOnClickListener(this)
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.GoToSomethingView, 0, 0)

        binding.apply {
            imageGoToSomething.setImageResource(
                typedArray.getResourceId(R.styleable.GoToSomethingView_icon, 0)
            )
            textGoToSomethingTitle.text = typedArray.getText(R.styleable.GoToSomethingView_title)
            textGoToSomethingDescription.text =
                typedArray.getText(R.styleable.GoToSomethingView_description)
        }
    }

    override fun onClick(v: View?) {
        listener?.onClick(v)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        binding.root.setOnClickListener(l)
    }
}