package br.com.dio.contatosbootcamp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(val contactsList: ArrayList<Contact>): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsAdapter.ViewHolder, position: Int) { // esse método serve para pegar a posição do item e mandar para o bindItem no método abaixo e assim bindar (ligar o dado que veio da dataclass, por exemplo: nome e telefone, ao campo especificado na view (no campo específico do layout)
        holder.bindItem(contactsList[position])
    }

    override fun getItemCount(): Int { // essa função pede o tamanho da lista(recyclerview)
        return contactsList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(contact: Contact) {
            val textName = itemView.findViewById<TextView>(R.id.contact_name)
            val textPhone = itemView.findViewById<TextView>(R.id.contact_phone_number)

            textName.text = contact.name
            textPhone.text = contact.phoneNumber
        }

    }
}