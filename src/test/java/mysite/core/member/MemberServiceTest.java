package mysite.core.member;

import mysite.core.AppConfig;
import mysite.core.member.Grade;
import mysite.core.member.Member;
import mysite.core.member.MemberService;
import mysite.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    @Test
    void join(){

        //given
        Member mymember1 = new Member(123L, "tom", Grade.BASIC);
        Member mymember2 = new Member(124L, "jain", Grade.VIP);

        //when
        memberService.join(mymember1);
        memberService.join(mymember2);
        Member mymember3 = memberService.findMember(123L);

        //then
        Assertions.assertThat(mymember1).isEqualTo(mymember3);

    }
}
