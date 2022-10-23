package com.example.sampledatastore.data.repository

import com.example.sampledatastore.AndroidApplication.Companion.prefs

class PreferenceSharedRepositoryImp : PreferenceSharedRepository {

    override fun setName(name: String) {
        prefs.name = name
    }

    override fun getName() = prefs.name

    override fun setAmount(amount: Float) {
        prefs.amount = amount
    }

    override fun getAmount() = prefs.amount
}
