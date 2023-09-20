package com.companyname.imagesearchpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.companyname.imagesearchpage.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

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
}