package com.chunyu.glidelearnning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private var isLoading = false

    private fun initView() {
        loadBtn.setOnClickListener {
            isLoading = !isLoading
            if (!isLoading) {
//                Glide.with(this).load("https://www.baidu.com/img/flexible/logo/pc/result.png").into(imageView)
                loadImg()
            } else {
                Glide.with(this).clear(imageView)
            }
        }
    }

    private fun loadImg() {
        Glide.with(this)
            .applyDefaultRequestOptions(RequestOptions().circleCrop().skipMemoryCache(false).diskCacheStrategy(
                DiskCacheStrategy.NONE))
            .load("https://www.baidu.com/img/flexible/logo/pc/result.png").into(imageView)
    }
}