package com.honey.scrapper;

import com.honey.scrapper.domain.course.Course;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LombokTest {

    @Test
    void setter() {
        Course course = new Course();
        course.setTitle("honey");
        Assertions.assertThat(course.getTitle()).isEqualTo("honey");
    }
}
