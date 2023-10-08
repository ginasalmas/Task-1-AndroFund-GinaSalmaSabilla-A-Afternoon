package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv =findViewById(R.id.textView2)

        val username = intent.getParcelableExtra<user>("user")?.username
        val password = intent.getParcelableExtra<user>("user")?.password
        tv.text = "Hallo $username"

        val btnLogout : Button = findViewById(R.id.btn_logout)
        btnLogout.setOnClickListener(this)

        val btnMore : Button = findViewById(R.id.btn_more)
        btnMore.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_logout -> {
            val intent = Intent()
            intent.putExtra("welcome", "Selamat Datang Kembali!")
            setResult(RESULT_OK, intent)
            finish()
            }
            R.id.btn_more -> {
                val intent = Intent(this@MainActivity, MoreActivity::class.java)
                startActivity(intent)
            }
        }
    }
}