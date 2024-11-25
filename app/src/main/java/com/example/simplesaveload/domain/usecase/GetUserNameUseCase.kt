package com.example.simplesaveload.domain.usecase

import com.example.simplesaveload.domain.models.UserName
import com.example.simplesaveload.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute() : UserName {
        return userRepository.getUsername()
    }
}