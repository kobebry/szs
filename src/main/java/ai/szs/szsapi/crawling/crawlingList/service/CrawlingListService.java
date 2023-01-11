package ai.szs.szsapi.crawling.crawlingList.service;



import ai.szs.szsapi.common.model.DataTable;
import ai.szs.szsapi.crawling.crawlingList.model.CrawlingKeywordListGetDto;
import ai.szs.szsapi.crawling.crawlingList.model.CrawlingKeywordListSetDto;
import ai.szs.szsapi.crawling.crawlingList.model.FileCompanyListSetDto;
import ai.szs.szsapi.db.domain.FileCompany;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrawlingListService {

    private final FileCompanyRepository fileCompanyRepository;

    private final KeywordRepository keywordRepository;


    public DataTable getFileCompanyList(FileCompanyListSetDto fileCompanyListSetDto) {

        int page = fileCompanyListSetDto.getStart() / fileCompanyListSetDto.getLength();
        PageRequest pageRequest = PageRequest.of(page,fileCompanyListSetDto.getLength());

        Page<FileCompany> responseList = fileCompanyRepository.findAllBypIdx(fileCompanyListSetDto.getPIdx(), pageRequest);

        return DataTable.builder()
                .data(Collections.singletonList(responseList))
                .recordsTotal(responseList.getTotalElements())
                .recordsFiltered(responseList.getTotalElements())
                .draw(fileCompanyListSetDto.getDraw())
                .start(fileCompanyListSetDto.getStart())
                .build();
    }

    public DataTable getKeywordList(CrawlingKeywordListSetDto keywordListSetDto) {
        log.info("[getKeywordList] : {}", keywordListSetDto);

        int page = keywordListSetDto.getStart() / keywordListSetDto.getLength();
        PageRequest pageRequest = PageRequest.of(page,keywordListSetDto.getLength());
        Page<CrawlingKeywordListGetDto> responseList =  keywordRepository.selectCrawlingKeywordList(keywordListSetDto.getPIdx(), pageRequest);

        return DataTable.builder()
                .data(Collections.singletonList(responseList))
                .recordsTotal(responseList.getTotalElements())
                .recordsFiltered(responseList.getTotalElements())
                .draw(keywordListSetDto.getDraw())
                .start(keywordListSetDto.getStart())
                .build();
    }
}


