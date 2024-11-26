package com.example.simplesaveload.presentation

import android.os.Bundle
import android.app.Activity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.simplesaveload.R
import com.example.simplesaveload.data.repository.UserRepositoryImpl
import com.example.simplesaveload.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.simplesaveload.domain.models.UserFullName
import com.example.simplesaveload.domain.usecase.GetUserNameUseCase
import com.example.simplesaveload.domain.usecase.SaveUserNameUseCase

class MainActivity : Activity() {
    private val sharedPreferencesUserStorage by lazy { SharedPrefUserStorage(context = applicationContext) }
    private val userRepository by lazy { UserRepositoryImpl(sharedPreferencesUserStorage) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayText = findViewById<TextView>(R.id.display_text)
        val inputField = findViewById<EditText>(R.id.input_field)
        val saveButton = findViewById<Button>(R.id.save_button)
        val loadButton = findViewById<Button>(R.id.load_button)

        saveButton.setOnClickListener {
            val text = inputField.text.toString()
            val fullName =  UserFullName(name = text)
            val result = saveUserNameUseCase.execute(userFullName = fullName)
            displayText.text = "Result: $result"
        }
        loadButton.setOnClickListener {
            val username = getUserNameUseCase.execute()
            displayText.text = "${username.firstName} ${username.lastName}"
        }
    }
}