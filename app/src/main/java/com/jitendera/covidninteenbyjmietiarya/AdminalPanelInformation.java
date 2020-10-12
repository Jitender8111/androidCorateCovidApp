package com.jitendera.covidninteenbyjmietiarya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class AdminalPanelInformation extends AppCompatActivity {

     TextView tview,textTwo,textThree,textFour,textFive,textViewRisk;
     LinearLayout parent,parentTwo,parentThree,parentFour,parentFive;
     LinearLayout linearLayoutToHideArcLoader,LinearLayoutAllVisible,linearlayouthiddenforbutton1,linearlayouthiddenforbutton2,linearlayouthiddenforbutton3,linearlayouthiddenforbutton4,linearlayouthiddenforbutton5;
     CardView CardViewTwo,CardViewThree,CardViewFour,CardViewFive;
     Button animate,animateTwo,animateTwoYes,animateTwoNo,animateThreeNo,animateThreeYes,animateFourNo,animateFourYes,animateFiveNo,animateFiveYes;
     private int valueOfRisk=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminal_panel_information);

        getSupportActionBar().setTitle("User Panel");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

          tview = findViewById(R.id.text);
        textTwo = findViewById(R.id.textTwo);
        textThree = findViewById(R.id.textThree);
        textFour = findViewById(R.id.textFour);
        textFive = findViewById(R.id.textFive);
        textViewRisk = findViewById(R.id.textViewRisk);

         parent = findViewById(R.id.parent);
        parentTwo = findViewById(R.id.parentTwo);
        parentThree = findViewById(R.id.parentThree);
        parentFour= findViewById(R.id.parentFour);
        parentFive = findViewById(R.id.parentFive);

        linearlayouthiddenforbutton1 = findViewById(R.id.linearlayouthiddenforbutton1);
        linearlayouthiddenforbutton2 = findViewById(R.id.linearlayouthiddenforbutton2);
        linearlayouthiddenforbutton3 = findViewById(R.id.linearlayouthiddenforbutton3);
        linearlayouthiddenforbutton4 = findViewById(R.id.linearlayouthiddenforbutton4);
        linearlayouthiddenforbutton5 = findViewById(R.id.linearlayouthiddenforbutton5);
        LinearLayoutAllVisible =findViewById(R.id.LinearLayoutAllVisible);
        linearLayoutToHideArcLoader = findViewById(R.id.linearLayoutToHideArcLoader);


        animate = findViewById(R.id.animate);
        animateTwo = findViewById(R.id.animateTwo);
        animateTwoNo = findViewById(R.id.animateTwoNo);
        animateTwoYes = findViewById(R.id.animateTwoYes);
        animateThreeNo = findViewById(R.id.animateThreeNo);
        animateThreeYes = findViewById(R.id.animateThreeYes);
        animateFourNo = findViewById(R.id.animateFourNo);
        animateFourYes = findViewById(R.id.animateFourYes);
        animateFiveNo = findViewById(R.id.animateFiveNo);
        animateFiveYes = findViewById(R.id.animateFiveYes);

        CardViewTwo = findViewById(R.id.CardViewTwo);
        CardViewThree = findViewById(R.id.CardViewThree);
        CardViewFour = findViewById(R.id.CardViewFour);
        CardViewFive = findViewById(R.id.CardViewFive);

        LinearLayoutAllVisible.setVisibility(View.VISIBLE);

        String question1 = "Q.1 = Are you Experiencing any symptoms like Cough,Fever,Loss of Smell & taste. ?";
        String question2 = "Q.2 = Have You Traveled anywhere internationally in the last 28 days. ?";
        String question3 = "Q.3 = You have recently interacted or lived with someone who has tested is covid-19 positive. ?";
        String question4 = "Q.4 = Are you Healthcare worker and  examined a covid-19 confirmed case without protective gear. ?";
        String question5 = "Q.5 = Have you ever had any of the disease. diabetes, lung disese, heart disese, kidney disorder ?";
        tview.setText(question1);
        textTwo.setText(question2);
        textThree.setText(question3);
        textFour.setText(question4);
        textFive.setText(question5);

        Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        parent.startAnimation(slideDown);

        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 valueOfRisk = valueOfRisk+1; // value=1

                Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                //Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top);
                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String ans = "Q.1 = Are you Experiencing any symptoms like Cough,Fever,Loss of Smell & taste. =YES ";
                        tview.setText(""+ans);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                parent.startAnimation(slideUp);
                CardViewTwo.setVisibility(View.VISIBLE);
                linearlayouthiddenforbutton1.setVisibility(View.GONE);
                parent.setBackgroundColor(getResources().getColor(R.color.dark_yellow));

                linearlayouthiddenforbutton2.setVisibility(View.VISIBLE);
            }


        });
        animateTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideUpNo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                slideUpNo.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String st = "Q.1 = Are you Experiencing any symptoms like Cough,Fever,Loss of Smell & taste = NO ";
                        tview.setText(""+st);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }


                });

                parent.startAnimation(slideUpNo);
                CardViewTwo.setVisibility(View.VISIBLE);
                linearlayouthiddenforbutton1.setVisibility(View.GONE);
                parent.setBackgroundColor(getResources().getColor(R.color.dark_yellow));

                linearlayouthiddenforbutton2.setVisibility(View.VISIBLE);
            }
        });


        animateTwoYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOfRisk = valueOfRisk+1; // value=2

                Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                //Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top);
                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String question2 = "Q.2 = Have You Traveled anywhere internationally in the last 28 days. = YES";
                        textTwo.setText(question2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                parentTwo.startAnimation(slideUp);
                CardViewThree.setVisibility(View.VISIBLE);
                linearlayouthiddenforbutton2.setVisibility(View.GONE);
                parentTwo.setBackgroundColor(getResources().getColor(R.color.dark_yellow));

                linearlayouthiddenforbutton3.setVisibility(View.VISIBLE);
            }


        });
        animateTwoNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideUpNo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                slideUpNo.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String question2 = "Q.2 = Have You Traveled anywhere internationally in the last 28 days. = NO";
                        textTwo.setText(question2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }


                });

              parentTwo.startAnimation(slideUpNo);
                CardViewThree.setVisibility(View.VISIBLE);
                linearlayouthiddenforbutton2.setVisibility(View.GONE);
                parentTwo.setBackgroundColor(getResources().getColor(R.color.dark_yellow));

                linearlayouthiddenforbutton3.setVisibility(View.VISIBLE);

            }
        });


        animateThreeYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOfRisk = valueOfRisk+1; // value=3
                Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                //Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top);
                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String question3 = "Q.3 = You have recently interacted or lived with someone who has tested is covid-19 positive. = YES";
                        textThree.setText(question3);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                parentThree.startAnimation(slideUp);
                CardViewFour.setVisibility(View.VISIBLE);
                linearlayouthiddenforbutton3.setVisibility(View.GONE);
                parentThree.setBackgroundColor(getResources().getColor(R.color.dark_yellow));

                linearlayouthiddenforbutton4.setVisibility(View.VISIBLE);
            }


        });
        animateThreeNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideUpNo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                slideUpNo.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String question3 = "Q.3 = You have recently interacted or lived with someone who has tested is covid-19 positive. = NO";
                        textThree.setText(question3);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }


                });

                parentThree.startAnimation(slideUpNo);
                CardViewFour.setVisibility(View.VISIBLE);
                linearlayouthiddenforbutton3.setVisibility(View.GONE);
                parentThree.setBackgroundColor(getResources().getColor(R.color.dark_yellow));

                linearlayouthiddenforbutton4.setVisibility(View.VISIBLE);

            }
        });


        animateFourYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOfRisk = valueOfRisk+1; // value=4
                Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                //Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top);
                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String question4 = "Q.4 = Are you Healthcare worker and  examined a covid-19 confirmed case without protective gear. = YES";
                        textFour.setText(question4);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                parentFour.startAnimation(slideUp);
                CardViewFive.setVisibility(View.VISIBLE);
                linearlayouthiddenforbutton4.setVisibility(View.GONE);
                parentFour.setBackgroundColor(getResources().getColor(R.color.dark_yellow));

                linearlayouthiddenforbutton5.setVisibility(View.VISIBLE);
            }


        });
        animateFourNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideUpNo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                slideUpNo.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String question4 = "Q.4 = Are you Healthcare worker and  examined a covid-19 confirmed case without protective gear. = NO";
                        textFour.setText(question4);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }


                });

                parentFour.startAnimation(slideUpNo);
                CardViewFive.setVisibility(View.VISIBLE);
                linearlayouthiddenforbutton4.setVisibility(View.GONE);
                parentFour.setBackgroundColor(getResources().getColor(R.color.dark_yellow));

                linearlayouthiddenforbutton5.setVisibility(View.VISIBLE);

            }
        });

        animateFiveYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOfRisk = valueOfRisk+1; // value=5
                Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                //Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top);
                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String question5 = "Q.5 = Have you ever had any of the disease. diabetes, lung disese, heart disese, kidney disorder = YES";
                        textFive.setText(question5);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                parentFive.startAnimation(slideUp);

                linearlayouthiddenforbutton5.setVisibility(View.GONE);
                parentFive.setBackgroundColor(getResources().getColor(R.color.dark_yellow));
                LinearLayoutAllVisible.setVisibility(View.GONE);

                piechart();

            }


        });
        animateFiveNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideUpNo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                slideUpNo.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String question5 = "Q.5 = Have you ever had any of the disease. diabetes, lung disese, heart disese, kidney disorder = NO";
                        textFive.setText(question5);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }


                });

                parentFive.startAnimation(slideUpNo);

                linearlayouthiddenforbutton5.setVisibility(View.GONE);
                parentFive.setBackgroundColor(getResources().getColor(R.color.dark_yellow));
                LinearLayoutAllVisible.setVisibility(View.GONE);

                piechart();



            }
        });

        //--------------------------------------------------------
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public  void piechart(){
        int va=0,va2=0;

        if( valueOfRisk==1) {

            va= valueOfRisk*20;
            va2 = 100-va;
            textViewRisk.setText("High Risk Please report to the doctor now [ Risk = "+va+" % ]");
        }
        if( valueOfRisk==2) {


            va= valueOfRisk*20;
            va2 = 100-va;
            textViewRisk.setText("High Risk Please go to for doctor Dont Forget to wear your Mask [ Risk = "+va+" % ]");

        }
        if( valueOfRisk==3) {

            va= valueOfRisk*20;
            va2 = 100-va;
            textViewRisk.setText("High Risk Please go to for doctor Dont Forget to wear your Mask [ Risk = "+va+" % ]");
        }
        if( valueOfRisk==4) {

            va= valueOfRisk*20;
            va2 = 100-va;
            textViewRisk.setText("High Risk Please report to the doctor now [ Risk = "+va+" % ]");
        }
        if( valueOfRisk==5) {

            va= valueOfRisk*20;
            va2 = 100-va;
            textViewRisk.setText("High Risk Please report to the doctor now [ Risk = "+va+" % ]");
        }
        if( valueOfRisk==0) {

            va= valueOfRisk*20;
            va2 = 100-va;
            textViewRisk.setText(" Risk is low Please Stay at Home [ Risk = "+va+" % ]");
        }


        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);

        mPieChart.addPieSlice(new PieModel("Safe", va2, Color.parseColor("#FBC02D")));
        mPieChart.addPieSlice(new PieModel("Risk", va, Color.parseColor("#D32F2F")));
       /* mPieChart.addPieSlice(new PieModel("Work", 35, Color.parseColor("#6200EE")));
        mPieChart.addPieSlice(new PieModel("Eating", 9, Color.parseColor("#FED70E")));*/

        mPieChart.startAnimation();
        linearLayoutToHideArcLoader.setVisibility(View.VISIBLE);


    }
}