package net.chandol.study.oop.store.repository;

import net.chandol.study.oop.store.model.Member;
import net.chandol.study.oop.store.repository.custom.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
