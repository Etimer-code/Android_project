package com.example.footballview.presentation.CompStandingsTable

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.footballview.R
import com.example.footballview.databinding.ActivityCompStandingsTableBinding
import com.example.footballview.di.NetworkProvider
import com.example.footballview.presentation.common.BaseActivity

class CompStandingsTableActivity : BaseActivity() {

    private var competitionName : String = "BL1"

    private val viewModel by viewModels<CompStandingsTableViewModel>{
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CompStandingsTableViewModel(
                    NetworkProvider.getStandingsTableRepository(), competitionName
                ) as T
            }
        }
    }
    private val viewBinding by viewBinding(ActivityCompStandingsTableBinding::bind)
    private val compStandingsTableAdapter = CompStandingsTableAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val selectedCompetitionName: String = intent.getStringExtra("CompetitionName").toString()
        when (selectedCompetitionName) {
            "Английская Премьер-лига" -> competitionName = "PL"
            "Ла Лига" -> competitionName = "PD"
            "Серия А" -> competitionName = "SA"
            "Немецкая футбольная Бундеслига" -> competitionName = "BL1"
            "Французская Лига 1" -> competitionName = "FL1"
        }
        setContentView(R.layout.activity_comp_standings_table)

        viewBinding.competitionNameTitle.text = selectedCompetitionName

        with(viewBinding.competitionStandingsTableList) {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false)
            adapter = compStandingsTableAdapter
        }

        viewModel.strsTable.observe(this) {
            compStandingsTableAdapter.setData(it)
        }
    }
}