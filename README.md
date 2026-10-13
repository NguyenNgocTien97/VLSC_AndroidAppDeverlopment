# Lab 3a - Student List Application (Danh Sách Sinh Viên)

Ứng dụng Android quản lý và hiển thị danh sách sinh viên sử dụng **RecyclerView**, **ListAdapter** và **Material Design 3**.

---

## 📱 Hình Ảnh Minh Chứng Chạy Ứng Dụng

![Ảnh minh chứng ứng dụng](screenshot.png)

---

## ✨ Tính Năng Nổi Bật

- **Hiển thị danh sách sinh viên**: Hiển thị danh sách sinh viên bao gồm Họ và tên, Mã số sinh viên (MSSV) và Ảnh đại diện.
- **Giao diện Material 3**: Sử dụng `MaterialCardView` tạo giao diện dạng card bo tròn hiện đại, dễ quan sát.
- **Tối ưu hóa hiệu năng**: Sử dụng `RecyclerView` kết hợp `ListAdapter` và `DiffUtil` để xử lý danh sách mượt mà.
- **Tương tác người dùng**: Nhấp vào từng sinh viên để hiển thị thông báo (`Toast`) thông tin sinh viên được chọn.
- **Edge-to-Edge**: Tự động căn chỉnh khoảng cách theo thanh hệ thống (System Bars) chuẩn Android hiện đại.

---

## 🛠 Thư Viện & Công Nghệ Sử Dụng

- **Ngôn ngữ**: Kotlin
- **Kiến trúc / Thành phần UI**:
  - `ViewBinding`
  - `RecyclerView`
  - `ListAdapter` & `DiffUtil`
  - `ConstraintLayout` & `LinearLayout`
  - `MaterialCardView` (Material Design 3)
- **Hệ thống Build**: Gradle (Kotlin DSL - `build.gradle.kts`)

---

## 📂 Cấu Trúc Dự Án

```text
app/src/main/java/vn/edu/vlsc/lab3a/
├── model/
│   └── Student.kt             # Data class định nghĩa đối tượng Sinh viên
├── adapter/
│   └── StudentAdapter.kt      # ListAdapter & ViewHolder xử lý danh sách sinh viên
└── MainActivity.kt            # Activity chính khởi tạo RecyclerView và xử lý sự kiện
```

---

## 🚀 Hướng Dẫn Chạy Dự Án

1. Clone repository về máy:
   ```bash
   git clone https://github.com/NguyenNgocTien97/VLSC_AndroidAppDeverlopment.git
   ```
2. Mở dự án trong **Android Studio**.
3. Chờ Gradle Sync hoàn tất.
4. Chọn thiết bị ảo (Emulator) hoặc thiết bị thật và nhấn **Run** (`Shift + F10`).
