package sg.edu.rp.c346.id21010860.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText etElement;
    Button btnAdd;
    Button btnClear;
    Button btnDelete;
    ListView lvTask;
    Spinner spnAddRemove;

    ArrayList<String> alTask;
    ArrayAdapter<String> aaTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        btnDelete = findViewById(R.id.buttonDelete);
        lvTask = findViewById(R.id.listViewTask);
        spnAddRemove = findViewById(R.id.spinner);

       alTask = new ArrayList<>();   //no need verify size

        aaTask = new ArrayAdapter<>(this, R.layout.layout,alTask);  //link array list with array adapter

        lvTask.setAdapter(aaTask);

        spnAddRemove.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                        etElement.setHint("Type in a new task here");
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        btnAdd.setTextColor(Color.BLUE);
                        btnDelete.setTextColor(Color.GRAY);
                        break;
                    case 1:
                        etElement.setHint("Type in the index of the task to be removed");
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);
                        btnAdd.setTextColor(Color.GRAY);
                        btnDelete.setTextColor(Color.BLUE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newTask = etElement.getText().toString();

                alTask.add(newTask);
                aaTask.notifyDataSetChanged();


            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newTask = etElement.getText().toString();
                int pos = Integer.parseInt(etElement.getText().toString());

                alTask.remove(pos);
                aaTask.notifyDataSetChanged();




            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String newTask = etElement.getText().toString();

                alTask.clear();
                aaTask.notifyDataSetChanged();
            }
        });
            }
}