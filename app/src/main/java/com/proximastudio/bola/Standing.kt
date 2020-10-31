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
                        val idTeam = it.teamid.toString()
                        val postServices = DataRepository.create()
                        postServices.getTeam(idTeam).enqueue(object : Callback<PostModel> {




                            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                                if (response.isSuccessful) {
                                    val data = response.body()
                                    val myList = data?.teams
                                    it.img = myList?.get(0)?.teamBadge.toString()

                                    // Log.d("alamat gambar", "alamatnya ${it.img}")




                                }
                            }

                            override fun onFailure(call: Call<PostModel>, error: Throwable) {
                                Log.e("tag", "errornya ${error.message}")
                            }

                        })

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