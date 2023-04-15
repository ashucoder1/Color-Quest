package com.example.colorquest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

class ColorSelectionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_selection)
        window.statusBarColor = ContextCompat.getColor(this, R.color.color_full)



        val color1 = intent.getStringExtra("color1")
        val color2 = intent.getStringExtra("color2")
        val color3 = intent.getStringExtra("color3")
        val color4 = intent.getStringExtra("color4")
        val color5 = intent.getStringExtra("color5")
        val color6 = intent.getStringExtra("color6")
        val color7 = intent.getStringExtra("color7")


        var name = intent.getStringExtra("MY_STRING")

        //this
        val myArray = mutableListOf<String>()
        val red = findViewById<AppCompatButton>(R.id.red)
        val green = findViewById<AppCompatButton>(R.id.green)
        val yellow = findViewById<AppCompatButton>(R.id.yellow)
        val magenta = findViewById<AppCompatButton>(R.id.magenta)
        val blue = findViewById<AppCompatButton>(R.id.blue)
        val cyan = findViewById<AppCompatButton>(R.id.cyan)
        val black = findViewById<AppCompatButton>(R.id.black)
        val reset = findViewById<AppCompatButton>(R.id.reset)

        //tick
        var redtick: ImageView = findViewById(R.id.redtick)
        var greentick: ImageView = findViewById(R.id.greentick)
        var yellowtick: ImageView = findViewById(R.id.yellowtick)
        var magentatick: ImageView = findViewById(R.id.magentatick)
        var bluetick: ImageView = findViewById(R.id.bluetick)
        var cyantick: ImageView = findViewById(R.id.cyantick)
        var blacktick: ImageView = findViewById(R.id.blacktick)


        red.setOnClickListener {
            val buttonText = red.text.toString()
            redtick.visibility = View.VISIBLE
            myArray.add(buttonText)

        }
        green.setOnClickListener {
            val buttonText = green.text.toString()
            greentick.visibility = View.VISIBLE
            myArray.add(buttonText)
        }
        yellow.setOnClickListener {
            val buttonText = yellow.text.toString()
            yellowtick.visibility = View.VISIBLE
            myArray.add(buttonText)
        }
        magenta.setOnClickListener {
            val buttonText = magenta.text.toString()
            magentatick.visibility = View.VISIBLE
            myArray.add(buttonText)
        }
        blue.setOnClickListener {
            val buttonText = blue.text.toString()
            bluetick.visibility = View.VISIBLE
            myArray.add(buttonText)
        }
        cyan.setOnClickListener {
            val buttonText = cyan.text.toString()
            cyantick.visibility = View.VISIBLE
            myArray.add(buttonText)
        }
        black.setOnClickListener {
            val buttonText = black.text.toString()
            blacktick.visibility = View.VISIBLE
            myArray.add(buttonText)
        }

        reset.setOnClickListener {
            myArray.clear()
            redtick.visibility = View.INVISIBLE
            greentick.visibility = View.INVISIBLE
            bluetick.visibility = View.INVISIBLE
            yellowtick.visibility = View.INVISIBLE
            magentatick.visibility = View.INVISIBLE
            cyantick.visibility = View.INVISIBLE
            blacktick.visibility = View.INVISIBLE

        }
        var viewResult: Button = findViewById(R.id.viewresult)
        var view1: LinearLayout = findViewById(R.id.screen1)
        var view2: LinearLayout = findViewById(R.id.screen2)
        var view3: LinearLayout = findViewById(R.id.view3)
        var resultstatement: TextView = findViewById(R.id.resultstatement)
        val animationView = findViewById<LottieAnimationView>(R.id.animation_view)
        val animationViewlost = findViewById<LottieAnimationView>(R.id.animation_viewlost)
        val finalname:TextView=findViewById(R.id.name)
        finalname.text= name


        viewResult.setOnClickListener {
            view1.visibility = View.INVISIBLE
            view2.visibility = View.VISIBLE

            if (color1 == myArray[0] && color2 == myArray[1] && color3 == myArray[2] && color4==myArray[3] &&color5==myArray[4] && color6==myArray[5] && color7==myArray[6]) {
                resultstatement.text = "Yay! you guessed Correctly :)"
                view3.visibility=View.VISIBLE
                animationViewlost.visibility=View.INVISIBLE
                animationView.visibility=View.VISIBLE

                var ans1: TextView = findViewById(R.id.q)
                ans1.text = "The Order of Your Selecion is:"

                //recycler
                var recyclerview:RecyclerView=findViewById(R.id.recyclerview)

                recyclerview.adapter=MyAdapter(myArray)
                recyclerview.layoutManager=LinearLayoutManager(this)

            } else {
                resultstatement.text = "Opps! Wrong Order :("
                animationView.visibility = View.INVISIBLE
                animationViewlost.visibility = View.VISIBLE

                var ans1: TextView = findViewById(R.id.q)
                ans1.text = "The Order of Your Selecion is wrong."
            }




        }


    }}







