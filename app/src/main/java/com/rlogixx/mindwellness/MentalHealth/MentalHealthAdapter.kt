package com.rlogixmindwellness.MentalHealth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rlogixx.mindwellness.R

class MentalHealthAdapter(private val arrMental : ArrayList<MenRvItem>):RecyclerView.Adapter<MentalHealthAdapter.ViewHolder>() {
    private lateinit var mlistener : MentalHealthAdapter.OnItemClickListener

    interface  OnItemClickListener{
        fun onItemClick(position:Int)
    }

    fun setOnItemClickListener(listener : MentalHealthAdapter.OnItemClickListener){
        mlistener=listener
    }
    class ViewHolder(itemview : View, listener : MentalHealthAdapter.OnItemClickListener):RecyclerView.ViewHolder(itemview) {
        val txtTitle = itemview.findViewById<TextView>(R.id.txt_mental_name)
        val txtDesc = itemview.findViewById<TextView>(R.id.txt_mental_desc)
        val imgMent = itemview.findViewById<ImageView>(R.id.profile_image)

        init{
            itemview.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_mental_health,parent,false)
        return  ViewHolder(view,mlistener)
    }

    override fun getItemCount(): Int {
        return  arrMental.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentitem = arrMental[position]
        holder.txtTitle.text = currentitem.Title
        holder.txtDesc.text = currentitem.Desc
        holder.imgMent.setImageResource(currentitem.imgMental)

    }
}