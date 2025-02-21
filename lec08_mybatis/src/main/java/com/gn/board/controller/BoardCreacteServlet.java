package com.gn.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;

@WebServlet("/boardCreate")
public class BoardCreacteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardCreacteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTilte = request.getParameter("board_title");
		String boardContent = request.getParameter("board_content");
		String temp= request.getParameter("board_writer");
		int boardWriter= 0;
		if(temp!=null)boardWriter=Integer.parseInt(temp);
		
		System.out.println(boardTilte);
		System.out.println(boardWriter);
		System.out.println(boardContent);
		
		
		
		Board board = new Board();
		board.setBoardTitle(boardTilte);
		board.setBoardContent(boardContent);
		board.setBoardWriter(boardWriter);
		
		int result = new BoardService().createBoard(board);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
