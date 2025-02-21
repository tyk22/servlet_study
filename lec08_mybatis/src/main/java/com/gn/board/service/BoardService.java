package com.gn.board.service;

import static com.gn.common.sql.SqlSessionTemplate.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Board;

public class BoardService {
	
	public int insertMany(List<Board> list) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().insertMany(session,list);
		session.close();
		return result;
	}
	
	public int createBoard(Board board) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().createBoard(session,board);
		session.close();
		return result;
	}
	
	public int daletBoard(int boardNo) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().daletBoard(session,boardNo);
		session.close();
		return result;
	}
	
	public int updateBoard(Board board) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().updateBoard(session,board);
//		session.commit();
//		session.rollback(); < commit , rollback 2개 전부 사용하는 방법 나쁘지 않은듯
		session.close();
		return result;
	}
	
	public Board selectBoardThree(Board option) {
		SqlSession session = getSqlSession();
		Board board = new BoardDao().selectBoardThree(session, option);
		session.close();
		return board;
	}
	
	public Board selectBoardTwo(Map<String, String> paramMap) {
		SqlSession session = getSqlSession();
		Board board = new BoardDao().selectBoardTwo(session, paramMap);
		session.close();
		return board;
	}
	
	public Board selectBoardOne(int boardNo) {
		SqlSession session = getSqlSession();
		Board board = new BoardDao().selectBoardOne(session,boardNo);
		session.close();
		return board;
	}
	
	
	public List<Board> selectBoardList(Board option){
		SqlSession session = getSqlSession();
		List<Board> resultList = new BoardDao().selectBoardList(session,option);
		session.close();
		return resultList;
	}
}
