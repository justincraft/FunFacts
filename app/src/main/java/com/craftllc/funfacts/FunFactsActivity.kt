package com.craftllc.funfacts

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import java.util.*

class FunFactsActivity : AppCompatActivity() {

    private val TAG = FunFactsActivity::class.java.simpleName
    private val factBook = FactBook()

    // Declare View vars
    private var factTextView: TextView? = null
    private var showFactButton: Button? = null
    private var relativeLayout: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun_facts)

        // Assign Views from layout file to the corresponding vars
        factTextView = findViewById(R.id.factTextView)
        showFactButton = findViewById(R.id.showFactButton)
        relativeLayout = findViewById(R.id.factLayoutView)
        showFactButton!!.setOnClickListener {
            // Update view with new fact
            val fact = factBook.getFact()
            factTextView!!.text = fact
            // Update background color
            val rndGen = Random()
            val rndColR = rndGen.nextInt(255)
            val rndColG = rndGen.nextInt(255)
            val rndColB = rndGen.nextInt(255)
            relativeLayout!!.setBackgroundColor(Color.rgb(rndColR, rndColG, rndColB))
            showFactButton!!.setTextColor(Color.rgb(rndColR, rndColG, rndColB))
        }

        //Toast.makeText(this, "Check out these fun facts!", Toast.LENGTH_SHORT).show()
        //Log.d(TAG, "Here is an example log entry.")

    }
}
