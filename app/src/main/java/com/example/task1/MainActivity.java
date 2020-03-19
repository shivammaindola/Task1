package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        ChatModel chat1 = new ChatModel("hello shivam", 1, 21, 31, ts1);
        ChatModel chat2 = new ChatModel("hello ", 2, 21, 31, ts2);
        ChatModel chat3 = new ChatModel("hello1 ", 3, 23, null, ts3);
        ChatModel chat4 = new ChatModel("hello2 ", 4, 23, null, ts4);
        messageset.add(chat1);
        messageset.add(chat2);
        messageset.add(chat3);
        messageset.add(chat4);

        //function
        List<ChatModel> getlist= new ArrayList<>();
        getlist=dosomething(messageset);

        //print list
        for(ChatModel model : getlist)
        {
            Log.d("CheckList", model.getMessage());
        }
    }

    private List<ChatModel> dosomething(List<ChatModel> messageset) {
        //descending order of createdattime
        Collections.sort(messageset, new Comparator<ChatModel>() {
            public int compare(ChatModel o1, ChatModel o2) {
                return o2.getCreatedAtTime().compareTo(o1.getCreatedAtTime());
            }
        });

        //create a list with latest message
        List<ChatModel> latestlist = new ArrayList<>();
        latestlist.add(messageset.get(0));
        for (int i = 1; i < messageset.size(); i++) {
            Integer groupid = messageset.get(i).getGroupId();

            if (groupid == null) {
                //get userid
                Integer userid = messageset.get(i).getUserId();
                int check = 0;
                for (int j = 0; j < latestlist.size(); j++) {
                    if (userid.equals(latestlist.get(j).getUserId()) && latestlist.get(j).groupId == null) {
                        check = 1;
                        //do nothing
                        break;
                    }
                }
                if (check == 0) {
                    //add this to latestlist
                    latestlist.add(messageset.get(i));
                }
            } else {
                int check = 0;
                for (int j = 0; j < latestlist.size(); j++) {
                    if (groupid.equals(latestlist.get(j).getGroupId())) {
                        check = 1;
                        break;
                    }

                }
                if (check == 0) {
                    latestlist.add(messageset.get(i));
                }
            }
        }

        return latestlist;
    }
}

