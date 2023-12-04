package com.rlogixmindwellness.ConnectToDoctor

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rlogixx.mindwellness.R


class Doctor : AppCompatActivity() {

    private lateinit var doctorArray:ArrayList<DocRvItems>
    private lateinit var doctorAdapter:DoctorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)
        val rv_doctor=findViewById<RecyclerView>(R.id.rv_doctor)
        //val scorll_add=findViewById<TextView>(R.id.txt_address_full)


        rv_doctor.layoutManager= LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        doctorArray = ArrayList()
        doctorArray.add(DocRvItems("Dr.Reetesh","MBBS",R.drawable.nine,"Neurology","Ed-256 RLogixx SOftware Development Centre","8000000000","Rlogixx"))
        doctorArray.add(DocRvItems("Dr.Wazid","MBBS",R.drawable.ten,"orthopaedics","Ed-360 RLogixx SOftware Development Centre","9000000000","Madiyaon"))
        doctorArray.add(DocRvItems("Dr.Sandeep","MBBS",R.drawable.one,"Eurology","Purania bridge crossing","1000000000","Puarnia"))


        doctorAdapter= DoctorAdapter(doctorArray)
        rv_doctor.adapter=doctorAdapter

    }
}