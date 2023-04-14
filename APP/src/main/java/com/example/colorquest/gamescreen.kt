package com.example.colorquest

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class gamescreen : AppCompatActivity() {

    val colors = arrayOf(
        Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
        Color.MAGENTA, Color.CYAN, Color.BLACK
    )
    //colors.shuffle()

    val colorNames = colors.map {
        when (it) {
            Color.RED -> "RED"
            Color.GREEN -> "GREEN"
            Color.BLUE -> "BLUE"
            Color.YELLOW -> "YELLOW"
            Color.MAGENTA -> "MAGENTA"
            Color.CYAN -> "CYAN"
            Color.BLACK -> "BLACK"
            else -> throw IllegalArgumentException("Invalid color value: $it")
        }
    }.map { it.toUpperCase() }.toMutableList()

    val finalColorNames=colorNames.toTypedArray()
    var c1=finalColorNames[0]
    var c2=finalColorNames[1]
    var c3=finalColorNames[2]
    var c4=finalColorNames[3]
    var c5=finalColorNames[4]
    var c6=finalColorNames[5]
    var c7=finalColorNames[6]


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamescreen)
        window.statusBarColor = ContextCompat.getColor(this, R.color.color_full)




        val myString = intent.getStringExtra("MY_STRING")
        var welcomeName = findViewById<TextView>(R.id.welcomeName)
        welcomeName.text = myString
        val view: View = findViewById(R.id.view)
        val start: Button = findViewById(R.id.startgame)
        val show:Button= findViewById(R.id.show)
        welcomeName.text= welcomeName.text


        show.setOnClickListener {
            lifecycleScope.launch {
                for (i in colors.indices) {
                    val color = colors[i]
                    view.setBackgroundColor(color)
                    delay(1000L)
                }
            }
        }


        start.setOnClickListener {

            val intent = Intent(this, ColorSelectionActivity::class.java)
            intent.putExtra("color1",c1)
            intent.putExtra("color2",c2)
            intent.putExtra("color3",c3)
            intent.putExtra("color4",c4)
            intent.putExtra("color5",c5)
            intent.putExtra("color6",c6)
            intent.putExtra("color7",c7)


            intent.putExtra("MY_STRING",welcomeName.text)

            startActivity(intent)
        }


    }
}


