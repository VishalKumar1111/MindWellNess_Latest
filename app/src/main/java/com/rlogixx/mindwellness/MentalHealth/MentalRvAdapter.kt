package com.rlogixmindwellness.MentalHealth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rlogixx.mindwellness.R

class MentalRvAdapter(private var arrVideo:ArrayList<RvVideoItem>):RecyclerView.Adapter<MentalRvAdapter.ViewHolder>() {

    class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
        val txtVideo=itemview.findViewById<TextView>(R.id.txt_video)
        val video=itemview.findViewById<ImageView>(R.id.img_ment_video)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_mental_health,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
    return  arrVideo.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentitem = arrVideo[position]
        holder.txtVideo.text = currentitem.txtVideo
        holder.video.setImageResource(currentitem.imgVideo)


    }


}