package com.example.board.demo.service;

import com.example.board.demo.dao.BoardDaoImpl;
import com.example.board.demo.dao.IBoardDao;
import com.example.board.demo.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements IBoardService{

    private final IBoardDao boardDao;

    @Autowired
    public BoardServiceImpl(BoardDaoImpl boardDao){
        this.boardDao = boardDao;
    }

    public void createBoard(BoardDto boardDto) throws RuntimeException{
        boardDao.createBoard(boardDto);
    }

}
