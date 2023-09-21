package com.companyname.imagesearchpage.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.companyname.imagesearchpage.Item.ItemY
import com.companyname.imagesearchpage.databinding.GreedviewItemBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

class ViewAdapter2(var mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 좋아요된 리스트 저장소
    var items = mutableListOf<ItemY>()

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = GreedviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // 이미지 로딩 라이브러리(Glide)를 사용해 썸네일 이미지를 로드한다.
        Glide.with(mContext)
            .load(items[position].thumbnailUrl)
            .into((holder as ItemViewHolder).thumbNail)

        holder.title.text = items[position].displaySiteName
        holder.iv_like.visibility = View.GONE // '좋아요' 아이콘을 숨김
        holder.dateTime.text =
            getDateFromTimestampWithFormat(
                items[position].dateTime,
                "yyyy-MM-dd'T'HH:mm:ss.SSS+09:00",
                "yyyy-MM-dd HH:mm:ss"
            )
    }

    inner class ItemViewHolder(binding: GreedviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var thumbNail: ImageView = binding.thumbnailImage
        var iv_like: ImageView = binding.likeImage
        var title: TextView = binding.itemTitle
        var dateTime: TextView = binding.itemDatetime
        var cl_item: ConstraintLayout = binding.gridViewLayout

        init {
            // 아이템 클릭 리스너 설정
            cl_item.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    items.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    //이 부분은 아직 이해 덜됬음 복습 이해 필요
    fun getDateFromTimestampWithFormat(
        timestamp: String?,
        fromFormatformat: String?,
        toFormatformat: String?
    ): String {
        var date: Date? = null
        var res = ""
        try {
            val format = SimpleDateFormat(fromFormatformat)
            date = format.parse(timestamp)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        Log.d("jbdate", "getDateFromTimestampWithFormat date >> $date")

        val df = SimpleDateFormat(toFormatformat)
        res = df.format(date)
        return res
    }
}