-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/MTT7P8
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.


CREATE TABLE `main_category` (
    `id` int  NOT NULL ,
    `name` varchar(225)  NOT NULL ,
    `status` varchar(225)  NOT NULL ,
    `create_by` int  NOT NULL ,
    `create_date` varchar(8)  NOT NULL ,
    `modify_by` int  NOT NULL ,
    `modify_date` varchar(8)  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `category` (
    `int` int  NOT NULL ,
    `main_category_id` int  NOT NULL ,
    `name` varchar(225)  NOT NULL ,
    `description` varchar(225)  NOT NULL ,
    `create_date` varchar(8)  NOT NULL ,
    `create_by` int  NOT NULL ,
    `modify_date` varchar(8)  NOT NULL ,
    `modify_by` int  NOT NULL ,
    PRIMARY KEY (
        `int`
    )
);

CREATE TABLE `link_product_to_details` (
    `id` int  NOT NULL ,
    `product_id` int  NOT NULL ,
    `resource_id` int  NOT NULL ,
    `product_details_id` int  NOT NULL ,
    `create_date` varchar(8)  NOT NULL ,
    `create_by` int  NOT NULL ,
    `modify_date` varchar(8)  NOT NULL ,
    `modify_by` int  NOT NULL 
);

CREATE TABLE `resource_img` (
    `id` int  NOT NULL ,
    `product_id` int  NOT NULL ,
    `url` varchar(225)  NOT NULL ,
    `status` varchar(8)  NOT NULL ,
    `create_date` varchar(8)  NOT NULL ,
    `create_by` int  NOT NULL ,
    `modify_date` varchar(8)  NOT NULL ,
    `modify_by` int  NOT NULL 
);

CREATE TABLE `product` (
    `id` int  NOT NULL ,
    `category_id` int  NOT NULL ,
    `name` varchar(225)  NOT NULL ,
    `status` varchar(10)  NOT NULL ,
    `create_date` varchar(8)  NOT NULL ,
    `create_by` int  NOT NULL ,
    `modify_date` varchar(8)  NOT NULL ,
    `modify_by` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `product_detials` (
    `id` int  NOT NULL ,
    `product_id` int  NOT NULL ,
    `context_en` text  NOT NULL ,
    `context_kh` text  NOT NULL ,
    `context_ch` text  NOT NULL ,
    `status` varchar(225)  NOT NULL ,
    `create_date` varchar(8)  NOT NULL ,
    `create_by` int  NOT NULL ,
    `modify_date` varchar(8)  NOT NULL ,
    `modify_by` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `import_product` (
    `id` int  NOT NULL ,
    `product_id` int  NOT NULL ,
    `vendor_id` int  NOT NULL ,
    `qty` int  NOT NULL ,
    `unit_price` int  NOT NULL ,
    `discount` int  NOT NULL ,
    `currency_code` string  NOT NULL ,
    `status` varchar(8)  NOT NULL ,
    `create_date` varchar(8)  NOT NULL ,
    `create_by` int  NOT NULL ,
    `modify_date` varchar(8)  NOT NULL ,
    `modify_by` int  NOT NULL 
);

CREATE TABLE `vendor` (
    `id` int  NOT NULL ,
    `name` varchar(225)  NOT NULL ,
    `address_id` int  NOT NULL ,
    `contact` varchar(225)  NOT NULL ,
    `email` varchar(225)  NOT NULL ,
    `status` varchar(8)  NOT NULL ,
    `create_date` varchar(8)  NOT NULL ,
    `create_by` int  NOT NULL ,
    `modify_date` varchar(8)  NOT NULL ,
    `modify_by` int  NOT NULL 
);

CREATE TABLE `address` (
    `id` int  NOT NULL ,
    `address_line` varchar(225)  NOT NULL ,
    `address_line1` varchar(225)  NOT NULL ,
    `city` varchar(225)  NOT NULL ,
    `state` varchar(10)  NOT NULL ,
    `postal_code` varchar(10)  NOT NULL ,
    `status` varchar(225)  NOT NULL ,
    `create_dete` varchar(8)  NOT NULL ,
    `create_by` int  NOT NULL ,
    `modify_date` varchar(8)  NOT NULL ,
    `modify_by` int  NOT NULL 
);

ALTER TABLE `main_category` ADD CONSTRAINT `fk_main_category_id` FOREIGN KEY(`id`)
REFERENCES `category` (`main_category_id`);

ALTER TABLE `category` ADD CONSTRAINT `fk_category_int` FOREIGN KEY(`int`)
REFERENCES `product` (`category_id`);

ALTER TABLE `link_product_to_details` ADD CONSTRAINT `fk_link_product_to_details_product_id` FOREIGN KEY(`product_id`)
REFERENCES `product` (`id`);

ALTER TABLE `link_product_to_details` ADD CONSTRAINT `fk_link_product_to_details_resource_id` FOREIGN KEY(`resource_id`)
REFERENCES `resource_img` (`id`);

ALTER TABLE `resource_img` ADD CONSTRAINT `fk_resource_img_product_id` FOREIGN KEY(`product_id`)
REFERENCES `product` (`category_id`);

ALTER TABLE `product` ADD CONSTRAINT `fk_product_id` FOREIGN KEY(`id`)
REFERENCES `import_product` (`product_id`);

ALTER TABLE `product_detials` ADD CONSTRAINT `fk_product_detials_id` FOREIGN KEY(`id`)
REFERENCES `link_product_to_details` (`product_details_id`);

ALTER TABLE `vendor` ADD CONSTRAINT `fk_vendor_id` FOREIGN KEY(`id`)
REFERENCES `import_product` (`vendor_id`);

ALTER TABLE `address` ADD CONSTRAINT `fk_address_id` FOREIGN KEY(`id`)
REFERENCES `vendor` (`address_id`);

