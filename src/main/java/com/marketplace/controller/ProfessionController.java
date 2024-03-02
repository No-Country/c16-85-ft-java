package com.marketplace.controller;

import com.marketplace.DTO.profession.ProfessionSaveRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.DTO.profession.ProfessionUpdateRequest;
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


    /** Recibe un Page & Size.
     * Usar en vista de cliente */
    @GetMapping
    public ResponseEntity<Page<ProfessionResponse>> findAllAvailable(Pageable pageable){
        return new ResponseEntity<>(professionService.findAllAvailable(pageable), HttpStatus.OK);
    }

    /** Recibe un Page & Size.
     * Usar en vista de administrador o contractor */
    @GetMapping("/all")
    public ResponseEntity<Page<ProfessionResponse>> findAll(Pageable pageable){
        return new ResponseEntity<>(professionService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(professionService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<Page<ProfessionResponse>> findByCategoryName(Pageable pageable,
                                                                     @PathVariable String name){
        return new ResponseEntity<>(professionService
                .findByCategoryName(pageable, name), HttpStatus.OK);
    }

    @GetMapping("/contractor/{id}")
    public ResponseEntity<Page<ProfessionResponse>> findByContractorId(Pageable pageable,
                                                                       @PathVariable Long id){
        return new ResponseEntity<>(professionService
                .findByContractorId(pageable, id), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Page<ProfessionResponse>> findByTitle(Pageable pageable,
                                                                @PathVariable String title){
        return new ResponseEntity<>(professionService
                .findByTitle(pageable, title), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProfessionSaveRequest professionSaveRequest){
        professionService.save(professionSaveRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody ProfessionUpdateRequest professionUpdateRequest){
        professionService.update(id, professionUpdateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        professionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
