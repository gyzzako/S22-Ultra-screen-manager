package be.arnaud.screenmanager.tiles

import android.os.Build
import android.service.quicksettings.Tile
import androidx.annotation.RequiresApi
import be.arnaud.screenmanager.MainActivity

fun keepTilesInstanceUpToDate(tile: Tile){
    val tiles = MainActivity.tilesInstance
    if(tiles.contains(tile)){
        tiles.remove(tile)
    }
    tiles.add(tile);
}

@RequiresApi(Build.VERSION_CODES.N)
fun deactivateOtherTiles(activeTile: Tile){
    val tiles = MainActivity.tilesInstance

    val otherTiles = tiles.filter { tile -> !tile.label.equals(activeTile.label) }
    otherTiles.forEach { tile ->
        tile.state = Tile.STATE_INACTIVE
        tile.updateTile()
     }
}