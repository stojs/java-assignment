package io.falcon.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestModel {

    private Long timestamp;
    private String content;
    private int size;

}
