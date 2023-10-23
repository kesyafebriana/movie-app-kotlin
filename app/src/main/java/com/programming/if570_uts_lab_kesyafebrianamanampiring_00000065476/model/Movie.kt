package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val posterUrl: String,
)
