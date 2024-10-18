package com.plcoding.cryptotracker.crypto.presentation

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.util.Locale

data class CoinUi(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercentage24Hr: DisplayableNumber,
    @DrawableRes val iconRes: Int
)

data class DisplayableNumber(
    val number: Double,
    val formatted: String
)

fun Double.toDisplayNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayableNumber(
        number = this,
        formatted = formatter.format(this)
    )
}

fun Coin.toCoin(): CoinUi {
    return CoinUi(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd.toDisplayNumber(),
        priceUsd = priceUsd.toDisplayNumber(),
        changePercentage24Hr = changePercentage24Hr.toDisplayNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}
