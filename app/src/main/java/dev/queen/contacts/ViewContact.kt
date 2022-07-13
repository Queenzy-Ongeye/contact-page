package dev.queen.contacts

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dev.queen.contacts.databinding.ActivityViewContactBinding

class ViewContact : AppCompatActivity() {
    lateinit var bindingView: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingView = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(bindingView.root)
        getExtras()


    }

    fun getExtras(){
        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        val extras = intent
        var name = extras.getStringExtra("NAME")
        var phone = extras.getStringExtra("PHONE")
        var email = extras.getStringExtra("EMAIL")
        var address = extras.getStringExtra("ADDRESS")

        var image = bindingView.imgProfile
        actionBar.setTitle(name)
        bindingView.tvNameOne.text = name
        bindingView.tvNumber.text = phone
        bindingView.tvEmailOne.text = email
        bindingView.tvAddress.text = address

        Picasso.get()
            .load(intent.getStringExtra("PROFILE"))
            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(image)

    }
}


