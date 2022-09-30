package dev.queen.contacts.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.queen.contacts.Contact
import dev.queen.contacts.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {
    val contactsRepository = ContactsRepository()
    lateinit var contactLiveData : LiveData<List<Contact>>

    fun saveContact(contact: Contact){
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }

    fun getAllContacts(){
        contactLiveData = contactsRepository.fetchContacts()
    }
}