package com.rlogixmindwellness.BodyMAssIndex

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.rlogixx.mindwellness.R

class BMI : AppCompatActivity() {
    var startPoint = 0
    var endPopint = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)


        val height = findViewById<SeekBar>(R.id.height)
        val heightText = findViewById<TextView>(R.id.txt_height)
        val weight = findViewById<SeekBar>(R.id.weight)
        var weightText = findViewById<TextView>(R.id.txt_weight)
        var bmi = findViewById<Button>(R.id.btn_calculate)


        height?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                    heightText.text = progress.toString()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (height != null){
                    startPoint = height.progress
                }
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        if(height != null){
                            endPopint = height.progress
                        }

                    Toast.makeText(this@BMI,"Progress is: " + height.progress + "%",Toast.LENGTH_SHORT).show()
                }
            })

            weight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    weightText.text = progress.toString()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    if (weight != null){
                        startPoint = weight.progress
                    }

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    if (weight != null){
                        endPopint = weight.progress
                    }
                    Toast.makeText(this@BMI,"Progress is: " + weight.progress + "%",Toast.LENGTH_SHORT).show()
                }

            }
            )

        bmi.setOnClickListener {
            if (heightText.text.isNotEmpty() && weightText.text.isNotEmpty()) {
                val height_cal = (heightText.text.toString()).toInt()
                val weight_cal = (weightText.text.toString()).toInt()

                // calculateBMI will return BMI
                val BMI = calculateBMI(height_cal, weight_cal)

                bmi.text = BMI.toString()
                bmi.visibility = View.VISIBLE


//                // update the status text as per the bmi conditions
//                if (BMI < 18.5) {
//                    status.text = "Under Weight"
//                } else if (BMI >= 18.5 && BMI < 24.9) {
//                    status.text = "Healthy"
//                } else if (BMI >= 24.9 && BMI < 30) {
//                    status.text = "Overweight"
//                } else if (BMI >= 30) {
//                    status.text = "Suffering from Obesity"
//                }
//
//            }
//
//            // when either Weight EditText or
//            // height EditText have null value
//            // we will display toast.
//            else {
//                Toast.makeText(this, "please enter the valid height and weight", Toast.LENGTH_SHORT).show()
//            }
        }
        }




    }

    private fun calculateBMI(height: Int, weight: Int): Float {

        val Height_in_metre = height.toFloat() / 100
        val BMI = weight.toFloat() / (Height_in_metre * Height_in_metre)

        return BMI
    }
    fun basicAlert(view: View){

        val builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Androidly Alert")
            setMessage("We have a message")
            show()
        }
    }
}