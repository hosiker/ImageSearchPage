package com.companyname.imagesearchpage.Item

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.DateTimeException

@Parcelize
data class ItemY(
    var displaySiteName:String?,
    var dateTime: String?,
    var thumbnailUrl:String?,
    var like:Boolean=false
): Parcelable