package com.library.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ClickCountHistory {
    private Integer id;
    private Integer bid;
    private Integer dayClickCount;
    private Integer monthClickCount;
    private Integer yearClickCount;
    private String summaryDate;

    private Book book;
}
