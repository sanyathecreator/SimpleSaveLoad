package com.example.simplesaveload.domain.usecase

import com.example.simplesaveload.domain.models.UserFullName
import com.example.simplesaveload.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(userFullName: UserFullName): Boolean {
        return userRepository.saveUsername(userFullName)
    }
}