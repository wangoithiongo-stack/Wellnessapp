package com.example.wanguiwellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         // end insets
         //Below are out explicit intent
//        Find all the buttons by use of their ids
        val healthyRecipes = findViewById<Button>(R.id.healthyrecipes)
        val nutritionAdvice = findViewById<Button>(R.id.nutritionadvice)
        val meditaion = findViewById<Button>(R.id.meditation)
        val hydrationAlert = findViewById<Button>(R.id.hydrationalert)
        val startExercise = findViewById<Button>(R.id.startexercise)
        val dailyMotivation = findViewById<Button>(R.id.dailymotivation)

        healthyRecipes.setOnClickListener {
            val newpage = Intent(applicationContext, HealthyRecipesActivity::class.java)
            startActivity(newpage)
        } //end intent

        nutritionAdvice.setOnClickListener {
            val newpage  = Intent(applicationContext, NutritionAdviceActivity::class.java)
            startActivity(newpage)
        }//end intent

        meditaion.setOnClickListener {
            val newpage = Intent(applicationContext, MeditationActivity::class.java)
            startActivity(newpage)
        }  //end intent

        hydrationAlert.setOnClickListener {
            val newpage = Intent(applicationContext, HydrationActivity::class.java)
            startActivity(newpage)
        }// end intent

        startExercise.setOnClickListener {
            val newpage = Intent(applicationContext, StartExerciseActivity::class.java)
            startActivity(newpage)
        }// end intent

        dailyMotivation.setOnClickListener {
            val newpage = Intent(applicationContext, DailyMotivationActivity::class.java)
            startActivity(newpage)
        }//end intent
    }
}
