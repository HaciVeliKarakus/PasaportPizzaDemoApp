package com.hvk.pasaportpizza

import android.app.Application
import com.hvk.pasaportpizza.ui.Graph

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(context = this)
    }
}