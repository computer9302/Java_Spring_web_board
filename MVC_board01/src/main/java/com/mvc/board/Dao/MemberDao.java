package com.mvc.board.Dao;

import com.mvc.board.Dto.MemberDto;

public interface MemberDao {
	String NAMESPACE = "mymember";
	
	//로그인
	public MemberDto login(MemberDto dto);
}
