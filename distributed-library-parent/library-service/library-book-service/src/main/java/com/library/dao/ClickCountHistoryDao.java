package com.library.dao;

import com.library.pojo.ClickCountHistory;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ClickCountHistoryDao extends Mapper<ClickCountHistory> {

}
