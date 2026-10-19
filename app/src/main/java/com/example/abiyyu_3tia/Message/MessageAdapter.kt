package com.example.abiyyu_3tia.Message

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.abiyyu_3tia.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter (
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = messages[position]

        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        view.setOnClickListener {
            val intent = Intent(context, MessageActivity::class.java)
            intent.putExtra("SENDER", data.senderName)
            intent.putExtra("MESSAGE", data.messageText)
            context.startActivity(intent)
//            Snackbar.make(
//                parent,
//                "Pesan dari ${data.senderName}: ${data.messageText}",
//                Snackbar.LENGTH_SHORT
//            ).show()
        }

        return view
    }
}