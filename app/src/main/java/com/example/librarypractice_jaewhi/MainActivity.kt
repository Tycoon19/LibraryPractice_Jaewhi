package com.example.librarypractice_jaewhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileImg.setOnClickListener {

        val myIntent = Intent(this, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)

        }

//        인터넷에 있는 이미지(https:///...)를 이미지뷰에 바로 대입

        Glide.with(this).load("https://i.ytimg.com/vi/qk8mlbBhHuY/maxresdefault.jpg").into(filmoImg)

    }
}