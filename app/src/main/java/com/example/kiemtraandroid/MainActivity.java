package com.example.kiemtraandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView edtMaSP, edtTenSP, edtPrice, edtImageName;
    Button btnClear, btnSave;
    ImageButton imageDelete;
    private RecyclerView recyclerView;
    private SanPhamAdap sanPhamAdap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SanPhamDAO sanPhamDAO = new SanPhamDAO(this);
        ArrayList<SanPham> listSanPham = sanPhamDAO.getListSanPham();
        sanPhamAdap = new SanPhamAdap(this, listSanPham);
        recyclerView.setAdapter(sanPhamAdap);

        // Khởi tạo các thành phần
        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtPrice = findViewById(R.id.edtPrice);
        edtImageName = findViewById(R.id.edtImageName);
        btnClear = findViewById(R.id.btnClear);
        btnSave = findViewById(R.id.btnSave);



//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Lấy dữ liệu từ EditText
//                String tenSp = edtTenSP.getText().toString();
//                String giaTien = edtPrice.getText().toString();
//                String Image = edtImageName.getText().toString();
//                if (TextUtils.isEmpty(tenSp) || TextUtils.isEmpty(giaTien) || TextUtils.isEmpty(Image)) {
//                    // Hiển thị thông báo lỗi nếu có trường nào đó rỗng
//                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                } else {
//                    SanPham newToDo = new SanPham(0,tenSp, Float.parseFloat(giaTien), Image);
//
//                    SanPhamDAO todoDAO = new SanPhamDAO(MainActivity.this);
//                    boolean isSuccess = todoDAO.Add(newToDo);
//
//                    if (isSuccess) {
//                        // Nếu thêm thành công, hiển thị thông báo thành công
//                        Toast.makeText(MainActivity.this, "Thêm mới thành công", Toast.LENGTH_SHORT).show();
//                        // Cập nhật ListView
//                        ArrayList<SanPham> list = todoDAO.getListSanPham();
//                        SanPhamAdap toDoAdapter = new SanPhamAdap(MainActivity.this, list);
//                        recyclerView.setAdapter(toDoAdapter);
//                    } else {
//                        // Nếu thêm không thành công, hiển thị thông báo lỗi
//                        Toast.makeText(MainActivity.this, "Thêm mới thất bại", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });

        // Sự kiện lắng nghe cho flButton (FloatingActionButton)
        // Sự kiện lắng nghe cho flButton (FloatingActionButton)
        FloatingActionButton flButton = findViewById(R.id.flButton);
        flButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate layout của đoạn mã XML bạn đã cung cấp
                View customDialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, null);

                // Tạo đối tượng AlertDialog.Builder với nội dung là customDialogView
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(customDialogView);

                // Nút tích cực
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Xử lý khi nhấn nút OK
                        dialogInterface.dismiss();
                    }
                });

                // Tạo và hiển thị AlertDialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }
}