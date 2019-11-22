package com.rphmelo.cnjokes.jokes.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class JokeResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("icon_url")
    val iconUrl: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("value")
    val value: String?
): Serializable
