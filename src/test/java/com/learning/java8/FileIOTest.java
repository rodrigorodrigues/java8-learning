package com.learning.java8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileIOTest {

    @Test
    @DisplayName("New Java File IO")
    void testReadFileJava8() throws IOException {
        List<String> strings = new FileIO().readFileJava8(new File("src/main/resources/names.txt"));

        assertThat(strings).hasSize(3);
        assertThat(strings).containsExactlyInAnyOrder("Rodrigo Rodrigues", "Juninho", "Anonymous");
    }

    @Test
    @DisplayName("Java File IO Old Way")
    void testReadFileOldWay() throws IOException {
        List<String> strings = new FileIO().readFileOldWay(new File("src/main/resources/names.txt"));

        assertThat(strings).hasSize(3);
        assertThat(strings).containsExactlyInAnyOrder("Rodrigo Rodrigues", "Juninho", "Anonymous");
    }
}
