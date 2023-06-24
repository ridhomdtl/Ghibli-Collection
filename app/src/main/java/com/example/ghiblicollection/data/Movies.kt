package com.example.ghiblicollection.data

import java.io.Serializable

data class Movies(
    val id: Int,
    val name: String,
    val desc: String,
    val imageUrl: String
) : Serializable
