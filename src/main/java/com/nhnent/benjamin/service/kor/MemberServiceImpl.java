package com.nhnent.benjamin.service.kor;

import com.nhnent.benjamin.dao.MemberDao;
import com.nhnent.benjamin.service.MemberService;
import com.nhnent.benjamin.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Date;

/**
 * Created by benjamin on 2017. 1. 16..
 */
@Service
public class MemberServiceImpl implements MemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public Member createMember(String email, String password, String name) {
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);
        member.setName(name);
        member.setCreatedDate(new Date());
        member.setModifiedDate(new Date());

        try {
            memberDao.insert(member);
        }
        catch (Exception e) {
            LOGGER.error("{}", e);
        }

        return member;
    }

    public Member getMember(String email, String password) throws Exception {
        Member member = memberDao.exist(email, password);
        if (member == null) {
            return null;
        }

        return memberDao.selectOne(member.getNo());
    }

    public void exchangeMemberName(Member member1, Member member2) throws Exception {
        TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            String tempName = member1.getName();
            member1.setName(member2.getName());
            member2.setName(tempName);

            memberDao.update(member1);
            memberDao.update(member2);

            this.transactionManager.commit(status);
        }
        catch (RuntimeException e) {
            this.transactionManager.rollback(status);
            throw e;
        }
    }
}
