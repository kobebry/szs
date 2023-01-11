package ai.szs.szsapi.crawling.crawlingResult.service;

import ai.szs.szsapi.common.model.DataTable;
import ai.ndata.gvcapi.crawling.crawlingResult.model.*;
import ai.szs.szsapi.crawling.crawlingResult.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrawlingResultService {

    private final FileCompanyRepository fileCompanyRepository;

    private final CrawlingLinkedRepository crawlingLinkedRepository;

    private final CrawlingStatisticsRepository crawlingStatisticsRepository;

    public List<CrawlingStatisticsGetDto> getCrawlingStatistics(CrawlingStatisticsSetDto crawlingStatisticsSetDto) {

        log.info("[getCrawlingStatistics] : {}", crawlingStatisticsSetDto);

        List<CrawlingStatisticsGetDto> responseList = null;
        //GVCCD
        if(crawlingStatisticsSetDto.getTargetType().equals("G")){
            if(crawlingStatisticsSetDto.getOverlapCompany().equals("Y")){
                responseList = crawlingStatisticsRepository.getStatisticsG_OverlapCompany(crawlingStatisticsSetDto.getPIdx());
            }else{
                responseList = crawlingStatisticsRepository.getStatisticsG(crawlingStatisticsSetDto.getPIdx());
            }

        }else{//정책
            responseList = crawlingStatisticsRepository.getStatisticsM(crawlingStatisticsSetDto.getPIdx());
        }

        //[산업] 별로 조회
        if(crawlingStatisticsSetDto.getSch_industryList().size() > 0){

            for(String industry : crawlingStatisticsSetDto.getSch_industryList()){
                responseList = responseList.stream()
                        .filter(dto -> dto.getIndustryCode().equals(industry))
                        .collect(Collectors.toList());
            }

        //[분야] 별로 조회
        }else if(crawlingStatisticsSetDto.getSch_fieldList().size() > 0){
            for(String field : crawlingStatisticsSetDto.getSch_fieldList()){
                responseList = responseList.stream()
                        .filter(dto -> dto.getFieldCode().equals(field))
                        .collect(Collectors.toList());
            }
        }

        return responseList;
    }

    public List<CrawlingStatisticsListGetDto> getCrawlingStatisticsList(CrawlingStatisticsListSetDto crawlingStatisticsListSetDto) {

        List<CrawlingStatisticsListGetDto> responseList = null;

        if(crawlingStatisticsListSetDto.getOverlapCompany().equals("Y")){
            if(crawlingStatisticsListSetDto.getSch_industryList().size() > 0){
                responseList = crawlingStatisticsRepository.getCrawlingStatisticsList_overlapCompany_industry(crawlingStatisticsListSetDto.getPIdx(), crawlingStatisticsListSetDto.getSch_industryList());
            }else{
                responseList = crawlingStatisticsRepository.getCrawlingStatisticsList_overlapCompany(crawlingStatisticsListSetDto.getPIdx());
            }
        }else{
            responseList =  crawlingStatisticsRepository.getCrawlingStatisticsList(crawlingStatisticsListSetDto.getPIdx());
        }

        return responseList;
    }

    public List<CrawlingStatisticsListGetDto_subList> getCrawlingStatisticsList_subList(CrawlingStatisticsListSetDto_subList crawlingStatisticsListSetDto) {
        if(crawlingStatisticsListSetDto.getOverlapCompany().equals("Y")){
            return crawlingStatisticsRepository.getCrawlingStatisticsList_subList_overlapCompany(crawlingStatisticsListSetDto.getPIdx(), crawlingStatisticsListSetDto.getField());
        }else {
            return crawlingStatisticsRepository.getCrawlingStatisticsList_subList(crawlingStatisticsListSetDto.getPIdx(), crawlingStatisticsListSetDto.getField());
        }

    }

    public List<CrawlingStatisticsDetailListGetDto> getCrawlingStatisticsDetailList(CrawlingStatisticsDetailListSetDto crawlingStatisticsDetailListSetDto) {

        if(crawlingStatisticsDetailListSetDto.getTargetType().equals("G")){
            return crawlingStatisticsRepository.getCrawlingStatisticsDetailList(crawlingStatisticsDetailListSetDto.getPIdx(), crawlingStatisticsDetailListSetDto.getIndustry());
        }else{
            return crawlingStatisticsRepository.getCrawlingStatisticsDetailListM(crawlingStatisticsDetailListSetDto.getPIdx(), crawlingStatisticsDetailListSetDto.getField());
        }
    }

    public List<CrawlingResultItemListGetDto> getCrawlingResultItemList(CrawlingResultItemListSetDto crawlingResultItemListSetDto){
        return crawlingStatisticsRepository.getCrawlingResultItemListItemName(crawlingResultItemListSetDto.getPIdx(), crawlingResultItemListSetDto.getGvccd());
    }

    public DataTable getCrawlingResultLinkedList(CrawlingLinkedListSetDto crawlingLinkedListSetDto){
        log.info("[getCrawlingResultLinkedList] : {}", crawlingLinkedListSetDto);

        int page = crawlingLinkedListSetDto.getStart() / crawlingLinkedListSetDto.getLength(); //Calculate page number
        PageRequest pageRequest = PageRequest.of(page,crawlingLinkedListSetDto.getLength());

        Page<CrawlingLinkedListGetDto> crawlingLinkedList = null;

        //전체 조회
        if(StringUtils.isEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getProductType())){
            crawlingLinkedList = crawlingLinkedRepository.getList(crawlingLinkedListSetDto.getPIdx(), pageRequest);
        }else {
            /* 분야 조회 */
            if (StringUtils.isNotEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getProductType())) {
                crawlingLinkedList = crawlingLinkedRepository.getListField(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(), pageRequest);
            }
            /* 분야,산업 조회 */
            if (StringUtils.isNotEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getProductType())) {
                crawlingLinkedList = crawlingLinkedRepository.getListFieldAndIndustry(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(),crawlingLinkedListSetDto.getIndustry(), pageRequest);
            }

            /* 분야,생산여부 조회 */
            if (StringUtils.isNotEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getProductType())) {
                if(crawlingLinkedListSetDto.getProductType().equals("생산기업")){//생산기업
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndProductType(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(),crawlingLinkedListSetDto.getProductType(), pageRequest);
                }else if(crawlingLinkedListSetDto.getProductType().equals("비생산기업")){//비생산 기업
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndProductTypeNull(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(), pageRequest);
                }else{
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndProductTypeUndefined(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(), pageRequest);
                }
            }

            /* 분야,산업,생산여부 조회 */
            if (StringUtils.isNotEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getProductType())) {
                if(crawlingLinkedListSetDto.getProductType().equals("생산기업")){//생산기업
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndIndustryAndProductType(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(),crawlingLinkedListSetDto.getIndustry(), crawlingLinkedListSetDto.getProductType(),pageRequest);
                }else if(crawlingLinkedListSetDto.getProductType().equals("비생산기업")){//비생산 기업
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndIndustryAndProductTypeNull(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(),crawlingLinkedListSetDto.getIndustry(), pageRequest);
                }else{
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndIndustryAndProductTypeUndefined(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(),crawlingLinkedListSetDto.getIndustry(), pageRequest);

                }
            }

            /* 산업 여부 조회 */
            if (StringUtils.isEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getProductType())) {
                crawlingLinkedList = crawlingLinkedRepository.getListIndustry(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getIndustry(), pageRequest);
            }

            /* 산업,생산여부 조회 */
            if (StringUtils.isEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getProductType())) {
                if(crawlingLinkedListSetDto.getProductType().equals("생산기업")){//생산기업
                    crawlingLinkedList = crawlingLinkedRepository.getListIndustryAndProductType(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getIndustry(),crawlingLinkedListSetDto.getProductType(), pageRequest);
                }else if(crawlingLinkedListSetDto.getProductType().equals("비생산기업")){//비생산 기업
                    crawlingLinkedList = crawlingLinkedRepository.getListIndustryAndProductTypeNull(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getIndustry(), pageRequest);
                }else{
                    crawlingLinkedList = crawlingLinkedRepository.getListIndustryAndProductTypeUndefined(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getIndustry(), pageRequest);
                }
            }

            /* 생산여부 조회 */
            if (StringUtils.isEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getProductType())) {
                if(crawlingLinkedListSetDto.getProductType().equals("생산기업")){//생산기업
                    crawlingLinkedList = crawlingLinkedRepository.getListProductType(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getProductType(), pageRequest);
                }else if(crawlingLinkedListSetDto.getProductType().equals("비생산기업")){//비생산 기업
                    crawlingLinkedList = crawlingLinkedRepository.getListProductTypeNull(crawlingLinkedListSetDto.getPIdx(), pageRequest);
                }else{
                    crawlingLinkedList = crawlingLinkedRepository.getListProductTypeUndefined(crawlingLinkedListSetDto.getPIdx(), pageRequest);
                }
            }

        }
        return DataTable.builder()
                .data(Collections.singletonList(crawlingLinkedList.getContent()))
                .recordsTotal(crawlingLinkedList.getTotalElements())
                .recordsFiltered(crawlingLinkedList.getTotalElements())
                .draw(crawlingLinkedListSetDto.getDraw())
                .start(crawlingLinkedListSetDto.getStart())
                .build();
    }

    public void getCrawlingResultLinkedListExcel(HttpServletResponse response, CrawlingLinkedListExcelSetDto crawlingLinkedListSetDto) throws IOException {

        log.info("[getCrawlingResultLinkedListExcel] : {} ", crawlingLinkedListSetDto);
        OutputStream outputStream = response.getOutputStream();


        List<CrawlingLinkedListGetDto> crawlingLinkedList = null;

        //전체 조회
        if(StringUtils.isEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getProductType())){
            crawlingLinkedList = crawlingLinkedRepository.getList(crawlingLinkedListSetDto.getPIdx());
        }else {
            /* 분야 조회 */
            if (StringUtils.isNotEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getProductType())) {
                crawlingLinkedList = crawlingLinkedRepository.getListField(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField());
            }
            /* 분야,산업 조회 */
            if (StringUtils.isNotEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getProductType())) {
                crawlingLinkedList = crawlingLinkedRepository.getListFieldAndIndustry(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(),crawlingLinkedListSetDto.getIndustry());
            }

            /* 분야,생산여부 조회 */
            if (StringUtils.isNotEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getProductType())) {
                if(crawlingLinkedListSetDto.getProductType().equals("생산기업")){//생산기업
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndProductType(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(),crawlingLinkedListSetDto.getProductType());
                }else if(crawlingLinkedListSetDto.getProductType().equals("비생산기업")){//비생산 기업
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndProductTypeNull(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField());
                }else{//미확인
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndProductTypeUndefined(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField());
                }
            }

            /* 분야,산업,생산여부 조회 */
            if (StringUtils.isNotEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getProductType())) {
                if(crawlingLinkedListSetDto.getProductType().equals("생산기업")){//생산기업
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndIndustryAndProductType(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(),crawlingLinkedListSetDto.getIndustry(), crawlingLinkedListSetDto.getProductType());
                }else if(crawlingLinkedListSetDto.getProductType().equals("비생산기업")){//비생산 기업
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndIndustryAndProductTypeNull(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(),crawlingLinkedListSetDto.getIndustry());
                }else{//미확인
                    crawlingLinkedList = crawlingLinkedRepository.getListFieldAndIndustryAndProductTypeUndefined(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getField(),crawlingLinkedListSetDto.getIndustry());
                }
            }

            /* 산업 여부 조회 */
            if (StringUtils.isEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getProductType())) {
                crawlingLinkedList = crawlingLinkedRepository.getListIndustry(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getIndustry());
            }

            /* 산업,생산여부 조회 */
            if (StringUtils.isEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getProductType())) {
                if(crawlingLinkedListSetDto.getProductType().equals("생산기업")){//생산기업
                    crawlingLinkedList = crawlingLinkedRepository.getListIndustryAndProductType(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getIndustry(),crawlingLinkedListSetDto.getProductType());
                }else if(crawlingLinkedListSetDto.getProductType().equals("비생산기업")){//비생산 기업
                    crawlingLinkedList = crawlingLinkedRepository.getListIndustryAndProductTypeNull(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getIndustry());
                }else {//미확인
                    crawlingLinkedList = crawlingLinkedRepository.getListIndustryAndProductTypeUndefined(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getIndustry());
                }
            }

            /* 생산여부 조회 */
            if (StringUtils.isEmpty(crawlingLinkedListSetDto.getField()) && StringUtils.isEmpty(crawlingLinkedListSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingLinkedListSetDto.getProductType())) {
                if(crawlingLinkedListSetDto.getProductType().equals("생산기업")){//생산기업
                    crawlingLinkedList = crawlingLinkedRepository.getListProductType(crawlingLinkedListSetDto.getPIdx(), crawlingLinkedListSetDto.getProductType());
                }else if(crawlingLinkedListSetDto.getProductType().equals("비생산기업")){//비생산 기업
                    crawlingLinkedList = crawlingLinkedRepository.getListProductTypeNull(crawlingLinkedListSetDto.getPIdx());
                }else {//미확인
                    crawlingLinkedList = crawlingLinkedRepository.getListProductTypeUndefined(crawlingLinkedListSetDto.getPIdx());
                }
            }

        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet1");

        Row row = null;
        Cell cell = null;
        int rowNo = 0;

        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD); //볼드 (굵게)

        CellStyle headStyle = workbook.createCellStyle();
        headStyle.setFont(font);

        // Header
        row = sheet.createRow(rowNo++);
        cell = row.createCell(0);
        cell.setCellValue("no");
        cell = row.createCell(1);
        cell.setCellValue("분야");
        cell = row.createCell(2);
        cell.setCellValue("산업");
        cell = row.createCell(3);
        cell.setCellValue("품목명");
        cell = row.createCell(4);
        cell.setCellValue("총 검색어 수");
        cell = row.createCell(5);
        cell.setCellValue("제조사");
        cell = row.createCell(6);
        cell.setCellValue("매칭 검색어 수");
        cell = row.createCell(7);
        cell.setCellValue("RPA 결과");
        cell = row.createCell(8);
        cell.setCellValue("홈페이지");
        cell = row.createCell(9);
        cell.setCellValue("매칭검색어");
        cell = row.createCell(10);
        cell.setCellValue("판단근거");

        int rowNum = 1;
        for(CrawlingLinkedListGetDto dto : crawlingLinkedList){
            row = sheet.createRow(rowNo++);
            cell = row.createCell(0);
            cell.setCellValue(rowNum++);
            cell = row.createCell(1);
            cell.setCellValue(dto.getField());
            cell = row.createCell(2);
            cell.setCellValue(dto.getIndustry());
            cell = row.createCell(3);
            cell.setCellValue(dto.getItemName());
            cell = row.createCell(4);
            cell.setCellValue(dto.getKwdCount());
            cell = row.createCell(5);
            cell.setCellValue(dto.getCompanyName());
            cell = row.createCell(6);
            cell.setCellValue(dto.getMatchCount());
            cell = row.createCell(7);
            cell.setCellValue(dto.getProductType());
            cell = row.createCell(8);
            cell.setCellValue(dto.getCompanyUrl());
            cell = row.createCell(9);
            cell.setCellValue(dto.getMatchKeyword());
            cell = row.createCell(10);
            cell.setCellValue(dto.getMatchUrl());
        }

        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=GVC.xlsx");

        workbook.write(outputStream);
        response.getOutputStream().close();



    }
}


