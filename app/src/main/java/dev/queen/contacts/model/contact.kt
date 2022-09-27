package dev.queen.contacts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")

data class Contact(
    @PrimaryKey(autoGenerate = true) var contactId : Int,
    var name: String,
    var address: String,
    var phone: String,
    var email: String,
    var imgView: String
)
