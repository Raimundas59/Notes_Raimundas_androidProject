package lt.raimundas.notes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

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
        setUpListViewItemClick();
        setUpListViewItemLongClick();
        setUpFloatingActionButtonClick();
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

    private void setUpListViewItemClick() {

        binding.notesListView.setOnItemClickListener(
                (adapterView, view, position, l) -> {
                    Log.i(TAG, "OnListItemClicked" + adapterView.getItemIdAtPosition(position));
                    Log.i(TAG, "OnListItemClicked" + position);

//                    adapterView.getItemIdAtPosition(position)

                }
        );
    }

    private void setUpListViewItemLongClick() {
        binding.notesListView.setOnItemLongClickListener(
                (adapterView, view, position, l) -> {
                    Log.i(TAG, "OnListItem_LONG_Clicked:" + adapterView.getItemAtPosition(position));
                    Note note = (Note) adapterView.getItemAtPosition(position);
                    showRemoveAlertDialog(note);
                    return true;
                }
        );

    }
    private void setUpFloatingActionButtonClick() {

        binding.floatingActionButton.setOnClickListener(
                view -> {
                    showSnacBar("FAB  was clicked");
                }
        );
    }

    private void showSnacBar(String message) {
        Snackbar
                .make(
                binding.notesListView,
                "Fab was clicked",
                Snackbar.LENGTH_LONG
        )
                .show();
    }

    private void showRemoveAlertDialog(Note note) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setMessage("Do you really want to remove this item?")
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    removeNoteFromList(note);
                })
                        .setNegativeButton("No", null)
                .show();
    }

    private void removeNoteFromList(Note note) {
        notes.remove(note);
        adapter.notifyDataSetChanged();
        showSnacBar("Note with id:" + note.getId()+ "was removed");
    }
}