package com.example.broadcastreciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class TestReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "TEST_ACTION"){
            println("Received Test intent")
        }
    }
}