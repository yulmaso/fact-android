package com.yulmaso.kskfact.ui.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.yulmaso.kskfact.databinding.FragmentTimetableBinding
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseFragment
import com.yulmaso.kskfact.ui.RequestListener
import com.yulmaso.kskfact.ui.dialogFragments.NewEventDialogFragment

class TimetableFragment : BaseFragment(), RequestListener, TimetableNavigator,
    TimetableAdapter.OnTimetableListener {

    private lateinit var viewModel: TimetableViewModel
    private lateinit var adapter: TimetableAdapter

    private var binding: FragmentTimetableBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.navigator = this
        viewModel.requestListener = this
        viewModel.updateData()

        adapter = TimetableAdapter(viewModel.userId, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimetableBinding.inflate(
            inflater, container, false
        )
        binding!!.apply {
            viewmodel = viewModel
            timetableRv.adapter = adapter
        }

        viewModel.events.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
        })

        return binding!!.root
    }

    override fun newEvent() {
        val newEventDialog = NewEventDialogFragment()
        newEventDialog.show(childFragmentManager, "New event dialog")
    }

    override fun emptyList() {
        binding?.timetableNoItemsYet!!.visibility = View.VISIBLE
    }

    override fun notEmptyList() {
        binding?.timetableNoItemsYet!!.visibility = View.GONE
    }

    override fun onStarted() {
        showProgressBar(childFragmentManager)
    }

    override fun onSuccess() {
        dismissProgressBar()
    }

    override fun onFailure(message: String) {
        dismissProgressBar()
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}