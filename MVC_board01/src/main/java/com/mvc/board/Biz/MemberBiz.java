package com.mvc.board.Biz;

import com.mvc.board.Dto.MemberDto;

public interface MemberBiz {
	//로그인
	public MemberDto login(MemberDto dto);
}
