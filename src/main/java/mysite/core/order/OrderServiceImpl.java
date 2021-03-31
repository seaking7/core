package mysite.core.order;

import lombok.RequiredArgsConstructor;
import mysite.core.discount.DiscountPolicy;
import mysite.core.discount.FixDiscountPolicy;
import mysite.core.discount.RateDiscountPolicy;
import mysite.core.member.Member;
import mysite.core.member.MemberRepository;
import mysite.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =  memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
