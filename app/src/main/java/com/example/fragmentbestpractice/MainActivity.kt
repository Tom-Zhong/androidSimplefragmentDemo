package com.example.fragmentbestpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentbestpractice.databinding.NewsTitleFragBinding
import com.example.fragmentbestpractice.fragment.NewsTitleFragment
import com.example.fragmentbestpractice.pojo.News
import com.example.fragmentbestpractice.ui.theme.FragmentBestPracticeTheme

class MainActivity : FragmentActivity() {
    private lateinit var NewsTitleFragBinding: NewsTitleFragBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }
}