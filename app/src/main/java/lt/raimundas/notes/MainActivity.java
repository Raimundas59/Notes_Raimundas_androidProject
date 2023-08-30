package lt.raimundas.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    private static final String TAG = "my_notes_main_activity";
    private ActivityMainBinding binding;
    private ArrayAdapter<Note> adapter;
    private ArrayList<Note> notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpListView();
        setUpListViewListener();
//        binding.myTextView.setText("Kokia graži diena ir koks aš nuostabus");
//        binding.myTextView.setTextSize(55);
//        binding.myTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


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

    }


    private void setUpListView() {

        notes = new ArrayList<>();

        notes.addAll(
                UseCaseRepository.generateDummyNotes(25)
        );

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                notes);
        binding.notesListView.setAdapter(adapter);
    }

    private void setUpListViewListener() {

        binding.notesListView.setOnItemClickListener(
                (adapterView, view, position, l) -> {
                    Log.i(TAG, "OnListItemClicked" + adapterView.getItemIdAtPosition(position));
                    Log.i(TAG, "OnListItemClicked" + position);

//                    adapterView.getItemIdAtPosition(position)

                }
        );
    }


}