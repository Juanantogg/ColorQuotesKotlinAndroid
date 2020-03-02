package com.juananto11.colorquptes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    private var quoteAuthor: String? = null
    private var quoteText: String? = null
    private var quoteColor: Int? = null

    companion object {
        private const val QUOTE_AUTHOR = "QUOTE_AUTHOR"
        private const val QUOTE_TEXT = "QUOTE_TEXT"
        private const val QUOTE_COLOR = "QUOTE_COLOR"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomQuote(mainLayout)
        println("onCreate")
        Log.d(TAG, "onCreate")
    }

    fun randomQuote(view: View) {
        val quote = QuoteGenerator.getQuote()
        quoteAuthor = quote.author
        quoteText = quote.text
        quoteColor = getRandomColor()
        updateUI()
    }

    private fun updateUI() {
        quoteTextView.text = quoteText
        authorTextView.text = quoteAuthor
        quoteColor?.let {
            mainLayout.setBackgroundColor(it)
            newQuoteButton.setBackgroundColor(it)
        }
    }

    private fun getRandomColor(): Int {
        val rainbow = resources.getIntArray(R.array.rainbow)
        return rainbow.random()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        quoteAuthor = savedInstanceState.getString(QUOTE_AUTHOR)
        quoteText = savedInstanceState.getString(QUOTE_TEXT)
        quoteColor = savedInstanceState.getInt(QUOTE_COLOR)
        updateUI()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(QUOTE_AUTHOR, quoteAuthor)
        outState.putString(QUOTE_TEXT, quoteText)
        quoteColor?.let {
            outState.putInt(QUOTE_COLOR, it)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy")
    }

}
