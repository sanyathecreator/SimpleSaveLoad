package com.example.simplesaveload.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.simplesaveload.R

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        val displayText = findViewById<TextView>(R.id.display_text)
        val inputField = findViewById<EditText>(R.id.input_field)
        val saveButton = findViewById<Button>(R.id.save_button)
        val loadButton = findViewById<Button>(R.id.load_button)

        vm.resultLive.observe(this) {
            displayText.text = it
        }

        saveButton.setOnClickListener {
            val text = inputField.text.toString()
             vm.save(text)
        }

        loadButton.setOnClickListener {
            vm.load()
        }
    }
}