package com.example.simplesaveload.domain.usecase

class SaveUserNameUseCase {
    fun execute(text: String): Boolean {
        return text.isNotEmpty()
    }
}