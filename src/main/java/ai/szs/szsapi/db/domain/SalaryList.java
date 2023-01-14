package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public interface SalaryList {

    String get소득내역();
    String get총지급액();
    String get업무시작일();
    String get기업명();
    String get이름();
    String get지급일();
    String get업무종료일();
    String get주민등록번호();
    String get소득구분();
    String get사업자등록번호();
}
