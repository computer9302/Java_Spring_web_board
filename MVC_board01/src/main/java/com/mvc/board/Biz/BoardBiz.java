package com.mvc.board.Biz;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mvc.board.Dto.BoardDto;

@Service
public interface BoardBiz {

	public List<BoardDto> selectList();
	public BoardDto selectOne(int bd_no);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int bd_no);
	
}
