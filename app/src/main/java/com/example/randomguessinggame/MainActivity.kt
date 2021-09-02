package com.example.randomguessinggame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var winner: String
    private lateinit var random_pic: String
    private var fruits = mutableListOf(R.drawable.random_apple, R.drawable.random_watermelon, R.drawable.random_cherry)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchRandomGame.setOnCheckedChangeListener{_, isChecked ->
            if (isChecked) {
                buttonApple.setOnClickListener {
                    ivSelected.setImageResource(R.drawable.random_apple)
                    winner = "apple"
                }
                buttonWatermelon.setOnClickListener {
                    ivSelected.setImageResource(R.drawable.random_watermelon)
                    winner = "watermelon"
                }
                buttonCherry.setOnClickListener {
                    ivSelected.setImageResource(R.drawable.random_cherry)
                    winner = "cherry"
                }
                buttonRandom.setOnClickListener {
                    var r = (fruits).shuffled().first()
                    ivRandom.setImageResource(r)
                    if (r == R.drawable.random_apple) {
                        random_pic = "apple"
                    }
                    else if (r == R.drawable.random_cherry) {
                        random_pic = "cherry"
                    }
                    else if (r == R.drawable.random_watermelon) {
                        random_pic = "watermelon"
                    }
                    if (r == R.drawable.random_apple && winner == "apple") {
                        Toast.makeText(this, "The fruit is $random_pic. Congratulations, you won", Toast.LENGTH_LONG).show()
                    }
                    else if (r == R.drawable.random_watermelon && winner == "watermelon") {
                        Toast.makeText(this, "The fruit is $random_pic. Congratulations, you won", Toast.LENGTH_LONG).show()
                    }
                    else if (r == R.drawable.random_cherry && winner == "cherry") {
                        Toast.makeText(this, "The fruit is $random_pic. Congratulations, you won", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "You Lost. The fruit is $random_pic. Try AGAIN", Toast.LENGTH_LONG).show()
                    }
                }
                switchRandomGame.text = "Stop Game"
            } else {
                switchRandomGame.text = "Start Game"
                buttonApple.setOnClickListener { Toast.makeText(this, "Switch on to start a game", Toast.LENGTH_SHORT, ).show() }
                buttonWatermelon.setOnClickListener { Toast.makeText(this, "Switch on to start a game", Toast.LENGTH_SHORT).show() }
                buttonCherry.setOnClickListener { Toast.makeText(this, "Switch on to start a game", Toast.LENGTH_SHORT).show() }
                buttonRandom.setOnClickListener { Toast.makeText(this, "Switch on to start a game", Toast.LENGTH_SHORT).show() }
            }
        }
    }
}