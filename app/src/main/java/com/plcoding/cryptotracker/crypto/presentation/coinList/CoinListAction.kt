package com.plcoding.cryptotracker.crypto.presentation.coinList

import com.plcoding.cryptotracker.crypto.presentation.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}