package com.companyname.imagesearchpage

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.companyname.imagesearchpage.Adapter.ViewAdapter2
import com.companyname.imagesearchpage.Item.ItemY
import com.companyname.imagesearchpage.databinding.FragmentLikeBinding

class LikeFragment : Fragment() {

    private lateinit var mContext:Context

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

        binding = FragmentLikeBinding.inflate(inflater,container,false).apply {
            likeRecyclerViewLayout.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            likeRecyclerViewLayout.adapter=adapter
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}