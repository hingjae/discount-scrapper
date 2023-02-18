package com.honey.scrapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplitTest {

    @Test
    void split() {
        String text = "I am honey !";
        String[] words = text.split(" ");
        Assertions.assertThat(words).isEqualTo(new String[]{"I", "am", "honey", "!"});
    }
}
