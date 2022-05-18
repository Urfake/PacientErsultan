package com.example.classwork;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.classwork.adapters.ConsultAdapter;
import com.example.classwork.models.Consult;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoctorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Consult> list;
    private ConsultAdapter adapter;
    //private Button btnAdd;
    public static final String KEY1 = "key";
    private static final int REQUEST_CODE = 2;
    public static final int REQUEST_COD = 3;
    private int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        BottomNavigationView bottomNavigationView=findViewById(R.id.nav_view);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_doctor);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.navigation_doctor:
                        return true;
                    case R.id.navigation_patient:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.rv_doctors);
//        btnAdd = findViewById(R.id.btnAdd);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Consult>();
        adapter = new ConsultAdapter((ArrayList<Consult>) list, this);
        setInitialData();
        recyclerView.setAdapter(adapter);


        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent();
//                startActivityForResult(intent, REQUEST_CODE);
//            }
//        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
//
//            Consult consult = (Consult) data.getSerializableExtra(ApplicationActivity.KEY);
//            adapter.addData(consult);
//
//        }
//        if (requestCode == REQUEST_COD && resultCode == RESULT_OK && data != null) {
//            Consult consult = (Consult) data.getSerializableExtra(ApplicationActivity.KEY);
//            adapter.changeData(consult, position);
//        }

    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP | ItemTouchHelper.DOWN,

            ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT

    ) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView,
                              @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            int positionDrag = viewHolder.getAdapterPosition();
            int positionTarget = target.getAdapterPosition();

            Collections.swap(adapter.list, positionDrag, positionTarget);
            adapter.notifyItemMoved(positionDrag, positionTarget);

            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            adapter.list.remove(viewHolder.getAdapterPosition());
            adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    };


    public void onItemClick(int position) {
//        this.position =position;
//        Intent intent = new Intent(MainActivity.this, ApplicationActivity.class);
//        intent.putExtra(KEY1, adapter.list.get(position));
//        startActivityForResult(intent, REQUEST_COD);
//

    }
    public void setInitialData(){
        list.add(new Consult("Salo", "Cabinet 660", R.drawable.img));
        list.add(new Consult("Aigo", "Cabinet 661", R.drawable.img));
        list.add(new Consult("Aidos", "Cabinet 662", R.drawable.img));
        list.add(new Consult("Kubik", "Cabinet 663", R.drawable.img));
        list.add(new Consult("Oloken", "Cabinet 664", R.drawable.img));
        list.add(new Consult("Aidor", "Cabinet 665", R.drawable.doctor2));
        list.add(new Consult("Ismo", "Cabinet 666", R.drawable.img));
        list.add(new Consult("Omo", "Cabinet 667", R.drawable.doctor4));
    }

}
