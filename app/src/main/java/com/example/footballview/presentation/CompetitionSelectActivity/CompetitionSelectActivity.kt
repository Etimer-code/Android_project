package com.example.footballview.presentation.CompetitionSelectActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.footballview.R
import com.example.footballview.presentation.common.BaseActivity
import com.example.footballview.databinding.ActivityCompetitionSelectBinding
import com.example.footballview.presentation.CompStandingsTable.CompStandingsTableActivity

class CompetitionSelectActivity : BaseActivity() {

    private val viewModel by viewModels<CompetitionSelectViewModel>()
    //private val viewBinding by viewBinding(ActivityCompetitionSelectBinding::bind)
    private var competitionName : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCompetitionSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_competition_select)
        binding.competitionNameSelectSubmit.setOnClickListener {
            viewModel.onSubmit(
                //competitionName = (viewBinding.competitionNameSpinner.selectedItem as String)
                competitionName = (binding.competitionNameSpinner.selectedItem as String)
            )
            competitionName = (binding.competitionNameSpinner.selectedItem as String)
            openCompetitionPage(competitionName)
        }

        viewModel.loading.observe(this) {
            binding.competitionNameSelectProgress.isVisible = it
            binding.competitionNameSelectStub.isVisible = it
        }
    }

    private fun openCompetitionPage(competitionName : String) {
        startActivity(
            Intent(this, CompStandingsTableActivity::class.java)
                .apply {
                    putExtra("CompetitionName", competitionName)
                }
        )
    }
}