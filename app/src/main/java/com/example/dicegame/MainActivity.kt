package com.example.dicegame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array= arrayOf(R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6)
        val btn=findViewById<Button>(R.id.btnid)
        val img1=findViewById<ImageView>(R.id.dice1)
        val img2=findViewById<ImageView>(R.id.dice2)
        val result=findViewById<TextView>(R.id.reultid)
        btn.setOnClickListener {
                val random1 = (1..6).shuffled().last()
                val a=random1
                val random2 = (1..6).shuffled().last()
                val b=random2
                if (a < b) {
                    //result.text="Better Luck Next Time"
                    val intent = Intent(this, Lose::class.java)
                    startActivity(intent)
                } else if (a > b) {
                    // result.text="Congratulation You Won!!"
                    val intent = Intent(this, Win::class.java)
                    startActivity(intent)
                } else {
                    //result.text="ITS DRAW"
                    val intent = Intent(this, Draw::class.java)
                    startActivity(intent)
                }
                img1.setImageResource(array[a])
                img2.setImageResource(array[b])
            }

    }
}