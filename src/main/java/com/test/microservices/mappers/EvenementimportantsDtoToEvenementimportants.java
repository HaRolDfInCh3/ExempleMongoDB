package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.EvenementimportantsDto;
import com.test.microservices.pojos.Evenementimportants;
@Service
public class EvenementimportantsDtoToEvenementimportants implements DtoToObject<EvenementimportantsDto,Evenementimportants> {
	DozerBeanMapper modelMapper;
	@Override
	public Evenementimportants dtoToObject(EvenementimportantsDto evenementimportantsDto) {
		this.modelMapper= new DozerBeanMapper();
		Evenementimportants evenementimportants=modelMapper.map(evenementimportantsDto, Evenementimportants.class);
		return evenementimportants;
	}

	@Override
	public EvenementimportantsDto objectToDto(Evenementimportants evenementimportants) {
		this.modelMapper= new DozerBeanMapper();
		EvenementimportantsDto evenementimportantsDto=modelMapper.map(evenementimportants, EvenementimportantsDto.class);
		return evenementimportantsDto;
	}


	@Override
	public List<EvenementimportantsDto> objectsToDtos(List<Evenementimportants> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<EvenementimportantsDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(evenementimportants -> dtoList.add(modelMapper.map(evenementimportants, EvenementimportantsDto.class)));
		return dtoList;
	}



	

}
