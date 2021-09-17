package com.cos.blogapp2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blogapp2.domain.board.Board;
import com.cos.blogapp2.domain.board.BoardRepository;
import com.cos.blogapp2.web.dto.BoardSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {

	private final BoardRepository boardRepository;
	
	@PostMapping("/board")
	public String save(BoardSaveReqDto dto) { // title=제목&content=내용
		
		Board board = dto.toEntity();
		boardRepository.save(board);
		return "redirect:/";
	}
	
	
	@GetMapping("/board")
	public String list() {	
		return "board/list";
	}
	
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id) {	
		return "board/detail";
	}
	
	@GetMapping("/board/saveForm")
	public String boardSaveForm() {
		return "board/saveForm";
	}
	
}


