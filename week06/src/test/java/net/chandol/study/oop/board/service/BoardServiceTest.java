package net.chandol.study.oop.board.service;

import net.chandol.study.oop.board.dto.BoardCreateRequest;
import net.chandol.study.oop.board.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    public void 보드생성() throws Exception {
        //given
        BoardCreateRequest request = new BoardCreateRequest("Java");

        //when
        Board board = boardService.createBoard(request);

        //then
        assertThat(board.getName()).isEqualTo("Java");
        assertThat(board.getId()).isNotNull();
    }
}