package be.arnaud.screenmanager

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.service.quicksettings.TileService
import android.widget.Toast
import androidx.annotation.RequiresApi
import be.arnaud.screenmanager.tiles.Tile120HzController
import be.arnaud.screenmanager.tiles.TileDynamicHzController
import be.arnaud.screenmanager.tiles.Tile60HzController
import be.arnaud.screenmanager.tiles.Tile96HzController

const val MIN_REFRESH_RATE = "min_refresh_rate"
private const val PEAK_REFRESH_RATE = "peak_refresh_rate"

enum class RefreshRate(val refreshRateValue: String) {
    Sixty("60.0"),
    NinetySix("96.0"),
    HundredTwenty("120.0"),
    Dynamic("dynamic")
}

fun setConfig(context: Context, key: String, value: String) {
    val contentResolver = context.contentResolver
    try {
        val contentValues = ContentValues(2)
        contentValues.put("name", key)
        contentValues.put("value", value)
        contentResolver.insert(Uri.parse("content://settings/system"), contentValues)
        Toast.makeText(context, "Applied", Toast.LENGTH_SHORT).show()
    } catch (th: Exception) {
        Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        th.printStackTrace()
    }
}

fun Context.setRefreshRate(rate: RefreshRate) {
    setConfig(this, MIN_REFRESH_RATE, rate.refreshRateValue)
    setConfig(this, PEAK_REFRESH_RATE, rate.refreshRateValue)
}