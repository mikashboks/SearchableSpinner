package com.leo.searchablespinnerexample

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leo.searchablespinnerexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityBinding = DataBindingUtil.inflate<ActivityMainBinding>(
            LayoutInflater.from(this), R.layout.activity_main, null, false
        )
        setContentView(activityBinding.root)
        activityBinding.materialButtonKotlin.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    KotlinImplementation::class.java
                )
            )
        }
    }
}
