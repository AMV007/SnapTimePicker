package com.akexorcist.snaptimepicker

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class ZoomCenterCardLayoutManager(context: Context?) :
    LinearLayoutManager(context) {
    // Shrink the cards around the center up to 50%
    private val mShrinkAmount = 0.13f

    // The cards will be at 50% when they are 75% of the way between the
    // center and the edge.
    private val mShrinkDistance = 0.5f
    override fun scrollVerticallyBy(
        dx: Int,
        recycler: Recycler, state: RecyclerView.State
    ): Int {
        val scrolled = super.scrollVerticallyBy(dx, recycler, state)
        val midpoint = height / 2f
        val d0 = 0f
        val d1 = mShrinkDistance * midpoint
        val s0 = 1f
        val s1 = 1f - mShrinkAmount
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val childMidpoint = (getDecoratedTop(child!!) + getDecoratedBottom(child)) / 2f
            val d = Math.min(d1, Math.abs(midpoint - childMidpoint))
            val scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0)
            child.scaleX = scale
            child.scaleY = scale
        }
        return scrolled
    }

    override fun onLayoutChildren(recycler: Recycler, state: RecyclerView.State) {
        super.onLayoutChildren(recycler, state)
        scrollHorizontallyBy(0, recycler, state)
    }
}