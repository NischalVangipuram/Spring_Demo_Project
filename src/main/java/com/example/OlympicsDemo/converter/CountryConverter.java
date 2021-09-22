package com.example.OlympicsDemo.converter;

import com.example.OlympicsDemo.dto.CountryDTO;
import com.example.OlympicsDemo.entity.Country;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryConverter {



        public CountryDTO entityToDto(Country country)
        {
            ModelMapper mapper=new ModelMapper();
            CountryDTO map=mapper.map(country,CountryDTO.class);
            return map;
        }
        public Country dtoToEntity(CountryDTO countryDTO)
        {
            ModelMapper mapper=new ModelMapper();
            Country map=mapper.map(countryDTO,Country.class);
            return map;
        }
        public List<CountryDTO> entityToDto(List<Country> countries)
        {
            return  countries.stream().map(x->entityToDto(x)).collect(Collectors.toList());

        }
        public List<Country> dtoToEntity(List<CountryDTO> countryDTOList){

            return countryDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
        }

    }


