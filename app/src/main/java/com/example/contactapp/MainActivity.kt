package com.example.contactapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
 import androidx.appcompat.app.AppCompatActivity
import com.example.contactapp.DataClasses.Adapter
import com.example.contactapp.DataClasses.Contact
 import com.example.contactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var name: String
    lateinit var phone: String
    lateinit var description: String
    lateinit var adapter: Adapter
    lateinit var list: List<Contact>
    val contactlist= mutableListOf<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initiRecyclerView()
        saveButtonClick()
        adapter.oncontactItemClickListener=
            Adapter.onContactItemClickListener { item ->
                intentToContentDetials(item)


            }
    }
////////////////////////////////////////////////////////////////////////////////////////////
    private fun intentToContentDetials(item: Contact) {
        var intant = Intent(this@MainActivity, ContentDetilsActivity::class.java)
        intant.putExtra(Constants.CONTACT, item)

        startActivity(intant)
    }

    ////////////////////////////////////////////////////////////////////////////////////
    private fun initiRecyclerView() {
        adapter = Adapter(contactlist)
    binding.recyView.adapter=adapter
    }

    ///////////////////////////////////////////////////////////////////////////
    @SuppressLint("SuspiciousIndentation")
    private fun saveButtonClick() {
        binding.saveButton.setOnClickListener {
            if (!validetTextView()) {
                return@setOnClickListener
            }
            name = binding.editTextName.text?.trim().toString()
            phone = binding.editTextPhone.text?.trim().toString()
            description = binding.editTextDescription.text?.trim().toString()
            val contact = Contact(name, phone, description)
                contactlist.add(contact)
            adapter.notifyItemInserted(contactlist.size-1)


        }}


    //////////////////////////////////////////////////////////
    fun validetTextView():Boolean{
            name=binding.editTextName.text?.trim().toString()
            phone=binding.editTextPhone.text?.trim().toString()
            binding.titleName.error=validateName(name)
            binding.titlePhone.error=validatePhone(phone)
return validateName(name)==null&&validatePhone(phone)==null


    }
    //////////////////////////////////////////////////////
    fun validateName(name:String):String?{

        if (name.trim().length<3){
            return "Name can't be than 3 characters"}
        if (name.isEmpty())
        { return "required"}
    return null
    }


////////////////////////////////////////////////
    fun validatePhone(phone:String):String?{

        if (phone.isEmpty()){
            return "required"
        }
        if (phone.trim().length<11)
            return "phone can't be than 11 number"
    return null
}

/////////////////////////////////////////////////////////////////////////////




















}