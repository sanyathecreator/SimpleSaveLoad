package com.example.simplesaveload.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simplesaveload.data.repository.UserRepositoryImpl
import com.example.simplesaveload.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.simplesaveload.domain.usecase.GetUserNameUseCase
import com.example.simplesaveload.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val sharedPreferencesUserStorage by lazy {
        SharedPrefUserStorage(
            context = context
        )
    }
    private val userRepository by lazy {
        UserRepositoryImpl(
            userStorage = sharedPreferencesUserStorage
        )
    }
    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase = getUserNameUseCase, saveUserNameUseCase = saveUserNameUseCase) as T
    }
}