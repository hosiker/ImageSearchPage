package com.companyname.imagesearchpage

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val itemImage: Uri?,
    val itemDate:String?,
    val itemTime:String?,
    val itemLike:Boolean
): Parcelable