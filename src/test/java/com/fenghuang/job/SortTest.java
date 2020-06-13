package com.fenghuang.job;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.service.BbsAreaService;
import com.fenghuang.job.service.ProjectInfoService;
import com.fenghuang.job.view.BbsAreaView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.FixedOrderComparator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: luoxian
 * @Date: 2020/6/8 15:48
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class SortTest extends FindJobApplicationTests {

    @Autowired
    BbsAreaService bbsAreaService;

    @Test
    public void insertBrowseRecordInfo(){
        Result bbsAreaByUPid = bbsAreaService.findBbsAreaByUPid( 0 );
        List<BbsAreaView> viewList = (List<BbsAreaView>) bbsAreaByUPid.getData();

        List<Integer> sortList = new ArrayList<>();
        sortList.add(110100);
        sortList.add(310100);
        sortList.add(120100);
        sortList.add(500100);
        sortList.add( 130000 );
        sortList.add( 140000 );

        Collections.sort(viewList, new BeanComparator<BbsAreaView>("areaId", new FixedOrderComparator(sortList)));


        log.info( "获取的结果:{}", JSON.toJSONString(viewList) );
    }

    @Test
    public void xxx(){
        Student student1 = new Student("spring", 20, false);
        Student student2 = new Student("summer", 18, false);
        Student student3 = new Student("automn", 30, false);
        Student student4 = new Student("winter", 25, true);

        List<Student> list1 = new ArrayList<Student>();
        list1.add(student1);
        list1.add(student3);
        list1.add(student2);
        list1.add(student4);

        List<Integer> ageList = new ArrayList<>();
        ageList.add(18);
        ageList.add(30);
        ageList.add(20);
        ageList.add(25);
        Collections.sort(list1, new BeanComparator<Student>("age", new FixedOrderComparator(ageList)));

        log.info( "dedao :{}",JSON.toJSONString( list1 ) );
       // list1.stream().forEach(val -> System.out.println(val.getName() + ":" + val.getAge()));
    }
}
