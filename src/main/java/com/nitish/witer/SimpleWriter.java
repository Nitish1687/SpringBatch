package com.nitish.witer;

import com.nitish.domain.UserInfoDomain;
import org.springframework.batch.item.ItemWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;


public class SimpleWriter implements ItemWriter<List<UserInfoDomain>> {
    @Override
    public void write(List<? extends List<UserInfoDomain>> list) throws Exception {

        File file = new File("C:\\Users\\Nitish Shukla\\BlackListFile\\BlackListOutput.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<? extends List<UserInfoDomain>> iterator = list.iterator();
        while (iterator.hasNext()) {
            List<UserInfoDomain> innerIterator = iterator.next();
            for (UserInfoDomain userInfoDomain : innerIterator) {
                stringBuilder.append(userInfoDomain.getEmailId());
                stringBuilder.append(",");
                stringBuilder.append(userInfoDomain.getName());
                stringBuilder.append("\r\n");

            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        fileWriter.close();
        bufferedWriter.close();

    }
}