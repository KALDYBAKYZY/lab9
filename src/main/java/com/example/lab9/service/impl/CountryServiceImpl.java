package com.example.lab9.service.impl;
import com.example.lab9.dto.CountryDTO;
import com.example.lab9.mapper.CountryMapper;
import com.example.lab9.models.Country;
import com.example.lab9.repositories.CountryRepository;
import com.example.lab9.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;
    @Override
    public CountryDTO getCountry(Long id){
        Country country = countryRepository.findById(id).orElse(null);
        if(Objects.isNull(country)){
            return null;
        }
        CountryDTO countryDTO = countryMapper.CountryToDTO(country);
        return countryDTO;
    }
    @Override
    public List<CountryDTO> getCountries(){
        List<Country> countries = countryRepository.findAll();
        List<CountryDTO> countriesDTO = countryMapper.CountryToDTOList(countries);
        return countriesDTO;
    }
    @Override
    public CountryDTO addCountry(CountryDTO countryDTO){
        Country country = countryMapper.CountryToEntity(countryDTO);
        Country createdCountry = countryRepository.save(country);
        return countryMapper.CountryToDTO(createdCountry);
    }
    @Override
    public CountryDTO updateCountry(Long id, CountryDTO countryDTO){
        Country country = countryRepository.findById(id).orElse(null);
        if(Objects.isNull(country)){
            return null;
        }
        country.setName(countryDTO.getName());
        country.setCode(countryDTO.getCode());
        Country updatedCountry = countryRepository.save(country);
        return countryMapper.CountryToDTO(updatedCountry);
    }
    @Override
    public boolean deleteCountry(Long id){
        CountryDTO countryDTO = getCountry(id);
        if(Objects.isNull(countryDTO)){
            return false;
        }
        countryRepository.deleteById(id);
        return true;
    }
}
