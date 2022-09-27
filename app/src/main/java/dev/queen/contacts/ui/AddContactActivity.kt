package dev.queen.contacts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dev.queen.contacts.Contact
import dev.queen.contacts.R
import dev.queen.contacts.databinding.ActivityAddContactBinding
import dev.queen.contacts.viewModel.ContactViewModel

class AddContactActivity : AppCompatActivity() {
    lateinit var addBinding : ActivityAddContactBinding
    val contactViewModel : ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addBinding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(addBinding.root)
    }

    override fun onResume() {
        super.onResume()
        addBinding.btnAdd.setOnClickListener {
            validateContact()
        }
    }

    fun validateContact(){
        val name = addBinding.etName.text.toString()
        val phone = addBinding.etPhone.text.toString()
        val email = addBinding.etEmail.text.toString()
        val address = addBinding.etName.text.toString()
        var error = false

        if (name.isBlank()){


        }

        val contact = Contact(
            contactId = 0,
            name = name,
            email = email,
            address = address,
            phone = phone,
            imgView = ""
        )
        contactViewModel.saveContact(contact)
        finish()
    }


}