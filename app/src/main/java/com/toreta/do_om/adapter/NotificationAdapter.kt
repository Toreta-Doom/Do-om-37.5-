package com.toreta.do_om.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.toreta.do_om.R
import com.toreta.do_om.data.dataFour
import com.toreta.do_om.data.dataOne
import java.util.ArrayList

class NotificationAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val cardViewItems = ArrayList<dataFour>()
    init {
        cardViewItems.add(dataFour("안녕하세요 도옴의 알림입니다."))
        cardViewItems.add(dataFour("펀딩에 참여하신 ‘만나고 싶은 연탄'의\n 온도가 37.5 °C에 달성했습니다."))
        cardViewItems.add(dataFour("위시리스트에 담긴 ‘따뜻한 핫팩 나누기'의 펀딩에 참여해보세요!"))
        cardViewItems.add(dataFour("펀딩에 참여하신 ‘버려진 신발 재활용하기'의\n 온도가 37.5 °C에 달성했습니다."))
        cardViewItems.add(dataFour("펀딩에 참여하신 ‘이웃과 함께 하는 식사'의\n 온도가 37.5 °C에 달성했습니다."))
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.notification_view, viewGroup, false)
        return RowCell(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as RowCell).notification.text = cardViewItems[position].notification
    }

    override fun getItemCount(): Int {
        return cardViewItems.size
    }

    private inner class RowCell(view: View) : RecyclerView.ViewHolder(view) {

        var notification: TextView = view.findViewById(R.id.notification_text)

    }
}