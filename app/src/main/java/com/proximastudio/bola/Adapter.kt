package com.proximastudio.bola

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proximastudio.bola.repo.*
import kotlinx.android.synthetic.main.list.view.*

class Adapter (private val list:List<Table>) : RecyclerView.Adapter<Adapter.Holder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false))

    }



    override fun onBindViewHolder(holder: Adapter.Holder, position: Int) {

        holder.view.teamName.text = list?.get(position)?.name
        holder.view.teamNumber.text = "${position + 1}."
        holder.view.played.text = "${list?.get(position)?.played}"
        holder.view.gd.text = "${list?.get(position)?.goalsdifference}"

        holder.view.win.text = "${list?.get(position)?.win}"
        holder.view.draw.text = "${list?.get(position)?.draw}"
        holder.view.loss.text = "${list?.get(position)?.loss}"

        holder.view.point.text = "${list?.get(position)?.total}"


        Glide.with(holder.view)
                .load(list.get(position)?.img+"/preview")
                .into(holder.view.teamLogo)

        holder.view.setOnClickListener {
          //  Toast.makeText(holder.view.context, "ini toast", Toast.LENGTH_SHORT).show()

            // val team = list.get(position)
            DataActivity.teamId = list.get(position).teamid.toString()
            val context = holder.view.context
            val intent = Intent(context, Detail::class.java)
//            intent.putExtra("key", team)
//            Log.d("dipencet eaaaaaa", "isinya $team")
            context.startActivity(intent)
        }







//
//            bundle.putString("name", list.get(position)?.name)
//            bundle.putString("desc", list.get(position)?.desc)
//            intent.putExtras(bundle)
//            context.startActivity(intent)
//
//        }
//        holder.view.btn2.setOnClickListener{
//
//            val context = holder.view.context
//            val intent = Intent(context, activity3::class.java)
//            context.startActivity(intent)

        //}
    }

    override fun getItemCount(): Int = list?.size

    //class holder

    class Holder(val view: View) : RecyclerView.ViewHolder(view){




    }
}
