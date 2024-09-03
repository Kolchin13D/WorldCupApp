package com.example.worldcupapp

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // adapter view
        //var listview: ListView = findViewById(R.id.listView)
        var listview = findViewById<ListView>(R.id.listView)

        // old adapter
//        val arrayAdapter: ArrayAdapter<*> = ArrayAdapter(
//            this,
//            R.layout.list_item,
//            R.id.nameCountry,
//            countries
//        )

        //  new adapter
        var adapter = ItemAdapter(this, generateData())
        listview?.adapter = adapter
        adapter?.notifyDataSetChanged()

    }

    //  data source
    //var countries = arrayOf("Russia", "Germany", "England", "Spain")
    fun generateData(): ArrayList<CountryModel> {
        var result = ArrayList<CountryModel>()
        var country1: CountryModel = CountryModel("Russia", "5 wins", R.drawable.russia)
        var country2: CountryModel = CountryModel("Germany", "1 wins", R.drawable.germany)
        var country3: CountryModel = CountryModel("England", "3 wins", R.drawable.uk)
        var country4: CountryModel = CountryModel("Spain", "2 wins", R.drawable.spain)

        result.add(country1)
        result.add(country2)
        result.add(country3)
        result.add(country4)

        return result
    }
}