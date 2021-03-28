package mysite.core;

import mysite.core.discount.DiscountPolicy;
import mysite.core.discount.FixDiscountPolicy;
import mysite.core.discount.RateDiscountPolicy;
import mysite.core.member.MemberRepository;
import mysite.core.member.MemberService;
import mysite.core.member.MemberServiceImpl;
import mysite.core.member.MemoryMemberRepository;
import mysite.core.order.OrderService;
import mysite.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
