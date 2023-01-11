package ai.szs.szsapi.crawling.crawlingList.controller;

import ai.szs.szsapi.common.model.DataTable;
import ai.szs.szsapi.crawling.crawlingList.model.CrawlingKeywordListSetDto;
import ai.szs.szsapi.crawling.crawlingList.model.FileCompanyListSetDto;
import ai.szs.szsapi.crawling.crawlingList.service.CrawlingListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webCrawling")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "GVC - 웹크롤링 리스트")
public class CrawlingListController {

    private final CrawlingListService crawlingListService;

    /**
     * 기업연계표 리스트 조회
     * **/
    @ResponseBody
    @PostMapping("/getFileCompanyList")
    @ApiOperation(value = "기업연계표 리스트 조회")
    public DataTable getFileCompanyList(@RequestBody FileCompanyListSetDto fileCompanyListSetDto){
        return crawlingListService.getFileCompanyList(fileCompanyListSetDto);
    }

    /**
     * 검색어사전 리스트 조회
     * **/
    @ResponseBody
    @PostMapping("/getKeywordList")
    @ApiOperation(value = "웹크롤링 - 검색어사전 리스트 조회")
    public DataTable getKeywordList(@RequestBody CrawlingKeywordListSetDto keywordListSetDto){
        return crawlingListService.getKeywordList(keywordListSetDto);
    }

    
}
