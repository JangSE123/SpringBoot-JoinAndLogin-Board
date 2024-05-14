package com.example.service;

import com.example.dto.DTOBoard;
import com.example.entity.EntityBoard;
import com.example.repository.BoardRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ServiceBoard {
    @Autowired
    BoardRepository boardRopo;

    @PostMapping("/Write")
    public void Write(DTOBoard board) {
        System.out.println(board.BoardTitle);
        System.out.println(board.BoardContent);
        System.out.println(board.BoardAuthor);
        System.out.println(board.BoardDate);

        boardRopo.save(board.ToEntity());
    }

    public Iterable<EntityBoard>GetAllBoard() {
        return boardRopo.findAll();
    }

}
