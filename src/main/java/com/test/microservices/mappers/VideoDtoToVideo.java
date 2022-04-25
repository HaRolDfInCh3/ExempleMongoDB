package com.test.microservices.mappers;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.VideoDto;
import com.test.microservices.pojos.Video;
@Service
public class VideoDtoToVideo implements DtoToObject<VideoDto,Video> {
	DozerBeanMapper modelMapper;
	@Override
	public Video dtoToObject(VideoDto dto) {
		this.modelMapper= new DozerBeanMapper();
		Video v=modelMapper.map(dto, Video.class);
		return v;
	}

	@Override
	public VideoDto objectToDto(Video obj) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
