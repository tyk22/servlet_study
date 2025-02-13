package com.gn.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gn.member.vo.Member;

public class MemberDao {
	
	
	// createMember 메소드
	// 매개변수로 Connection , Member 받아서
	// DB에 INSERT(member_id, member_pw, member_name)
	// ResultSet X, executeUpdate(O)
	// 결과 int로 반환
	
	public int createMember(Connection conn, Member m) {
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
