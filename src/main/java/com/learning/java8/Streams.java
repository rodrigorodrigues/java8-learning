package com.learning.java8;

import com.learning.java8.dto.ChildDto;
import com.learning.java8.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Streams {
    public static void main(String[] args) {
        List<PersonDto> persons = new ArrayList<>();
        persons.add(PersonDto.builder().fullName("Rodrigo Rodrigues")
                .dateOfBirth(LocalDate.of(1983, 1, 1))
                .children(Arrays.asList(new ChildDto("Daniel", LocalDate.of(2017, 1, 1)), new ChildDto("Oliver", LocalDate.of(2017, 1, 1))))
                .build());

        persons.add(PersonDto.builder().fullName("Juninho")
                .dateOfBirth(LocalDate.of(1981, 5, 10))
                .children(Arrays.asList(new ChildDto("Dan", LocalDate.of(2014, 5, 10)), new ChildDto("Iam", LocalDate.of(2016, 10, 20))))
                .build());

        persons.add(PersonDto.builder().fullName("Anonymous")
                .dateOfBirth(LocalDate.of(1985, 8, 25))
                .build());

        //Old way
        //Sort by age
        List<PersonDto> copyPersons = new ArrayList<>(persons);
        Collections.sort(copyPersons, new Comparator<PersonDto>() {
            @Override
            public int compare(PersonDto p, PersonDto p1) {
                return (int) (convertToTimestamp(p.getDateOfBirth()) - convertToTimestamp(p1.getDateOfBirth()));
            }
        });

        log.debug("old way - sort by age: {}", copyPersons);

        PersonDto youngestPerson = null;
        PersonDto oldestPerson = null;
        List<PersonDto> personsWithoutChild = new ArrayList<>();
        Map<String, String> mapPersonsNames = new HashMap<>();

        for (PersonDto person : persons) {
            if (youngestPerson == null && oldestPerson == null) {
                youngestPerson = person;
                oldestPerson = person;
            } else if (person.getDateOfBirth().isBefore(youngestPerson.getDateOfBirth()) ||  person.getDateOfBirth().isEqual(youngestPerson.getDateOfBirth())) {
                youngestPerson = person;
            } else if (person.getDateOfBirth().isAfter(oldestPerson.getDateOfBirth()) || person.getDateOfBirth().isEqual(oldestPerson.getDateOfBirth())) {
                oldestPerson = person;
            }

            if (person.getChildren() == null || person.getChildren().isEmpty()) {
                personsWithoutChild.add(person);
            }

            mapPersonsNames.put(person.getId(), person.getFullName());
        }

        log.debug("old way - youngestPerson: {}", youngestPerson);
        log.debug("old way - oldestPerson: {}", oldestPerson);
        log.debug("old way - personsWithoutChild: {}", personsWithoutChild);
        log.debug("old way - mapPersons: {}", mapPersonsNames);
        //Old way

        //New way using CustomLambda + Streams
        //Sort by age
        copyPersons = new ArrayList<>(persons);
        copyPersons.sort(Comparator.comparing(PersonDto::getDateOfBirth));

        youngestPerson = persons.stream()
                .min(Comparator.comparing(PersonDto::getDateOfBirth))
                .get();

        oldestPerson = persons.stream()
                .max(Comparator.comparing(PersonDto::getDateOfBirth))
                .get();

        personsWithoutChild = persons.stream()
                .filter(p -> p.getChildren() == null || p.getChildren().isEmpty())
                .collect(Collectors.toList());

        mapPersonsNames = persons.stream()
                .collect(Collectors.toMap(PersonDto::getId, PersonDto::getFullName));

        log.debug("--------------");
        log.debug("new way - sort by age: {}", copyPersons);
        log.debug("new way - youngestPerson: {}", youngestPerson);
        log.debug("new way - oldestPerson: {}", oldestPerson);
        log.debug("new way - personsWithoutChild: {}", personsWithoutChild);
        log.debug("new way - mapPersonsNames: {}", mapPersonsNames);
    }

    private static long convertToTimestamp(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant())
                .getTime();
    }
}


