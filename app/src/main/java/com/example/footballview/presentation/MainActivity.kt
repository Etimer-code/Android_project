package com.example.footballview.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.footballview.R
import com.example.footballview.presentation.CompetitionSelectActivity.CompetitionSelectActivity
import com.example.footballview.presentation.common.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.competitionSelectButton)?.setOnClickListener {
            openCompetitionSelect()
        }
    }

    private fun openCompetitionSelect() {
        startActivity(
            Intent(this, CompetitionSelectActivity::class.java)
        )
    }
}