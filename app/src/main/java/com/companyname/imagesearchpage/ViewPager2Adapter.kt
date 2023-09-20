package com.companyname.imagesearchpage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val fragments = ArrayList<Tabs>()

    override fun getItemCount(): Int {
        return fragments.size
    }

    init {
        // 뷰페이저에 넣을 프래그먼트
        fragments.add(
            Tabs(SearchResultFragment(), "검색 결과")
        )
        fragments.add(
            Tabs(LikeFragment(), "내 보관함")
        )
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }

    fun getTitle(position: Int): String {
        return fragments[position].title
    }



}