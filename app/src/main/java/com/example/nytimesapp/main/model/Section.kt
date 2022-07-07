package com.example.nytimesapp.main.model

import android.os.Parcelable
import com.example.nytimesapp.common.basemvp.Item
import kotlinx.parcelize.Parcelize

@Parcelize
data class Section(
    val section: String?,
    val displayName: String?
) : Item, Parcelable
