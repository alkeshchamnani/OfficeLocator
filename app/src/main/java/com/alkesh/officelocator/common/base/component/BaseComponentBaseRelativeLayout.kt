package com.alkesh.officelocator.common.base.component

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.util.SparseArray
import android.widget.RelativeLayout

abstract class BaseComponentBaseRelativeLayout :
    RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    public override fun onSaveInstanceState(): Parcelable? {
        val superState = super.onSaveInstanceState()
        val ss = SavedState(superState!!)
        ss.childrenStates = SparseArray()
        for (i in 0 until childCount) {
            getChildAt(i).saveHierarchyState(ss.childrenStates as SparseArray<Parcelable>)
        }
        return ss
    }

    public override fun onRestoreInstanceState(state: Parcelable) {
        if (state is SavedState) {
            val ss = state
            super.onRestoreInstanceState(ss.superState)
            for (i in 0 until childCount) {
                getChildAt(i).restoreHierarchyState(ss.childrenStates as SparseArray<Parcelable>)
            }
        } else {
            super.onRestoreInstanceState(state)
        }

    }

    override fun dispatchSaveInstanceState(container: SparseArray<Parcelable>) {
        dispatchFreezeSelfOnly(container)
    }

    override fun dispatchRestoreInstanceState(container: SparseArray<Parcelable>) {

        dispatchThawSelfOnly(container)

    }

    companion object {

        class SavedState : BaseSavedState {
            var childrenStates: SparseArray<Any>? = null

            constructor(superState: Parcelable) : super(superState)

            constructor(parcel: Parcel?, classLoader: ClassLoader?) : super(parcel) {
                childrenStates = parcel?.readSparseArray(classLoader)
            }
        }
    }

}