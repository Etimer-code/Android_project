package com.example.footballview.presentation.CompetitionSelectActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompetitionSelectViewModel : ViewModel() {

    private val _loading = MutableLiveData(false)
    val  loading : LiveData<Boolean> = _loading

    override fun onCleared() {
        super.onCleared()
    }

    fun onSubmit(
        competitionName : String
    ) {
        _loading.value = true
    }
}