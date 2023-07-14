
--CREATE DATABASE db_mu_schema;
--SHOW DATABASES;
--SELECT user(), now(), DATABASE();
--use db_mu_schema;

CREATE TABLE tbl_student
(
    studentID int(9) NOT NULL PRIMARY KEY,
    student_name varchar(10) NOT NULL
);
CREATE TABLE tbl_Department
(
    departmentName varchar(10) NOT NULL PRIMARY KEY,
    facultyId int(9) NOT NULL
);
CREATE TABLE tbl_programme
(
    programmeCode varchar(10) NOT NULL ,
    departmentName varchar(10) NOT NULL,
    pr_Name varchar(10) NOT NULL,
    PRIMARY KEY (programmeCode)
);
CREATE TABLE tbl_batch
(
    batchNO varchar(10) NOT NULL,
    programmeCode varchar(10) NOT NULL, 
    PRIMARY KEY (BatchNO)
);
CREATE TABLE tbl_section
(
    sectionNo varchar(10) NOT NULL,
    batchNO varchar(10) NOT NULL,
    PRIMARY KEY (sectionNo)
);
CREATE TABLE tbl_admission
(
    addmissionID int(9) NOT NULL,
    sectionNo varchar(10) NOT NULL,
    studentID int(9) NOT NULL,
    PRIMARY KEY (addmissionID)
);
CREATE TABLE tbl_Academic
(
    addmissionID int(9) NOT NULL,
    programmeCode varchar(10) NOT NULL
);
CREATE TABLE tbl_library
(
    libraryCardNo int(9) NOT NULL,
    studentID int(9) NOT NULL,
    PRIMARY KEY (libraryCardNo)
);
CREATE TABLE tbl_faculty
(
    facultyId int(9) NOT NULL,
    departmentName varchar(10) NOT NULL,
    fclt_Name varchar(10) NOT NULL,
    PRIMARY KEY (facultyId)
);
CREATE TABLE tbl_classShedule
(  
    classRoomNO int(100) NOT NULL,
    cls_Time TIME NOT NULL,
    cls_Date DATE NOT NULL,
    departmentName varchar(10) NOT NULL,
    PRIMARY KEY (classRoomNO)
);
CREATE TABLE tbl_course
(
    courseCode varchar(10) NOT NULL,
    crs_title varchar(10) NOT NULL,
    programmeCode varchar(10) NOT NULL,
    PRIMARY KEY (courseCode)
);
CREATE TABLE tbl_offeredCourse
(
    offeredCourseId varchar(10) NOT NULL,
    courseCode varchar(10) NOT NULL,
    facultyId int(9) NOT NULL,
    sectionNo varchar(10) NOT NULL,
    PRIMARY KEY (offeredCourseId)
);
CREATE TABLE Tbl_courseReg 
(
    courseSemester varchar(10) NOT NULL,
    offeredCourseId varchar(10) NOT NULL,
    PRIMARY KEY (courseSemester)
);
CREATE TABLE tbl_exam
(
    examName varchar(10) NOT NULL,
    exm_time TIME NOT NULL,
    exm_Date DATE NOT NULL,
    exm_roomNO int(100) NOT NULL,
    examSession YEAR NOT NULL,
    examType varchar(10) NOT NULL,
    PRIMARY KEY (examName)
);
CREATE TABLE tbl_examResult
(
    examName varchar(10) NOT NULL,
    courseSemester varchar(10) NOT NULL
);
CREATE TABLE tbl_StudentDeposite
(
    examName varchar(10) NOT NULL,
    studentId int(9) NOT NULL,
    accountantType varchar(10) NOT NULL,
    dep_amount INT(10) NOT NULL
);
CREATE TABLE tbl_Accounting
(
    accountantType varchar(10) NOT NULL,
    PRIMARY KEY (accountantType)
);
CREATE TABLE tbl_Employee
(
    employeeId bigint(10) NOT NULL,
    emp_name varchar(10) NOT NULL,
    emp_type varchar(10) NOT NULL,
    accountantType varchar(10) NOT NULL,
    PRIMARY KEY (employeeId)
);
CREATE TABLE tbl_Budget
(
    BudgetNo int(10) NOT NULL,
    bgt_session YEAR NOT NULL,
    bgt_time TIMESTAMP NOT NULL,
    PRIMARY KEY (BudgetNo)
);
CREATE TABLE tbl_FinancialReport
(
    FinancialReportNO int(10) NOT NULL,
    Fr_type varchar(10) NOT NULL,
    Fr_expence float(10,2) NOT NULL,
    PRIMARY KEY (FinancialReportNO)
);
CREATE TABLE tbl_ApplyAccountant
(
    accountantType varchar(10) NOT NULL,
    BudgetNo int(10) NOT NULL,
    FinancialReportNO int(10) NOT NULL
);
--REFERENTIAL INTEGRITY CONSTRAINTS---------------

