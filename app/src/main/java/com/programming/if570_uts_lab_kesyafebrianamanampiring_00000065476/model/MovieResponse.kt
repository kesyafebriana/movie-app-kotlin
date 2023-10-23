package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results") val results: List<Movie>,
    @SerializedName("total_results") val totalResults: Int,   // Total number of results
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("page") val page: Int,

    )
