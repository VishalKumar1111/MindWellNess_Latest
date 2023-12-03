package com.rlogixx.mindwellness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemChangeListener
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.navigation.NavigationView
import com.rlogixmindwellness.MentalHealth.MentalHealth
import com.rlogixmindwellness.StressFolder.Stress

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navigationView: NavigationView

    private   val imageTitle = mutableListOf(
        "MindWellness",
        "MindWellness",
        "MindWellness",
        "MindWellness",
        "MindWellness",
        "MindWellness"
    )
    private val Title = mutableListOf(
        "How This App Can Help You",
        "Calculate Your Stress",
        "Yoga & Benifits",
        "Mental Health problem",
        "Meditation",
        "Concern To Doctor"
    )
    private val descTitle = arrayListOf(
        "1- Know Your Stress Level.\n 2- Manage Your Stress.\n  3- Possible Treatment You Can Seek.\n 4- Help You De-Stress With Yoga. \n 5- Know About Mental Health Problem. \n 6- Connect To An Expert. \n 7-  Health Tips. \n",
        "Your Stress Result Will Display Here",
        "Benefits Of Yoga \n 1- Relief from depression and anxiety.\n2- Reduce the effects of PTSD and similar conditions\n 3- Boost concentration, focus, and memory \n  4- Improve your mood \n 5- Keep your brain young",
        " 1- Anxiety disorders.\n 2- Behavioural and emotional disorders in children.\n3- Bipolar affective disorder.\n4- Depression\n5- Addiction\n6- Psychosis",
        " 1-Gaining a new perspective on stressful situations.\n 2- Building skills to manage your stress.  \n  3- Increasing self-awareness. \n  4- Focusing on the present. \n 5- Reducing negative emotions",
        "Counsellors work with clients experiencing a wide range of emotional and psychological difficulties to help them bring about effective change and/or enhance their wellbeing. Clients could have issues such as depression, anxiety, stress, loss and relationship difficulties that are affecting their ability to manage life.",

        )
    private var topicimageList = mutableListOf(
        R.drawable.helpapp,
        R.drawable.twelve,
        R.drawable.yog,
        R.drawable.mentalhealth,
        R.drawable.meditation,
        R.drawable.doctor,
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigationView)

        // Set the toolbar as the action bar
        setSupportActionBar(toolbar)

        // Set up the navigation drawer toggle
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item1 -> {
                    // Handle item 1 click
                    drawerLayout.closeDrawers()
                    Toast.makeText(this,"Item !1 Clicked",Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
                R.id.nav_item2 -> {
                    // Handle item 2 click
                    drawerLayout.closeDrawers()
                    return@setNavigationItemSelectedListener true
                }
                // Add more cases as needed
                else -> return@setNavigationItemSelectedListener false
            }
        }



        val mainImage: ImageView = findViewById(R.id.main_image)
        val container = findViewById<ConstraintLayout>(R.id.contraint_layout)
        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        val nameTitle = findViewById<TextView>(R.id.name_title)
        val description = findViewById<TextView>(R.id.name_desciption)
        val title = findViewById<TextView>(R.id.title)
        // val float=findViewById<FloatingActionButton>(R.id.next)

        title.text = "How this App Can Help You"
        title.setOnClickListener { startActivity(Intent(this@MainActivity, Stress::class.java)) }
        description.text =
            "1- Know Your Stress Level.\n 2- Manage Your Stress.\n  3- Possible Treatment You Can Seek.\n 4- Help You De-Stress With Yoga. \n 5- Know About Mental Health Problem. \n 6- Connect To An Expert. \n 7-  Health Tips. \n"
        mainImage.setImageResource(R.drawable.helpapp)
        nameTitle.text = "MindWellness"


        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.helpapp))
        imageList.add(SlideModel(R.drawable.twelve))
        imageList.add(SlideModel(R.drawable.yog))
        imageList.add(SlideModel(R.drawable.mentalhealth))
        imageList.add(SlideModel(R.drawable.meditation))
        imageList.add(SlideModel(R.drawable.doctor))


        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.startSliding(1500)


        imageSlider.setItemChangeListener(object : ItemChangeListener {
            override fun onItemChanged(position: Int) {
                if (position ==0){
                    title.text = Title[0]

                    description.text = descTitle[0]
                    mainImage.setImageResource(topicimageList[0])

                    nameTitle.text = imageTitle[0]
                }
                if (position == 1) {
                    title.text = Title[1]

                    description.text = descTitle[1]
                    mainImage.setImageResource(topicimageList[1])
                    mainImage.setOnClickListener { startActivity(Intent(this@MainActivity, Stress::class.java)) }
                    nameTitle.text = imageTitle[1]
                }

                if (position == 2) {
                    title.text = Title[2]
                    description.text = descTitle[2]
                    mainImage.setImageResource(topicimageList[2])
//                    mainImage.setOnClickListener { startActivity(Intent(this@MainActivity, GaugeActivity::class.java)) }
                    nameTitle.text = imageTitle[2]
                }
                if (position == 3) {
                    title.text = Title[3]
                    description.text = descTitle[3]
                    mainImage.setImageResource(topicimageList[3])
                    mainImage.setOnClickListener { startActivity(Intent(this@MainActivity, MentalHealth::class.java)) }
                    nameTitle.text = imageTitle[3]
                }
                if (position == 4) {
                    title.text = Title[4]
                    description.text = descTitle[4]
                    mainImage.setImageResource(topicimageList[4])
                 //   mainImage.setOnClickListener {startActivity(Intent(this@MainActivity, BMI::class.java)) }
                    nameTitle.text = imageTitle[4]
                }

                if (position == 5){
                    title.text = Title[5]
                    description.text = descTitle[5]

                    mainImage.setImageResource(topicimageList[5])
                //    mainImage.setOnClickListener {startActivity(Intent(this@MainActivity, Doctor::class.java))}
                    nameTitle.text = imageTitle[5]

                }

            }


        }

        )


/*
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {

            }

            override fun onItemSelected(position: Int) {
                if (position == 1) {

                    val intent = Intent(this@MainActivity, Stress::class.java)
                    startActivity(intent)

                    nameTitle.setOnClickListener {
                        startActivity(
                            (Intent(this@MainActivity, Stress::class.java))
                        )
                    }
                }

                if (position==0){
                    startActivity(Intent(this@MainActivity,Treatment::class.java))
                }
                if (position==3){
                    startActivity(Intent(this@MainActivity,MentalHealth::class.java))
                }
                if (position==2){
                    startActivity(Intent(this@MainActivity,Yoga::class.java))
                }
                if (position == 4 ){
                    startActivity(Intent(this@MainActivity,Meditation::class.java))
                }


            }
        }
        )

    */

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView)
        } else {
            super.onBackPressed()
        }
    }
}