ALTER TABLE tbl_faculty
ADD constraint `FK_tbl_faculty_CREATE TABLE tbl_Department`
FOREIGN KEY (departmentName) REFERENCES tbl_Department(departmentName)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_programme
ADD constraint `FK_tbl_programme_tbl_Department`
FOREIGN KEY (departmentName) REFERENCES tbl_Department(departmentName)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_batch
ADD constraint `FK_tbl_batch_tbl_programme`
FOREIGN KEY (programmeCode) REFERENCES tbl_programme(programmeCode)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_section
ADD constraint `FK_tbl_section_tbl_batch`
FOREIGN KEY (BatchNO) REFERENCES tbl_batch(BatchNO)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_admission
ADD constraint `FK_tbl_admission_tbl_student`
FOREIGN KEY (studentID) REFERENCES tbl_student(studentID)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_admission
ADD constraint `FK_tbl_admission_tbl_section`
FOREIGN KEY (sectionNo) REFERENCES tbl_section(sectionNo)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_Academic
ADD constraint `FK_tbl_Academic_tbl_addmission`
FOREIGN KEY (addmissionID) REFERENCES tbl_admission(addmissionID)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_Academic
ADD constraint `FK_tbl_Academic_tbl_programme`
FOREIGN KEY (programmeCode) REFERENCES tbl_programme(programmeCode)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_library
ADD constraint `FK_tbl_library_tbl_student`
FOREIGN KEY (studentID) REFERENCES tbl_student(studentID)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_classShedule
ADD constraint `FK_tbl_classShedule_tbl_Department`
FOREIGN KEY (departmentName) REFERENCES tbl_Department(departmentName)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_course
ADD constraint `FK_tbl_course_tbl_programme`
FOREIGN KEY (programmeCode) REFERENCES tbl_programme(programmeCode)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_offeredCourse
ADD constraint `FK_tbl_offeredCourse_tbl_course`
FOREIGN KEY (courseCode) REFERENCES tbl_course(courseCode)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_offeredCourse
ADD constraint `FK_tbl_offeredCourse_tbl_faculty`
FOREIGN KEY (facultyId) REFERENCES tbl_faculty(facultyId)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_offeredCourse
ADD constraint `FK_tbl_offeredCourse_tbl_section`
FOREIGN KEY (sectionNo) REFERENCES tbl_section(sectionNo)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE Tbl_courseReg
ADD constraint `FK_Tbl_courseReg_tbl_offeredCourse`
FOREIGN KEY (offeredCourseId) REFERENCES tbl_offeredCourse(offeredCourseId)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_examResult
ADD constraint `FK_tbl_examResult_Tbl_courseReg`
FOREIGN KEY (courseSemester) REFERENCES Tbl_courseReg(courseSemester)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_examResult
ADD constraint `FK_tbl_examResult_tbl_exam`
FOREIGN KEY (examName) REFERENCES tbl_exam(examName)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_StudentDeposite
ADD constraint `FK_tbl_StudentDeposite_tbl_exam`
FOREIGN KEY (examName) REFERENCES tbl_exam(examName)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_StudentDeposite
ADD constraint `FK_tbl_StudentDeposite_tbl_Accounting`
FOREIGN KEY (accountantType) REFERENCES tbl_Accounting(accountantType)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_StudentDeposite
ADD constraint `FK_tbl_StudentDeposite_tbl_student`
FOREIGN KEY (studentId) REFERENCES tbl_student(studentId)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_Employee
ADD constraint `FK_tbl_Employee_tbl_Accounting`
FOREIGN KEY (accountantType) REFERENCES tbl_Accounting(accountantType)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_ApplyAccountant
ADD constraint `FK_tbl_ApplyAccountant_tbl_Budget`
FOREIGN KEY (BudgetNo) REFERENCES tbl_Budget(BudgetNo)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_ApplyAccountant
ADD constraint `FK_tbl_ApplyAccountant_tbl_FinancialReport`
FOREIGN KEY (FinancialReportNO) REFERENCES tbl_FinancialReport(FinancialReportNO)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE tbl_ApplyAccountant
ADD constraint `FK_tbl_ApplyAccountant_tbl_Accounting`
FOREIGN KEY (accountantType) REFERENCES tbl_Accounting(accountantType)
ON DELETE NO ACTION
ON UPDATE CASCADE;

--UNIQUE CONSTRAINT--------------------

ALTER TABLE tbl_programme
ADD CONSTRAINT constraint_name UNIQUE (pr_Name);

ALTER TABLE tbl_exam
ADD CONSTRAINT constraint_name UNIQUE (examSession, examType);

--ENUMERATION FIELD----------------

ALTER TABLE tbl_StudentDeposite
ADD column depositeType enum('monthly_fee','semester_fee', 'transport_fee') NOT NULL;


show tables;
describe tbl_student;
describe tbl_Department;
describe tbl_programme;
describe tbl_batch;
describe tbl_section;
describe tbl_admission;
describe tbl_Academic;
describe tbl_library;
describe tbl_faculty;
describe tbl_classShedule;
describe tbl_course;
describe tbl_offeredCourse;
describe Tbl_courseReg;
describe tbl_exam;
describe tbl_examResult;
describe tbl_StudentDeposite;
describe tbl_Accounting;
describe tbl_Employee;
describe tbl_Budget;
describe tbl_FinancialReport;
describe tbl_ApplyAccountant;

