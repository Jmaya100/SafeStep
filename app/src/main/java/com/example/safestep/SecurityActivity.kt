package com.example.safestep

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.safestep.databinding.ActivitySecurityBinding

class SecurityActivity : AppCompatActivity() {

    private lateinit var b: ActivitySecurityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivitySecurityBinding.inflate(layoutInflater)
        setContentView(b.root)

        loadUserData()

        //  Manage Check-in Time
        b.btnCheckIn.setOnClickListener {
            startActivity(Intent(this, CheckInActivity::class.java))
        }

        //  Manage Password
        b.btnPassword.setOnClickListener {
            startActivity(Intent(this, PasswordActivity::class.java))
        }

        //  Delete Account (show confirmation for now)
        b.btnDeleteAccount.setOnClickListener {
            // You can replace this with a real delete flow later
            android.widget.Toast.makeText(this, "Account deletion disabled for demo", android.widget.Toast.LENGTH_SHORT).show()
        }

        //  Back to Profile
        b.btnBack.setOnClickListener {
            finish()
        }

        //  Bottom Navigation
        b.bottomNav.navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        b.bottomNav.navContacts.setOnClickListener {
            startActivity(Intent(this, ContactsActivity::class.java))
        }

        b.bottomNav.navProfile.setOnClickListener {
            finish()  // returns to ProfileActivity
        }

        b.btnDeleteAccount.setOnClickListener {
            startActivity(Intent(this, DeleteAccountActivity::class.java))
        }

    }

    private fun loadUserData() {
        val prefs = getSharedPreferences("user_profile", MODE_PRIVATE)
        val name = prefs.getString("name", "User")
        b.tvUserName.text = name
    }
}
