INSERT INTO member_available (name,regNo) VALUES ('홍길동','860824-1655068');
INSERT INTO member_available (name,regNo) VALUES ('김둘리','921108-1582816');
INSERT INTO member_available (name,regNo) VALUES ('마징가','880601-2455116');
INSERT INTO member_available (name,regNo) VALUES ('베지터','910411-1656116');
INSERT INTO member_available (name,regNo) VALUES ('손오공','820326-2715702');

INSERT INTO member (userId,password,name,regNo) VALUES ('hong12','123456','홍길동','860824-1655068');

INSERT INTO salary (userId,소득내역,총지급액,업무시작일,기업명,이름,지급일,업무종료일,주민등록번호,소득구분,사업자등록번호,year) VALUES ('hong12','급여','30,000,000','2020,10,02','(주)할빈당','홍길동','2020.11.02','2021.11.02','860824-1655068','근로소득(연간)','012-34-56789','2023');
INSERT INTO salary (userId,소득내역,총지급액,업무시작일,기업명,이름,지급일,업무종료일,주민등록번호,소득구분,사업자등록번호,year) VALUES ('kim12','급여','35,000,000','2020,01,02','(주)할빈당','베지터','2020.05.02','2021.05.02','921108-1582816','근로소득(연간)','012-34-56789','2023');
INSERT INTO salary (userId,소득내역,총지급액,업무시작일,기업명,이름,지급일,업무종료일,주민등록번호,소득구분,사업자등록번호,year) VALUES ('ma12','급여','55,000,000','2020,01,02','(주)할빈당','베지터','2021.09.02','2022.09.02','880601-2455116','근로소득(연간)','012-34-56789','2023');

INSERT INTO TaxAmount (userId,산출세액) VALUES ('hong12','600,000');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('hong12','100,000','보험료');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('hong12','200,000','교육비');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('hong12','150,000','기부금');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('hong12','700,000','의료비');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('hong12','500,000','퇴직연금');

INSERT INTO TaxAmount (userId,산출세액) VALUES ('kim12','700,000');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('kim12','150,000','보험료');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('kim12','220,000','교육비');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('kim12','200,000','기부금');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('kim12','600,000','의료비');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('kim12','500,000','퇴직연금');

INSERT INTO TaxAmount (userId,산출세액) VALUES ('ma12','900,000');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('ma12','350,000','보험료');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('ma12','500,000','교육비');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('ma12','50,000','기부금');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('ma12','300,000','의료비');
INSERT INTO TaxCredit (userId,금액,소득구분) VALUES ('ma12','900,000','퇴직연금');
