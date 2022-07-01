package com.example.tbc_shemajamebeli_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

private var words = hashMapOf<String, String>()
private var words2 = arrayListOf<String>()

//for array groups
private var finalList:Array<String> = arrayOf()

//validate word
fun String.onlyLetters() = all { it.isLetter() }
private  fun isValidWord(name: String):Boolean {
    if (name.onlyLetters())  return true
    return false

}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var input: EditText = findViewById<EditText>(R.id.inputAnagram)
        val saveButton: Button = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            if (isValidWord(input.text.toString().trim())) {
                var temp = input.text.toString()
                words.put(temp, temp.lowercase())
                Toast.makeText(this, "Word inserted", Toast.LENGTH_LONG).show()

            } else Toast.makeText(this, "Wrong input", Toast.LENGTH_LONG).show()
        }

        val outputButton: Button = findViewById<Button>(R.id.outputButton)
        var anagramCount: TextView = findViewById<TextView>(R.id.anagramsCount)
        outputButton.setOnClickListener {
            //iterate through list
            for (str in words) {
                val arr = str.value.toCharArray()
                words[str.key] = arr.sorted().joinToString("")
            }

            for (str in words) {
                words2.add(str.value)
            }

            //how many containers we should get
            //output answer
            anagramCount.text = "Anagram count " + words2.distinct().size.toString()

            //did not manage to finish

            //create group lists
            //that was also asked to do
            var i:Int =0
            var j:Int=0
            var Temp = arrayOf<String>()
            for(a in words2){
                for (b in words){
                    if(a==b.value){
                        Temp[i]=(b.key)

                    }
//                    finalList[j]=Temp
                }
            }
        }


    }
}