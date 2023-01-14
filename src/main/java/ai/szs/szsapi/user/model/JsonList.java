package ai.szs.szsapi.user.model;

import ai.szs.szsapi.db.domain.SalaryList;
import com.google.gson.JsonArray;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonList {


    public List<SalaryList> 급여;

    public String 산출세액;

    public List<Map> 소득공제;

    public String appVer;

    public String errMsg;

    public String company;

    public String svcCd;

    public String hostNm;

    public String workerResDt;

    public String workerReqDt;

}
