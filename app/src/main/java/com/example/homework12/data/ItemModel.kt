package com.example.homework12.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class ItemModel (
    val name: String,
    val image: Int,
    val description: String,
    val rate: Float,
    val price: String,
    val id: UUID = UUID.randomUUID(),
) : Parcelable
