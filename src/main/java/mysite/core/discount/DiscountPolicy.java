package mysite.core.discount;

import mysite.core.member.Member;

public interface DiscountPolicy {

    //할인 대상금액 return
    int discount(Member member, int price);
}
