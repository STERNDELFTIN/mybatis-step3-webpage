package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/save")
	public String save() {
		return "save";
	}
	@PostMapping("/save")
	public String save(BoardDTO dto) {
		System.out.println("DTO = " + dto);
		boardService.save(dto);
		// return "index"
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String findAll(Model model) {
		List<BoardDTO> boardDTOList = boardService.findAll();
		model.addAttribute("boardList", boardDTOList);
		System.out.println("boardDTOList = " + boardDTOList);
		return "list";
	}
	
	@GetMapping("/{id}")
	public String findByAll(@PathVariable("id") Long id, Model model) {
		// 상세 내용 가져옴
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		System.out.println("boardDTO = " + boardDTO);
		return "detail";
	}
	
	// @Get
	
}
