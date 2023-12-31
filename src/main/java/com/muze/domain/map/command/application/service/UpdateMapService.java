package com.muze.domain.map.command.application.service;

import com.muze.domain.map.command.domain.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateMapService {

    private final MapRepository mapRepository;

    @Autowired
    public UpdateMapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }


    //update data String
//    @Transactional
//    public boolean updateMap(RequestMapDTO updateMapDTO){
//        Optional<Map> beforeMap = mapRepository.findById(updateMapDTO.getId());
//        if(beforeMap.isPresent()){
//            Map afterMap = beforeMap.get();
//            if(!updateMapDTO.getTitle().isEmpty()){
//                afterMap.setTitle(updateMapDTO.getTitle());
//            }
//            if(!updateMapDTO.getSong().isEmpty()){
//                afterMap.setSong(updateMapDTO.getSong());
//            }
//            if(!updateMapDTO.getData().isEmpty()){
//                afterMap.setData(updateMapDTO.getData());
//            }
//            // save 해야됨
//            return true;
//        }
//        return false;
//    }

    //update data file
//    @Transactional
//    public boolean updateMap(RequestMapDTO updateMapDTO, MultipartFile file) throws IOException {
//        Optional<Map> beforeMap = mapRepository.findById(updateMapDTO.getId());
//        if(beforeMap.isPresent()){
//            Map afterMap= beforeMap.get();
//            if(!updateMapDTO.getTitle().isEmpty()){
//                afterMap.setTitle(updateMapDTO.getTitle());
//            }
//            if(!updateMapDTO.getSong().isEmpty()){
//                afterMap.setSong(updateMapDTO.getSong());
//            }
//            if(!file.isEmpty()){
//                InputStream inputStream = file.getInputStream();
//
//                StringBuilder content = new StringBuilder();
//                byte[] buffer = new byte[1024];
//                int bytesRead;
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    content.append(new String(buffer, 0, bytesRead));
//                }
//                String fileContent = content.toString();
//                afterMap.setData(fileContent);
//            }
//            return true;
//        }
//        return false;
//    }
}
