package com.example.board.demo.dao;

import com.example.board.demo.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements IBoardDao{

    private static final String NAMESPACE = "com.example.board.demo.dao.boardMapper.";

    @Autowired
    private SqlSession sqlSession;

    public void createBoard(BoardDto boardDto){
        sqlSession.insert(NAMESPACE + "createBoard", boardDto);
    }

}
