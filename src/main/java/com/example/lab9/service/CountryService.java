package com.example.lab9.service;
import com.example.lab9.dto.CountryDTO;
import java.util.List;

public interface CountryService {
    CountryDTO getCountry(Long id);
    List<CountryDTO> getCountries();
    CountryDTO addCountry(CountryDTO countryDTO);
    CountryDTO updateCountry(Long id, CountryDTO countryDTO);
    boolean deleteCountry(Long id);
}
