package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText ed_name;
    private TextView tv_text,tv_name,tv_winner,tv_mmora,tv_cmora;
    private RadioButton btn_scissor, btn_stone, btn_paper;
    private Button btn_mora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //連結XML元件
        ed_name = findViewById(R.id.gamer);
        tv_text = findViewById(R.id.status);
        tv_name = findViewById(R.id.name);
        tv_winner = findViewById(R.id.winner);
        tv_mmora = findViewById(R.id.our);
        tv_cmora = findViewById(R.id.their);
        btn_scissor = findViewById(R.id.Button1);
        btn_stone = findViewById(R.id.Button2);
        btn_paper = findViewById(R.id.Button3);
        btn_mora = findViewById(R.id.play);
        btn_mora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
                //判斷字串是否空白:
                if(ed_name.length()<1)
                    tv_text.setText("趕快輸入名字啊 !!! ");
                else{
                    tv_name.setText(String.format("名字\n%s",ed_name.getText().toString()));
                    if(btn_scissor.isChecked())
                        tv_mmora.setText("我方出拳\n剪刀");
                    else if(btn_stone.isChecked())
                        tv_mmora.setText("我方出拳\n石頭");
                    else if(btn_paper.isChecked())
                        tv_mmora.setText("我方出拳\n布");
                }

                //Random 電腦出的拳:
                int com = (int)(Math.random()*3);
                if(com==0)
                    tv_cmora.setText("電腦出拳\n剪刀");
                else if(com==1)
                    tv_cmora.setText("電腦出拳\n石頭");
                else if(com==2)
                    tv_cmora.setText("電腦出拳\n布");

                //判斷結果:
                if(btn_paper.isChecked() && com == 1 || btn_stone.isChecked() && com == 0 || btn_scissor.isChecked() && com == 2){
                    tv_winner.setText("勝利者\n" + ed_name.getText().toString());
                    tv_text.setText("你竟然贏電腦了!太強了吧");
                }
                else if(btn_paper.isChecked() && com == 2 || btn_stone.isChecked() && com == 1 || btn_scissor.isChecked() && com == 0){
                    tv_winner.setText("勝利者\n哈哈平手哈哈");
                    tv_text.setText("你跟電腦平手唷!");
                }
                else if(btn_paper.isChecked() && com == 0 || btn_stone.isChecked() && com == 2 || btn_scissor.isChecked() && com == 1){
                    tv_winner.setText("勝利者\n電腦贏囉哈哈");
                    tv_text.setText("笑死，你連電腦都輸!");
                }
            }
        });



    }
}