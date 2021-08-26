package com.example.ums

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun navigateUpTo(upIntent: Intent?): Boolean {
        return Navigation.findNavController(this, R.id.navHost).navigateUp()
    }
}