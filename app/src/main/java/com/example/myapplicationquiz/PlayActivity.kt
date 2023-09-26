package com.example.myapplicationquiz

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationquiz.databinding.ActivityPlayBinding


class PlayActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPlayBinding
    private lateinit var totalQuestionTv: TextView
    private lateinit var questionTv: TextView
    private lateinit var ansABtn: Button
    private lateinit var ansBBtn: Button
    private lateinit var ansCBtn: Button
    private lateinit var ansDBtn: Button
    private lateinit var submitBtn: Button
    private var score = 0
    private var totalQuestion = Question.question.size
    private var currentQuestionIndex = 0
    private var selectedAnswer = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        totalQuestionTv = binding.total
        questionTv = binding.question
        ansABtn = binding.ansA
        ansBBtn = binding.ansB
        ansCBtn = binding.ansC
        ansDBtn = binding.ansD
        submitBtn = binding.submitBtn
        ansABtn.setOnClickListener(this)
        ansBBtn.setOnClickListener(this)
        ansCBtn.setOnClickListener(this)
        ansDBtn.setOnClickListener(this)
        submitBtn.setOnClickListener(this)
        totalQuestionTv.text = "Total question: $totalQuestion"
        loadNewQuestion()
    }

    private fun loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz()
            return
        }
        questionTv.text = Question.question[currentQuestionIndex]
        ansABtn.text = Question.option[currentQuestionIndex][0]
        ansBBtn.text = Question.option[currentQuestionIndex][1]
        ansCBtn.text = Question.option[currentQuestionIndex][2]
        ansDBtn.text = Question.option[currentQuestionIndex][3]
    }

    private fun finishQuiz() {
        val passStatus = if (score > totalQuestion * 0.60) {
            "Passed"
        } else {
            "failed"
        }
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(passStatus)
        alertDialog.setMessage("Score is $score out of $totalQuestion")
        alertDialog.setPositiveButton("RESTART"){_, _ -> restartQuiz()}
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun restartQuiz() {
        score = 0
        currentQuestionIndex = 0
        loadNewQuestion()
    }

    override fun onClick(p0: View?) {
        ansABtn.setBackgroundColor(Color.WHITE)
        ansBBtn.setBackgroundColor(Color.WHITE)
        ansCBtn.setBackgroundColor(Color.WHITE)
        ansDBtn.setBackgroundColor(Color.WHITE)
        val clickedButton = p0 as Button
        if (clickedButton.id == R.id.submitBtn) {
            if (selectedAnswer == Question.answer[currentQuestionIndex]) {
                score++
            }
            currentQuestionIndex++
            loadNewQuestion()
        } else {
            selectedAnswer = clickedButton.text.toString()
            clickedButton.setBackgroundColor(Color.MAGENTA)
        }
    }
}