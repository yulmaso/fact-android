package com.yulmaso.kskfact.ui.horseProfile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.data.model.HorseVaccination
import com.yulmaso.kskfact.data.model.Vaccination
import com.yulmaso.kskfact.databinding.ItemInfoRowBinding

class HProfileVaccinationsAdapter(
    private val onVaccinationListener: OnVaccinationListener
): RecyclerView.Adapter<HProfileVaccinationsAdapter.ViewHolder>() {

    private val items: MutableList<HorseVaccination> = ArrayList()

    interface OnVaccinationListener {
        fun cancelVaccination(vaccination: Vaccination)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemInfoRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), onVaccinationListener)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    //TODO:: здесь нужны только ГРЯДУЩИЕ ENABLED вакцинации
    fun setItems(items: List<HorseVaccination>?) {
        if (!items.isNullOrEmpty()) {
            this.items.apply {
                clear()
                addAll(items)
            }
            notifyDataSetChanged()
        }
    }

    class ViewHolder(
        private val binding: ItemInfoRowBinding,
        private val onVaccinationListener: OnVaccinationListener
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(horseVaccination: HorseVaccination) {
            binding.apply {
                //TODO:: сделать отображение даты вида "30 июня"
                infoContentTv.text = horseVaccination.vaccination?.time?.toString()

                infoDescriptionTv.text = horseVaccination.vaccination?.name
            }
        }

        //TODO:: сделать контекстное меню для удаления вакцинации
    }
}