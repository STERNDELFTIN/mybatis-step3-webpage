package com.example.demo.repository;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.BoardDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
	
	private final SqlSessionTemplate sql;
	
	public BoardDTO save(BoardDTO dto) {
		sql.insert("Board.save", dto);
		return dto;
	}
	
	public List<BoardDTO> findAll() {
		return sql.selectList("Board.findAll");
	}
	
	public BoardDTO findById(Long id) {
		return sql.selectOne("Board.findById", id);
	}
	
	public void update(BoardDTO boardDTO) {
		sql.update("Board.update", boardDTO);
	}
	
	public void delete(Long id) {
		sql.delete("Board.delete", id);
	}
}
