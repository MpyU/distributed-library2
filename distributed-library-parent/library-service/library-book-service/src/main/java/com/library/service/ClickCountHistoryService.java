package com.library.service;

import com.library.pojo.ClickCountHistory;

public interface ClickCountHistoryService {

    int addClickCount(ClickCountHistory clickCountHistory);

    Integer deleteClickCountHistoryByBid(ClickCountHistory setBid);

}
