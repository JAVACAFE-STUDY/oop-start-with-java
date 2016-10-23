package net.chandol.study.oop.store.repository;

import net.chandol.study.oop.store.model.Item;
import net.chandol.study.oop.store.repository.custom.ItemRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom{
    List<Item> findByNameContaining(String contains);

    @Query("SELECT A FROM Item A WHERE A.name LIKE CONCAT('%',:name,'%')")
    List<Item> jpqlFindByNameContaining(@Param("name") String name);
}
