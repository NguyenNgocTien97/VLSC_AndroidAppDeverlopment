package vn.edu.vlsc.lab3a

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import vn.edu.vlsc.lab3a.adapter.StudentAdapter
import vn.edu.vlsc.lab3a.databinding.ActivityMainBinding
import vn.edu.vlsc.lab3a.model.Student

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Cập nhật sự kiện click để khởi tạo Explicit Intent truyền dữ liệu Student sang DetailActivity
    private val studentAdapter = StudentAdapter { student ->
        val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_STUDENT, student)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        applyWindowInsets()
        setupRecyclerView()
        studentAdapter.submitList(getSampleStudents())
    }

    private fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val types = WindowInsetsCompat.Type.systemBars() or
                    WindowInsetsCompat.Type.displayCutout()
            val bars = insets.getInsets(types)
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
    }

    private fun setupRecyclerView() {
        binding.rvStudents.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = studentAdapter
            setHasFixedSize(true)
        }
    }

    private fun getSampleStudents(): List<Student> {
        val avatar = R.mipmap.ic_launcher_round
        return listOf(
            Student(1, "Nguyễn Văn An", "2024001", avatar),
            Student(2, "Trần Thị Bình", "2024002", avatar),
            Student(3, "Lê Hoàng Cường", "2024003", avatar),
            Student(4, "Phạm Thu Dung", "2024004", avatar),
            Student(5, "Hoàng Minh Đức", "2024005", avatar),
            Student(6, "Vũ Thị Hoa", "2024006", avatar),
            Student(7, "Đặng Quốc Hùng", "2024007", avatar),
            Student(8, "Bùi Khánh Linh", "2024008", avatar),
            Student(9, "Ngô Tuấn Minh", "2024009", avatar),
            Student(10, "Đỗ Thùy Trang", "2024010", avatar)
        )
    }
}