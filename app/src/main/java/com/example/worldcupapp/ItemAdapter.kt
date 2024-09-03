package com.example.worldcupapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ItemAdapter(private var activity: Activity, private var items: ArrayList<CountryModel>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): CountryModel {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater =
                activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var countries = items[position]
        viewHolder.textName?.text = countries.name
        viewHolder.textWins?.text = countries.wins
        viewHolder.image?.setImageResource(countries.flagImg)

        view?.setOnClickListener() {
            Toast.makeText(
                activity,
                "You clicked ${countries.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view as View
    }

    private class ViewHolder(row: View?) {
        var textName: TextView? = null
        var textWins: TextView? = null
        var image: ImageView? = null

        init {
            this.textName = row?.findViewById(R.id.nameCountry)
            this.textWins = row?.findViewById(R.id.winCount)
            this.image = row?.findViewById(R.id.flagImage)
        }

    }

}