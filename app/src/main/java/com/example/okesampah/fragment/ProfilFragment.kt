package com.example.okesampah.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.okesampah.R
import com.example.okesampah.helper.SharedPref

/**
 * A simple [Fragment] subclass.
 * Use the [ProfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfilFragment : Fragment() {

    lateinit var s:SharedPref
    lateinit var btnLogout:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_profil, container, false)

        btnLogout = view.findViewById(R.id.btnLogout)

        s = SharedPref(requireActivity())

        btnLogout.setOnClickListener {
            s.setStatusLogin(false)
        }
        return view
    }

}