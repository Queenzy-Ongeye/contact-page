package dev.queen.contacts.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.queen.contacts.ConctactRVAdapter
import dev.queen.contacts.Contact
import dev.queen.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()

        binding.floatBtn.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }
    }

    fun displayContacts(){
        var contact_one = Contact( 5,"Anne", "500  Owiti Rd", "0000000","anne.com", "https://images.pexels.com/photos/935985/pexels-photo-935985.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact_two = Contact( 6,"Suzzana", "00-00 thika", "5555555","sue.org", "https://images.pexels.com/photos/871495/pexels-photo-871495.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact_three = Contact(50,"Kelv", "Zero Lane Plaza", "05500055","kel-matan.com", "https://images.pexels.com/photos/2033447/pexels-photo-2033447.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact_four = Contact(65,"Bina", "000,Ocean Peak", "550055600","bina-mos.com", "https://images.pexels.com/photos/3031396/pexels-photo-3031396.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact_five = Contact(55,"Anne Brenda", "500 Dongle-Rd", "0000000","anne.com", "https://images.pexels.com/photos/935985/pexels-photo-935985.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact_six = Contact(66,"George", "Kenyatta Rd.", "0000000","anne.com", "https://images.pexels.com/photos/2033447/pexels-photo-2033447.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact_seven = Contact(56,"Gg", "Kenyatta Rd.", "0000000","anne.com", "https://images.pexels.com/photos/2033447/pexels-photo-2033447.jpeg?auto=compress&cs=tinysrgb&w=400")

        var contList = listOf(contact_one, contact_two, contact_three, contact_four,contact_five,contact_six,contact_seven)
        var contactAdapter = ConctactRVAdapter(contList)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = contactAdapter
    }
}