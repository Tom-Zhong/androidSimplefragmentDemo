package com.example.fragmentbestpractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.fragmentbestpractice.databinding.ActivityNewsContentBinding
import com.example.fragmentbestpractice.fragment.NewsContentFragment

class NewsContentActivity : FragmentActivity() {
    private lateinit var activityNewsContentBinding: ActivityNewsContentBinding
    companion object {
       fun actionStart (context: Context, title: String, content: String) {
           val intent = Intent(context, NewsContentActivity::class.java).apply {
               putExtra("news_title", title)
               putExtra("news_content", content)
           }
           context.startActivity(intent)
       }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activityNewsContentBinding = ActivityNewsContentBinding.inflate(layoutInflater)
        val view = activityNewsContentBinding.root
        setContentView(view)

        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")
        if (title != null && content != null) {
            val newsContentFrag = supportFragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
            newsContentFrag.refresh(title, content)
        }
    }
}