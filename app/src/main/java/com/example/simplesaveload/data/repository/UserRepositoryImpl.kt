package com.example.simplesaveload.data.repository

import com.example.simplesaveload.data.storage.models.User
import com.example.simplesaveload.data.storage.UserStorage
import com.example.simplesaveload.domain.models.UserFullName
import com.example.simplesaveload.domain.models.UserName
import com.example.simplesaveload.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun saveUsername(username: UserFullName): Boolean {
        return userStorage.save(mapToStorage(username))
    }

    override fun getUsername(): UserName {
        return mapToDomain(userStorage.get())
    }

    private fun mapToStorage(username: UserFullName): User {
        return User(firstName = username.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}