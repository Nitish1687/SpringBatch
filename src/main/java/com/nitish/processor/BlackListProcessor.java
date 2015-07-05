package com.nitish.processor;

import com.nitish.bean.BlackListUser;
import com.nitish.domain.UserInfoDomain;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class BlackListProcessor implements ItemProcessor<List<BlackListUser>,List<UserInfoDomain>> {


    @Override
    public List<UserInfoDomain> process(List<BlackListUser> blackListUsers) throws Exception {
        List<UserInfoDomain> userInfoDomains = new ArrayList<UserInfoDomain>();
        for (BlackListUser blackListUser : blackListUsers) {
            UserInfoDomain userInfoDomain = new UserInfoDomain();
            userInfoDomain.setEmailId(blackListUser.getEmailId());
            userInfoDomain.setName(blackListUser.getName());
            userInfoDomains.add(userInfoDomain);
        }
        return userInfoDomains;
    }
}
