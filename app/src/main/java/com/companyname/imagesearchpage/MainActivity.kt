package com.companyname.imagesearchpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.companyname.imagesearchpage.Adapter.ViewPager2Adapter
import com.companyname.imagesearchpage.Item.ItemY
import com.companyname.imagesearchpage.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    //좋아요 저장하는 리스트
    var likedItems: ArrayList<ItemY> = ArrayList()

    private val viewPager2Adapter by lazy {
        ViewPager2Adapter(this)
    }

    private val tabsIcon = arrayListOf(
        R.drawable.ic_search, R.drawable.ic_thumbs
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager2.adapter = viewPager2Adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.setText(viewPager2Adapter.getTitle(position))
            tab.setIcon(tabsIcon[position])
        }.attach()
    }

    fun addLikedItem(item: ItemY) {
        if(!likedItems.contains(item)) {
            likedItems.add(item)
        }
    }
    fun removeLikedItem(item: ItemY) {
        likedItems.remove(item)
    }
}