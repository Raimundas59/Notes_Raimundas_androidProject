package lt.raimundas.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import lt.raimundas.notes.databinding.ActivityNoteDetailsBinding;

public class NoteDetails extends AppCompatActivity {
    private ActivityNoteDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        int id intent.getIntExtra("id", 0);
        String title intent.getStringExtra("title");
        String description intent.getStringExtra("description");
        binding.textView.setText(
                id + "\n" + "Title:" + title + "\n" + description
        );
        setContentView(R.layout.activity_note_details);
    }
}