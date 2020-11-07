package com.proximastudio.bola

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.proximastudio.bola.repo.*
import kotlinx.android.synthetic.main.activity_standing.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Standing : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standing)

        val leagueId = DataActivity.leagueId
        val leagueName = DataActivity.leagueName

        titleLeague.text = "Klasemen ${leagueName}"

        // set background

        bg.setImageResource(DataActivity.bgRes)

        // set list

        showStandings(leagueId)



    }


    fun showStandings(idCompetition:String){

        val postServices = DataRepository.create()
        postServices.getStanding(idCompetition,"2020-2021").enqueue(object : Callback<StandingModel> {



            override fun onResponse(call: Call<StandingModel>, response: Response<StandingModel>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    val myList = data?.table
                    if (myList != null) {

                       // Log.d("tag", "alamat imgnya ${getTeamInfo("133612")}")

                        // getTeamInfo("133612")

                        showRecyclerList(myList)

                    }
                    // Log.d("tag", "responsennya ${data?.table?.size}")


                    // add img Badge for each Team


                    data?.table?.map {


                    }
                }
            }

            override fun onFailure(call: Call<StandingModel>, error: Throwable) {
                Log.e("tag", "errornya ${error.message}")
            }


        })



    }

    fun showRecyclerList(list:List<Table>){
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(list)
        adapter.notifyDataSetChanged()

        //tampilkan data dalam recycler view
        rv.adapter = adapter

    }

    fun getTeamInfo(idTeam: String){




    }
}