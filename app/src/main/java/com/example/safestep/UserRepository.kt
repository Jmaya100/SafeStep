package com.example.safestep

object UserRepository {
    var currentUser = User()

    fun updateUser(name: String, address: String, phone: String) {
        currentUser.name = name
        currentUser.address = address
        currentUser.phone = phone
    }
}



