package com.plcoding.cryptotracker.crypto.presentation.coinList

import com.plcoding.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent{
    data class Error(val error: NetworkError): CoinListEvent
}