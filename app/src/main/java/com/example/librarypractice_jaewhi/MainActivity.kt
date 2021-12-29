package com.example.librarypractice_jaewhi

import android.content.Intent
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

        profileImg.setOnClickListener {

        val myIntent = Intent(this, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)

        }

//        인터넷에 있는 이미지(https:///...)를 이미지뷰에 바로 대입

        Glide.with(this).load("https://i.pinimg.com/564x/00/82/29/008229ddb8cb675158b1c00449aa86f9.jpg").apply(
            RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE)
        ).into(filmoImg)

//        전화걸기 버튼 누름 => 권한 확인 / 전화 연결
        callBtn.setOnClickListener {

//            라이브러리 활용 => 전화 권한 확인 => 실제 전화 연결

        }

    }
}