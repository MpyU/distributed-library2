package com.library.service.impl;

import com.library.dao.ClickCountHistoryDao;
import com.library.pojo.ClickCountHistory;
import com.library.service.ClickCountHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClickCountHistoryServiceImpl implements ClickCountHistoryService {

    @Autowired
    private ClickCountHistoryDao clickCountHistoryDao;

    @Override
    public int addClickCount(ClickCountHistory clickCountHistory) {
        return clickCountHistoryDao.insert(clickCountHistory);
    }

    @Override
    public Integer deleteClickCountHistoryByBid(ClickCountHistory clickCountHistory) {
        return clickCountHistoryDao.delete(clickCountHistory);
    }
}
