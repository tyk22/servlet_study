package com.gn.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;

@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp = request.getParameter("board_no");
		int boarNo = 0;
		if(temp!=null)boarNo = Integer.parseInt(temp);
		String boardTitle = request.getParameter("board_title");
		String boardContent = request.getParameter("board_content");
		
		
		
		
		Board board = new Board();
		board.setBoardNo(boarNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		
		
		
		
		int result = new BoardService().updateBoard(board);
		System.out.println(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
