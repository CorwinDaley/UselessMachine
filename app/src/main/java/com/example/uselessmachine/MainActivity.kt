package com.example.uselessmachine

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //View.OnClickListener
        //Lambda --> Anon function
        //You can use a lambda to implement a one function interface
        //onClick(view: View) is a function being implemented by the lambda
        //when there's one parameter in the function, "it" us used to refer to the param

        button_main_lookBusy.setOnClickListener {
            Toast.makeText(this, "Hello!", Toast.LENGTH_LONG).show()
        }
        switch_main_useless.setOnCheckedChangeListener { compoundButton, isChecked ->
            // 1. toast the status of the button {checked, or not checked}
            // 2. if the button is checked, uncheck it.
            //

            Toast.makeText(this, isChecked.toString(), Toast.LENGTH_SHORT).show()
            val timer = object : CountDownTimer((1500..4500).random().toLong(), 1000) {
                override fun onFinish() {
                    switch_main_useless.isChecked = false
                }
                override fun onTick(millisRemaining: Long) {}
            }
            timer.start()
            if (!switch_main_useless.isChecked) {
                timer.cancel()
            }


        }
        fun timerMethod() {
            var totalTime = 10000
            var intervalTime = 500

            val timer = object : CountDownTimer(totalTime.toLong(), intervalTime.toLong()) {
                var i = 0
                override fun onFinish() {

                    System.exit(0);
                }

                override fun onTick(millisRemaining: Long) {

                    if (i % 4 == 0 || (i % 2 == 0 && i > 10)) {
                        main_background.setBackgroundColor(Color.parseColor("#FF0000"))
                    } else {
                        main_background.setBackgroundColor(Color.parseColor("#FFFFFF"))
                    }
                    i++

                }
            }
            timer.start()
            button_main_selfDestruct.setOnClickListener {
                timer.cancel()
                main_background.setBackgroundColor(Color.parseColor("#FFFFFF"))
                button_main_selfDestruct.setOnClickListener {
                    timerMethod()
                }


            }
        }
        button_main_selfDestruct.setOnClickListener {
            timerMethod()
        }

        button_main_lookBusy.setOnClickListener {
            progressBar_main_lookbusy
        }


    }
}
