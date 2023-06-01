package com.example.okesampah.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.okesampah.R
import com.example.okesampah.adapter.AdapterPelanggan
import com.example.okesampah.adapter.AdapterSlider
import com.example.okesampah.model.Pelanggan


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var vpSlider :ViewPager
    lateinit var rvPelanggan : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_home, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)
        rvPelanggan = view.findViewById(R.id.rv_pelanggan)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)

        //Slider
        val adapterSlider = AdapterSlider(arrSlider,activity)
        vpSlider.adapter = adapterSlider

        //recyclerView database
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvPelanggan.adapter = AdapterPelanggan(arrPelanggan)
        rvPelanggan.layoutManager = layoutManager

        return view
    }

    val arrPelanggan: ArrayList<Pelanggan>get(){
        val arr = ArrayList<Pelanggan>()
        val p1 = Pelanggan()
        p1.nama = "Andika Zulfiansyah"
        p1.nik = "6104172603990004"
        p1.status = "Sudah Approve"

        val p2 = Pelanggan()
        p2.nama = "Budi"
        p2.nik = "6104123124039304"
        p2.status = "Belum Approve"

        val p3 = Pelanggan()
        p3.nama = "Joko"
        p3.nik = "6105121512315123"
        p3.status = "Tidak Aktif"

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }

}