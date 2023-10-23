package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
)

