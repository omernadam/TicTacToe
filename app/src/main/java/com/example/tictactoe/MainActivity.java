package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];

    private boolean player1Turn = true;
    private int roundCount;
    private int player1Points;
    private int player2Points;

    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                String buttonId = "button_" + i + j;
                int res = getResources().getIdentifier(buttonId, "id", getPackageName());
                buttons[i][j] = findViewById(res);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        if(!((Button) view).getText().toString().equals("")){
            return;
        }

        if(player1Turn){
            ((Button) view).setText("X");
        }else{
            ((Button) view).setText("O");
        }

        roundCount++;
        if (checkWin()) {   //there is a win
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }


    }

    private boolean checkWin(){
        String[][] board = new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1])
                    && board[i][0].equals(board[i][2])
                    && !board[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i])
                    && board[0][i].equals(board[2][i])
                    && !board[0][i].equals("")) {
                return true;
            }
        }

        if (board[0][0].equals(board[1][1])
                && board[0][0].equals(board[2][2])
                && !board[0][0].equals("")) {
            return true;
        }

        if (board[0][2].equals(board[1][1])
                && board[0][2].equals(board[2][0])
                && !board[0][2].equals("")) {
            return true;
        }

        return false;

    }

    private void player1Wins() {
    }

    private void player2Wins() {
    }

    private void draw() {
    }
}