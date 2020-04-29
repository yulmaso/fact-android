package com.yulmaso.kskfact.ui.dialogFragments.addService

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.yulmaso.kskfact.R
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.data.model.Service
import com.yulmaso.kskfact.databinding.DialogAddServiceBinding
import com.yulmaso.kskfact.di.injectViewModel
import com.yulmaso.kskfact.ui.BaseDialogFragment
import com.yulmaso.kskfact.ui.RequestListener
import java.util.*

class AddServiceDialogFragment(val horse: Horse) :
    BaseDialogFragment(),
    RequestListener,
    AddServiceDialogNavigator,
    AddServiceDialogAdapter.OnAddServiceListener,
    AdapterView.OnItemSelectedListener
{
    private lateinit var viewModel: AddServiceViewModel
    private lateinit var adapter: AddServiceDialogAdapter

    private lateinit var binding: DialogAddServiceBinding

    private val durationOptions =
        resources.getStringArray(R.array.addService_spinner_duration_options)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.requestListener = this
        viewModel.navigator = this
        viewModel.createdHorseServiceMLive.value!!.horse = horse

        adapter = AddServiceDialogAdapter(this)
        viewModel.services.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogAddServiceBinding.inflate(
            inflater, container, false
        )
        binding.apply {
            viewmodel = viewModel
            addServiceRv.adapter = adapter
            showFirstScene()
        }
        return binding.root
    }

    override fun onServiceClick(service: Service) {
        viewModel.chosenServiceMLive.value = service
        showSecondScene()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val calendar = Calendar.getInstance()
        when (p2) {
            0 -> { //1 week
                viewModel.createdHorseServiceMLive.value!!.apply {
                    startTime = calendar
                    //TODO:: формирование даты окончания
                    //endTime = ?
                }
                val resultCost = 7 * viewModel.chosenService.value!!.price!!
                viewModel.resultCostMLive.value =
                    "$resultCost " + resources.getString(R.string.rubles)
            }
            1 -> { //2 weeks

                val resultCost = 14 * viewModel.chosenService.value!!.price!!
                viewModel.resultCostMLive.value =
                    "$resultCost " + resources.getString(R.string.rubles)
            }
            3 -> { //1 month

                //TODO:: расчет дней в текущем месяце
            }
            4 -> { //2 months

            }
        }
    }

    private fun showFirstScene() {
        binding.apply {
            addServiceChosenTv.visibility = View.GONE
            addServiceDurationTv.visibility = View.GONE
            addServiceDurationSpinner.visibility = View.GONE
            addServiceResultCostTv.visibility = View.GONE
            addServiceResultCostDescriptionTv.visibility = View.GONE
            addServiceAddButton.visibility = View.GONE
            addServiceCancelButton.visibility = View.GONE
        }
    }

    private fun showSecondScene() {
        binding.apply {
            addServiceRv.visibility = View.GONE

            addServiceChosenTv.visibility = View.VISIBLE
            addServiceDurationTv.visibility = View.VISIBLE
            addServiceDurationSpinner.visibility = View.VISIBLE
            addServiceDurationSpinner.onItemSelectedListener = this@AddServiceDialogFragment

            addServiceResultCostTv.visibility = View.VISIBLE
            addServiceResultCostDescriptionTv.visibility = View.VISIBLE
            addServiceAddButton.visibility = View.VISIBLE
            addServiceCancelButton.visibility = View.VISIBLE
        }
    }

    override fun goBack() {
        dismiss()
    }

    override fun onStarted() {
        showProgressBar(childFragmentManager)
    }

    override fun onSuccess() {
        dismissProgressBar()
    }

    override fun onFailure(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        dismissProgressBar()
    }
}