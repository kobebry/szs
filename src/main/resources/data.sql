INSERT INTO member_available (name,regNo) VALUES ('홍길동','860824-1655068');
INSERT INTO member_available (name,regNo) VALUES ('김둘리','921108-1582816');
INSERT INTO member_available (name,regNo) VALUES ('마징가','880601-2455116');
INSERT INTO member_available (name,regNo) VALUES ('베지터','910411-1656116');
INSERT INTO member_available (name,regNo) VALUES ('손오공','820326-2715702');

INSERT INTO salary (memberIdx,소득내역,총지급액,업무시작일,기업명,이름,지급일,업무종료일,주민등록번호,소득구분,사업자등록번호,year) VALUES (1,'급여','30,000,000','2020,10,02','(주)할빈당','홍길동','2020.11.02','2021.11.02','860824-1655068','근로소득(연간)','012-34-56789','2023');
INSERT INTO salary (memberIdx,소득내역,총지급액,업무시작일,기업명,이름,지급일,업무종료일,주민등록번호,소득구분,사업자등록번호,year) VALUES (2,'급여','35,000,000','2020,01,02','(주)할빈당','베지터','2020.05.02','2021.05.02','910411-1656116','근로소득(연간)','012-34-56789','2023');

INSERT INTO TaxAmount (memberIdx,산출세액) VALUES (1,'600,000');
INSERT INTO TaxCredit (memberIdx,금액,소득구분) VALUES (1,'100,000','보험료');
INSERT INTO TaxCredit (memberIdx,금액,소득구분) VALUES (1,'200,000','교육비');
INSERT INTO TaxCredit (memberIdx,금액,소득구분) VALUES (1,'150,000','기부금');
INSERT INTO TaxCredit (memberIdx,금액,소득구분) VALUES (1,'700,000','의료비');
INSERT INTO TaxCredit (memberIdx,금액,소득구분) VALUES (1,'500,000','퇴직연금');
