package com.example.sampledatastore.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampledatastore.domain.usecase.PreferenceDataStoreUseCase
import com.example.sampledatastore.domain.usecase.PreferenceSharedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var preferenceSharedUseCase: PreferenceSharedUseCase,
    var preferenceDataStoreUseCase: PreferenceDataStoreUseCase
) : ViewModel() {

    val getNameAmount: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun setDataPreference(name: String, amount: Float) {
        preferenceSharedUseCase.setName(name)
        preferenceSharedUseCase.setAmount(amount)
    }
    fun getDataPreference() = preferenceSharedUseCase.getName() + "-" + preferenceSharedUseCase.getAmount().toString()

    suspend fun setDataPreferenceDatStore(name: String, amount: Double) {
        preferenceDataStoreUseCase.setName(name)
        preferenceDataStoreUseCase.setAmount(amount)
    }

    fun getDataPreferenceDataStore() {
        viewModelScope.launch {
            preferenceDataStoreUseCase.getName()
                .zip(preferenceDataStoreUseCase.getAmount()) { first, second ->
                    return@zip "$first - $second"
                }
                .flowOn(Dispatchers.IO)
                .collect {
                    getNameAmount.value = it
                }
        }
    }
}
