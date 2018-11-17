package com.emirim.hyejin.findclassroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// 3층
public class Floor3  extends AppCompatActivity {
    public ImageView space[];
    public ImageView hallway[];
    public String spaceValue[];
    public TextView timeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor2);

        // 현재 위치 저장
        Data.currentFloor = 3;
        timeText = (TextView)findViewById(R.id.timeText);
        timeText.setText("3층");

        hallway = new ImageView[] {
                (ImageView)findViewById(R.id.td61), (ImageView)findViewById(R.id.td62),  (ImageView)findViewById(R.id.td63), (ImageView)findViewById(R.id.td64), (ImageView)findViewById(R.id.td65)
        };
        space = new ImageView[]{
                (ImageView)findViewById(R.id.td1), (ImageView)findViewById(R.id.td2),  (ImageView)findViewById(R.id.td3), (ImageView)findViewById(R.id.td4), (ImageView)findViewById(R.id.td5),  (ImageView)findViewById(R.id.td6),  (ImageView)findViewById(R.id.td7),  (ImageView)findViewById(R.id.td8), (ImageView)findViewById(R.id.td9), (ImageView)findViewById(R.id.td10),
                (ImageView)findViewById(R.id.td11), (ImageView)findViewById(R.id.td12),  (ImageView)findViewById(R.id.td13),  (ImageView)findViewById(R.id.td14), (ImageView)findViewById(R.id.td15),  (ImageView)findViewById(R.id.td16),  (ImageView)findViewById(R.id.td17),  (ImageView)findViewById(R.id.td18), (ImageView)findViewById(R.id.td19), (ImageView)findViewById(R.id.td20),
                (ImageView)findViewById(R.id.td21), (ImageView)findViewById(R.id.td22),  (ImageView)findViewById(R.id.td23), (ImageView)findViewById(R.id.td24), (ImageView)findViewById(R.id.td25),  (ImageView)findViewById(R.id.td26),  (ImageView)findViewById(R.id.td27),  (ImageView)findViewById(R.id.td28), (ImageView)findViewById(R.id.td29), (ImageView)findViewById(R.id.td30),
                (ImageView)findViewById(R.id.td31), (ImageView)findViewById(R.id.td32),  (ImageView)findViewById(R.id.td33), (ImageView)findViewById(R.id.td34), (ImageView)findViewById(R.id.td35),  (ImageView)findViewById(R.id.td36),  (ImageView)findViewById(R.id.td37),  (ImageView)findViewById(R.id.td38), (ImageView)findViewById(R.id.td39), (ImageView)findViewById(R.id.td40),
                (ImageView)findViewById(R.id.td41), (ImageView)findViewById(R.id.td42),  (ImageView)findViewById(R.id.td43), (ImageView)findViewById(R.id.td44), (ImageView)findViewById(R.id.td45),  (ImageView)findViewById(R.id.td46),  (ImageView)findViewById(R.id.td47),  (ImageView)findViewById(R.id.td48), (ImageView)findViewById(R.id.td49), (ImageView)findViewById(R.id.td50),
                (ImageView)findViewById(R.id.td51), (ImageView)findViewById(R.id.td52),  (ImageView)findViewById(R.id.td53), (ImageView)findViewById(R.id.td54), (ImageView)findViewById(R.id.td55),  (ImageView)findViewById(R.id.td56),  (ImageView)findViewById(R.id.td57),  (ImageView)findViewById(R.id.td58), (ImageView)findViewById(R.id.td59), (ImageView)findViewById(R.id.td60),
        };
        spaceValue = new String[] {
                "solution2", "solution2", null, "solution1", "solution1",
                "solution2", "solution2", null, "solution1", "solution1",
                "appban", "appban", null, null, null,
                "jeonsan", "jeonsan", null, null, null,
                "miben", "miben", null, "web", "web",
                "design1", "design1", null, "jogyo", "jogyo",
                "design1", "design1", null, "design2", "design2",
                "appchang", "appchang", null, "design2", "design2",
                "appchang", "appchang", null, "design2", "design2",
                "appchang", "appchang", null, null, null,
                null, null, null, null, null,
                null, null, null, null, null,
        };

        for(int i=0; i<space.length; i++) {
            if(i == 2 || i == 57 || i == 13 || i == 51 || i == 18 || i == 56) continue;

            space[i].setOnClickListener(new IndexOnClickListener(i) {
                @Override
                public void onClick(View v) {
                    if(spaceValue[index] != null) {
                        if (Data.answer[Data.currentStage - 1][Data.currentMissionStage - 1] == spaceValue[index]) {
                            if(Data.currentStage != 3) {
                                Data.currentStage += 1;
                            }
                            // 정답일 경우 행동 **
                            if(Data.currentMissionStage == 1) {
                                Data.currentMissionStage ++;
                            } else {
                                // Stage 변경
                                Data.currentStage ++;
                            }
                        } else {
                            // 정답이 아닐 경우 행동 **
                        }
                    }
                }
            });
        }

        // 복도 부분
        // * 투명한 네모 만들어서 할당해줘
        for(int i=7; i<55; i+=5) {
            // space[i].setImageResource(투명한 네모) **
            space[i].setImageResource(R.drawable.square1); // 위에꺼 하면 이건 지워
        }

        // 위 층
        for(int i = 13; i<=51; i+=38) {
            space[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Data.currentFloor != 4) {
                        Data.currentFloor += 1;
                    }
                }
            });
        }

        // 아래 층
        for(int i = 18; i<=56; i+=38) {
            space[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Data.currentFloor != -1) {
                        Data.currentFloor -= 1;
                        startActivity(new Intent(Floor3.this, Floor2.class));
                        finish();
                    }
                }
            });
        }

        // 복도 이동
        for(int i=0; i<hallway.length; i++) {
            hallway[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 복도 이동하는 작업 추가
                }
            });
        }

        // 솔루션 2실
        space[0].setImageResource(R.drawable.square2);
        space[1].setImageResource(R.drawable.square2);
        space[5].setImageResource(R.drawable.square2);
        space[6].setImageResource(R.drawable.square2);

        // 솔루션 1실
        space[3].setImageResource(R.drawable.square2);
        space[4].setImageResource(R.drawable.square2);
        space[8].setImageResource(R.drawable.square2);
        space[9].setImageResource(R.drawable.square2);

        // 동아리 실 (앱반)
        space[10].setImageResource(R.drawable.square2);
        space[11].setImageResource(R.drawable.square2);

        // 전산실
        space[15].setImageResource(R.drawable.square2);
        space[16].setImageResource(R.drawable.square2);

        // 계단
        space[14].setImageResource(R.drawable.square2);
        space[19].setImageResource(R.drawable.square2);

        // 동아리실 (미벤)
        space[20].setImageResource(R.drawable.square2);
        space[21].setImageResource(R.drawable.square2);

        // 동아리실 (웹진)
        space[23].setImageResource(R.drawable.square2);
        space[24].setImageResource(R.drawable.square2);

        // 디자인 1실
        space[25].setImageResource(R.drawable.square2);
        space[26].setImageResource(R.drawable.square2);
        space[30].setImageResource(R.drawable.square2);
        space[31].setImageResource(R.drawable.square2);

        // 조교실
        space[28].setImageResource(R.drawable.square2);
        space[29].setImageResource(R.drawable.square2);

        // 디자인 2실
        space[33].setImageResource(R.drawable.square2);
        space[34].setImageResource(R.drawable.square2);
        space[38].setImageResource(R.drawable.square2);
        space[39].setImageResource(R.drawable.square2);
        space[43].setImageResource(R.drawable.square2);
        space[44].setImageResource(R.drawable.square2);

        // 앱창작터 1실
        space[35].setImageResource(R.drawable.square2);
        space[36].setImageResource(R.drawable.square2);
        space[40].setImageResource(R.drawable.square2);
        space[41].setImageResource(R.drawable.square2);
        space[45].setImageResource(R.drawable.square2);
        space[46].setImageResource(R.drawable.square2);

        // 계단
        space[50].setImageResource(R.drawable.square2);
        space[55].setImageResource(R.drawable.square2);

        // 계단 버튼
        space[13].setImageResource(R.drawable.up); // 상승
        space[51].setImageResource(R.drawable.up); // 상승
        space[18].setImageResource(R.drawable.down); // 하락
        space[56].setImageResource(R.drawable.down); // 하락

        // 식수대
        space[49].setImageResource(R.drawable.square2);

        // 벽
        space[54].setImageResource(R.drawable.square2);

        // 화장실
        space[59].setImageResource(R.drawable.square2);
    }
}
