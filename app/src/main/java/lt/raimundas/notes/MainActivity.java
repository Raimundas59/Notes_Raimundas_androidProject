package lt.raimundas.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lt.raimundas.notes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        binding.myTextView.setText("Kokia graži diena ir koks aš nuostabus");
//        binding.myTextView.setTextSize(55);
//        binding.myTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        ArrayList<String> list = new ArrayList<>();
       List<String> newlist =  Arrays.asList(
                "Pirmadienis",
                "Antradienis",
                "Trečiadienis",
                "Ketvirtadienis",
                "Penktadienis",
                "Šeštadienis",
                "Sekmadienis"
        );
        list.addAll(newlist);
        list.addAll(newlist);
        list.addAll(newlist);
        list.addAll(newlist);
        list.addAll(newlist);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                list);
        binding.notesListView.setAdapter(adapter);

    }
}