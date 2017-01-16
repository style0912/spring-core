package com.nhnent.benjamin;

import com.nhnent.benjamin.config.ApplicationContextConfig;
import com.nhnent.benjamin.service.MemberService;
import com.nhnent.benjamin.vo.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by benjamin on 2017. 1. 15..
 */
public class Server {

    public static void main(String args[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        MemberService memberService = context.getBean(MemberService.class);

        Member member = memberService.getMember();
        System.out.println(member.getEmail());

        context.close();

    }
}
