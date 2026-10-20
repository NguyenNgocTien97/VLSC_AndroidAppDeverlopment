package vn.edu.vlsc.lab3a

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vn.edu.vlsc.lab3a.databinding.ActivityDetailBinding
import vn.edu.vlsc.lab3a.model.Student

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_STUDENT = "vn.edu.vlsc.lab3a.EXTRA_STUDENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        extractAndBindData()
    }

    private fun extractAndBindData() {
        val student: Student? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_STUDENT, Student::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_STUDENT)
        }

        student?.let { sv ->
            binding.tvDetailName.text = sv.name
            binding.tvDetailMssv.text = sv.mssv

            // Bắt sự kiện click nút chia sẻ
            binding.btnShare.setOnClickListener {
                executeShareIntent(sv)
            }
        } ?: run {
            binding.tvDetailName.text = "Lỗi: Khuyết dữ liệu định tuyến."
            binding.btnShare.isEnabled = false
        }
    }

    // Tích hợp Implicit Intent (Action Send)[cite: 6]
    private fun executeShareIntent(student: Student) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Hồ sơ SV: ${student.name} - ${student.mssv}")
            type = "text/plain"
        }
        val chooser = Intent.createChooser(sendIntent, "Chia sẻ hồ sơ qua:")
        startActivity(chooser)
    }
}