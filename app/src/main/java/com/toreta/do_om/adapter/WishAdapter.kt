package com.toreta.do_om.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.toreta.do_om.R
import com.toreta.do_om.data.dataThree
import com.toreta.do_om.data.dataTwo
import java.util.ArrayList

class WishAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val cardViewItems = ArrayList<dataTwo>()
    init {

        cardViewItems.add(dataTwo(R.drawable.two, "사랑의 집 짓기 봉사활동", "안락한 집이 있는 세상을 위해"))
        cardViewItems.add(dataTwo(R.drawable.three, "행복가득한 재능 나눔", "이웃 나라 어린이들을 위한 재능"))
        cardViewItems.add(dataTwo(R.drawable.four, "연탄: 만나고 싶은 연탄", "연탄봉사의 고수(高手)"))
        cardViewItems.add(dataTwo(R.drawable.five, "스마일 재능 뱅크", "농어촌에 재능을 기부하세요"))
        cardViewItems.add(dataTwo(R.drawable.six, "책 보내기 캠페인", "기부 도서로 지식 나누기"))
        cardViewItems.add(dataTwo(R.drawable.one, "희망 나눔 집중모금 캠페인", "친구들과 함께해요"))
        cardViewItems.add(dataTwo(R.drawable.seven, "이웃사랑 실천 나눔 행사", "라면·휴지로 이웃의 따뜻함 느끼기"))
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.wish_item, viewGroup, false)
        return RowCell(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as RowCell).imageView.setImageResource(cardViewItems[position].imageView)
        viewHolder.title.text = cardViewItems[position].title
        viewHolder.subtitle.text = cardViewItems[position].subtitle

    }

    override fun getItemCount(): Int {
        return cardViewItems.size
    }

    private inner class RowCell(view: View) : RecyclerView.ViewHolder(view) {

        var imageView: ImageView = view.findViewById(R.id.wish_image)
        var title: TextView = view.findViewById(R.id.wish_title)
        var subtitle: TextView = view.findViewById(R.id.wish_subtitle)

    }
}