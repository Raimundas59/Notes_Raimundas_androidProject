package lt.raimundas.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import lt.raimundas.notes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.myTextView.setText("Kokia graži diena ir koks aš nuostabus");
        binding.myTextView.setTextSize(55);
        binding.myTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//        TextView myTextView = findViewById(R.id.myTextView);
//        myTextView.setText("Kokia graži diena ir koks aš nuostabus");
//        myTextView.setTextSize(24);
//        myTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
}