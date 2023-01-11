package ai.szs.szsapi.crawling.crawlingResult.controller;

import ai.szs.szsapi.common.model.DataTable;
import ai.ndata.gvcapi.crawling.crawlingResult.model.*;
import ai.szs.szsapi.crawling.crawlingResult.model.*;
import ai.szs.szsapi.crawling.crawlingResult.service.CrawlingResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/webCrawling")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "GVC - 웹크롤링 결과")
public class CrawlingResultController {

    private final CrawlingResultService crawlingResultService;
    
    @ResponseBody
    @PostMapping("/getCrawlingStatistics")
    @ApiOperation(value = "웹크롤링 통계")
    public List<CrawlingStatisticsGetDto> getCrawlingStatistics(@RequestBody CrawlingStatisticsSetDto crawlingStatisticsSetDto){
        return crawlingResultService.getCrawlingStatistics(crawlingStatisticsSetDto);
    }

    @ResponseBody
    @PostMapping("/getCrawlingStatisticsList")
    @ApiOperation(value = "웹크롤링 통계 > 통계 리스트 [표1]")
    public List<CrawlingStatisticsListGetDto> getCrawlingStatisticsList(@RequestBody CrawlingStatisticsListSetDto crawlingStatisticsListSetDto){
        return crawlingResultService.getCrawlingStatisticsList(crawlingStatisticsListSetDto);
    }

    @ResponseBody
    @PostMapping("/getCrawlingStatisticsList_subList")
    @ApiOperation(value = "웹크롤링 통계 > 통계 리스트 [표1] > 서브 리스트")
    public List<CrawlingStatisticsListGetDto_subList> getCrawlingStatisticsList_subList(@RequestBody CrawlingStatisticsListSetDto_subList crawlingStatisticsListSetDto){
        return crawlingResultService.getCrawlingStatisticsList_subList(crawlingStatisticsListSetDto);
    }


    @ResponseBody
    @PostMapping("/getCrawlingStatisticsDetailList")
    @ApiOperation(value = "웹크롤링 통계 >  분야별 품목 조회 [표2]")
    public List<CrawlingStatisticsDetailListGetDto> getCrawlingStatisticsDetailList(@RequestBody CrawlingStatisticsDetailListSetDto crawlingStatisticsDetailListSetDto){
        return crawlingResultService.getCrawlingStatisticsDetailList(crawlingStatisticsDetailListSetDto);
    }

    @ResponseBody
    @PostMapping("/getCrawlingResultItemList")
    @ApiOperation(value = "웹크롤링 통계 > 분야별 품목 조회 [표2]> 품목상세 [팝업]")
    public List<CrawlingResultItemListGetDto> getCrawlingResultItemList(@RequestBody CrawlingResultItemListSetDto crawlingResultItemListSetDto){
        return crawlingResultService.getCrawlingResultItemList(crawlingResultItemListSetDto);
    }

    @ResponseBody
    @PostMapping("/getCrawlingResultLinkedList")
    @ApiOperation(value = "웹크롤링 통계 > 수정기업연계표")
    public DataTable getCrawlingResultLinkedList(@RequestBody CrawlingLinkedListSetDto crawlingLinkedListSetDto){
        return crawlingResultService.getCrawlingResultLinkedList(crawlingLinkedListSetDto);
    }

    @CrossOrigin("*")
    @PostMapping("/getCrawlingResultLinkedListExcel")
    @ApiOperation(value = "웹크롤링 통계 > 수정기업연계표 엑셀 다운로드")
    public void getCrawlingResultLinkedListExcel(@RequestBody CrawlingLinkedListExcelSetDto crawlingLinkedListSetDto, HttpServletResponse response) throws IOException {
        crawlingResultService.getCrawlingResultLinkedListExcel(response, crawlingLinkedListSetDto);
    }





}
