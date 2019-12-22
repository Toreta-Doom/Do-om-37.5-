package com.toreta.do_om.adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.toreta.do_om.R
import com.toreta.do_om.ReadFundingActivity
import com.toreta.do_om.activity.MainActivity
import com.toreta.do_om.data.dataOne
import java.util.ArrayList

class FundingAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val cardViewItems = ArrayList<dataOne>()
    init {
        cardViewItems.add(dataOne(R.drawable.one, "희망 나눔 집중모금 캠페인", "친구들과 함께해요", 98, "37.4"))
        cardViewItems.add(dataOne(R.drawable.two, "사랑의 집 짓기 봉사활동", "안락한 집이 있는 세상을 위해", 60, "21.5"))
        cardViewItems.add(dataOne(R.drawable.three, "행복가득한 재능 나눔", "이웃 나라 어린이들을 위한 재능", 30, "33.5"))
        cardViewItems.add(dataOne(R.drawable.four, "연탄: 만나고 싶은 연탄", "연탄봉사의 고수(高手)", 70, "35.5"))
        cardViewItems.add(dataOne(R.drawable.five, "스마일 재능 뱅크", "농어촌에 재능을 기부하세요", 10, "19.5"))
        cardViewItems.add(dataOne(R.drawable.six, "책 보내기 캠페인", "기부 도서로 지식 나누기", 90, "36.5"))
        cardViewItems.add(dataOne(R.drawable.seven, "이웃사랑 실천 나눔 행사", "라면·휴지로 이웃의 따뜻함 느끼기", 20, "17.5"))
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.main_recyclerview_item, viewGroup, false)
        return RowCell(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as RowCell).imageView.setImageResource(cardViewItems[position].imageView)
        viewHolder.title.text = cardViewItems[position].title
        viewHolder.subtitle.text = cardViewItems[position].subtitle
        viewHolder.dataOne.max = 100
        viewHolder.dataOne.progress = cardViewItems[position].data
        viewHolder.sub.text = cardViewItems[position].ondo

        viewHolder.imageView.setOnClickListener {
            var bundle = Bundle()
            var intent = Intent(viewHolder.imageView.context, ReadFundingActivity::class.java)
            ContextCompat.startActivity(viewHolder.imageView.context,intent, bundle)
        }

    }

    override fun getItemCount(): Int {
        return cardViewItems.size
    }

    private inner class RowCell(view: View) : RecyclerView.ViewHolder(view) {

        var imageView: ImageView = view.findViewById(R.id.imageView_main)
        var title: TextView = view.findViewById(R.id.title)
        var subtitle: TextView = view.findViewById(R.id.subTitle)
        var dataOne: ProgressBar = view.findViewById(R.id.progress)
        var sub: TextView = view.findViewById(R.id.sub)

    }
}