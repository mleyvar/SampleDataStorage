package com.example.sampledatastore.domain.usecase

import com.example.sampledatastore.data.repository.PreferenceSharedRepository
import javax.inject.Inject

class PreferenceSharedUseCase @Inject constructor(
    var preferenceSharedRepository: PreferenceSharedRepository
) {

    fun setName(name: String) {
        preferenceSharedRepository.setName(name)
    }

    fun getName() = preferenceSharedRepository.getName()

    fun setAmount(amount: Float) {
        preferenceSharedRepository.setAmount(amount)
    }

    fun getAmount() = preferenceSharedRepository.getAmount()
}
