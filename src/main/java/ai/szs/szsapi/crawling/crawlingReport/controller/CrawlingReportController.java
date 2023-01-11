package ai.szs.szsapi.crawling.crawlingReport.controller;

import ai.szs.szsapi.common.model.DataTable;
import ai.szs.szsapi.crawling.crawlingReport.model.CrawlingReportSetDto;
import ai.szs.szsapi.crawling.crawlingReport.service.CrawlingReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/crawling")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "GVC - 웹크롤링 보고서")
public class CrawlingReportController {

    private final CrawlingReportService crawlingReportService;

    @ResponseBody
    @PostMapping("/getCrawlingReportList")
    @ApiOperation(value = "웹크롤링 보고서 조회")
    public DataTable getCrawlingReportList(@RequestBody CrawlingReportSetDto crawlingReportSetDto){
        return crawlingReportService.getCrawlingReportList(crawlingReportSetDto);
    }
    
}
