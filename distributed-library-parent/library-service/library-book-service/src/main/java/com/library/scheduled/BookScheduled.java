package com.library.scheduled;

import com.github.pagehelper.PageInfo;
import com.library.dao.BookDao;
import com.library.pojo.Book;
import com.library.pojo.ClickCountHistory;
import com.library.pojo.Result;
import com.library.pojo.UserBook;
import com.library.service.BookService;
import com.library.service.ClickCountHistoryService;
import com.library.utils.ConvertJsonToBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class BookScheduled {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao bookDao;
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ClickCountHistoryService clickCountHistoryService;

//    @Scheduled(cron = "0 0 * * * ?")
    @Scheduled(cron = "0 0 * * * ?")
    public void clearDayClickCount(){
        Result userBookResult = restTemplate.getForObject("http://user-book-service/select/10000/1", Result.class);
        PageInfo<UserBook> pageInfo = ConvertJsonToBean.convertMapToBean((Map<String, Object>) userBookResult.getData(), PageInfo.class);
        List<UserBook> list = pageInfo.getList();
        List<Book> books = new ArrayList<>();
        for(UserBook ub: list){
            Result bookResult = restTemplate.getForObject("http://book-service/book/get/" + ub.getBid(), Result.class);
            Book b = ConvertJsonToBean.convertMapToBean((Map<String, Object>) bookResult.getData(), Book.class);
            LocalDate now = LocalDate.now();
            LocalDate localDate = now.plusDays(-1);
            ClickCountHistory clickCountHistory = new ClickCountHistory().setDayClickCount(b.getDayClickCount()).setMonthClickCount(b.getMonthClickCount())
                    .setYearClickCount(b.getTotalClickCount()).setSummaryDate(localDate.toString()).setBid(b.getId());
            clickCountHistoryService.addClickCount(clickCountHistory);
        }
        Book book = new Book().setDayClickCount(0);
        Example example = new Example(Book.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThan("dayClickCount",0);
        int row = bookDao.updateByExampleSelective(book,example);
    }

    @Scheduled(cron = "0 0 0 1 * *")
    public void clearMonthClickCount(){
        Book book = new Book().setMonthClickCount(0);
        Example example = new Example(Book.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThan("monthClickCount",0);
    }

}
