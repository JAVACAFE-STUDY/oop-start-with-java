package net.chandol.study.oop.store.repository.custom;

import net.chandol.study.oop.store.model.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberExistOrder();
}
