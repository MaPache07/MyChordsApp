package com.mapache.mychords.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapache.mychords.R

class MyChordsFragment : Fragment(){

    lateinit var viewF: View

    companion object{
        fun newInstance():MyChordsFragment{
            val newFragment = MyChordsFragment()
            return newFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewF = inflater.inflate(R.layout.fragment_my_chords, container, false)
        return viewF
    }
}