package com.haire.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.haire.databinding.ActivityDetailBinding
import com.haire.model.Jobs

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.btnBack.setOnClickListener { finish() }
        setData()
    }

    private fun setData() {
        val data = intent.getParcelableExtra<Jobs>(EXTRA_JOBS)
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(data?.image)
                .into(ivJobs)
            tvPekerjaan.text = data?.pekerjaan.toString()
            tvAlamat.text = data?.provinsi.toString()
            btnApply.setOnClickListener { Toast.makeText(this@DetailActivity, "Berhasil daftar!", Toast.LENGTH_SHORT).show() }
        }
    }

    companion object {
        const val EXTRA_JOBS = "extra_jobs"
    }
}