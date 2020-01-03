#2020-1-3 16:52:00
ALTER TABLE `project`
ADD COLUMN `project_labels`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci 
NULL COMMENT '项目标签' AFTER `project_content`;