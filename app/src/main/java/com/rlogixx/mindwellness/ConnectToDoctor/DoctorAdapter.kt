package com.rlogixmindwellness.ConnectToDoctor

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.rlogixx.mindwellness.R
import de.hdodenhof.circleimageview.CircleImageView

class DoctorAdapter(private var doctors:ArrayList<DocRvItems>): RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {
    class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {

        var docImage: ImageView =itemview.findViewById(R.id.iv_doc)
        var docName: TextView =itemview.findViewById(R.id.txt_Doctor_name)
        var docCourse: TextView =itemview.findViewById(R.id.txt_Course)
        var docField: TextView =itemview.findViewById(R.id.txt_field)
        var docClinic: TextView =itemview.findViewById(R.id.txt_clinic_name)
        var docAdress: TextView =itemview.findViewById(R.id.txt_address_full)
        var docNumber: TextView =itemview.findViewById(R.id.txt_moNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_doctor,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return doctors.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=doctors[position]
        holder.docImage.setImageResource(currentItem.docImage)
        holder.docName.text=currentItem.name
        holder.docCourse.text=currentItem.couse
        holder.docField.text=currentItem.field
        holder.docClinic.text=currentItem.clinicName
        holder.docAdress.text=currentItem.adress
        holder.docNumber.text=currentItem.number

        holder.docAdress.movementMethod = ScrollingMovementMethod()
    }
}