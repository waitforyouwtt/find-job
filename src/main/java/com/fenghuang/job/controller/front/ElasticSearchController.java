package com.fenghuang.job.controller.front;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.service.ElasticSearchService;
import com.fenghuang.job.view.ProjectESByParamsView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;

/**
 * @Author: luoxian
 * @Date: 2020/6/16 16:42
 * @Email: 15290810931@163.com
 */
@RestController
public class ElasticSearchController {

    @Autowired
    ElasticSearchService searchService;

    //ॣ ॣ ॣ
    @ApiOperation(value = "创建projectInfoES索引库")
    @PostMapping("/createIndex")
    public Result createIndex(){
      return searchService.createIndex();
    }

    @ApiOperation(value = "保存或更新兼职项目")
    @PostMapping("/saveOrUpdateProjectByES")
    public Result saveOrUpdateProjectByES(){
        return searchService.saveOrUpdateProjectByES();
    }

    //ॣ ॣ ॣ
    @ApiOperation(value = "通过es 自动生成的Id查询projectInfoES索引库")
    @PostMapping("/queryProjectESByAutoId")
    public Result queryProjectESByAutoId(@RequestParam("id")String id) throws ParseException {
        return searchService.queryProjectESByAutoId(id);
    }

    //ॣ ॣ ॣ
    @ApiOperation(value = "通过database Id查询projectInfoES索引库")
    @PostMapping("/queryProjectESById")
    public Result queryProjectESById(@RequestParam("id")String id) throws ParseException {
        return searchService.queryProjectESById(id);
    }

    @ApiOperation(value = "通过条件查询projectInfoES索引库")
    @PostMapping("/queryProjectESByParams")
    public Result queryProjectESByParams(@RequestBody(required = false) ProjectESByParamsView view){
        return searchService.queryProjectESByParams(view);
    }


}
