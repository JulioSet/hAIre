package com.haire.ui.openjobs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.haire.databinding.OpenJobsFragmentBinding
import com.haire.model.InitialJobsValue
import com.haire.model.Jobs
import com.haire.ui.detail.DetailActivity

class OpenJobsFragment : Fragment() {

    private lateinit var binding: OpenJobsFragmentBinding
    private lateinit var viewModel: OpenJobsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[OpenJobsViewModel::class.java]
        binding = OpenJobsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData(InitialJobsValue.dummyJobs)
    }

    private fun setData(listJobs: List<Jobs>) {
        val listJob = ArrayList<Jobs>()
        binding.apply {
            for (a in listJobs) {
                listJob.clear()
                listJob.addAll(listJobs)
            }
            val adapter = JobAdapter(listJobs) {
                val intentDetail = Intent(context, DetailActivity::class.java)
                intentDetail.putExtra(DetailActivity.EXTRA_JOBS, it)
                requireActivity().startActivity(intentDetail)
            }
            rvOpenJobs.layoutManager = LinearLayoutManager(context)
            rvOpenJobs.adapter = adapter
        }
    }
}