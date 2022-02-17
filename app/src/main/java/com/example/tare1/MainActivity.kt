package com.example.tare1

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private val TAG="MainActivity"
private val TEXT="TEXT_CONTENT"

class MainActivity : AppCompatActivity() {

    private var textview: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Referencias a los elementos de la aplicación
         val editText: EditText=findViewById<EditText>(R.id.editTextTextPersonName)
         val button:Button=findViewById<Button>(R.id.button)
         val textview:TextView=findViewById<TextView>(R.id.textView)

        textview?.text = ""
        textview?.movementMethod=ScrollingMovementMethod()


        //Funcionalidad del botton
        button?.setOnClickListener(object :View.OnClickListener{
            override  fun onClick(p0:View?){
               Log.d(TAG,"onClick")
                textview?.append(editText.text)
               textview?.append("\n")
                    //editText.setText("")
                editText.text.clear()
            }

        })

    }
    override fun onStart() {
        Log.d(TAG,"onStart")
        super.onStart()
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG,"onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        textview?.text=savedInstanceState.getString(TEXT,  "")
    }
    override fun onResume(){
        Log.d(TAG,"onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG,"onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT,textview?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG,"onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG,"onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy")
        super.onDestroy()
    }
}