package com.Teamfinder.controller.configuration;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Converter {

    private final ModelMapper modelMapper;

    public <T> T convert(final Object from, final Class<T> to) {
        return modelMapper.map(from, to);
    }

    public <S, T> List<T> convertList(List<S> from, Class<T> to) {
        return from
                .stream()
                .map(element -> modelMapper.map(element, to))
                .collect(Collectors.toList());
    }
}

