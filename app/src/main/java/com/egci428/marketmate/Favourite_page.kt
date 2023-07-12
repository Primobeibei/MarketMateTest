package com.egci428.marketmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.egci428.marketmate.adapter.FavouriteAdapter
import com.egci428.marketmate.dataclass.Favourite

class Favourite_page : AppCompatActivity() {

    lateinit var FavRecycler: RecyclerView
    var favouriteArray: ArrayList<Favourite> = ArrayList()
    var favouriteAdapter: FavouriteAdapter = FavouriteAdapter(favouriteArray)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite_page)

        FavRecycler = findViewById(R.id.favRecycler)

        val linearLayoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        FavRecycler.layoutManager = linearLayoutManager
        FavRecycler.adapter = favouriteAdapter


        val clockButton = findViewById<ImageButton>(R.id.clockBtn)
        val homeButton = findViewById<ImageButton>(R.id.homeBtn)
        val budButton = findViewById<ImageButton>(R.id.budBtn)
        val disButton = findViewById<ImageButton>(R.id.DisBtn)


        clockButton.setOnClickListener{
            //val intent = Intent(this, Expirydatelist::class.java)
            startActivity(intent)
        }

        homeButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
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
}