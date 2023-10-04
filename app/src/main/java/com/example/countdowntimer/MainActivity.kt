package com.example.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var numberPicker: NumberPicker
    private lateinit var countdownText: TextView
    private lateinit var resetButton: Button
    private lateinit var startButton: Button
    private lateinit var pauseButton: Button


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
            val time=numberPicker.value.toLong()*1000
            startTimer(time)
        }
    }
    private fun startTimer(duration:Long){
        var minute= duration/60
        var second=duration%60
        countdownText.text = minute.toString()+second.toString()
        if (duration.toInt()==0) {
            Toast.makeText(this, "Timer Finished", Toast.LENGTH_SHORT).show()
            countdownText.text = "Finished"
        }
    }
}