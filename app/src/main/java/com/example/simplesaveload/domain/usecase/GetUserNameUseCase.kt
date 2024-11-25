package com.example.simplesaveload.domain.usecase

import com.example.simplesaveload.domain.models.Username

class GetUserNameUseCase {
    fun execute() : Username {
        return Username(firstName = "Jack", lastName = "London")
    }
}