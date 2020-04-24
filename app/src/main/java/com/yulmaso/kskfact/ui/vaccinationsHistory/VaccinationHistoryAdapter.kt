package com.yulmaso.kskfact.ui.vaccinationsHistory

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.kskfact.data.model.HorseVaccination
import com.yulmaso.kskfact.data.model.Vaccination
import com.yulmaso.kskfact.databinding.ItemVaccinationsHistoryBinding
import com.yulmaso.kskfact.utils.Constants.monthFormat
import java.time.Month
import java.time.ZoneId
import java.time.format.TextStyle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class VaccinationHistoryAdapter: RecyclerView.Adapter<VaccinationHistoryAdapter.VaccinationsHistoryViewHolder>() {

    private val items: MutableList<HorseVaccination> = ArrayList()

    private val years: MutableList<String> = ArrayList()
    private val vaccinationsByYears = HashMap<String, List<Vaccination>>()

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): VaccinationsHistoryViewHolder =
        VaccinationsHistoryViewHolder(ItemVaccinationsHistoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))

    override fun getItemCount() = years.size

    override fun onBindViewHolder(holder: VaccinationsHistoryViewHolder, position: Int) =
        holder.bind(years[position], vaccinationsByYears[years[position]]!!)

    fun setItems(items: List<HorseVaccination>) {
        if (!items.isNullOrEmpty()) {
            this.items.addAll(items)
            for (item in items) {
                val time = item.vaccination!!.time
                val locale = Locale.forLanguageTag("ru")
                val month = Month.of(time!!.get(Calendar.MONTH))
                val nameOfMonth = month.getDisplayName(TextStyle.FULL_STANDALONE, locale)

                //TODO: НУЖНО ДОСТАВАТЬ ОТСОРТИРОВАННЫЕ ВАКЦИНАЦИИ СРАЗУ ИЗ БАЗЫ, А НЕ СОРТИРОВАТЬ ИХ ЗДЕСЬ
                if (!years.contains(nameOfMonth)) {
                    years.add(nameOfMonth)
                }
            }
            notifyDataSetChanged()
        }
    }

    class VaccinationsHistoryViewHolder(
        private val binding: ItemVaccinationsHistoryBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(year: String, horseVaccination: List<Vaccination>) {

        }
    }
}