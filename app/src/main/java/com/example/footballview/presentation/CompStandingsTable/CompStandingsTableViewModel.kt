package com.example.footballview.presentation.CompStandingsTable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballview.domain.StandingsTableRepository
import com.example.footballview.domain.entity.StrTable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class CompStandingsTableViewModel(
    private val standingsTableRepository : StandingsTableRepository, compname : String
) : ViewModel() {

    private val _strsTable = MutableLiveData<List<StrTable>>()

    val strsTable: LiveData<List<StrTable>> = _strsTable

    init {
        viewModelScope.launch(CoroutineExceptionHandler { coroutineContext, throwable ->

        }) {
            val strsTable = standingsTableRepository.getStandingsTable(compname)
            _strsTable.value = strsTable
        }
    }
}