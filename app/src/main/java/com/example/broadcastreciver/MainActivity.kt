package com.example.broadcastreciver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.broadcastreciver.ui.theme.BroadCastReciverTheme

class MainActivity : ComponentActivity() {

    private val airplaneModeReceiver = AirplaneModeReceiver()
    private val testReceiver = TestReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(
            airplaneModeReceiver,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            )
        registerReceiver(
            testReceiver,
            IntentFilter("TEST_ACTION")
        )
        setContent {
            BroadCastReciverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeReceiver)
        unregisterReceiver(testReceiver)
    }
}
