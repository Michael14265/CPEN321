package com.example.cpen321m1v3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = QuestionsAnswers.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        String questionText = "Total questions: " + totalQuestion;
        totalQuestionsTextView.setText(questionText);
        
        loadNewQuestion();
    }

    private void loadNewQuestion() {

        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionsAnswers.question[currentQuestionIndex]);
        ansA.setText(QuestionsAnswers.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionsAnswers.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionsAnswers.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionsAnswers.choices[currentQuestionIndex][3]);

    }

    private void finishQuiz() {
        new AlertDialog.Builder(this)
                .setTitle("Results")
                .setMessage("Score is " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View v) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) v;
        if(clickedButton.getId()==R.id.submit_btn) {
            if (selectedAnswer.equals(QuestionsAnswers.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        } else {

            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }

    }
}