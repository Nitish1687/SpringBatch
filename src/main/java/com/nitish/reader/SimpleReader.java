package com.nitish.reader;


import com.nitish.bean.BlackListUser;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class SimpleReader implements ItemReader<List<BlackListUser>>{



    @Override
    public List<BlackListUser> read() throws Exception {

        File file = new File("C:\\Users\\Nitish Shukla\\BlackListFile\\BlackListUser.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<BlackListUser> blackListUsers = new ArrayList<BlackListUser>();

        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");
            System.out.println(split);
            BlackListUser blackListUser = new BlackListUser();
            blackListUser.setEmailId(split[0]);
            blackListUser.setName(split[1]);
            blackListUsers.add(blackListUser);
        }
        return blackListUsers;
    }

    public static void main(String[] args) {
        SimpleReader simpleReader = new SimpleReader();
        try {
            simpleReader.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
