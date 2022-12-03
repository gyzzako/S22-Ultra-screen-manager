package be.arnaud.screenmanager.tiles

import android.service.quicksettings.TileService

interface ITileController {
    fun isCurrentRefreshRate(controller: TileService) :Boolean
}