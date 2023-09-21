package com.companyname.imagesearchpage.Item


import com.google.gson.annotations.SerializedName

//Respone : 결과를 받아오는 클래스
data class ItemX(
    @SerializedName("meta")
    val metaData: Metadata,

    @SerializedName("documents")
    val documents: ArrayList<Documents>
)

//Meta : 필요한 값 지정
data class Metadata(
    @SerializedName("totalCount")
    val totalCount:Int,

    @SerializedName("pageableCount")
    val pageableCount:Int,

    @SerializedName("isEnd")
    val isEnd:Boolean
)
//Documents : 필요한 값 지정
data class Documents(
    @SerializedName("thumbnailUrl")
    val thumbnailUrl:String,

    @SerializedName("display_sitename")
    val displaySiteName:String,

    @SerializedName("datetime")
    val dateTime:String,

    @SerializedName("collection")
    val collection: String,

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("width")
    val width: Int,

    @SerializedName("height")
    val height: Int,

    @SerializedName("doc_url")
    val docUrl: String
)