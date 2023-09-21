package com.companyname.imagesearchpage

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.adapters.SearchViewBindingAdapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.companyname.imagesearchpage.Adapter.ViewAdapter
import com.companyname.imagesearchpage.Item.Client.apiService
import com.companyname.imagesearchpage.Item.ItemX
import com.companyname.imagesearchpage.Item.ItemY
import com.companyname.imagesearchpage.databinding.FragmentSearchResultBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchResultFragment : Fragment() {

    private lateinit var binding: FragmentSearchResultBinding
    private lateinit var mContext: Context
    private lateinit var adapter: ViewAdapter

    private var resItems:ArrayList<ItemY> = ArrayList()

    override fun onAttach(context: Context){
        super.onAttach(context)
        mContext =context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchResultBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var gridView = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerViewLayout.layoutManager = gridView

        adapter = ViewAdapter(mContext)
        binding.recyclerViewLayout.adapter = adapter

        // 검색 버튼 기능
        binding.searchBtn.setOnClickListener {
            //검색어 입력창을 의미
            val query = binding.search.text.toString()

            if(query.isNotEmpty()){
                adapter.clearItem()
                fetchImageResults(query)
            }
            else{
                Toast.makeText(mContext,"검색어가 없습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchImageResults(query: String) {
        apiService.getItem(Constants.AUTH_HEADER, query, "recency", 1, 80)
            ?.enqueue(object : Callback<ItemX?> {
                override fun onResponse(call: Call<ItemX?>, response: Response<ItemX?>) {
                    response.body()?.metaData?.let { metaData ->
                        if (metaData.totalCount!! > 0) {
                            response.body()!!.documents.forEach { document ->
                                val title = document.displaySiteName
                                val datetime:String? = document.dateTime
                                val url = document.thumbnailUrl
                                resItems.add(ItemY(title,datetime,url))
                            }
                        }
                    }
                    adapter.items = resItems
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<ItemX?>, t: Throwable) {
                    Toast.makeText(mContext,"검색 실패.",Toast.LENGTH_SHORT).show()
                }
            })
    }

}