package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Computer;
import com.study.rest.repository.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerServiceImpl {

    @Autowired
    private ComputerMapper computerMapper;

    public int registerComputer(ReqRegisterComputerDto reqDto) {
        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();

        return computerMapper.save(computer);
    };

    public List<RespGetListDto> getComputerList(ReqGetListDto reqDto) {
        List<RespGetListDto> respDtos = new ArrayList<>();

        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .build();

        List<Computer> computers = computerMapper.findComputerByComputerAndCpu(computer);
        // Dto -> entity -> Dao -> entity -> Dto

        for(Computer com : computers) {
            RespGetListDto dto = RespGetListDto.builder()
                    .computerId(com.getComputerId())
                    .company(com.getCompany())
                    .build();

            respDtos.add(dto);
        }

        return respDtos;
    }
//    다른 방식으로 작성    
//    public List<RespGetListDto> getComputerList2(ReqGetListDto reqDto) {
//        Computer computer = Computer.builder()
//                .company(reqDto.getCompany())
//                .cpu(reqDto.getCpu())
//                .build();
//
//        List<Computer> computers = computerMapper.findComputerByComputerAndCpu(computer);
//
//        return computers.stream().map(com -> RespGetListDto.builder()
//                .computerId(com.getComputerId())
//                .company(com.getCompany())
//                .build()
//        ).collect(Collectors.toList());
//    }

    public RespGetComputerDto getComputer(int computerId){
        Computer computer = computerMapper.findComputerById(computerId);
        return RespGetComputerDto.builder()
                .computerId(computer.getComputerId())
                .company(computer.getCompany())
                .cpu(computer.getCpu())
                .ram(computer.getRam())
                .ssd(computer.getSsd())
                .build();
    }

    public int deleteComputer(int computerId) {
        return computerMapper.delete(computerId);
    }

    public int updateComputer(ReqUpdateComputerDto reqDto){
        Computer computer = Computer.builder()
                .computerId(reqDto.getComputerId())
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();

        return computerMapper.update(computer);
    }
}
