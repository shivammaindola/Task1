package com.example.task1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ChatModel> messageset = new ArrayList<>();

        //dummy data
        Timestamp ts1 = Timestamp.valueOf("2021-09-01 09:01:15");
        Timestamp ts2 = Timestamp.valueOf("2020-09-01 03:01:15");
        Timestamp ts3 = Timestamp.valueOf("2019-09-01 03:01:15");
        Timestamp ts4 = Timestamp.valueOf("2022-09-01 03:01:15");
        ChatModel chat1 = new ChatModel("hello shivam",1,21,31,ts1);
        ChatModel chat2 = new ChatModel("hello ",2,22,32,ts2);
        ChatModel chat3 = new ChatModel("hello1 ",3,23,33,ts3);
        ChatModel chat4 = new ChatModel("hello2 ",4,24,34,ts4);
        messageset.add(chat1);
        messageset.add(chat2);
        messageset.add(chat3);
        messageset.add(chat4);

        //function
        dosomething(messageset);
    }

    private void dosomething(List<ChatModel> messageset) {
        //descending order of createdattime

             Collections.sort(messageset, new Comparator<ChatModel>() {
                 public int compare(ChatModel o1, ChatModel o2) {
                     return o2.getCreatedAtTime().compareTo(o1.getCreatedAtTime());
                 }
             });

        for(ChatModel model : messageset) {
            {
                Log.d("MYAPP", model.getMessage());
                Log.d("MYAPP", model.getId().toString());
                Log.d("MYAPP", model.getCreatedAtTime().toString());
            }
        }
    }
}
