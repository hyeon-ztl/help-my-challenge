DROP DATABASE IF EXISTS `SSAFIT`;
CREATE DATABASE `SSAFIT`;
USE `SSAFIT`;

-- 메인 기본 서비스 스키마

DROP TABLE IF EXISTS `body_part`;
CREATE TABLE `body_part`(
	`part_code` INT PRIMARY KEY,
    `part_name` VARCHAR(20) NOT NULL UNIQUE
);

-- body 데이터
INSERT INTO `body_part` (part_code, part_name)
VALUES (100, '전신'),
	   (200, '상체'),
       (201, '등'),
       (202, '어깨'),
       (203, '가슴'),
       (204, '팔'),
       (205, '복부'),
       (300, '하체'),
       (301, '엉덩이'),
       (302, '허벅지'),
       (303, '종아리'),
       (400, '기타');

DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
    `video_id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL, 
    `youtube_url` TEXT NOT NULL,
    `channel_name` VARCHAR(100) NOT NULL,
	`view_cnt` INT DEFAULT 0, 
    `part_code` INT NOT NULL,
    
    FOREIGN KEY (`part_code`) REFERENCES `body_part` (`part_code`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
    `review_id` INT PRIMARY KEY AUTO_INCREMENT,
    `email` VARCHAR(50) NOT NULL, -- 카카오 API에 맞게 수정
    `video_id` VARCHAR(50) NOT NULL,        
    `content` TEXT NOT NULL
);

commit;

SELECT * FROM video;
SELECT * FROM review;