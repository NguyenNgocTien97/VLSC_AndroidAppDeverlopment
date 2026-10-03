package vn.edu.vlsc.lab1helloworld

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 1. Khai báo TAG dùng chung cho Logcat
    private val TAG = "Lab1_Debug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2. Phân biệt val (Hằng) và var (Biến)
        val studentId: String = "2500113793"
        var studentName = "Nguyễn Ngọc Tiến"
        studentName = "Nguyễn Ngọc Tiến"

        // 3. Null Safety - Toán tử ? và Elvis ?:
        var nullableName: String? = null
        val length = nullableName?.length ?: 0

        // 4. In Log để Debug
        Log.i(TAG, "Ứng dụng đã chạy qua hàm onCreate!")
        Log.d(TAG, "Thông tin SV: MSSV: $studentId | Tên: $studentName")
        Log.w(TAG, "Cảnh báo: Biến nullableName đang có độ dài là $length")

        // 5. Thử nghiệm bắt lỗi (Try-Catch)
        try {
            val result = 10 / 0
        } catch (e: Exception) {
            Log.e(TAG, "Phát hiện lỗi nghiêm trọng: ${e.message}", e)
        }
    }
}