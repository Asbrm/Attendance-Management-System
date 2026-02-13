CREATE DATABASE attendance_db;
USE attendance_db;
-- Öğrenci Ekleme
DELIMITER $$
CREATE PROCEDURE AddStudent(IN studentName VARCHAR(100))
BEGIN
    INSERT INTO students(name) VALUES (studentName);
END $$

-- Yoklama Ekleme
CREATE PROCEDURE AddAttendance(IN studentId INT, IN courseId INT, IN attDate DATE)
BEGIN
    INSERT INTO attendance(student_id, course_id, attendance_date)
    VALUES (studentId, courseId, attDate);
END $$

-- Yoklama Sayısı
CREATE FUNCTION GetAttendanceCount(attDate DATE)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE count INT;
    SELECT COUNT(*) INTO count FROM attendance WHERE attendance_date = attDate;
    RETURN count;
END $$

DELIMITER ;


