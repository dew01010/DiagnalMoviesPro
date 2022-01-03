package com.example.diagnal.data.model

import com.google.gson.annotations.SerializedName

class Movies(
    @SerializedName("name") val name: String,
    @SerializedName("poster-image") val posterImage: String,
)