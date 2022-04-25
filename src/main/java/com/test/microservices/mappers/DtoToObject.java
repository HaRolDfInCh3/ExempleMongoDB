package com.test.microservices.mappers;










public interface DtoToObject<Dto,Obj> {
	Obj  dtoToObject(Dto dto);
    Dto  objectToDto(Obj obj);
}
