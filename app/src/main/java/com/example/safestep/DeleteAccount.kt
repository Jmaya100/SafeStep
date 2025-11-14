package com.example.safestep

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.safestep.databinding.ActivityDeleteAccountBinding

class DeleteAccountActivity : AppCompatActivity() {

    private lateinit var b: ActivityDeleteAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityDeleteAccountBinding.inflate(layoutInflater)
        setContentView(b.root)

        loadUserData()

        b.btnConfirmDelete.setOnClickListener {
            deleteUser()
        }

        b.btnBack.setOnClickListener {
            finish()
        }

        // Bottom Navigation
        b.bottomNav.navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        b.bottomNav.navContacts.setOnClickListener {
            startActivity(Intent(this, ContactsActivity::class.java))
        }
        b.bottomNav.navProfile.setOnClickListener {
            finish()
        }
    }

    private fun loadUserData() {
        val prefs = getSharedPreferences("user_profile", MODE_PRIVATE)
        val name = prefs.getString("name", "User")
        b.tvUserName.text = name
    }

    private fun deleteUser() {
        // remove profile info
        val prefs = getSharedPreferences("user_profile", MODE_PRIVATE)
        prefs.edit().clear().apply()

        // remove settings
        val settings = getSharedPreferences("user_settings", MODE_PRIVATE)
        settings.edit().clear().apply()

        Toast.makeText(this, "Account deleted", Toast.LENGTH_LONG).show()

        // go back to Home (or login)
        val i = Intent(this, MainActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }
}
