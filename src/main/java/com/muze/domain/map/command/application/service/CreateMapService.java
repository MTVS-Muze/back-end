package com.muze.domain.map.command.application.service;

import com.muze.domain.map.command.application.dto.RequestMapDTO;
import com.muze.domain.map.command.application.dto.ResponseMapDTO;
import com.muze.domain.map.command.domain.aggregate.entity.Map;
import com.muze.domain.map.command.domain.aggregate.vo.MemberVO;
import com.muze.domain.map.command.domain.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class CreateMapService {

    private final MapRepository mapRepository;

    @Autowired
    public CreateMapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public ResponseMapDTO createMap(RequestMapDTO createMapDTO, MultipartFile file) {
        MemberVO memberId = MemberVO.builder().memeberId(createMapDTO.getMemberId()).build();
        try {
            InputStream inputStream = file.getInputStream();

            StringBuilder content = new StringBuilder();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                content.append(new String(buffer, 0, bytesRead));
            }

            String fileContent = content.toString();
            System.out.println("FileContent");
            System.out.println(fileContent);

            Map newMap = mapRepository.save(new Map(memberId, createMapDTO.getTitle(),
                    createMapDTO.getSong(), fileContent));
            ResponseMapDTO map = new ResponseMapDTO(
                    newMap.getId(),
                    newMap.getMemberId().getId(),
                    newMap.getTitle(),
                    newMap.getSong(),
                    newMap.getData(),
                    newMap.getCreatedDate()
            );

            return map;
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("오류 발생!");
            return null;
        }
    }
//    public ResponseMapDTO createMap(RequestMapDTO createMapDTO) {
//        MemberVO memberId = MemberVO.builder().memeberId(createMapDTO.getMemberId()).build();
//        Map newMap = mapRepository.save(new Map(memberId, createMapDTO.getTitle(),
//                    createMapDTO.getSong(), createMapDTO.getDate()));
//        ResponseMapDTO map = new ResponseMapDTO(
//                    newMap.getId(),
//                    newMap.getMemberId().getId(),
//                    newMap.getTitle(),
//                    newMap.getSong(),
//                    newMap.getData(),
//                    newMap.getCreatedDate()
//        );
//            return map;
//    }
}
