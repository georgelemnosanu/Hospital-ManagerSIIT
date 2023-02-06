package com.siit.hospital_manager.service;

import com.siit.hospital_manager.exception.BusinessException;
import com.siit.hospital_manager.model.Procedure;
import com.siit.hospital_manager.repository.ProcedureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProcedureService {


    private final ProcedureRepository procedureRepository;


    public void createProcedure(String name){
        procedureRepository.findByName(name).ifPresent(procedure -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Procedure Already Exists");
        });
        Procedure procedure = new Procedure();
        procedure.setName(name);
        procedureRepository.save(procedure);

    }
     @Transactional
    public void deleteProcedure(Integer id){
        Procedure procedure = procedureRepository.findById(id).orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"Procedure not found"));
        procedureRepository.deleteByIdNativeQuery(procedure.getId());
    }

}
