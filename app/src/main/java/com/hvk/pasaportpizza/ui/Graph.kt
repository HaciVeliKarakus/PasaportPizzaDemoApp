package com.hvk.pasaportpizza.ui

import android.content.Context
import com.hvk.pasaportpizza.model.DataStoreManager

object Graph {
    lateinit var dataStoreManager: DataStoreManager

    fun provide(context: Context) {
        dataStoreManager = DataStoreManager(context)
    }
}