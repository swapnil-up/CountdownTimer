package com.example.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private lateinit var numberPicker: NumberPicker
    private lateinit var countdownText: TextView
    private lateinit var resetButton: Button
    private lateinit var startButton: Button
    private lateinit var pauseButton: Button
    private var timer:CountDownTimer?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker=findViewById(R.id.numberPicker)
        countdownText=findViewById(R.id.countdownText)
        resetButton=findViewById(R.id.resetButton)
        startButton=findViewById(R.id.startButton)
        pauseButton=findViewById(R.id.pauseButton)

        numberPicker.minValue=0
        numberPicker.maxValue=600

        startButton.setOnClickListener{
            val time=(numberPicker.value+1).toLong()*1000
            startTimer(time)
        }
        resetButton.setOnClickListener{
            countdownText.text="00:00"
            timer?.cancel()
        }
        pauseButton.setOnClickListener{
            timer?.cancel()
        }
    }
    private fun startTimer(duration:Long){
        timer?.cancel()
        timer=object : CountDownTimer(duration,1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes= (millisUntilFinished/1000)/60
                val seconds=(millisUntilFinished/1000)%60
                countdownText.text=String.format("%02d:%02d",minutes,seconds)
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity, "Timer Finished", Toast.LENGTH_SHORT).show()
                countdownText.text = "Finished"
            }
        }
        timer?.start()
    }
}