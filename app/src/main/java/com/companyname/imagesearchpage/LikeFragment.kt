package com.companyname.imagesearchpage

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.companyname.imagesearchpage.Adapter.ViewAdapter2
import com.companyname.imagesearchpage.Item.ItemY
import com.companyname.imagesearchpage.databinding.FragmentLikeBinding

class LikeFragment : Fragment() {

    private lateinit var mContext:Context
    //좋아요 해제시 null로 되는것 예방
    private var binding:FragmentLikeBinding?=null
    private lateinit var adapter:ViewAdapter2
    //좋아요 저장하는 용도
    private var likedItems:List<ItemY> = listOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext=context
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //메인 액티비티에서 좋아요 눌러서 들어온 리스트를 가져옴
        val mainActivity =activity as MainActivity
        likedItems = mainActivity.likedItems

        adapter = ViewAdapter2(mContext).apply {
            items = likedItems.toMutableList()
        }

        return inflater.inflate(R.layout.fragment_like, container, false)
    }

}