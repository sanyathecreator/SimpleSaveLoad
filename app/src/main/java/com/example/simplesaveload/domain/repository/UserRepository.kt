package com.example.simplesaveload.domain.repository

import com.example.simplesaveload.domain.models.UserFullName
import com.example.simplesaveload.domain.models.UserName

interface UserRepository {
    fun saveUsername(username: UserFullName): Boolean
    fun getUsername(): UserName
}