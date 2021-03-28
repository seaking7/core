package mysite.core;

import mysite.core.member.Grade;
import mysite.core.member.Member;
import mysite.core.member.MemberService;
import mysite.core.member.MemberServiceImpl;
import mysite.core.order.Order;
import mysite.core.order.OrderService;
import mysite.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

     //   AppConfig appconfig = new AppConfig();

      //  MemberService memberService = appconfig.memberService();
       // OrderService orderService = appconfig.orderService();

        ApplicationContext aC = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = aC.getBean("memberService", MemberService.class);
        OrderService orderService = aC.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order= "+ order);

    }
}
