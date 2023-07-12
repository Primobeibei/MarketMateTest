package com.egci428.marketmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.egci428.marketmate.adapter.FavouriteAdapter
import com.egci428.marketmate.dataclass.Favourite
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var homeRecyclerView: RecyclerView
    lateinit var dataReference: FirebaseFirestore
    var favouriteArray: ArrayList<Favourite> = ArrayList()
    var favouriteAdapter: FavouriteAdapter = FavouriteAdapter(favouriteArray)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //readFirestoreData()


        homeRecyclerView = findViewById(R.id.hmRecycler)

        val linearLayoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        homeRecyclerView.layoutManager = linearLayoutManager
        homeRecyclerView.adapter = favouriteAdapter

        val addButton = findViewById<Button>(R.id.button)
        val favButton = findViewById<ImageButton>(R.id.favBtn)
        val clockButton = findViewById<ImageButton>(R.id.clockBtn)
        val budButton = findViewById<ImageButton>(R.id.budBtn)
        val disButton = findViewById<ImageButton>(R.id.DisBtn)

        dataReference = FirebaseFirestore.getInstance()



        addButton.setOnClickListener{
            //val intent = Intent(this, Shoppinglist::class.java)
            startActivity(intent)
        }

        favButton.setOnClickListener{
            val intent = Intent(this, Favourite_page::class.java)
            startActivity(intent)
        }

        clockButton.setOnClickListener{
            //val intent = Intent(this, Expirydatelist::class.java)
            startActivity(intent)
        }


        budButton.setOnClickListener{
            val intent = Intent(this, Expense_management::class.java)
            startActivity(intent)
        }

        disButton.setOnClickListener{
            val intent = Intent(this, Discount_raffle::class.java)
            startActivity(intent)
        }
    }

    /*private fun readFirestoreData(){
        var db = dataReference.collection("dataMessage")
        db.orderBy("timeStamp").get()
            .addOnSuccessListener { snapshot ->
                if (snapshot != null){
                    msgList.clear()
                    val messages = snapshot.toObjects(Favourite::class.java)
                    for (message in messages){
                        msgList.add(message)
                    }
                    adapter = FavouriteAdapter(applicationContext, R.layout.messages, msgList)
                    listView.adapter = adapter
                    //Log.d("Firestore Read", messages.toString())
                }

            }
            .addOnFailureListener {
                Toast.makeText(applicationContext,"Fail to read messages from Firestore", Toast.LENGTH_SHORT).show()
            }

    }*/
}