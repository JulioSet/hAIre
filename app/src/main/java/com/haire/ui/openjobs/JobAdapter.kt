package com.haire.ui.openjobs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.haire.databinding.ItemJobsBinding
import com.haire.model.Jobs

class JobAdapter(private val listJobs: List<Jobs>, private val onItemClick: (Jobs) -> Unit) :
    RecyclerView.Adapter<JobAdapter.JobViewHolder>() {
    inner class JobViewHolder(private var binding: ItemJobsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(jobs: Jobs) {
            binding.apply {
                Glide.with(root.context)
                    .load(jobs.image)
                    .into(ivJobs)
                tvTitle.text = jobs.pekerjaan
                tvAddres.text = jobs.alamat
            }
            itemView.setOnClickListener {
                onItemClick(jobs)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = ItemJobsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobViewHolder(binding)
    }

    override fun getItemCount(): Int = listJobs.size

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        holder.bind(listJobs[position])
    }
}