package be.arnaud.screenmanager

import android.app.Activity
import android.os.Bundle
import android.service.quicksettings.Tile
import be.arnaud.screenmanager.databinding.ActivityMainBinding

class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        var tilesInstance = ArrayList<Tile>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonsListener()
    }

    private fun setButtonsListener(){
        binding.set60.setOnClickListener { setRefreshRate(RefreshRate.Sixty) }
        binding.set90.setOnClickListener { setRefreshRate(RefreshRate.NinetySix) }
        binding.set120.setOnClickListener { setRefreshRate(RefreshRate.HundredTwenty) }
        binding.setDynamic.setOnClickListener { setRefreshRate(RefreshRate.Dynamic) }
    }
}