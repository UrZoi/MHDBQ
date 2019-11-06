package com.example.mhqdb

import android.content.Context
import android.content.Intent
import android.content.LocusId
import android.graphics.Color
import android.inputmethodservice.Keyboard
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_mhfu.*
import kotlinx.android.synthetic.main.activity_mhfu.view.*
import java.util.concurrent.atomic.AtomicReferenceArray

class MHFU : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mhfu)


        var ListView = findViewById<ListView>(R.id.MHFUListView)
        //val redcolor = Color.parseColor("#FF0000")
       //ListView.setBackgroundColor(redcolor)
        ListView.adapter = MyCustomAdapter(this,0) // This needs to be my custom adapter telling my list what to render

        ListView.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id->
            when (position) {
                0 -> {Toast.makeText(this,"Wanna see missions of 1 star",Toast.LENGTH_SHORT).show()
                    ListView.adapter = MyCustomAdapter(this,1)} // This needs to be my custom adapter telling my list what to render
                1 -> Toast.makeText(this,"2",Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this,"3",Toast.LENGTH_SHORT).show()
                else -> intent = Intent(this, MainActivity::class.java)
            }}

        )

    }

    private class MyCustomAdapter(context: Context, ID:Int): BaseAdapter()  {


        private val starts = arrayListOf<String>(
        "Quests of *",
        "Quests of **",
        "Quests of ***",
        "Quests of ****",
        "Quests of *****",
        "Quests of ******")


        private  val Misiones = arrayListOf<String>(
            "A True Foe - The Giadrome!",
            "Reckless Bulldrome Hunter",
            "A Pack of Blangos",
            "Mountain Herb Picking",
            "Rarest of Rare Beasts",
            "Hunt the Rare Forest Congas!",
            "A Mushroom Goldrush",
            "The Land Shark",
            "The Giant Enemy Crab",
            "The Lady Gourmet"
        )

        private  val Descripsiones1 = arrayListOf<String>(
            "Hunt the Giadrome",
            "Hunt the Bulldrome",
            "Slay 15 Blangos",
            "Deliver 20 Mountain Herbs",
            "Hunt the Congalala",
            "Hunt the Rare Forest Congas!",
            "Deliver 20 Special Mushrooms",
            "Hunt the Cephadrome",
            "Hunt the Daimyo Hermitaur",
            "Deliver 8 Piscine Livers"
        )

        private  val Area  = arrayListOf<String>(
            "Snowy Mountains (Day)",
            "Snowy Mountains (Night)",
            "Snowy Mountains (Day)",
            "Snowy Mountains (Night)",
            "Jungle (Night)",
            "Jungle (Day)",
            "Jungle (Day)",
            "Desert (Night)",
            "Desert (Day)",
            "Desert (Day)"
        )



        private  val Time = arrayListOf<String>(
            "50mins",
            "50mins",
            "50mins",
            "50mins",
            "50mins",
            "50mins",
            "50mins",
            "50mins",
            "50mins",
            "50mins"
        )



        private  val Fee = arrayListOf<String>(
            "100z",
            "100z",
            "100z",
            "100z",
            "150z",
            "100z",
            "100z",
            "150z",
            "180z",
            "100z"
            )

        private  val Reward = arrayListOf<String>(
            "1200z",
            "1500z",
            "900z",
            "900z",
            "1800z",
            "900z",
            "900z",
            "1800z",
            "2100z",
            "900z"
        )


        private  val Notes = arrayListOf<String>(
            "",
            "", 
            "Bulldrome is present",
            "Bulldrome is present",
            "Congalala is present",
            "Velocidrome is present",
            "Velocidrome is present",
            "",
            "",
            "Gendrome is present"
            )



        private val mContext: Context
        init {
            mContext = context
        }

        private val  mID: Int
        init {
            mID = ID
        }



        //Responsible for how many rows in my list
        override fun getCount(): Int {

            when (mID) {
                0 -> return starts.size
                1 -> return Misiones.size
                else -> return 4
            }
        }

        //You can ignore this for now
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        //You can ignore this for now
        override fun getItem(position: Int): Any {
            return  "Test"
        }
        //Responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, parenta: ViewGroup?): View {

            val LayoutInflater = LayoutInflater.from(mContext)
            val RowMain = LayoutInflater.inflate(R.layout.rowtable, parenta, false)

            if (mID == 0){
                val nametext = RowMain.findViewById<TextView>(R.id.maintext)
                nametext.text = starts.get(position)

            }
            else{
                val nametext = RowMain.findViewById<TextView>(R.id.maintext)
                nametext.text = Misiones.get(position)

                val positionTextView = RowMain.findViewById<TextView>(R.id.Area)
                positionTextView.text = Area.get(position)

                val time = RowMain.findViewById<TextView>(R.id.Time)
                time.text = Time.get(position)

                val fee = RowMain.findViewById<TextView>(R.id.Fee)
                fee.text = Fee.get(position)


                val reward = RowMain.findViewById<TextView>(R.id.Reward)
                reward.text = Reward.get(position)


                val notes = RowMain.findViewById<TextView>(R.id.Notes)
                notes.text = Notes.get(position)



            }



            return RowMain

        }

    }


    private class Model(val name:String, val Desc:String){}



}
