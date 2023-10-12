package com.spring.myweb.freeboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.myweb.freeboard.dto.FreeDetailResponseDTO;
import com.spring.myweb.freeboard.dto.FreeListResponseDTO;
import com.spring.myweb.freeboard.dto.FreeModifyRequestDTO;
import com.spring.myweb.freeboard.dto.FreeRegistRequestDTO;
import com.spring.myweb.freeboard.entity.FreeBoard;
import com.spring.myweb.freeboard.mapper.IFreeBoardMapper;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreeBoardService implements IFreeBoardService {

	private final IFreeBoardMapper mapper;
	
	@Override
	public void regist(FreeRegistRequestDTO dto) {
		mapper.regist(FreeBoard.builder()
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.build());

	}

	@Override
	public List<FreeListResponseDTO> getList() {
		List<FreeListResponseDTO> dtoList = new ArrayList<>();
		List<FreeBoard> list = mapper.getList();
		for(FreeBoard board : list) {
			dtoList.add(new FreeListResponseDTO(board));
		}
		return dtoList;
	}

	@Override
	public FreeDetailResponseDTO getContent(int bno) {
		FreeBoard board = mapper.getContent(bno);
		return new FreeDetailResponseDTO(board);
	}

	@Override
	public void update(FreeModifyRequestDTO freeboard) {
//		FreeBoard board = mapper.getContent(bno);
		mapper.update(FreeBoard.builder()
				.title(freeboard.getTitle())
				.content(freeboard.getContent())
				.bno(freeboard.getBno())
				.build());	
		

	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub

	}

}