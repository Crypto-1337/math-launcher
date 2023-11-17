package com.example.math_launcher;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TaskActivity extends Activity {

    private TextView textViewMathProblem;
    private EditText editTextAnswer;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_activity);

        // UI-Elemente initialisieren
        textViewMathProblem = findViewById(R.id.textViewMathProblem);
        editTextAnswer = findViewById(R.id.editTextAnswer);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Mathematische Aufgabe generieren
        generateMathProblem();

        // OnClickListener für den Überprüfen-Button hinzufügen
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    private void generateMathProblem() {
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);
        int result = number1 + number2;

        // Die mathematische Aufgabe im TextView anzeigen
        textViewMathProblem.setText(String.format("%d + %d = ?", number1, number2));
    }

    private void checkAnswer() {

        String userAnswerString = editTextAnswer.getText().toString().trim();

        if (!userAnswerString.isEmpty()) {
            int userAnswer = Integer.parseInt(userAnswerString);

            //Überprüfen, ob die Antwort korrekt ist
            if (userAnswer == getCorrectAnswer()) {
                Toast.makeText(this, "Richtig!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Falsch. Versuche es erneut.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Bitte gib eine Antwort ein.", Toast.LENGTH_SHORT).show();
        }
    }

    private int getCorrectAnswer() {
        return 0;
    }
}
