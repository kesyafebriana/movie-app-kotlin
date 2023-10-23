package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model

import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("id") val id: Long,
    @SerializedName("original_title") val title: String,
    @SerializedName("poster_path") val posterUrl: String,
    @SerializedName("overview") val synopsis: String,
    @SerializedName("genres") val genres: List<Genre>,
)