package dev.queen.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.queen.contacts.databinding.ContactListItemBinding

class ConctactRVAdapter(var contactList: List<Contact>) :
    RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        var binding =
            ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentItem = contactList.get(position)
//        val contactBinding = holder.binding
//        contactBinding.tvName.text = currentItem.name
//        contactBinding.tvPhone.text = currentItem.phone
//        contactBinding.tvEmail.text = currentItem.email
//        contactBinding.tvAdd.text = currentItem.address

        with(holder.binding) {
            tvName.text = currentItem.name
            tvPhone.text = currentItem.phone
            tvEmail.text = currentItem.email
            tvAdd.text = currentItem.address

            Picasso
                .get()
                .load(currentItem.imgView)
                .resize(500, 500)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(imageView2)

        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

class ContactViewHolder(var binding: ContactListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {


}

