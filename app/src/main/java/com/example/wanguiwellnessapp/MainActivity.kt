package com.example.wanguiwellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
class MainActivity : AppCompatActivity() {

    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        loadInterstitialAd()
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

            showInterstitialAd()
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

            showInterstitialAd()
        }// end intent

        dailyMotivation.setOnClickListener {
            val newpage = Intent(applicationContext, DailyMotivationActivity::class.java)
            startActivity(newpage)
        }//end intent

//        Below we implement our ad
        MobileAds.initialize(this)
        val adView = findViewById<AdView>(R.id.adview)
        val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }


    fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()
        //Requests interstitial ads
        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712", // Test ID
            adRequest,
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(ad: InterstitialAd) {
                    mInterstitialAd = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    mInterstitialAd = null
                }
            }
        )
    }
    //Function checks if ad already running not to run another one and overlap - which is wrong
    fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
    }
}
