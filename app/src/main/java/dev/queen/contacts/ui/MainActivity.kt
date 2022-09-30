package dev.queen.contacts.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.queen.contacts.ConctactRVAdapter
import dev.queen.contacts.Contact
import dev.queen.contacts.databinding.ActivityMainBinding
import dev.queen.contacts.viewModel.ContactViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactViewModel : ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatBtn.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        displayContacts()
    }


    fun displayContacts(){
        val contacts = listOf(contactViewModel.getAllContacts())
        var adapter = ConctactRVAdapter(contacts)
        binding.rvContacts.adapter = adapter
        binding.rvContacts.layoutManager = LinearLayoutManager(baseContext)
    }
}