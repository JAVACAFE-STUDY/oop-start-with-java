package net.chandol.study.oop.store.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import net.chandol.study.oop.store.model.Member;
import net.chandol.study.oop.store.model.QMember;
import net.chandol.study.oop.store.model.QOrder;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class MemberRepositoryImpl extends QueryDslRepositorySupport implements MemberRepositoryCustom{
    public MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public List<Member> findMemberExistOrder() {
        QMember member = QMember.member;
        QOrder order = QOrder.order;

        JPQLQuery<Member> query = this.from(order, member)
                .where(order.member.eq(member))
                .select(member)
                .distinct();

        List<Member> result = query.fetch();
        System.out.println(result);

        return result;

    }
}
