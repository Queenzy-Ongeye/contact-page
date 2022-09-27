package dev.queen.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.queen.contacts.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactsDB : RoomDatabase() {
    abstract fun contactDao(): ContactDao
    companion object{
        private var database: ContactsDB? = null

        fun getDatabase(context: Context):ContactsDB{
            if (database === null){
                database = Room
                    .databaseBuilder(context, ContactsDB::class.java, "ContactDB")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as ContactsDB
        }
    }
}