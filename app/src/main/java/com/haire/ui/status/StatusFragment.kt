package com.haire.ui.status

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.haire.R
import com.haire.databinding.StatusFragmentBinding

class StatusFragment : Fragment() {
    private lateinit var binding: StatusFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StatusFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}