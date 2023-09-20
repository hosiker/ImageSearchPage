package com.companyname.imagesearchpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.companyname.imagesearchpage.databinding.FragmentSearchResultBinding

class SearchResultFragment : Fragment() {

    private var binding: FragmentSearchResultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchResultBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datalist = arrayListOf<Item>()

        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,datalist)

        binding?.gridView?.adapter =adapter
    }

}