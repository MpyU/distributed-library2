package com.library.dao;

import com.library.pojo.ClickCountHistory;
import com.library.pojo.UserBook;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminDao{

    @Select("select id,bid,day_click_count,month_click_count,year_click_count,summary_date from click_count_history where day(summary_date)=${date} order by summary_date desc")
    List<ClickCountHistory> summaryByDay(@Param("date") String date);

    @Select("select id,bid,day_click_count,month_click_count,year_click_count,summary_date from click_count_history where month(summary_date)=${date} order by summary_date desc")
    List<ClickCountHistory> summaryByMonth(@Param("date") String date);

    @Select("select id,bid,day_click_count,month_click_count,year_click_count,summary_date from click_count_history where year(summary_date)=${date} order by summary_date desc")
    List<ClickCountHistory> summaryByYear(@Param("date") String date);

    @Insert("   insert into user_book(uid,bid,status,lend_date) values(#{userId},#{bookId},0,#{lendDate})")
    public int lendBook(@Param("userId") Integer userId,@Param("bookId")Integer bookId,@Param("lendDate")String lendDate);
    @Insert("    update user_book  set status=1,return_date=#{returnDate} where uid=#{userId} and bid=#{bookId} and status=0")

    public int  returnBook(@Param("userId")Integer userId, @Param("bookId")Integer bookId,@Param("returnDate")String returnDate);
    // 查询还在借的书，看是否已经借够三本
    @Select(" select id,uid,bid,status,lend_date return_date from user_book where uid=#{uid} and status=0")
    public List<UserBook> hasLendBooks(Integer userId);


    //减库存
    @Update(" update book set count=count-#{num}   where id=#{bookId}")
    int subBook(@Param("bookId")int bookId,@Param("num")int num);


//    int bookUp(Integer bookId);
//
//    int bookDown(Integer bookId);
}
