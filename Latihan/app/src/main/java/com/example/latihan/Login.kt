package com.example.latihan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class Login : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var welcome:TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("welcome")
            welcome.text = returnString
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        welcome = findViewById(R.id.tv_welcome)
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)

        val bundle :Bundle? = intent.extras
        if (bundle != null) {
            etUsername.setText(bundle.getString("username"))
            etPassword.setText(bundle.getString("password"))
        }

        val btnLogin : Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_login -> {
                val userObject = user(etUsername.text.toString(), etPassword.text.toString())
                val intent = Intent(this@Login, MainActivity::class.java)
                intent.putExtra("user", user(etUsername.text.toString(), etPassword.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}