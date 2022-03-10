package pb.testphone.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pb.testphone.domain.Member;
import pb.testphone.repository.MemberRepository;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setId(20214100L);
        member.setName("홍길동");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberService.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 회원_중복_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setId(20214100L);
        member1.setName("홍길동");

        Member member2 = new Member();
        member2.setId(20214100L);
        member2.setName("이순신");

        //when
        memberService.join(member1);
        memberService.join(member2); // 예외 발생

        //then
        fail("예외 발생해야 함");
    }

    @Test
    public void 회원_전체_조회() throws Exception {
        //given
        Member member1 = new Member();
        member1.setId(20214100L);
        member1.setName("홍길동");

        Member member2 = new Member();
        member2.setId(20214101L);
        member2.setName("이순신");

        //when
        memberService.join(member1);
        memberService.join(member2);
        List<Member> memberList = memberService.findMembers();

        //then
        assertEquals(2, memberList.size());
    }
}