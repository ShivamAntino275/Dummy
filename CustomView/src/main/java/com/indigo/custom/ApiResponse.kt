package com.indigo.custom


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

class ApiResponse : ArrayList<ApiResponse.ApiResponseItem>(){
    @Parcelize
    data class ApiResponseItem(
        @SerializedName("body")
        var body: String? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("userId")
        var userId: Int? = null
    ) : Parcelable
}