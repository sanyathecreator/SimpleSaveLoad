package com.example.simplesaveload.data.storage

import com.example.simplesaveload.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}