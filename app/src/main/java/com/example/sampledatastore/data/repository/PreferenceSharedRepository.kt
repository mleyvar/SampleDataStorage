package com.example.sampledatastore.data.repository


interface PreferenceSharedRepository {
    fun setName(name: String) fun getName(): String

    fun setAmount(amount: Float) fun getAmount(): Float
}
