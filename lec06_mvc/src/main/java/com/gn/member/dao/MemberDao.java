package com.gn.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gn.member.vo.Member;

public class MemberDao {
	
	public Member selectMember(Connection conn, String no) {
		PreparedStatement pstmt = null;
		Member m = null;
		ResultSet rs =null;
		try {
			String sql = "SELECT * "
					+ "FROM member "
					+ "WHERE member_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new Member();
				m.setMemberNO(rs.getInt("member_no"));
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPw(rs.getString("member_pw"));
				m.setMemberName(rs.getString("member_name"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	
	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "UPDATE member "
					+ "SET  member_pw= ? ,member_name=? "
					+ "WHERE  member_no= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getMemberName());
			pstmt.setInt(3, m.getMemberNO());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public Member loginMember(Connection conn, String id, String pw) {
		PreparedStatement pstmt = null;
		Member m = null;
		ResultSet rs =null;
		try {
			String sql = "SELECT * "
					+ "FROM member "
					+ "WHERE member_id = ? AND member_pw = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new Member();
				m.setMemberNO(rs.getInt("member_no"));
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPw(rs.getString("member_pw"));
				m.setMemberName(rs.getString("member_name"));
				
//				int memberNO = rs.getInt("member_no");
//				String memberId = rs.getString("member_id");
//				String memberPw = rs.getString("member_pw");
//				String memberName = rs.getString("member_name");
//				m = new Member(memberNO,memberId,memberPw,memberName);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return m;
		
	}
	
	public int createMember(Connection conn, Member m) {
		// createMember 메소드
		// 매개변수로 Connection , Member 받아서
		// DB에 INSERT(member_id, member_pw, member_name)
		// ResultSet X, executeUpdate(O)
		// 결과 int로 반환
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "INSERT INTO `member`(member_id,`member_pw`,`member_name`,`member_no`) "
					+ " VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setInt(4, m.getMemberNO());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
