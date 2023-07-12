package com.egci428.marketmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.egci428.marketmate.adapter.FavouriteAdapter
import com.egci428.marketmate.dataclass.Favourite
import com.google.android.material.textfield.TextInputEditText

class Expense_management : AppCompatActivity() {

    lateinit var budRecyclerView: RecyclerView
    var favouriteArray: ArrayList<Favourite> = ArrayList()
    var favouriteAdapter: FavouriteAdapter = FavouriteAdapter(favouriteArray)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_management)

        val linearLayoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        budRecyclerView.layoutManager = linearLayoutManager
        budRecyclerView.adapter = favouriteAdapter

        budRecyclerView = findViewById(R.id.budRecycler)

        val favButton = findViewById<ImageButton>(R.id.favBtn)
        val clockButton = findViewById<ImageButton>(R.id.clockBtn)
        val homeButton = findViewById<ImageButton>(R.id.homeBtn)
        val disButton = findViewById<ImageButton>(R.id.DisBtn)
        val input = findViewById<EditText>(R.id.inputText1)
        val ProgressBar = findViewById<ProgressBar>(R.id.progressBar)




        favButton.setOnClickListener{
            val intent = Intent(this, Favourite_page::class.java)
            startActivity(intent)
        }

        clockButton.setOnClickListener{
            //val intent = Intent(this, Expirydatelist::class.java)
            startActivity(intent)
        }

        homeButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        disButton.setOnClickListener{
            val intent = Intent(this, Discount_raffle::class.java)
            startActivity(intent)
        }
    }
}