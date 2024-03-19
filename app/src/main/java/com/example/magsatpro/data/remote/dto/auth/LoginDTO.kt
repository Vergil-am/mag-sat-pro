package com.example.magsatpro.data.remote.dto.auth

data class LoginDTO(
    val msg: String,
    val status: Int,
    val code: String?,
    val expire: String?,
    val hash: String?
)