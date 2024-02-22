package com.marketplace.controller;

import com.marketplace.DTO.profession.ProfessionRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.service.IProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/professions")
@RequiredArgsConstructor
public class ProfessionController {

    private final IProfessionService professionService;

    /** Recibe un Page & Size */
    @GetMapping
    public ResponseEntity<Page<ProfessionResponse>> findAll(Pageable pageable){
        return new ResponseEntity<>(professionService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionResponse> findByUUID(@PathVariable Long id){
        return new ResponseEntity<>(professionService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProfessionRequest professionRequest){
        professionService.save(professionRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody ProfessionRequest professionRequest){
        professionService.update(id, professionRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        professionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
