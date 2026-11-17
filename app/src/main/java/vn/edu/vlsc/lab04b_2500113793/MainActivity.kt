package vn.edu.vlsc.lab04b_2500113793

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import vn.edu.vlsc.lab04b_2500113793.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isCounting = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Nút 1: Gây lỗi ANR (Chặn trực tiếp Main Thread trong 5 giây)
        binding.btnBlockThread.setOnClickListener {
            binding.tvStatus.text = "Trạng thái: Đang xử lý nặng (Gây đơ UI)..."
            Thread.sleep(5000) // Làm đứng hình ProgressBar và đồng hồ
            binding.tvStatus.text = "Trạng thái: Xử lý xong (Main Thread)!"
        }

        // Nút 2: Xử lý bất đồng bộ mượt mà bằng Kotlin Coroutines
        binding.btnRunCoroutine.setOnClickListener {
            binding.tvStatus.text = "Trạng thái: Đang xử lý ngầm bằng Coroutines..."

            lifecycleScope.launch(Dispatchers.IO) {
                val result = doHeavyCalculation()

                withContext(Dispatchers.Main) {
                    binding.tvStatus.text = result
                }
            }
        }

        startCountdownTimer()
    }

    private suspend fun doHeavyCalculation(): String {
        delay(5000) // Tạm dừng an toàn 5 giây, nhường CPU cho giao diện
        return "Trạng thái: Xử lý xong mượt mà (Coroutines)!"
    }

    private fun startCountdownTimer() {
        if (isCounting) return
        isCounting = true

        lifecycleScope.launch(Dispatchers.Main) {
            for (i in 60 downTo 1) {
                binding.tvCountdown.text = "Thời gian: $i s"
                delay(1000)
            }
            binding.tvCountdown.text = "Thời gian: Hết giờ!"
            isCounting = false
        }
    }
}