package com.library.controller;

import com.library.service.ClickCountHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/summaryHistory")
public class ClickCountHistoryController {

    @Autowired
    private ClickCountHistoryService clickCountHistoryService;

//    @DeleteMapping("/delete/{bid}")
//    public Result<Integer> deleteClickCountHistory(@PathVariable("bid")Integer bid){
//        Integer row = clickCountHistoryService.deleteClickCountHistoryByBid(new ClickCountHistory().setBid(bid));
//        if(row > 0){
//            return new Result(ResultCode.SUCCESS,"删除该书籍统计历史成功！",row);
//        }
//        return new Result(ResultCode.FAIL,"删除该书籍统计历史失败！");
//    }
//
}
