package com.rlogixmindwellness.MentalHealth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.rlogixx.mindwellness.R

class MentalHealth : AppCompatActivity() {
    private lateinit var mentalArray :ArrayList<MenRvItem>
    private lateinit var mentalAdapter: MentalHealthAdapter
    private lateinit var arrzero:ArrayList<RvVideoItem>
    private lateinit var mentalRvAdapter:MentalRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mental_health)
        val rvMental = findViewById<RecyclerView>(R.id.rv_yoga)
        rvMental.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        mentalArray= ArrayList()
        mentalArray.add(MenRvItem("Depression","Label",R.drawable.twelve))
        mentalArray.add(MenRvItem("Anxiety","Label",R.drawable.thirteen))
        mentalArray.add(MenRvItem("Addiction","Label",R.drawable.one))
        mentalArray.add(MenRvItem("Psychosis","Label",R.drawable.one))
        mentalArray.add(MenRvItem("Bipolar Disorder","Label",R.drawable.one))
        mentalArray.add(MenRvItem("Other psychological Disorder","Label",R.drawable.one))

        mentalAdapter= MentalHealthAdapter(mentalArray)
        rvMental.adapter= mentalAdapter

        mentalAdapter.setOnItemClickListener(object : MentalHealthAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MentalHealth, "Clicked on the $position", Toast.LENGTH_SHORT).show()

//                val intent = Intent(this@MentalHealth, VideoYoga::class.java)
//                    .putExtra("Position", position)
//                startActivity(intent)
//
            if (position == 0){

                rvMental.layoutManager = LinearLayoutManager(this@MentalHealth,RecyclerView.VERTICAL,false)

                arrzero = ArrayList()
                arrzero.add(RvVideoItem(R.drawable.depression,"What Is Depression"))
                arrzero.add(RvVideoItem(R.drawable.depression, "Depression is Not Sadness,Grief,or Berevement"))
                arrzero.add(RvVideoItem(R.drawable.depression,"Factors Risk for Depression"))
                arrzero.add(RvVideoItem(R.drawable.depression,"Meditation"))
                arrzero.add(RvVideoItem(R.drawable.depression,"Introspection And Copying"))
                arrzero.add(RvVideoItem(R.drawable.depression, "Disruptive Mood Dysregulation Disorder"))

                mentalRvAdapter= MentalRvAdapter(arrzero)
                rvMental.adapter= mentalRvAdapter


            }

            }

        })




    }
}