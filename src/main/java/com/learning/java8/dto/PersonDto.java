package com.learning.java8.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private String id;

    private String fullName;

    private LocalDate dateOfBirth;

    private List<ChildDto> children;

    private AddressDto address;
}
