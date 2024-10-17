package com.plcoding.cryptotracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.plcoding.cryptotracker.crypto.presentation.coinList.CoinListScreen
import com.plcoding.cryptotracker.crypto.presentation.coinList.components.previewCoin
import com.plcoding.cryptotracker.crypto.presentation.models.CoinListState
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTrackerTheme {
                CoinListScreen(
                    state = CoinListState(
                        coins = (1..100).map {
                            previewCoin.copy(id = it.toString())
                        }
                    ),
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background))
            }
        }
    }
}

