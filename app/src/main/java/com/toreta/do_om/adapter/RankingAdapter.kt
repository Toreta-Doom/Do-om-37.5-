package com.toreta.do_om.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.toreta.do_om.R
import com.toreta.do_om.data.dataOne
import com.toreta.do_om.data.dataThree
import java.util.ArrayList

class RankingAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val cardViewItems = ArrayList<dataThree>()
    init {
        cardViewItems.add(dataThree(R.drawable.ic_one, "커밋", "37.5°C"))
        cardViewItems.add(dataThree(R.drawable.ic_two, "뽀로로", "32.5°C"))
        cardViewItems.add(dataThree(R.drawable.ic_three, "test", "30°C"))
        cardViewItems.add(dataThree(R.drawable.ic_four, "포메", "27.5°C"))
        cardViewItems.add(dataThree(R.drawable.ic_five, "씨익", "25.5°C"))
        cardViewItems.add(dataThree(R.drawable.ic_six, "App", "20.5°C"))
        cardViewItems.add(dataThree(R.drawable.ic_seven, "WOW", "15.5°C"))
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.raking_item_top, viewGroup, false)
        return RowCell(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as RowCell).imageView.setImageResource(cardViewItems[position].imageView)
        viewHolder.title.text = cardViewItems[position].user
        viewHolder.subtitle.text = cardViewItems[position].ranking

    }

    override fun getItemCount(): Int {
        return cardViewItems.size
    }

    private inner class RowCell(view: View) : RecyclerView.ViewHolder(view) {

        var imageView: ImageView = view.findViewById(R.id.rankingImage)
        var title: TextView = view.findViewById(R.id.rankingName)
        var subtitle: TextView = view.findViewById(R.id.ondo)

    }
}