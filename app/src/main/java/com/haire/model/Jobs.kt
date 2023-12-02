package com.haire.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Jobs(
    val id: Int,
    val image: Int,
    val alamat: String,
    val pekerjaan: String,
    val provinsi: String
) : Parcelable
