package dev.queen.contacts.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.queen.contacts.Contact
import dev.queen.contacts.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {
    val contactsRepository = ContactsRepository()

    fun saveContact(contact: Contact){
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }
}