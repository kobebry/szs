package ai.szs.szsapi.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum enumLink {


//    shareNotice("공유링크안내", "https://bati-s3.s3.ap-northeast-2.amazonaws.com/templates/common/shareNotice.xlsx")
    shareNotice("공유링크안내", "templates/common/shareNotice.xlsx"),

    componentTableBlue("바티블루", "templates/component/component_table_blue.ssjson")
//    TOSSPG("TOSSPG", "TOSSPG")
    ;

    private String sourceTitle;
    private String sourceLink;
}
