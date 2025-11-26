package com.example.lab9.mapper;
import com.example.lab9.dto.CountryDTO;
import com.example.lab9.models.Country;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel="spring")
public interface CountryMapper {
    Country CountryToEntity(CountryDTO countryDto);
    CountryDTO CountryToDTO(Country country);
    List<CountryDTO> CountryToDTOList(List<Country> countries);
}
