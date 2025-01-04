package com.example.fragmentbestpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragmentbestpractice.R

class NewsContentFragment : Fragment() {
    private lateinit var contentLayout: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contentLayout = inflater.inflate(R.layout.news_content_frag, container, false)
        return contentLayout
    }

    fun refresh(title: String, content: String) {
        contentLayout.findViewById<LinearLayout>(R.id.contentLayout).visibility = View.VISIBLE
        contentLayout.findViewById<TextView>(R.id.newsTitle).text = title
        contentLayout.findViewById<TextView>(R.id.newsContent).text = content
    }
}