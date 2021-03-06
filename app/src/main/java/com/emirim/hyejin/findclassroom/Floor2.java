package com.emirim.hyejin.findclassroom;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

// 2층
public class Floor2  extends AppCompatActivity {
    public ImageView space[];
    public String spaceValue[];
    public ImageView hallway[];
    public TextView timeText;
    public CountDownTimer _timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor2);

        // 현재 위치 저장
        Data.currentFloor = 2;
        timeText = (TextView)findViewById(R.id.timeText);
        _timer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                Data.time--;
                timeText.setText(Data.time + "");


                if(Data.time < 1) {
                    // Intent
                    // startActivity(new Intent(Floor2.this, Finisha.class));
                }
            }

            public void onFinish() {
                // Intent
                // startActivity(new Intent(Floor2.this, Finisha.class));
            }
        }.start();

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
                "teacherRestRoom", "teacherRestRoom", null, "office3", "office3",
                "teacherRestRoom", "teacherRestRoom", null, "office3", "office3",
                "office2", "office2", null, null, null,
                "office2", "office2", null, null, null,
                "consultation", "consultation", null, "level1", "level1",
                "sciencePreparation", "sciencePreparation", null, "level2", "level2",
                "science", "science", null, "healthEducation", "healthEducation",
                "science", "science", null, "healthEducation", "healthEducation",
                "nursing", "nursing", null, "healthEducation", "healthEducation",
                "nursing", "nursing", null, null, null,
                null, null, null, null, null,
                null, null, null, null, null,
        };

        for(int i=0; i<space.length; i++) {
            if(i == 2 || i == 57 || i == 13 || i == 51 || i == 18 || i == 56) continue;
            else if(i % 5 == 2) continue;

            space[i].setOnClickListener(new IndexOnClickListener(i) {
                @Override
                public void onClick(View v) {
                    if(spaceValue[index] != null) {
                        final Dialog dialog = new Dialog(Floor2.this);
                        dialog.setContentView(R.layout.dialog_modal);

                        if (Data.answer[Data.currentStage - 1][Data.currentMissionStage - 1] == spaceValue[index]) {
                            // 정답일 경우 행동 **
                            if(Data.currentMissionStage == 1) {
                                Data.currentMissionStage ++;

                                final ImageView resultImage = (ImageView) dialog.findViewById(R.id.resultImage);

                                try {
                                    dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                                    dialog.show();

                                    new Handler().postDelayed(new Runnable() {// 1 초 후에 실행
                                        @Override
                                        public void run() {
                                            dialog.dismiss();
                                        } }, 2000);
                                } catch(Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                // Stage 변경
                                dialog.setContentView(R.layout.dialog_modal_success);

                                final ImageView resultImage = (ImageView) dialog.findViewById(R.id.resultImage);
                                final Button nextBtn = (Button) dialog.findViewById(R.id.nextBtn);

                                if(Data.currentStage != 3) {
                                    Data.currentStage += 1;
                                }

                                Data.currentStage ++;
                                Data.time = 30;

                                resultImage.setImageResource(R.drawable.success);
                                dialog.show();

                                nextBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();

                                        dialog.setContentView(R.layout.dialog_modal);
                                        final ImageView resultImage2 = (ImageView) dialog.findViewById(R.id.resultImage);
                                        resultImage2.setImageResource(R.drawable.success);

                                        try {
                                            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                                            dialog.show();

                                            new Handler().postDelayed(new Runnable() {// 1 초 후에 실행
                                                @Override
                                                public void run() {
                                                    dialog.dismiss();

                                                    resultImage.setImageResource(R.drawable.success);
                                                } }, 2000);
                                        } catch(Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        } else {
                            // 정답이 아닐 경우 행동 **
                            // Intent

                            final ImageView resultImage = (ImageView) dialog.findViewById(R.id.resultImage);

                            try {
                                resultImage.setImageResource(R.drawable.success);

                                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                                dialog.show();

                                new Handler().postDelayed(new Runnable() {// 1 초 후에 실행
                                    @Override
                                    public void run() {
                                        dialog.dismiss();
                                    } }, 2000);
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
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
                        startActivity(new Intent(Floor2.this, Floor3.class));
                        finish();
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
                    startActivity(new Intent(Floor2.this, Floor3.class));
                    finish();
                }
            });
        }

        // 교사 휴게실
        space[0].setImageResource(R.drawable.square2);
        space[1].setImageResource(R.drawable.square2);
        space[5].setImageResource(R.drawable.square2);
        space[6].setImageResource(R.drawable.square2);

        // 3교무실
        space[3].setImageResource(R.drawable.square2);
        space[4].setImageResource(R.drawable.square2);
        space[8].setImageResource(R.drawable.square2);
        space[9].setImageResource(R.drawable.square2);

        // 2교무실
        space[10].setImageResource(R.drawable.square2);
        space[11].setImageResource(R.drawable.square2);
        space[15].setImageResource(R.drawable.square2);
        space[16].setImageResource(R.drawable.square2);

        // 계단
        space[14].setImageResource(R.drawable.square2);
        space[19].setImageResource(R.drawable.square2);

        // 상담실(2교무실 부속)
        space[20].setImageResource(R.drawable.square2);
        space[21].setImageResource(R.drawable.square2);

        // 수준별 교육실 1
        space[23].setImageResource(R.drawable.square2);
        space[24].setImageResource(R.drawable.square2);

        // 과학 준비실
        space[25].setImageResource(R.drawable.square2);
        space[26].setImageResource(R.drawable.square2);

        // 수준별 교육실 2
        space[28].setImageResource(R.drawable.square2);
        space[29].setImageResource(R.drawable.square2);

        // 보건 교육실
        space[33].setImageResource(R.drawable.square2);
        space[34].setImageResource(R.drawable.square2);
        space[38].setImageResource(R.drawable.square2);
        space[39].setImageResource(R.drawable.square2);
        space[43].setImageResource(R.drawable.square2);
        space[44].setImageResource(R.drawable.square2);

        // 과학실
        space[30].setImageResource(R.drawable.square2);
        space[31].setImageResource(R.drawable.square2);
        space[35].setImageResource(R.drawable.square2);
        space[36].setImageResource(R.drawable.square2);

        // 보건실
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
