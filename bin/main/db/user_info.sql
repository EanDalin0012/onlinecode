-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.


-- add user information(user_info) in e-commerce table
CREATE TABLE `user_info` (
    `id` int,  NOT NULL ,
    `first_name` varchar(50),  NOT NULL ,
    `last_name` varchar(50),  NOT NULL ,
    `gender` varchar(10),  NOT NULL ,
    `date_birth` varchar(8),  NOT NULL ,
    `email` varchar(50),  NOT NULL ,
    `contact` varchar(50),  NOT NULL ,
    `kh_id` varchar(100),  NOT NULL ,
    `resource_img` int,  NOT NULL ,
    `status` varchar(10),  NOT NULL ,
    `create_date` varchar(8),  NOT NULL ,
    `create_by` int,  NOT NULL ,
    `modify_date` varchar(8),  NOT NULL ,
    `modify_by` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

