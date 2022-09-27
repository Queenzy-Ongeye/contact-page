package dev.queen.contacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dev.queen.contacts.databinding.ContactListItemBinding
import dev.queen.contacts.ui.ViewContact

class ConctactRVAdapter(var contactList: List<Contact>) :
    RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        var binding =
            ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentItem = contactList.get(position)
        val context = holder.itemView.context
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
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView2)

            cvCons.setOnClickListener {
                var intent = Intent(context, ViewContact::class.java)
                intent.putExtra("NAME", currentItem.name)
                intent.putExtra("PHONE", currentItem.phone)
                intent.putExtra("EMAIL", currentItem.email)
                intent.putExtra("ADDRESS", currentItem.address)
                intent.putExtra("PROFILE", currentItem.imgView)
                context.startActivity(intent)
            }
        }

        holder.binding.imageView2.setOnClickListener {
            Snackbar.make(it, "Beautiful people", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

class ContactViewHolder(var binding: ContactListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {


}

