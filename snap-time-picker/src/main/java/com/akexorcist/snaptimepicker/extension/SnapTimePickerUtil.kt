package com.akexorcist.snaptimepicker.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@Suppress("unused")
object SnapTimePickerUtil {
    fun observe(activity: FragmentActivity, onPickedEvent: (hour: Int, minute: Int) -> Unit): Unit =
        ViewModelProvider(activity)
            .get(SnapTimePickerViewModel::class.java)
            .timePickedEvent
            .observe(activity) { event: TimePickedEvent ->
                onPickedEvent(event.hour, event.minute)
            }

    fun observe(fragment: Fragment, onPickedEvent: (hour: Int, minute: Int) -> Unit) =
        ViewModelProvider(fragment)
            .get(SnapTimePickerViewModel::class.java)
            .timePickedEvent
            .observe(fragment) { event: TimePickedEvent ->
                onPickedEvent(event.hour, event.minute)
            }
}

fun RecyclerView?.getCurrentPosition() : Int {
    return (this?.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
}
