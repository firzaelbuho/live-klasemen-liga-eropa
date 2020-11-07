package com.proximastudio.bola

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.proximastudio.bola.repo.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get post data
       england.setOnClickListener{
           DataActivity.leagueId = "4328"
           DataActivity.leagueName = "English Premier League"
           DataActivity.bgRes = R.drawable.epl
           startActivity(Intent(this, Standing::class.java))
       }
        italy.setOnClickListener{
            DataActivity.leagueId = "4332"
            DataActivity.leagueName = "Serie-A"
            DataActivity.bgRes = R.drawable.seriea
            startActivity(Intent(this, Standing::class.java))
        }
        spain.setOnClickListener{
            DataActivity.leagueId = "4335"
            DataActivity.leagueName = "Laliga BBVA"
            DataActivity.bgRes = R.drawable.laliga
            startActivity(Intent(this, Standing::class.java))
        }
        france.setOnClickListener{
            DataActivity.leagueId = "4334"
            DataActivity.leagueName = "Ligue 1"
            DataActivity.bgRes = R.drawable.ligue1
            startActivity(Intent(this, Standing::class.java))
        }
        germany.setOnClickListener{
            DataActivity.leagueId = "4331"
            DataActivity.leagueName = "Bundesliga"
            DataActivity.bgRes = R.drawable.bundesliga
            startActivity(Intent(this, Standing::class.java))
        }
        netherland.setOnClickListener{
            DataActivity.leagueId = "4337"
            DataActivity.leagueName = "Eredivisie"
            DataActivity.bgRes = R.drawable.eredivisie
            startActivity(Intent(this, Standing::class.java))
        }


    }
}