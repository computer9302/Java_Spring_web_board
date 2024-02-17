package com.mvc.board.Biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.board.Dao.BoardDao;
import com.mvc.board.Dto.BoardDto;

@Repository
public class BoardBizImpl implements BoardBiz {

	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int bd_no) {
		// TODO Auto-generated method stub
		return dao.selectOne(bd_no);
	}

	@Override
	public int insert(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int bd_no) {
		// TODO Auto-generated method stub
		return dao.delete(bd_no);
	}

	
	
}
