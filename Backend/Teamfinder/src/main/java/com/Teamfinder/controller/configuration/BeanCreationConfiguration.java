package com.Teamfinder.controller.configuration;

import com.Teamfinder.entity.User;
import com.Teamfinder.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Configuration
public class BeanCreationConfiguration {
    @Bean
    public ModelMapper mapperFactory() {
        return new ModelMapper();
    }


}
