package com.rlogixmindwellness.StressFolder

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rlogixx.mindwellness.MainActivity
import com.rlogixx.mindwellness.R

class Stress : AppCompatActivity(){
    private lateinit var questionTextView: TextView
    private lateinit var option1Button: Button
    private lateinit var option2Button: Button
    private lateinit var option3Button: Button
    private lateinit var option4Button: Button
    private lateinit var imgBack:ImageView

    private var currentQuestionIndex = 0
    private var score = 0

    private val questions = listOf(
        Question("Little interest or pleasure in doing things?", listOf("Not At All" , "Once in a while" , "More Than Half Days" , "Nearly Every Day"), 0),
        Question("Feeling down, depressed, or hopeless?", listOf("Not At All" , "Once in a while" , "More Than Half Days" , "Nearly Every Day"), 0),
        Question("Trouble falling or staying asleep, or sleeping too much?", listOf("Not At All" , "Once in a while" , "More Than Half Days" , "Nearly Every Day"), 0),
        Question("Feeling tired or having little energy?", listOf("Not At All" , "Once in a while" , "More Than Half Days" , "Nearly Every Day"), 0),
        Question("Poor appetite or overeating?", listOf("Not At All" , "Once in a while" , "More Than Half Days" , "Nearly Every Day"), 0),
        Question("Feeling bad about yourself - or that you are a failure or have let yourself or your family down?", listOf("Not At All" , "Once in a while" , "More Than Half Days" , "Nearly Every Day"), 0),
        Question("Trouble concentrating on things, such as reading the newspaper or watching television?", listOf("Not At All" , "Once in a while" , "More Than Half Days" , "Nearly Every Day"), 0),
        Question("Moving or speaking so slowly that other people could have noticed?", listOf("Not At All" , "Once in a while" , "More Than Half Days" , "Nearly Every Day"), 0),
        Question("Thoughts that you would be better off dead, or of hurting yourself in some way?", listOf("Not At All" , "Once in a while" , "More Than Half Days" , "Nearly Every Day"), 0),
        Question("Having Problem in Breathing ?" ,listOf("Not At All" , "Once in a while" , "More Than Half Days" , "Nearly Every Day"), 0)
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stress)

        setTitle("Calculate Your Stress")
        supportActionBar?.hide()

        questionTextView = findViewById(R.id.questionTextView)
        option1Button = findViewById(R.id.option1Button)
        option2Button = findViewById(R.id.option2Button)
        option3Button = findViewById(R.id.option3Button)
        option4Button = findViewById(R.id.option4Button)
        imgBack=findViewById(R.id.imgBack)
        imgBack.setOnClickListener {
            this.startActivity(Intent(this@Stress, MainActivity::class.java))
        }
        displayQuestion()

        option1Button.setOnClickListener { checkAnswer(0) }
        option2Button.setOnClickListener { checkAnswer(1) }
        option3Button.setOnClickListener { checkAnswer(2) }
        option4Button.setOnClickListener { checkAnswer(3) }
    }

    private fun displayQuestion() {
        val currentQuestion = questions[currentQuestionIndex]
        questionTextView.text = currentQuestion.question
        option1Button.text = currentQuestion.options[0]
        option2Button.text = currentQuestion.options[1]
        option3Button.text = currentQuestion.options[2]
        option4Button.text = currentQuestion.options[3]

    }


    private fun checkAnswer(selectedOptionIndex: Int) {
        val currentQuestion = questions[currentQuestionIndex]

        if(selectedOptionIndex==0){
            score+=2
        }
        if(selectedOptionIndex==1){
            score+=5
        }
        if(selectedOptionIndex==2){
            score+=7
        }
        if(selectedOptionIndex==3){
            score+=10
        }


        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            displayQuestion()
        } else {
            showFinalScore()
        }

    }

    private fun showFinalScore() {
        val intent=Intent(this@Stress,StressGauge::class.java)
            .putExtra("Score",score)
        startActivity(intent)
        Toast.makeText(this, "Final Score: $score", Toast.LENGTH_LONG).show()
        // You can perform additional actions here, such as restarting the quiz.
    }
}


data class Question(val question: String, val options: List<String>, val correctAnswerIndex: Int)
