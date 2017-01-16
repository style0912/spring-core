package com.nhnent.benjamin;

import com.nhnent.benjamin.config.ApplicationContextConfig;
import com.nhnent.benjamin.dao.MemberDao;
import com.nhnent.benjamin.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

/**
 * Created by benjamin on 2017. 1. 15..
 */
public class Server {
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        MemberDao memberDao = context.getBean(MemberDao.class);

        Member member = memberDao.exist("dongmyo@nhnent.com", "12345");
        if (member == null) {
            member = new Member();
            member.setEmail("dongmyo@nhnent.com");
            member.setPassword("12345");
            member.setName("dongmyo");
            member.setCreatedDate(new Date());
            member.setModifiedDate(new Date());

            try {
                memberDao.insert(member);
            } catch (Exception e) {
                LOGGER.error("{}", e);
            }

            System.out.println("dongmyo NOT exists");
        } else {
            System.out.println(member.getName());
        }

    }
}
