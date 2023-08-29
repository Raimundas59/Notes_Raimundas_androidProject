package lt.raimundas.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import lt.raimundas.notes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayAdapter<Note> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        binding.myTextView.setText("Kokia graži diena ir koks aš nuostabus");
//        binding.myTextView.setTextSize(55);
//        binding.myTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        ArrayList<Note> list = new ArrayList<>();
        list.addAll(generateDummyNotes(25));

//       List<String> newlist =  Arrays.asList(
//                "Pirmadienis",
//                "Antradienis",
//                "Trečiadienis",
//                "Ketvirtadienis",
//                "Penktadienis",
//                "Šeštadienis",
//                "Sekmadienis"
//        );
//        list.addAll(newlist);
//        list.addAll(newlist);
//        list.addAll(newlist);
//        list.addAll(newlist);
//        list.addAll(newlist);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                list);
        binding.notesListView.setAdapter(adapter);

    }

    private List<Note> generateDummyNotes(int notesNumber) {
        ArrayList<Note> notes = new ArrayList<>();
        for (int i = 1; i <= notesNumber; i++) {
            notes.add(
                    new Note(
                            i,
                            UUID.randomUUID().toString().substring(0, 10),
                            UUID.randomUUID().toString()
                    )
            );
        }
        return notes;
    }
}