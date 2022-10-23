package com.example.sampledatastore.data.repository

import kotlinx.coroutines.flow.Flow

interface PreferenceDataStoreRepository {
    suspend fun setName(name: String) fun getName(): Flow<String>

    suspend fun setAmount(amount: Double) fun getAmount(): Flow<Double>
}
