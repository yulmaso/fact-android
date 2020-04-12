package com.yulmaso.kskfact.ui.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.databinding.FragmentTimetableBinding
import com.yulmaso.kskfact.ui.BaseFragment

class TimetableFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTimetableBinding>(
            inflater, R.layout.fragment_timetable, container, false
        )
        return binding.root
    }

}