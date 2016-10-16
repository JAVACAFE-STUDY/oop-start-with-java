package net.chandol.study.oop.board.service;

import net.chandol.study.oop.board.dto.BoardCreateRequest;
import net.chandol.study.oop.board.model.Board;
import net.chandol.study.oop.board.model.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public Board createBoard(BoardCreateRequest request){
        Board board = new Board(request.getName());
        return boardRepository.save(board);
    }
}
