package com.mvc.board.Dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.board.Dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate SqlSession;

	@Override
	public List<BoardDto> selectList() {
		// TODO Auto-generated method stub
		List<BoardDto> list = new ArrayList<BoardDto>();

		try {
			list = SqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	

	@Override
	public BoardDto selectOne(int bd_no) {
		// TODO Auto-generated method stub
		BoardDto dto = null;

		try {
			dto = SqlSession.selectOne(NAMESPACE + "selectOne", bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		// TODO Auto-generated method stub
		int res = 0;
		
		try {
			res = SqlSession.insert(NAMESPACE + "insert", dto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		// TODO Auto-generated method stub
		int res=0;
		
		try {
			res = SqlSession.update(NAMESPACE + "update", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int bd_no) {
		// TODO Auto-generated method stub
		int res=0;
		
		try {
			res = SqlSession.delete(NAMESPACE+"delete", bd_no);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

}
