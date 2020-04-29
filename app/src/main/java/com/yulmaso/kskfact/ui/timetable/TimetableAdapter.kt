package com.yulmaso.kskfact.ui.timetable

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.data.model.Event
import com.yulmaso.kskfact.data.model.enums.EventType
import com.yulmaso.kskfact.databinding.ItemTimetableBinding
import com.yulmaso.kskfact.utils.Constants.LOG_TAG
import com.yulmaso.kskfact.utils.Constants.timeFormat

class TimetableAdapter(
   private val userId: Long,
   private val onTimetableListener: OnTimetableListener
): RecyclerView.Adapter<TimetableAdapter.TimetableViewHolder>() {

    private val items: MutableList<Event> = ArrayList()

    interface OnTimetableListener {
        fun emptyList()
        fun notEmptyList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TimetableViewHolder(
            ItemTimetableBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), userId
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: TimetableViewHolder, position: Int) =
        holder.bind(items[position])

    fun setItems(items: List<Event>?) {
        Log.d(LOG_TAG, "on setItems() in timetableAdapter")
        if (!items.isNullOrEmpty()) {
            onTimetableListener.notEmptyList()
            this.items.apply {
                clear()
                addAll(items)
            }
            notifyDataSetChanged()
        } else {
            onTimetableListener.emptyList()
        }
    }

    class TimetableViewHolder(
        val binding: ItemTimetableBinding,
        val userId: Long
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(eventItem: Event) {
            binding.apply {
                event = eventItem
                timetableTimeStart.text = timeFormat.format(eventItem.startTime)
                timetableTimeEnd.text = timeFormat.format(eventItem.endTime)
                if (eventItem.trainer!!.id == userId)
                    timetableTrainer.setTextColor(root.resources.getColor(R.color.colorAccent))
                if (eventItem.eventType == EventType.TRAINING_ADULT) {
                    timetableLabel.setImageResource(R.drawable.ic_adults_label)
                } else {
                    timetableLabel.setImageResource(R.drawable.ic_children_label)
                }
            }
        }
    }
}