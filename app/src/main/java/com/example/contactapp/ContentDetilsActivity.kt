package com.example.contactapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactapp.DataClasses.Contact
import com.example.contactapp.databinding.ActivityContentDetilsBinding

@Suppress("DEPRECATION")
class ContentDetilsActivity : AppCompatActivity() {
    lateinit var binding: ActivityContentDetilsBinding


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding=ActivityContentDetilsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActivityView()

    }

    private fun navBack(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }





    ///////////////////////////////////////////////////
    private fun setActivityView() {
        var contact =
            IntentCompat.getParcelableExtra(intent, Constants.CONTACT, Contact::class.java)
        contact?.let {

            binding.nameDetelis.text = contact.name
            binding.nameDetelis2.text = contact.name
            binding.phoneDetils.text = contact.phone
            binding.descDetils.text = contact.description


        }
    }
    /////////////////////////////////////////
}