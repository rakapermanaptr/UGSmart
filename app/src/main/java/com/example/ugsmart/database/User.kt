package com.example.ugsmart.database

data class User(
    val id: Long?,
    val username: String?,
    val userEmail: String?,
    val userNPM: String?,
    val userClass: String?,
    val userPassword: String?
) {

    companion object {
        const val TABLE_USER: String = "TABLE_USER"
        const val ID: String = "ID_"
        const val USERNAME: String = "USERNAME"
        const val USER_EMAIL: String = "USER_EMAIL"
        const val USER_NPM: String = "USER_NPM"
        const val USER_CLASS: String = "USER_CLASS"
        const val USER_PASSWORD: String = "USER_PASSWORD"
    }

}