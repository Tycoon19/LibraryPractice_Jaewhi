package com.example.librarypractice_jaewhi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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

            val permissionListener = object : PermissionListener{
                override fun onPermissionGranted() {
//                권한 승인 -> 실제로 전화 연결 진행.

                    val myUri = Uri.parse("tel:010-2222-3333")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)

                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                권한 거절 -> 토스로, 권한이 없어서 전화 연결 실패

                    Toast.makeText(this@MainActivity,"권한이 없어서 전화 연결에 실패했습니다.",Toast.LENGTH_SHORT).show()


                }


            }

        }

    }
}