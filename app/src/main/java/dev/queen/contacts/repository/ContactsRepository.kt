package dev.queen.contacts.repository

import androidx.lifecycle.LiveData
import dev.queen.contacts.Contact
import dev.queen.contacts.Contacts
import dev.queen.contacts.database.ContactsDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDB.getDatabase(Contacts.appContext)

    suspend fun saveContact(contact: Contact){
        withContext(Dispatchers.IO){
            database.contactDao().insertContact(contact)
        }
    }

    fun fetchContacts(): LiveData<List<Contact>>{
        return  database.contactDao().getAllContacts()
    }
}