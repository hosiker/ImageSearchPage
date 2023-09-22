package com.companyname.imagesearchpage.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.companyname.imagesearchpage.Item.ItemY
import com.companyname.imagesearchpage.MainActivity
import com.companyname.imagesearchpage.databinding.FragmentSearchResultBinding
import com.companyname.imagesearchpage.databinding.GreedviewItemBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

class ViewAdapter(private val mContext: Context) : RecyclerView.Adapter<ViewAdapter.ItemViewHolder>() {

    var items = ArrayList<ItemY>()

    override fun getItemCount(): Int {
        return items.size
    }
    fun clearItem(){
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdapter.ItemViewHolder {
        val binding = GreedviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder:ItemViewHolder,position:Int){
        val item = items[position]

        Glide.with(mContext).load(item.thumbnailUrl).into(holder.thumbNail)

        holder.like.visibility = if (item.like) View.VISIBLE else View.INVISIBLE
        holder.title.text = item.displaySiteName
        holder.dateTime.text = getDateFromTimestampWithFormat(item.dateTime,"yyyy-MM-dd'T'HH:mm:ss.SSS+09:00","yyyy-MM-dd HH:mm:ss")

    }

    //불러온 greedview_item binding 에다가 값 배치
    inner class ItemViewHolder(binding:GreedviewItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        var thumbNail = binding.thumbnailImage
        var title = binding.itemTitle
        var dateTime =binding.itemDatetime
        var like = binding.likeImage

        init {
            like.visibility=View.GONE
            binding.gridViewLayout.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition.takeIf { it !=RecyclerView.NO_POSITION }?:return
            val item = items[position]

            item.like=!item.like

            if (item.like){
                (mContext as MainActivity).addLikedItem(item)
            }
            else{
                (mContext as MainActivity).removeLikedItem(item)
            }

            notifyItemChanged(position)
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