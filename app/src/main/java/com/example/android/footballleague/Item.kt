package com.example.android.footballleague

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val image: Int?, val name: String?, val desc: String?): Parcelable