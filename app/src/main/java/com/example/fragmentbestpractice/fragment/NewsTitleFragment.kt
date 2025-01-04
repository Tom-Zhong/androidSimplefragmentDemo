package com.example.fragmentbestpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentbestpractice.NewsContentActivity
import com.example.fragmentbestpractice.R
import com.example.fragmentbestpractice.pojo.News

class NewsTitleFragment: Fragment() {
    private var isTwoPane = false
    private lateinit var newsContentFrag: NewsContentFragment

    inner class NewsAdapter(val newsList: List<News>): RecyclerView.Adapter<NewsAdapter.ViewHolder> () {
        inner class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            val holder = ViewHolder(view)

            holder.itemView.setOnClickListener {
                val news = newsList[holder.bindingAdapterPosition]
                if (isTwoPane) {
                    newsContentFrag = getParentFragmentManager().findFragmentById(R.id.newsContentFrag) as NewsContentFragment
                    newsContentFrag.refresh(news.title, news.content)
                } else {
                    NewsContentActivity.actionStart(parent.context, news.title, news.content)
                }
            }

            return holder
        }

        override fun getItemCount() = newsList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_title_frag, container, false)
        val layoutManager = LinearLayoutManager(activity)
        val newsTitleRecyclerView: RecyclerView = view.findViewById(R.id.newsTitleRecyclerView)
        newsTitleRecyclerView.layoutManager = layoutManager
        val adapter = NewsAdapter(getNews())
        newsTitleRecyclerView.adapter = adapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout) != null
    }

    private fun getNews(): List<News> {
        val newsList = ArrayList<News>()
        for (i in 1..50) {
            val news = News("This is news title $i", getRandomLengthString("This is news content $i. "))
            newsList.add(news)
        }
        return newsList
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }

}