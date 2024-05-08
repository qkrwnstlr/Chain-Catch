package com.dtd.chaincatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dtd.chaincatch.drawing.fragment.DrawingFragment

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    supportFragmentManager.beginTransaction().replace(R.id.framelayout, DrawingFragment()).commit()
  }
}