package edu.ius.p435.assignment1.geoquiz

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import edu.ius.p435.assignment1.geoquiz.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private var currentIndex = 0
    private var score = 0
    private var attempted = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        binding.questionTextView.setOnClickListener {
            if (currentIndex < questionBank.size - 1) {
                currentIndex = (currentIndex + 1) % questionBank.size
            }
            updateQuestionAndButtons()
        }

        binding.previousButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex = (currentIndex - 1) % questionBank.size
            }
            updateQuestionAndButtons()
        }

        binding.nextButton.setOnClickListener {
            if (currentIndex < questionBank.size - 1) {
                currentIndex = (currentIndex + 1) % questionBank.size
            }
            updateQuestionAndButtons()
        }

        updateQuestionAndButtons()
        updateScore()
    }

    private fun updateQuestionAndButtons() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
        binding.trueButton.isEnabled = !questionBank[currentIndex].isAnswered
        binding.falseButton.isEnabled = !questionBank[currentIndex].isAnswered
        binding.previousButton.isEnabled = currentIndex != 0
        binding.nextButton.isEnabled = currentIndex != questionBank.size - 1
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        questionBank[currentIndex].isAnswered = true
        binding.trueButton.isEnabled = false
        binding.falseButton.isEnabled = false
        attempted++
        if (userAnswer == correctAnswer) {
            score++
        }
        updateScore()
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        val toast = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
        val layout: View = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container))
        layout.findViewById<TextView?>(R.id.custom_toast_message).setText(messageResId)
        toast.view = layout
        toast.setGravity(Gravity.TOP, 0, 200)
        toast.show()
    }

    private fun updateScore() {
        val scoreString = "Score $score/$attempted"
        binding.scoreTextView.text = scoreString
    }
}
