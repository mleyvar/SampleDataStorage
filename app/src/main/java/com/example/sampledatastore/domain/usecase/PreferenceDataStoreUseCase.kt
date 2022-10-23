package com.example.sampledatastore.domain.usecase

import com.example.sampledatastore.data.repository.PreferenceDataStoreRepository
import javax.inject.Inject

class PreferenceDataStoreUseCase @Inject constructor(
    var preferenceDataStoreRepository: PreferenceDataStoreRepository
) {

    suspend fun setName(name: String) {
        preferenceDataStoreRepository.setName(name)
    }

    fun getName() = preferenceDataStoreRepository.getName()

    suspend fun setAmount(amount: Double) {
        preferenceDataStoreRepository.setAmount(amount)
    }

    fun getAmount() = preferenceDataStoreRepository.getAmount()
}
