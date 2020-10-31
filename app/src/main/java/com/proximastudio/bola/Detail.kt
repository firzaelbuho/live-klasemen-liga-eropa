package com.proximastudio.bola

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.proximastudio.bola.repo.DataActivity
import com.proximastudio.bola.repo.DataRepository
import com.proximastudio.bola.repo.PostModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val teamId = DataActivity.teamId
        setDetail(teamId)
    }

    fun setDetail(teamId : String){
        val idTeam = teamId
        val postServices = DataRepository.create()
        postServices.getTeam(idTeam).enqueue(object : Callback<PostModel> {




            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    val myTeam = data?.teams?.get(0)


                    Glide.with(this@Detail)
                        .load(myTeam?.teamBadge)
                        .into(teamBadge)
                    teamName.text = "${myTeam?.teamName}"
                    stadiumName.text = "${myTeam?.teamStadium} | ${myTeam?.teamFormedYear}"
                    desc.text = "${myTeam?.teamDesc}"


                }
            }

            override fun onFailure(call: Call<PostModel>, error: Throwable) {
                Log.e("tag", "errornya ${error.message}")
            }

        })
    }

}