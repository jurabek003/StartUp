package com.turgunboyevjurabek.startup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.turgunboyevjurabek.startup.databinding.ActivitySpalashBinding

class SpalashActivity : AppCompatActivity() {
    val binding by lazy { ActivitySpalashBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        },700)

    }
}