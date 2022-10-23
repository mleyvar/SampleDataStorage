package com.example.sampledatastore.data.repository

import com.example.sampledatastore.AndroidApplication.Companion.appContext
import com.example.sampledatastore.data.database.readDouble
import com.example.sampledatastore.data.database.readString
import com.example.sampledatastore.data.database.writeDouble
import com.example.sampledatastore.data.database.writeString

class PreferenceDataStoreRepositoryImpl : PreferenceDataStoreRepository {
    companion object {
        const val NAME_USER_KEY = "NAME_USER_KEY"
        const val AMOUNT_USER_KEY = "AMOUNT_USER_KEY"
    }

    override suspend fun setName(name: String) {
        appContext.writeString(NAME_USER_KEY, name)
    }

    override fun getName() = appContext.readString(NAME_USER_KEY)

    override suspend fun setAmount(amount: Double) {
        appContext.writeDouble(AMOUNT_USER_KEY, amount)
    }

    override fun getAmount() = appContext.readDouble(AMOUNT_USER_KEY)
}