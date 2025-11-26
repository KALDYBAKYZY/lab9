package com.example.lab9.controllers;

import com.example.lab9.dto.CountryDTO;
import com.example.lab9.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;
    @GetMapping
    public ResponseEntity<?> getCountries() {
        List<CountryDTO> countries = countryService.getCountries();
        if (countries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(countries);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCountry(@PathVariable Long id) {
        CountryDTO countryDTO = countryService.getCountry(id);
        if (Objects.isNull(countryDTO)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(countryDTO);
        }
    }

    @PostMapping
    public ResponseEntity<?> addCountry(@RequestBody CountryDTO countryDTO) {
        CountryDTO createdCountry = countryService.addCountry(countryDTO);
        return new ResponseEntity<>(createdCountry, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        CountryDTO updatedCountry = countryService.updateCountry(id, countryDTO);
        if (Objects.isNull(updatedCountry)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(updatedCountry);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long id) {
        boolean deleted = countryService.deleteCountry(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
