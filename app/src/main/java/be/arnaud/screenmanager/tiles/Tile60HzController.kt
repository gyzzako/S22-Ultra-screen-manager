package be.arnaud.screenmanager.tiles

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.provider.Settings
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import be.arnaud.screenmanager.*

@SuppressLint("NewApi")
class Tile60HzController : TileService(), ITileController {
    override fun onStartListening() {
        super.onStartListening()
        val tile = qsTile
        tile.label = getString(R.string.set_60hz)
        tile.icon = Icon.createWithResource(this, R.drawable.ic_refresh_black_24dp)
        if(isCurrentRefreshRate(this)){
            tile.state = Tile.STATE_ACTIVE
        }else{
            tile.state = Tile.STATE_INACTIVE
        }
        tile.updateTile()
        keepTilesInstanceUpToDate(tile)
    }

    override fun onClick() {
        super.onClick()
        setRefreshRate(RefreshRate.Sixty)
        val tile = qsTile
        tile.state = Tile.STATE_ACTIVE
        tile.updateTile()
        deactivateOtherTiles(tile)
    }

    override fun isCurrentRefreshRate(controller: TileService) :Boolean{
        val refreshRate = Settings.System.getString(contentResolver, MIN_REFRESH_RATE)
        return refreshRate.equals(RefreshRate.Sixty.minRefreshRateValue)
    }
}
