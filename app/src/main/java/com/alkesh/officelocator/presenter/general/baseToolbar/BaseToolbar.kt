package com.alkesh.officelocator.presenter.general.baseToolbar

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.alkesh.officelocator.R
import com.alkesh.officelocator.common.base.component.BaseComponentBaseRelativeLayout
import kotlinx.android.synthetic.main.component_toolbar.view.*

class BaseToolbar : BaseComponentBaseRelativeLayout {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    constructor(
        context: Context,
        attributeSet: AttributeSet?,
        defaultStyleAttributeId: Int
    ) : super(context, attributeSet, defaultStyleAttributeId) {
        init()
        initAttributes(attributeSet)
    }

    private fun init() {
        inflate(context, R.layout.component_toolbar, this)
        setView()
        setEvents()
    }

    private fun initAttributes(attrs: AttributeSet?) {
        val styledAttributes =
            context.obtainStyledAttributes(attrs, R.styleable.BaseToolbarAttributes)

        val title = styledAttributes.getString(R.styleable.BaseToolbarAttributes_title)
        val titleColor =
            styledAttributes.getColor(R.styleable.BaseToolbarAttributes_titleColor, Color.WHITE)
        val toolbarBackgroundColor = styledAttributes.getColor(
            R.styleable.BaseToolbarAttributes_tootlbarBackgroundColor,
            Color.TRANSPARENT
        )

        styledAttributes.recycle()
        if (!title.isNullOrEmpty()) {
            setTitle(title)
        }
        setTitleColor(titleColor)
        setToolbarBackgroundColor(toolbarBackgroundColor)

    }


    fun setup(activity: AppCompatActivity, title: String, enableBack: Boolean) {
        toolbarStartIV.visibility = View.INVISIBLE
        toolbarEndIv.visibility = View.INVISIBLE

        if (enableBack) {
            toolbarStartIV.visibility = View.VISIBLE
            toolbarStartIV.setOnClickListener(OnClickListener {
                // activity.onBackPressed()
                activity.onBackPressed()
            })
        }
        setTitle(title)
    }

    fun addDrawableStart(drawable: Drawable?): View {
        drawable?.let {
            toolbarStartIV.visibility = View.VISIBLE
            toolbarStartIV.background = drawable
        }
        return toolbarStartIV
    }

    fun addDrawableEnd(drawable: Drawable?): View {
        drawable?.let {
            toolbarEndIv.visibility = View.VISIBLE
            toolbarEndIv.background = drawable
        }
        return toolbarEndIv
    }


    fun setTitle(title: String) {
        toolbarTitle.text = title
    }

    fun setTitleColor(color: Int) {
        toolbarTitle.setTextColor(color)
    }

    fun setToolbarBackgroundColor(color: Int) {
        toolbarBackground.setBackgroundColor(color)
    }


    private fun setView() {
    }

    private fun setEvents() {
    }
}