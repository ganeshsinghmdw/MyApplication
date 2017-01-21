package com.example.ganeshsingh.myapplication;

import android.util.Log;

import java.util.Random;

/**
 * Created by ganeshsingh on 21/01/17.
 */
public class QuesAlgo {
    private static QuesAlgo ourInstance = new QuesAlgo();
    int[ ][ ] myarray = new int[2][6];


    public static QuesAlgo getInstance() {
        return ourInstance;
    }

    private QuesAlgo() {
    }

    public void select(int no_of_topics,int desired_complexity,int no_of_question)
    {
        myarray[0][0] = 4;
        myarray[0][1] = 5;
        myarray[0][2] = 5;
        myarray[0][3] = 7;
        myarray[0][4] = 3;
        myarray[0][5] = 6;

        myarray[1][0] = 2;
        myarray[1][1] = 9;
        myarray[1][2] = 7;
        myarray[1][3] = 3;
        myarray[1][4] = 1;
        myarray[1][5] = 8;
        for(int i=0;i<no_of_topics;i++)
        {
            int current_ques_complextity=0;
            int no_of_quest_in_that_topics=6;
            int remaing_complexity=0;
            int remaing_question=0;
            int average_complexity=0;
            while (desired_complexity!=current_ques_complextity)
            {
                Random r = new Random();
                int rand = r.nextInt(no_of_quest_in_that_topics - 0) + 0;
                int temp_complexity = myarray[i][rand];
                if(current_ques_complextity==0)
                {
                    current_ques_complextity = temp_complexity;
                    remaing_complexity= desired_complexity-current_ques_complextity;
                    remaing_question = no_of_question-1;
                    average_complexity = remaing_complexity/remaing_question;
                    Log.d("Value of i",""+i+"temp"+temp_complexity);
                    Log.d("Value of r",""+rand);

                }
                else if(remaing_question==1)
                {
                    if(temp_complexity==remaing_complexity)
                    {
                        current_ques_complextity = current_ques_complextity+temp_complexity;
                        Log.d("Value of i",""+i+"temp"+temp_complexity);
                        Log.d("Value of r",""+rand);
                    }
                }
                else if(temp_complexity<=average_complexity &&remaing_question!=1)
                {
                    current_ques_complextity = current_ques_complextity +temp_complexity;

                    remaing_complexity= desired_complexity-current_ques_complextity;
                    remaing_question = no_of_question-1;
                    average_complexity = remaing_complexity/remaing_question;
                    Log.d("Value of i",""+i+"temp"+temp_complexity);
                    Log.d("Value of r",""+rand);
                }

            }

        }
        
    }

}
