package com.example.simplesaveload.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplesaveload.domain.models.UserFullName
import com.example.simplesaveload.domain.usecase.GetUserNameUseCase
import com.example.simplesaveload.domain.usecase.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase: GetUserNameUseCase, private val saveUserNameUseCase: SaveUserNameUseCase): ViewModel() {
    private var resultLiveMutable = MutableLiveData<String>()
    var resultLive: LiveData<String> = resultLiveMutable

    fun save(text: String) {
        val fullName = UserFullName(name = text)
        val result = saveUserNameUseCase.execute(userFullName = fullName)
        resultLiveMutable.value = "Result: $result"
    }

    fun load() {
        val username = getUserNameUseCase.execute()
        resultLiveMutable.value = "${username.firstName} ${username.lastName}"
    }
}