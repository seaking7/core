package mysite.core;

import mysite.core.member.Grade;
import mysite.core.member.Member;
import mysite.core.member.MemberService;
import mysite.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

       // AppConfig appConfig = new AppConfig();
        //MemberService memberService = new MemberServiceImpl();
       // MemberService memberService = appConfig.memberService();

        ApplicationContext aC = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = aC.getBean("memberService", MemberService.class);

        Member mymember1 = new Member(123L, "tom", Grade.BASIC);
        Member mymember2 = new Member(124L, "jain", Grade.VIP);

        memberService.join(mymember1);
        memberService.join(mymember2);

        Member mymember3 = memberService.findMember(123L);
        System.out.println("Result : "+ mymember3.getName());


    }
}
