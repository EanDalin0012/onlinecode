/*
 Navicat Premium Data Transfer

 Source Server         : e-commerce
 Source Server Type    : PostgreSQL
 Source Server Version : 120003
 Source Host           : localhost:5432
 Source Catalog        : online-code
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120003
 File Encoding         : 65001

 Date: 22/11/2020 16:53:49
*/


-- ----------------------------
-- Sequence structure for authority_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."authority_id_seq";
CREATE SEQUENCE "public"."authority_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for main_category_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."main_category_id_seq";
CREATE SEQUENCE "public"."main_category_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sequence_category
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sequence_category";
CREATE SEQUENCE "public"."sequence_category" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sequence_product
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sequence_product";
CREATE SEQUENCE "public"."sequence_product" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sequence_vendor
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sequence_vendor";
CREATE SEQUENCE "public"."sequence_vendor" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for serial_t
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."serial_t";
CREATE SEQUENCE "public"."serial_t" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 101
CACHE 1;

-- ----------------------------
-- Sequence structure for user__id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user__id_seq";
CREATE SEQUENCE "public"."user__id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for user_info_details_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_info_details_id_seq";
CREATE SEQUENCE "public"."user_info_details_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 32767
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for user_info_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_info_id_seq";
CREATE SEQUENCE "public"."user_info_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for user_lock_count_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_lock_count_id_seq";
CREATE SEQUENCE "public"."user_lock_count_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS "public"."address";
CREATE TABLE "public"."address" (
  "id" int4 NOT NULL,
  " street" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "sang_kat" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "khan" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "state" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "create_dete" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" int4 NOT NULL,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "modify_by" int4 NOT NULL
)
;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS "public"."authority";
CREATE TABLE "public"."authority" (
  "id" int8 NOT NULL DEFAULT nextval('authority_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO "public"."authority" VALUES (1, 'COMPANY_CREATE');
INSERT INTO "public"."authority" VALUES (2, 'COMPANY_READ');
INSERT INTO "public"."authority" VALUES (3, 'COMPANY_UPDATE');
INSERT INTO "public"."authority" VALUES (4, 'COMPANY_DELETE');
INSERT INTO "public"."authority" VALUES (5, 'DEPARTMENT_CREATE');
INSERT INTO "public"."authority" VALUES (6, 'DEPARTMENT_READ');
INSERT INTO "public"."authority" VALUES (7, 'DEPARTMENT_UPDATE');
INSERT INTO "public"."authority" VALUES (8, 'DEPARTMENT_DELETE');
INSERT INTO "public"."authority" VALUES (9, 'ROLE_COMPANY_READER');

-- ----------------------------
-- Table structure for card_identify
-- ----------------------------
DROP TABLE IF EXISTS "public"."card_identify";
CREATE TABLE "public"."card_identify" (
  "id" varchar COLLATE "pg_catalog"."default" NOT NULL,
  "card_id" varchar COLLATE "pg_catalog"."default",
  "card_img_front" varchar(255) COLLATE "pg_catalog"."default",
  "card_img_rear" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of card_identify
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS "public"."category";
CREATE TABLE "public"."category" (
  "id" int4 NOT NULL,
  "name" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default",
  "create_by" int4,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default",
  "modify_by" int4,
  "status" varchar(10) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO "public"."category" VALUES (5, 'Mouse', 'Mouse', '20200913', 2, '20200913', 1, '1');
INSERT INTO "public"."category" VALUES (1, 'Laptop', 'Laptop', '20200913', 2, '20200913', 1, '1');
INSERT INTO "public"."category" VALUES (6, 'Desktop', '', '20200913', 1, '20200913', 1, '3');
INSERT INTO "public"."category" VALUES (7, 'PC', '', '20200913', 1, '20200913', 1, '3');
INSERT INTO "public"."category" VALUES (9, 'Dalin ltd', '', '20200917', 1, NULL, NULL, '1');
INSERT INTO "public"."category" VALUES (10, 'a', '', '20200924', 1, NULL, NULL, '1');
INSERT INTO "public"."category" VALUES (30, 'dafa', '', '20201105', 1, NULL, NULL, '1');
INSERT INTO "public"."category" VALUES (31, 'Phone', 'Phone grade A+', '20201109', 1, NULL, NULL, '1');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer";
CREATE TABLE "public"."customer" (
  "id" int4 NOT NULL,
  "first_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "last_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "birth_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "contact" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" int4 NOT NULL,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "modify_by" int4 NOT NULL
)
;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for import_product
-- ----------------------------
DROP TABLE IF EXISTS "public"."import_product";
CREATE TABLE "public"."import_product" (
  "id" int4 NOT NULL,
  "product_id" int4 NOT NULL,
  "vendor_id" int4 NOT NULL,
  "qty" int4 NOT NULL,
  "unit_price" int4 NOT NULL,
  "discount" int4 NOT NULL,
  "currency_code" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" int4 NOT NULL,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "modify_by" int4 NOT NULL
)
;

-- ----------------------------
-- Records of import_product
-- ----------------------------

-- ----------------------------
-- Table structure for link_product_to_details
-- ----------------------------
DROP TABLE IF EXISTS "public"."link_product_to_details";
CREATE TABLE "public"."link_product_to_details" (
  "id" int4 NOT NULL,
  "product_id" int4 NOT NULL,
  "resource_id" int4 NOT NULL,
  "product_details_id" int4 NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" int4 NOT NULL,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "modify_by" int4 NOT NULL
)
;

-- ----------------------------
-- Records of link_product_to_details
-- ----------------------------

-- ----------------------------
-- Table structure for main_category
-- ----------------------------
DROP TABLE IF EXISTS "public"."main_category";
CREATE TABLE "public"."main_category" (
  "name" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" int4,
  "create_date" varchar(8) COLLATE "pg_catalog"."default",
  "modify_by" int4,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default",
  "description" varchar(225) COLLATE "pg_catalog"."default",
  "id" int4 NOT NULL DEFAULT nextval('main_category_id_seq'::regclass)
)
;

-- ----------------------------
-- Records of main_category
-- ----------------------------
INSERT INTO "public"."main_category" VALUES ('lettop', '1', 1, '20200817', NULL, NULL, 'description', 2);
INSERT INTO "public"."main_category" VALUES ('Phone', '1', 1, '20200818', NULL, NULL, NULL, 3);
INSERT INTO "public"."main_category" VALUES ('Key Board', '1', 1, '20200818', NULL, NULL, NULL, 4);
INSERT INTO "public"."main_category" VALUES ('Mouse', '1', 1, '20200818', NULL, NULL, NULL, 5);
INSERT INTO "public"."main_category" VALUES ('Maskrskara', '1', 1, '20200818', NULL, NULL, 'Maskara', 7);
INSERT INTO "public"."main_category" VALUES ('Lee', '3', 1, '20200818', 1, '20200818', 'Lee', 6);
INSERT INTO "public"."main_category" VALUES ('Test_A', '3', 1, '20200829', 1, '20200829', 'Test', 8);
INSERT INTO "public"."main_category" VALUES ('admin', '1', 1, '20200829', NULL, NULL, 'dte', 9);
INSERT INTO "public"."main_category" VALUES ('add test', '1', 1, '20200829', NULL, NULL, 'test', 10);
INSERT INTO "public"."main_category" VALUES ('Desktop', '3', 1, '20200817', 1, '20200908', 'description', 1);

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS "public"."oauth_access_token";
CREATE TABLE "public"."oauth_access_token" (
  "token_id" varchar(255) COLLATE "pg_catalog"."default",
  "token" bytea,
  "authentication_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "user_name" varchar(255) COLLATE "pg_catalog"."default",
  "client_id" varchar(255) COLLATE "pg_catalog"."default",
  "authentication" bytea,
  "refresh_token" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------
INSERT INTO "public"."oauth_access_token" VALUES ('5649ad7a030c83496d28cd8eff849c1c', E'\\254\\355\\000\\005sr\\000Corg.springframework.security.oauth2.common.DefaultOAuth2AccessToken\\014\\262\\2366\\033$\\372\\316\\002\\000\\006L\\000\\025additionalInformationt\\000\\017Ljava/util/Map;L\\000\\012expirationt\\000\\020Ljava/util/Date;L\\000\\014refreshTokent\\000?Lorg/springframework/security/oauth2/common/OAuth2RefreshToken;L\\000\\005scopet\\000\\017Ljava/util/Set;L\\000\\011tokenTypet\\000\\022Ljava/lang/String;L\\000\\005valueq\\000~\\000\\005xpsr\\000\\036java.util.Collections$EmptyMapY6\\024\\205Z\\334\\347\\320\\002\\000\\000xpsr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001s\\344\\024\\235\\327xsr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationq\\000~\\000\\002xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valueq\\000~\\000\\005xpt\\000$98b90e39-2427-4472-a9b0-686ab10d92aasq\\000~\\000\\011w\\010\\000\\000\\001tx\\352\\035\\206xsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001ct\\000\\026Ljava/util/Collection;xpsr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\002?@\\000\\000\\000\\000\\000\\001t\\000\\004readxt\\000\\006bearert\\000$9c5baf62-081a-47d2-b9ba-c2d739f58b65', 'a8ee66debb22efeb858276e767cdf208', 'reader', 'spring-security-oauth2-read-client', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\002w\\004\\000\\000\\000\\002sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\017DEPARTMENT_READxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000\\026xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000\\024L\\000\\005scopeq\\000~\\000\\026xpt\\000"spring-security-oauth2-read-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000\\024xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\003w\\010\\000\\000\\000\\004\\000\\000\\000\\002t\\000\\012grant_typet\\000\\010passwordt\\000\\010usernamet\\000\\006readerxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\004readx\\001sq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\002w\\004\\000\\000\\000\\002q\\000~\\000\\017q\\000~\\000\\021xq\\000~\\0002sr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\003w\\010\\000\\000\\000\\004\\000\\000\\000\\002q\\000~\\000\\036q\\000~\\000\\037q\\000~\\000 q\\000~\\000!x\\000pt\\000\\006reader', '9c729fa5df5d0950139a45cc5dc964ab');
INSERT INTO "public"."oauth_access_token" VALUES ('634b1a6f306bbe0c900ab9fdd125e5d5', E'\\254\\355\\000\\005sr\\000Corg.springframework.security.oauth2.common.DefaultOAuth2AccessToken\\014\\262\\2366\\033$\\372\\316\\002\\000\\006L\\000\\025additionalInformationt\\000\\017Ljava/util/Map;L\\000\\012expirationt\\000\\020Ljava/util/Date;L\\000\\014refreshTokent\\000?Lorg/springframework/security/oauth2/common/OAuth2RefreshToken;L\\000\\005scopet\\000\\017Ljava/util/Set;L\\000\\011tokenTypet\\000\\022Ljava/lang/String;L\\000\\005valueq\\000~\\000\\005xpsr\\000\\036java.util.Collections$EmptyMapY6\\024\\205Z\\334\\347\\320\\002\\000\\000xpsr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001s\\3448\\012\\025xsr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationq\\000~\\000\\002xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valueq\\000~\\000\\005xpt\\000$a3dc00ae-886e-4825-972b-6166a2d0927dsq\\000~\\000\\011w\\010\\000\\000\\001t~\\022\\006\\225xsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001ct\\000\\026Ljava/util/Collection;xpsr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\002?@\\000\\000\\000\\000\\000\\001t\\000\\004readxt\\000\\006bearert\\000$d4d4da1d-60e0-4b43-9e06-c8fe4d4406eb', 'a65c44cc30c9e93e4c99d3c8b2025f33', 'modifier', 'spring-security-oauth2-read-client', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\002w\\004\\000\\000\\000\\002sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATExq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000\\026xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000\\024L\\000\\005scopeq\\000~\\000\\026xpt\\000"spring-security-oauth2-read-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000\\024xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\003w\\010\\000\\000\\000\\004\\000\\000\\000\\002t\\000\\012grant_typet\\000\\010passwordt\\000\\010usernamet\\000\\010modifierxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\004readx\\001sq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\002w\\004\\000\\000\\000\\002q\\000~\\000\\017q\\000~\\000\\021xq\\000~\\0002sr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\003w\\010\\000\\000\\000\\004\\000\\000\\000\\002q\\000~\\000\\036q\\000~\\000\\037q\\000~\\000 q\\000~\\000!x\\000pt\\000\\010modifier', 'e20a5dc8efee6a8bb249081f9f8da5f1');
INSERT INTO "public"."oauth_access_token" VALUES ('b54f7b9f0c7b59a27c36d483f6484163', E'\\254\\355\\000\\005sr\\000Corg.springframework.security.oauth2.common.DefaultOAuth2AccessToken\\014\\262\\2366\\033$\\372\\316\\002\\000\\006L\\000\\025additionalInformationt\\000\\017Ljava/util/Map;L\\000\\012expirationt\\000\\020Ljava/util/Date;L\\000\\014refreshTokent\\000?Lorg/springframework/security/oauth2/common/OAuth2RefreshToken;L\\000\\005scopet\\000\\017Ljava/util/Set;L\\000\\011tokenTypet\\000\\022Ljava/lang/String;L\\000\\005valueq\\000~\\000\\005xpsr\\000\\036java.util.Collections$EmptyMapY6\\024\\205Z\\334\\347\\320\\002\\000\\000xpsr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001u\\360\\002\\341hxsr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationq\\000~\\000\\002xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valueq\\000~\\000\\005xpt\\000$ef5390c3-1b5a-4119-b096-4bfa3397ca31sq\\000~\\000\\011w\\010\\000\\000\\001vP\\305\\007\\202xsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001ct\\000\\026Ljava/util/Collection;xpsr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writext\\000\\006bearert\\000$920fcbfd-3804-4c47-958c-2f84e202b006', 'd557e74143287f87984f133c7409755d', 'admin', 'spring-security-oauth2-read-write-client', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin', '99c8a4945634fc60c42dcfd06aae7f24');
INSERT INTO "public"."oauth_access_token" VALUES ('5b945bdd3ac2e724d9fac38350d375d9', E'\\254\\355\\000\\005sr\\000Corg.springframework.security.oauth2.common.DefaultOAuth2AccessToken\\014\\262\\2366\\033$\\372\\316\\002\\000\\006L\\000\\025additionalInformationt\\000\\017Ljava/util/Map;L\\000\\012expirationt\\000\\020Ljava/util/Date;L\\000\\014refreshTokent\\000?Lorg/springframework/security/oauth2/common/OAuth2RefreshToken;L\\000\\005scopet\\000\\017Ljava/util/Set;L\\000\\011tokenTypet\\000\\022Ljava/lang/String;L\\000\\005valueq\\000~\\000\\005xpsr\\000\\036java.util.Collections$EmptyMapY6\\024\\205Z\\334\\347\\320\\002\\000\\000xpsr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001t\\276\\370''Bxsr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationq\\000~\\000\\002xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valueq\\000~\\000\\005xpt\\000$8b856e10-4f80-448d-a491-6538c6283411sq\\000~\\000\\011w\\010\\000\\000\\001u \\275\\211\\243xsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001ct\\000\\026Ljava/util/Collection;xpsr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\004?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writext\\000\\006bearert\\000$357c6cec-7f8b-4d37-9b49-d30c3ec4b004', '7a150a95b28e54c23e293a11ef4a9596', 'reader', 'spring-security-oauth2-read-write-client', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\002w\\004\\000\\000\\000\\002sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\017DEPARTMENT_READxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000\\026xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000\\024L\\000\\005scopeq\\000~\\000\\026xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000\\024xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\006readerxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\002w\\004\\000\\000\\000\\002q\\000~\\000\\017q\\000~\\000\\021xq\\000~\\0005sr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000\\036q\\000~\\000\\037q\\000~\\000 q\\000~\\000!q\\000~\\000"q\\000~\\000#x\\000pt\\000\\006reader', 'dcfea05ddae9ad8863de8e3b48505b76');

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS "public"."oauth_approvals";
CREATE TABLE "public"."oauth_approvals" (
  "userid" varchar(255) COLLATE "pg_catalog"."default",
  "clientid" varchar(255) COLLATE "pg_catalog"."default",
  "scope" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar(10) COLLATE "pg_catalog"."default",
  "expiresat" timestamp(6),
  "lastmodifiedat" timestamp(6)
)
;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS "public"."oauth_client_details";
CREATE TABLE "public"."oauth_client_details" (
  "client_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "resource_ids" varchar(255) COLLATE "pg_catalog"."default",
  "client_secret" varchar(255) COLLATE "pg_catalog"."default",
  "scope" varchar(255) COLLATE "pg_catalog"."default",
  "authorized_grant_types" varchar(255) COLLATE "pg_catalog"."default",
  "web_server_redirect_uri" varchar(255) COLLATE "pg_catalog"."default",
  "authorities" varchar(255) COLLATE "pg_catalog"."default",
  "access_token_validity" int4,
  "refresh_token_validity" int4,
  "additional_information" varchar(4096) COLLATE "pg_catalog"."default",
  "autoapprove" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO "public"."oauth_client_details" VALUES ('spring-security-oauth2-read-client', 'resource-server-rest-api', '$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km', 'read', 'password,authorization_code,refresh_token,implicit', NULL, 'USER', 10800, 2592000, NULL, NULL);
INSERT INTO "public"."oauth_client_details" VALUES ('spring-security-oauth2-read-write-client', 'resource-server-rest-api', '$2a$04$soeOR.QFmClXeFIrhJVLWOQxfHjsJLSpWrU1iGxcMGdu.a5hvfY4W', 'read,write', 'password,authorization_code,refresh_token,implicit', NULL, 'USER', 10800, 2592000, NULL, NULL);

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS "public"."oauth_client_token";
CREATE TABLE "public"."oauth_client_token" (
  "token_id" varchar(255) COLLATE "pg_catalog"."default",
  "token" bytea,
  "authentication_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "user_name" varchar(255) COLLATE "pg_catalog"."default",
  "client_id" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS "public"."oauth_code";
CREATE TABLE "public"."oauth_code" (
  "code" varchar(255) COLLATE "pg_catalog"."default",
  "authentication" bytea
)
;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS "public"."oauth_refresh_token";
CREATE TABLE "public"."oauth_refresh_token" (
  "token_id" varchar(255) COLLATE "pg_catalog"."default",
  "token" bytea,
  "authentication" bytea
)
;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------
INSERT INTO "public"."oauth_refresh_token" VALUES ('9c729fa5df5d0950139a45cc5dc964ab', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$98b90e39-2427-4472-a9b0-686ab10d92aasr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001tx\\352\\035\\206x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\002w\\004\\000\\000\\000\\002sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\017DEPARTMENT_READxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000\\026xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000\\024L\\000\\005scopeq\\000~\\000\\026xpt\\000"spring-security-oauth2-read-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000\\024xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\003w\\010\\000\\000\\000\\004\\000\\000\\000\\002t\\000\\012grant_typet\\000\\010passwordt\\000\\010usernamet\\000\\006readerxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\004readx\\001sq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\002w\\004\\000\\000\\000\\002q\\000~\\000\\017q\\000~\\000\\021xq\\000~\\0002sr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\003w\\010\\000\\000\\000\\004\\000\\000\\000\\002q\\000~\\000\\036q\\000~\\000\\037q\\000~\\000 q\\000~\\000!x\\000pt\\000\\006reader');
INSERT INTO "public"."oauth_refresh_token" VALUES ('e20a5dc8efee6a8bb249081f9f8da5f1', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$a3dc00ae-886e-4825-972b-6166a2d0927dsr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001t~\\022\\006\\225x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\002w\\004\\000\\000\\000\\002sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATExq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000\\026xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000\\024L\\000\\005scopeq\\000~\\000\\026xpt\\000"spring-security-oauth2-read-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000\\024xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\003w\\010\\000\\000\\000\\004\\000\\000\\000\\002t\\000\\012grant_typet\\000\\010passwordt\\000\\010usernamet\\000\\010modifierxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\004readx\\001sq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\000%w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\002w\\004\\000\\000\\000\\002q\\000~\\000\\017q\\000~\\000\\021xq\\000~\\0002sr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\003w\\010\\000\\000\\000\\004\\000\\000\\000\\002q\\000~\\000\\036q\\000~\\000\\037q\\000~\\000 q\\000~\\000!x\\000pt\\000\\010modifier');
INSERT INTO "public"."oauth_refresh_token" VALUES ('ba6f52b2623d120c622798d96e0f36cd', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$f2fd1533-f3fd-4134-ade5-c058a5d74c5esr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\306\\302\\347x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('99c8a4945634fc60c42dcfd06aae7f24', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$ef5390c3-1b5a-4119-b096-4bfa3397ca31sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vP\\305\\007\\202x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('02a9fca21fa9a66c6f23bab6416c8376', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$45606105-a114-40ac-83a8-a07aa0e2a12fsr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001t\\323\\205\\262\\342x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\002w\\004\\000\\000\\000\\002sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\017DEPARTMENT_READxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000\\026xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000\\024L\\000\\005scopeq\\000~\\000\\026xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000\\024xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\006readerxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\002w\\004\\000\\000\\000\\002q\\000~\\000\\017q\\000~\\000\\021xq\\000~\\0005sr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000\\036q\\000~\\000\\037q\\000~\\000 q\\000~\\000!q\\000~\\000"q\\000~\\000#x\\000pt\\000\\006reader');
INSERT INTO "public"."oauth_refresh_token" VALUES ('d14c347c89f3a151b819c709bfca2075', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$ce74cb88-9aee-4f07-af75-4c1af54916f2sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001u\\035;\\244\\337x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\002w\\004\\000\\000\\000\\002sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\017DEPARTMENT_READxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000\\026xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000\\024L\\000\\005scopeq\\000~\\000\\026xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000\\024xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\006readerxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\002w\\004\\000\\000\\000\\002q\\000~\\000\\017q\\000~\\000\\021xq\\000~\\0005sr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000\\036q\\000~\\000\\037q\\000~\\000 q\\000~\\000!q\\000~\\000"q\\000~\\000#x\\000pt\\000\\006reader');
INSERT INTO "public"."oauth_refresh_token" VALUES ('4e7c0e51f7e14131a5b0f03c5ab4f545', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$b9326ab5-ef6d-4347-8332-7a33c7697318sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001u \\027r\\357x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\002w\\004\\000\\000\\000\\002sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\017DEPARTMENT_READxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000\\026xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000\\024L\\000\\005scopeq\\000~\\000\\026xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000\\024xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\006readerxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\002w\\004\\000\\000\\000\\002q\\000~\\000\\017q\\000~\\000\\021xq\\000~\\0005sr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000\\036q\\000~\\000\\037q\\000~\\000 q\\000~\\000!q\\000~\\000"q\\000~\\000#x\\000pt\\000\\006reader');
INSERT INTO "public"."oauth_refresh_token" VALUES ('10974c1135b32f2281e2cdc6358eb0e8', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$cb3352b8-2deb-4860-8583-db725056e2a6sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001u\\022\\323\\333\\373x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('8fbd81c4fe753257d61c97191de1391b', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$3fb8b6a3-e00d-4d86-8b78-58e456ce4d82sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\326\\264\\347x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('929f4ae6c68939a6f96267df7f01199a', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$4064b35d-4efb-4d57-9908-12a7dd9271e8sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\326\\344\\341x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('2d91de8a6a7f62447c1a72ac37d04b3f', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$8472890b-8714-48c2-9e2c-73d3b1c78f15sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001u\\371+\\207\\200x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('dcfea05ddae9ad8863de8e3b48505b76', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$8b856e10-4f80-448d-a491-6538c6283411sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001u \\275\\211\\243x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\002w\\004\\000\\000\\000\\002sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\017DEPARTMENT_READxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000\\026xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000\\024L\\000\\005scopeq\\000~\\000\\026xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000\\024xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\006readerxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\000''w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\002w\\004\\000\\000\\000\\002q\\000~\\000\\017q\\000~\\000\\021xq\\000~\\0005sr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000\\034?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000\\036q\\000~\\000\\037q\\000~\\000 q\\000~\\000!q\\000~\\000"q\\000~\\000#x\\000pt\\000\\006reader');
INSERT INTO "public"."oauth_refresh_token" VALUES ('0b248d0f7414a4755f604a63b9a18d3d', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$747900ec-bd85-423a-83bc-38476c65d01asr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001u:\\327\\375\\027x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('ef1cf2420c4bbf4cd1761e62348cfaea', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$7fc45305-4c52-47e9-9486-399632e99cacsr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001v(Y\\211\\233x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('ab865513464e11b1bf0db16da7670b6b', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$d520388e-ce07-4154-b2a1-dcbe94b28f1esr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\177\\317\\035x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('929ec3a5e9b963077189d293d9983617', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$c033223c-1faa-471f-ac05-0b185acd20b5sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\200Hsx', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('a4726b483b6ea1ce5a4537182e5fdf3c', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$9ae92bf7-8cff-42f0-8b03-5ef6a1d3ff77sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\216\\343>x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('e8bef573fa2b6628bf3bfad2825d99ad', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$6768b06f-c333-4aac-b178-e2000e7b2254sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\220\\245\\217x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('5cda6f8c8ad8e9f022b14f698342e33d', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$f8d7d425-1d7d-41b1-adf4-7010a10fd77asr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\331{.x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('ebdeb3103a1d483ec9b80956ef5a995c', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$433520fb-75a7-4b18-a657-734e13b17b11sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\303Nzx', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('121a900d867e13a26477d4d54fec22fc', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$0c01cb21-3272-4c42-aa6f-cd0bcee82cb5sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\305\\005\\000x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('8aaf901baa0919f759c90c5575e72c13', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$117c0cc2-b434-490f-8fbe-73e029ca98desr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001u\\214\\246\\264wx', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');
INSERT INTO "public"."oauth_refresh_token" VALUES ('a3a4322485466dc7ebea852bbd1961fb', E'\\254\\355\\000\\005sr\\000Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\337Gc\\235\\320\\311\\267\\002\\000\\001L\\000\\012expirationt\\000\\020Ljava/util/Date;xr\\000Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\341\\016\\012cT\\324^\\002\\000\\001L\\000\\005valuet\\000\\022Ljava/lang/String;xpt\\000$eb93ce76-77a0-4aca-ac78-e1cfcdbe0559sr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001vF\\305\\330\\213x', E'\\254\\355\\000\\005sr\\000Aorg.springframework.security.oauth2.provider.OAuth2Authentication\\275@\\013\\002\\026bR\\023\\002\\000\\002L\\000\\015storedRequestt\\000<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\\000\\022userAuthenticationt\\0002Lorg/springframework/security/core/Authentication;xr\\000Gorg.springframework.security.authentication.AbstractAuthenticationToken\\323\\252(~nGd\\016\\002\\000\\003Z\\000\\015authenticatedL\\000\\013authoritiest\\000\\026Ljava/util/Collection;L\\000\\007detailst\\000\\022Ljava/lang/Object;xp\\000sr\\000&java.util.Collections$UnmodifiableList\\374\\017%1\\265\\354\\216\\020\\002\\000\\001L\\000\\004listt\\000\\020Ljava/util/List;xr\\000,java.util.Collections$UnmodifiableCollection\\031B\\000\\200\\313^\\367\\036\\002\\000\\001L\\000\\001cq\\000~\\000\\004xpsr\\000\\023java.util.ArrayListx\\201\\322\\035\\231\\307a\\235\\003\\000\\001I\\000\\004sizexp\\000\\000\\000\\011w\\004\\000\\000\\000\\011sr\\000Borg.springframework.security.core.authority.SimpleGrantedAuthority\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\001L\\000\\004rolet\\000\\022Ljava/lang/String;xpt\\000\\016COMPANY_CREATEsq\\000~\\000\\015t\\000\\014COMPANY_READsq\\000~\\000\\015t\\000\\016COMPANY_UPDATEsq\\000~\\000\\015t\\000\\016COMPANY_DELETEsq\\000~\\000\\015t\\000\\021DEPARTMENT_CREATEsq\\000~\\000\\015t\\000\\017DEPARTMENT_READsq\\000~\\000\\015t\\000\\021DEPARTMENT_UPDATEsq\\000~\\000\\015t\\000\\021DEPARTMENT_DELETEsq\\000~\\000\\015t\\000\\023ROLE_COMPANY_READERxq\\000~\\000\\014psr\\000:org.springframework.security.oauth2.provider.OAuth2Request\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007Z\\000\\010approvedL\\000\\013authoritiesq\\000~\\000\\004L\\000\\012extensionst\\000\\017Ljava/util/Map;L\\000\\013redirectUriq\\000~\\000\\016L\\000\\007refresht\\000;Lorg/springframework/security/oauth2/provider/TokenRequest;L\\000\\013resourceIdst\\000\\017Ljava/util/Set;L\\000\\015responseTypesq\\000~\\000$xr\\0008org.springframework.security.oauth2.provider.BaseRequest6(z>\\243qi\\275\\002\\000\\003L\\000\\010clientIdq\\000~\\000\\016L\\000\\021requestParametersq\\000~\\000"L\\000\\005scopeq\\000~\\000$xpt\\000(spring-security-oauth2-read-write-clientsr\\000%java.util.Collections$UnmodifiableMap\\361\\245\\250\\376t\\365\\007B\\002\\000\\001L\\000\\001mq\\000~\\000"xpsr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003t\\000\\012grant_typet\\000\\010passwordt\\000\\011client_idt\\000(spring-security-oauth2-read-write-clientt\\000\\010usernamet\\000\\005adminxsr\\000%java.util.Collections$UnmodifiableSet\\200\\035\\222\\321\\217\\233\\200U\\002\\000\\000xq\\000~\\000\\011sr\\000\\027java.util.LinkedHashSet\\330l\\327Z\\225\\335*\\036\\002\\000\\000xr\\000\\021java.util.HashSet\\272D\\205\\225\\226\\270\\2674\\003\\000\\000xpw\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\002t\\000\\004readt\\000\\005writex\\001sq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001sq\\000~\\000\\015t\\000\\004USERxsq\\000~\\000*?@\\000\\000\\000\\000\\000\\000w\\010\\000\\000\\000\\020\\000\\000\\000\\000xppsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\001t\\000\\030resource-server-rest-apixsq\\000~\\0005w\\014\\000\\000\\000\\020?@\\000\\000\\000\\000\\000\\000xsr\\000Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\\000\\000\\000\\000\\000\\000\\002\\034\\002\\000\\002L\\000\\013credentialsq\\000~\\000\\005L\\000\\011principalq\\000~\\000\\005xq\\000~\\000\\003\\001sq\\000~\\000\\007sq\\000~\\000\\013\\000\\000\\000\\011w\\004\\000\\000\\000\\011q\\000~\\000\\017q\\000~\\000\\021q\\000~\\000\\023q\\000~\\000\\025q\\000~\\000\\027q\\000~\\000\\031q\\000~\\000\\033q\\000~\\000\\035q\\000~\\000\\037xq\\000~\\000Csr\\000\\027java.util.LinkedHashMap4\\300N\\\\\\020l\\300\\373\\002\\000\\001Z\\000\\013accessOrderxq\\000~\\000*?@\\000\\000\\000\\000\\000\\006w\\010\\000\\000\\000\\010\\000\\000\\000\\003q\\000~\\000,q\\000~\\000-q\\000~\\000.q\\000~\\000/q\\000~\\0000q\\000~\\0001x\\000pt\\000\\005admin');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS "public"."payment";
CREATE TABLE "public"."payment" (
  "id" int4 NOT NULL,
  "purchase_id" int4 NOT NULL,
  "customer_id" int4 NOT NULL,
  "user_id" int4 NOT NULL,
  "payment_id" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "approval_status" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" int4 NOT NULL,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "modify_by" int4 NOT NULL
)
;

-- ----------------------------
-- Records of payment
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS "public"."product";
CREATE TABLE "public"."product" (
  "id" int4 NOT NULL,
  "category_id" int4 NOT NULL,
  "name" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default",
  "create_by" int4,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default",
  "modify_by" int4,
  "resource_img_id" varchar(100) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO "public"."product" VALUES (8, 6, 'Product c', '1', '20201105', 1, NULL, NULL, '448648c1-2bb1-4506-a1ad-d80af03db2c4-20201105073121', 'Product c');
INSERT INTO "public"."product" VALUES (9, 1, 'Product Testing', '1', '20201107', 1, NULL, NULL, '4e0aed21-3017-4aaf-9dce-c76bd367412d-20201107052940', 'Tesing');
INSERT INTO "public"."product" VALUES (11, 6, 'a', '1', '20201108', 1, NULL, NULL, '6935aea2-9380-4aa4-987a-29620b447041-20201108052749', 'a');
INSERT INTO "public"."product" VALUES (12, 6, 'Dell', '1', '20201108', 1, NULL, NULL, '7e576151-aab6-4b7d-b51f-69f81e7920bf-20201108052814', 'Dell');
INSERT INTO "public"."product" VALUES (13, 6, 'Testing Product AA', '1', '20201108', 1, '20201109', 1, '785a86ae-87eb-41b1-b19a-5ad6dbbf2c48-20201108054618', 'Testing Product AA');
INSERT INTO "public"."product" VALUES (10, 6, 'Assuse A+', '1', '20201108', 1, '20201109', 1, '9c80c032-4d6a-4973-96f7-f39d0e210943-20201109013748', 'Assuse A+');
INSERT INTO "public"."product" VALUES (7, 1, 'Product B', '1', '20201105', 1, '20201109', 1, 'f14eade1-e23f-4cad-9c7a-a5b66f01357d-20201109013947', 'Product B');
INSERT INTO "public"."product" VALUES (6, 5, 'dfa', '1', '20201105', 1, '20201109', 1, 'e47763eb-e6cc-4273-9d0f-e2e758bb144b-20201109013916', 'dfa');
INSERT INTO "public"."product" VALUES (14, 6, 'l', '1', '20201108', 1, '20201112', 1, '29f975a5-2548-4ef4-97d2-21c13427ed89-20201112081523', 'l Testing');

-- ----------------------------
-- Table structure for product_detials
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_detials";
CREATE TABLE "public"."product_detials" (
  "id" int4 NOT NULL,
  "product_id" int4 NOT NULL,
  "context_en" text COLLATE "pg_catalog"."default" NOT NULL,
  "context_kh" text COLLATE "pg_catalog"."default" NOT NULL,
  "context_ch" text COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" int4 NOT NULL,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "modify_by" int4 NOT NULL
)
;

-- ----------------------------
-- Records of product_detials
-- ----------------------------

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS "public"."purchase";
CREATE TABLE "public"."purchase" (
  "id" int4 NOT NULL,
  "transaction_details_id" int4 NOT NULL,
  "customer_id" int4 NOT NULL,
  "shipping_id" int4 NOT NULL,
  "amount" numeric(42) NOT NULL,
  "free" numeric(22) NOT NULL,
  "status" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "error_code" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "error_message" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "approval_code" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "approval_status" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "pg_code" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "pg_error_message" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "pg_approval_code" varchar(225) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of purchase
-- ----------------------------

-- ----------------------------
-- Table structure for resource_img
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource_img";
CREATE TABLE "public"."resource_img" (
  "id" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default",
  "create_by" int4,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default",
  "modify_by" int4,
  "file_source" text COLLATE "pg_catalog"."default",
  "file_name" varchar(255) COLLATE "pg_catalog"."default",
  "file_size" int4,
  "file_extension" varchar(10) COLLATE "pg_catalog"."default",
  "file_type" varchar(255) COLLATE "pg_catalog"."default",
  "original_name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of resource_img
-- ----------------------------
INSERT INTO "public"."resource_img" VALUES ('abc', '1', '1', 1, '1', 1, '/uploads/Products_Abc/713b6045-a1f9-47df-9e8a-91c42611884d.jpg', 'test', 100, '.jpg', NULL, NULL);
INSERT INTO "public"."resource_img" VALUES ('fcf7e2c1-3361-4a6e-b353-131e1fd26bc3-20201103045613', '1', '20201103', 1, NULL, NULL, '/uploads/products/fcf7e2c1-3361-4a6e-b353-131e1fd26bc3-20201103045613.jpg', 'fcf7e2c1-3361-4a6e-b353-131e1fd26bc3-20201103045613', 215675, '.jpg', 'image/jpeg', '3425914.jpg');
INSERT INTO "public"."resource_img" VALUES ('f4489550-6ef1-48d6-8c86-7fe3b703001d-20201103053635', '1', '20201103', 1, NULL, NULL, '/uploads/products/f4489550-6ef1-48d6-8c86-7fe3b703001d-20201103053635.jpg', 'f4489550-6ef1-48d6-8c86-7fe3b703001d-20201103053635', 215675, '.jpg', 'image/jpeg', '3425914.jpg');
INSERT INTO "public"."resource_img" VALUES ('5d01ab7a-04f4-4a13-9606-12ed7cd7f83b-20201105070334', '1', '20201105', 1, NULL, NULL, '/uploads/products/5d01ab7a-04f4-4a13-9606-12ed7cd7f83b-20201105070334.jpg', '5d01ab7a-04f4-4a13-9606-12ed7cd7f83b-20201105070334', 215675, '.jpg', 'image/jpeg', '3425914.jpg');
INSERT INTO "public"."resource_img" VALUES ('211c2b4d-51e7-49c4-9084-42ad4b5145b3-20201105072921', '1', '20201105', 1, NULL, NULL, '/uploads/products/211c2b4d-51e7-49c4-9084-42ad4b5145b3-20201105072921.jpg', '211c2b4d-51e7-49c4-9084-42ad4b5145b3-20201105072921', 215675, '.jpg', 'image/jpeg', '3425914.jpg');
INSERT INTO "public"."resource_img" VALUES ('448648c1-2bb1-4506-a1ad-d80af03db2c4-20201105073121', '1', '20201105', 1, NULL, NULL, '/uploads/products/448648c1-2bb1-4506-a1ad-d80af03db2c4-20201105073121.jpg', '448648c1-2bb1-4506-a1ad-d80af03db2c4-20201105073121', 215675, '.jpg', 'image/jpeg', '3425914.jpg');
INSERT INTO "public"."resource_img" VALUES ('4e0aed21-3017-4aaf-9dce-c76bd367412d-20201107052940', '1', '20201107', 1, NULL, NULL, '/uploads/products/4e0aed21-3017-4aaf-9dce-c76bd367412d-20201107052940.jpg', '4e0aed21-3017-4aaf-9dce-c76bd367412d-20201107052940', 60078, '.jpg', 'image/jpeg', 'photo_2020-09-24_11-57-36.jpg');
INSERT INTO "public"."resource_img" VALUES ('6935aea2-9380-4aa4-987a-29620b447041-20201108052749', '1', '20201108', 1, NULL, NULL, '/uploads/products/6935aea2-9380-4aa4-987a-29620b447041-20201108052749.jpg', '6935aea2-9380-4aa4-987a-29620b447041-20201108052749', 110802, '.jpg', 'image/jpeg', 'photo_2020-09-21_21-06-00 (2).jpg');
INSERT INTO "public"."resource_img" VALUES ('7e576151-aab6-4b7d-b51f-69f81e7920bf-20201108052814', '1', '20201108', 1, NULL, NULL, '/uploads/products/7e576151-aab6-4b7d-b51f-69f81e7920bf-20201108052814.jpg', '7e576151-aab6-4b7d-b51f-69f81e7920bf-20201108052814', 104345, '.jpg', 'image/jpeg', '119753288_1459524027769440_7399896723103371023_o.jpg');
INSERT INTO "public"."resource_img" VALUES ('785a86ae-87eb-41b1-b19a-5ad6dbbf2c48-20201108054618', '1', '20201108', 1, NULL, NULL, '/uploads/products/785a86ae-87eb-41b1-b19a-5ad6dbbf2c48-20201108054618.jpg', '785a86ae-87eb-41b1-b19a-5ad6dbbf2c48-20201108054618', 58580, '.jpg', 'image/jpeg', 'photo_2020-09-21_21-05-59 (3).jpg');
INSERT INTO "public"."resource_img" VALUES ('5e331fa4-0914-4cf5-9319-4739c8f07d69-20201109013453', '1', '20201109', 1, NULL, NULL, '/uploads/products/5e331fa4-0914-4cf5-9319-4739c8f07d69-20201109013453.jpg', '5e331fa4-0914-4cf5-9319-4739c8f07d69-20201109013453', 83790, '.jpg', 'image/jpeg', 'photo_2020-09-21_21-05-58.jpg');
INSERT INTO "public"."resource_img" VALUES ('9c80c032-4d6a-4973-96f7-f39d0e210943-20201109013748', '1', '20201109', 1, NULL, NULL, '/uploads/products/9c80c032-4d6a-4973-96f7-f39d0e210943-20201109013748.jpg', '9c80c032-4d6a-4973-96f7-f39d0e210943-20201109013748', 98776, '.jpg', 'image/jpeg', 'photo_2020-09-21_21-07-03 (2).jpg');
INSERT INTO "public"."resource_img" VALUES ('e47763eb-e6cc-4273-9d0f-e2e758bb144b-20201109013916', '1', '20201109', 1, NULL, NULL, '/uploads/products/e47763eb-e6cc-4273-9d0f-e2e758bb144b-20201109013916.jpg', 'e47763eb-e6cc-4273-9d0f-e2e758bb144b-20201109013916', 58048, '.jpg', 'image/jpeg', 'photo_2020-09-21_21-07-04 (2).jpg');
INSERT INTO "public"."resource_img" VALUES ('f14eade1-e23f-4cad-9c7a-a5b66f01357d-20201109013947', '1', '20201109', 1, NULL, NULL, '/uploads/products/f14eade1-e23f-4cad-9c7a-a5b66f01357d-20201109013947.jpg', 'f14eade1-e23f-4cad-9c7a-a5b66f01357d-20201109013947', 299123, '.jpg', 'image/jpeg', 'photo_2020-09-24_20-31-35.jpg');
INSERT INTO "public"."resource_img" VALUES ('29f975a5-2548-4ef4-97d2-21c13427ed89-20201112081523', '1', '20201112', 1, NULL, NULL, '/uploads/products/29f975a5-2548-4ef4-97d2-21c13427ed89-20201112081523.jpg', '29f975a5-2548-4ef4-97d2-21c13427ed89-20201112081523', 44292, '.jpg', 'image/jpeg', 'photo_2020-09-24_20-44-54.jpg');
INSERT INTO "public"."resource_img" VALUES ('4ae9b8f5-f739-4128-bb96-7aecf205c351-20201120033808', '1', '20201120', 1, NULL, NULL, '/uploads/products/4ae9b8f5-f739-4128-bb96-7aecf205c351-20201120033808.jpg', '4ae9b8f5-f739-4128-bb96-7aecf205c351-20201120033808', 215675, '.jpg', 'image/jpeg', '3425914.jpg');
INSERT INTO "public"."resource_img" VALUES ('71b6cc70-7cfc-4f80-a546-da4baab07d48-20201120033826', '1', '20201120', 1, NULL, NULL, '/uploads/products/71b6cc70-7cfc-4f80-a546-da4baab07d48-20201120033826.jpg', '71b6cc70-7cfc-4f80-a546-da4baab07d48-20201120033826', 215675, '.jpg', 'image/jpeg', '3425914.jpg');
INSERT INTO "public"."resource_img" VALUES ('55535638-ca38-4c82-ba94-a6b1037d7857-20201120033833', '1', '20201120', 1, NULL, NULL, '/uploads/products/55535638-ca38-4c82-ba94-a6b1037d7857-20201120033833.jpg', '55535638-ca38-4c82-ba94-a6b1037d7857-20201120033833', 215675, '.jpg', 'image/jpeg', '3425914.jpg');
INSERT INTO "public"."resource_img" VALUES ('59ab1cc9-5d48-4906-8b6b-36d512cb9bb4-20201120040442', '1', '20201120', 1, NULL, NULL, '/uploads/products/59ab1cc9-5d48-4906-8b6b-36d512cb9bb4-20201120040442.jpg', '59ab1cc9-5d48-4906-8b6b-36d512cb9bb4-20201120040442', 215675, '.jpg', 'image/jpeg', '3425914.jpg');
INSERT INTO "public"."resource_img" VALUES ('c520daad-f044-4836-8b86-68db60b24d72-20201120040455', '1', '20201120', 1, NULL, NULL, '/uploads/products/c520daad-f044-4836-8b86-68db60b24d72-20201120040455.jpg', 'c520daad-f044-4836-8b86-68db60b24d72-20201120040455', 215675, '.jpg', 'image/jpeg', '3425914.jpg');
INSERT INTO "public"."resource_img" VALUES ('3282d83b-a5ea-44a2-9b71-a5ae56a2af8a-20201120040459', '1', '20201120', 1, NULL, NULL, '/uploads/products/3282d83b-a5ea-44a2-9b71-a5ae56a2af8a-20201120040459.jpg', '3282d83b-a5ea-44a2-9b71-a5ae56a2af8a-20201120040459', 215675, '.jpg', 'image/jpeg', '3425914.jpg');

-- ----------------------------
-- Table structure for shipping
-- ----------------------------
DROP TABLE IF EXISTS "public"."shipping";
CREATE TABLE "public"."shipping" (
  "id" int4 NOT NULL,
  "first_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "last_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "address_line1" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "address_line2" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "country" varchar(80) COLLATE "pg_catalog"."default" NOT NULL,
  "state" varchar(80) COLLATE "pg_catalog"."default" NOT NULL,
  "city" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "postal_code" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "phone_number" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of shipping
-- ----------------------------

-- ----------------------------
-- Table structure for stock_details
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock_details";
CREATE TABLE "public"."stock_details" (
  "id" int4 NOT NULL,
  "import_product_id" int4 NOT NULL,
  "product_id" int4 NOT NULL,
  "stock_in_id" int4 NOT NULL,
  "unit_qty" int4 NOT NULL,
  "unit_price" int4 NOT NULL,
  "unit_discount" int4 NOT NULL,
  "to_stock_in_qty" int4 NOT NULL,
  "qty" int4 NOT NULL,
  "profit_rate" int4 NOT NULL,
  "price" int4 NOT NULL,
  "status" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" int4 NOT NULL,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "modify_by" int4 NOT NULL
)
;

-- ----------------------------
-- Records of stock_details
-- ----------------------------

-- ----------------------------
-- Table structure for stock_in
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock_in";
CREATE TABLE "public"."stock_in" (
  "id" int4 NOT NULL,
  "product_id" int4 NOT NULL,
  "qty" int4 NOT NULL,
  "price" numeric(102) NOT NULL,
  "discount" numeric(22) NOT NULL,
  "profit_rate" numeric(22) NOT NULL,
  "status" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" int4 NOT NULL,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "modify_by" int4 NOT NULL
)
;

-- ----------------------------
-- Records of stock_in
-- ----------------------------

-- ----------------------------
-- Table structure for t
-- ----------------------------
DROP TABLE IF EXISTS "public"."t";
CREATE TABLE "public"."t" (
  "id" int4,
  "name" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of t
-- ----------------------------
INSERT INTO "public"."t" VALUES (101, 't1');
INSERT INTO "public"."t" VALUES (102, 't2');

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS "public"."transaction";
CREATE TABLE "public"."transaction" (
  "id" int4 NOT NULL,
  "product_id" int4 NOT NULL,
  "qty" int4 NOT NULL,
  "price" numeric(4,2) NOT NULL,
  "discount" numeric(22) NOT NULL,
  "total" numeric(4,2) NOT NULL,
  "status" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" int4 NOT NULL,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "modify_by" int4 NOT NULL
)
;

-- ----------------------------
-- Records of transaction
-- ----------------------------

-- ----------------------------
-- Table structure for transaction_details
-- ----------------------------
DROP TABLE IF EXISTS "public"."transaction_details";
CREATE TABLE "public"."transaction_details" (
  "id" int4 NOT NULL,
  "transaction_id" int4 NOT NULL,
  "stock_in_id" int4 NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of transaction_details
-- ----------------------------

-- ----------------------------
-- Table structure for user_
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_";
CREATE TABLE "public"."user_" (
  "id" int8 NOT NULL DEFAULT nextval('user__id_seq'::regclass),
  "account_expired" bool,
  "account_locked" bool,
  "credentials_expired" bool,
  "enabled" bool,
  "password" varchar(255) COLLATE "pg_catalog"."default",
  "user_name" varchar(255) COLLATE "pg_catalog"."default",
  "resource_img_id" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar COLLATE "pg_catalog"."default",
  "create_date" varchar(8) COLLATE "pg_catalog"."default",
  "create_by" int4,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default",
  "modify_by" int4,
  "last_login_date" varchar(8) COLLATE "pg_catalog"."default",
  "last_login_time" varchar(8) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."user_"."account_expired" IS 'Account Expired';
COMMENT ON COLUMN "public"."user_"."account_locked" IS 'Account Locked';
COMMENT ON COLUMN "public"."user_"."credentials_expired" IS 'Credentials Expired';
COMMENT ON COLUMN "public"."user_"."enabled" IS 'Enable';
COMMENT ON COLUMN "public"."user_"."password" IS 'Password';
COMMENT ON COLUMN "public"."user_"."user_name" IS 'User Name';
COMMENT ON COLUMN "public"."user_"."resource_img_id" IS 'Resource Image ID';
COMMENT ON COLUMN "public"."user_"."status" IS 'Status';
COMMENT ON COLUMN "public"."user_"."create_date" IS 'Create Date';
COMMENT ON COLUMN "public"."user_"."create_by" IS 'Create By';
COMMENT ON COLUMN "public"."user_"."modify_date" IS 'Modify Date';
COMMENT ON COLUMN "public"."user_"."modify_by" IS 'Modify By';

-- ----------------------------
-- Records of user_
-- ----------------------------
INSERT INTO "public"."user_" VALUES (3, 'f', 'f', 'f', 't', '$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', 'modifier', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."user_" VALUES (4, 'f', 't', 'f', 't', '$2a$08$vVXqh6S8TqfHMs1SlNTu/.J25iUCrpGBpyGExA.9yI.IlDRadR6Ea', 'reader2', NULL, '3', NULL, NULL, '20200903', 1, NULL, NULL);
INSERT INTO "public"."user_" VALUES (2, 'f', 'f', 'f', 't', '$2a$10$nj4x5nWUlMlLTzvGK9pUvONEUTdoMLGXtVnR/BSAXKyH.kcWXZSh6', 'reader', NULL, NULL, NULL, NULL, NULL, NULL, '20200924', '111608');
INSERT INTO "public"."user_" VALUES (1, 'f', 'f', 'f', 't', '$2a$10$nj4x5nWUlMlLTzvGK9pUvONEUTdoMLGXtVnR/BSAXKyH.kcWXZSh6', 'admin', NULL, '3', NULL, NULL, '20200924', 2, '20200924', '110541');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_info";
CREATE TABLE "public"."user_info" (
  "id" int4 NOT NULL DEFAULT nextval('user_info_id_seq'::regclass),
  "first_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "last_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "gender" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "date_birth" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "contact" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "profile_resource_img_id" int4 NOT NULL,
  "status" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date" varchar(8) COLLATE "pg_catalog"."default",
  "create_by" int4,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default",
  "modify_by" int4,
  "description" varchar COLLATE "pg_catalog"."default",
  "address" varchar COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_info_details
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_info_details";
CREATE TABLE "public"."user_info_details" (
  "id" int2 NOT NULL DEFAULT nextval('user_info_details_id_seq'::regclass),
  "card_identify_id" varchar(255) COLLATE "pg_catalog"."default",
  "user_info_id" int4,
  "user_id" int4
)
;

-- ----------------------------
-- Records of user_info_details
-- ----------------------------
INSERT INTO "public"."user_info_details" VALUES (1, 'daf', NULL, NULL);
INSERT INTO "public"."user_info_details" VALUES (2, 'daf', 2, 1);

-- ----------------------------
-- Table structure for user_lock_count
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_lock_count";
CREATE TABLE "public"."user_lock_count" (
  "id" int4 NOT NULL DEFAULT nextval('user_lock_count_id_seq'::regclass),
  "user_name" varchar COLLATE "pg_catalog"."default" NOT NULL,
  "count" int4 NOT NULL,
  "date" varchar COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar COLLATE "pg_catalog"."default" NOT NULL,
  "message" varchar COLLATE "pg_catalog"."default" NOT NULL,
  "islocked" bool NOT NULL DEFAULT false,
  "time" varchar COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."user_lock_count"."id" IS 'ID';
COMMENT ON COLUMN "public"."user_lock_count"."user_name" IS 'User Name';
COMMENT ON COLUMN "public"."user_lock_count"."count" IS 'count user lock';
COMMENT ON COLUMN "public"."user_lock_count"."date" IS 'Date Time';
COMMENT ON COLUMN "public"."user_lock_count"."status" IS 'Status';
COMMENT ON COLUMN "public"."user_lock_count"."message" IS 'Message';
COMMENT ON COLUMN "public"."user_lock_count"."islocked" IS 'Is Lock User';
COMMENT ON TABLE "public"."user_lock_count" IS 'Lock User login wrong user or password';

-- ----------------------------
-- Records of user_lock_count
-- ----------------------------

-- ----------------------------
-- Table structure for users_authorities
-- ----------------------------
DROP TABLE IF EXISTS "public"."users_authorities";
CREATE TABLE "public"."users_authorities" (
  "user_id" int8 NOT NULL,
  "authority_id" int8 NOT NULL
)
;

-- ----------------------------
-- Records of users_authorities
-- ----------------------------
INSERT INTO "public"."users_authorities" VALUES (1, 1);
INSERT INTO "public"."users_authorities" VALUES (1, 2);
INSERT INTO "public"."users_authorities" VALUES (1, 3);
INSERT INTO "public"."users_authorities" VALUES (1, 4);
INSERT INTO "public"."users_authorities" VALUES (1, 5);
INSERT INTO "public"."users_authorities" VALUES (1, 6);
INSERT INTO "public"."users_authorities" VALUES (1, 7);
INSERT INTO "public"."users_authorities" VALUES (1, 8);
INSERT INTO "public"."users_authorities" VALUES (1, 9);
INSERT INTO "public"."users_authorities" VALUES (2, 2);
INSERT INTO "public"."users_authorities" VALUES (2, 6);
INSERT INTO "public"."users_authorities" VALUES (3, 3);
INSERT INTO "public"."users_authorities" VALUES (3, 7);
INSERT INTO "public"."users_authorities" VALUES (4, 9);

-- ----------------------------
-- Table structure for vendor
-- ----------------------------
DROP TABLE IF EXISTS "public"."vendor";
CREATE TABLE "public"."vendor" (
  "id" int4 NOT NULL,
  "name" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "address" varchar(225) COLLATE "pg_catalog"."default",
  "contact" varchar(225) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(225) COLLATE "pg_catalog"."default",
  "status" varchar(8) COLLATE "pg_catalog"."default",
  "create_date" varchar(8) COLLATE "pg_catalog"."default",
  "create_by" int4,
  "modify_date" varchar(8) COLLATE "pg_catalog"."default",
  "modify_by" int4,
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "other_contact" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of vendor
-- ----------------------------
INSERT INTO "public"."vendor" VALUES (0, 'Test Co.ltd', '2222', '0865547555', '222', '1', '20200918', 1, '20201014', 1, '', NULL);
INSERT INTO "public"."vendor" VALUES (6, 'Wwwol', '33', '0852444544', '333', '1', '20200918', 1, '20201014', 1, '33', NULL);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."authority_id_seq"
OWNED BY "public"."authority"."id";
SELECT setval('"public"."authority_id_seq"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."main_category_id_seq"
OWNED BY "public"."main_category"."id";
SELECT setval('"public"."main_category_id_seq"', 12, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."sequence_category"', 32, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."sequence_product"', 15, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."sequence_vendor"', 7, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."serial_t"', 103, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user__id_seq"
OWNED BY "public"."user_"."id";
SELECT setval('"public"."user__id_seq"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_info_details_id_seq"
OWNED BY "public"."user_info_details"."id";
SELECT setval('"public"."user_info_details_id_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_info_id_seq"
OWNED BY "public"."user_info"."id";
SELECT setval('"public"."user_info_id_seq"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_lock_count_id_seq"
OWNED BY "public"."user_lock_count"."id";
SELECT setval('"public"."user_lock_count_id_seq"', 15, true);

-- ----------------------------
-- Uniques structure for table authority
-- ----------------------------
ALTER TABLE "public"."authority" ADD CONSTRAINT "authority_name" UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table authority
-- ----------------------------
ALTER TABLE "public"."authority" ADD CONSTRAINT "authority_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table card_identify
-- ----------------------------
ALTER TABLE "public"."card_identify" ADD CONSTRAINT "card_identify_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table category
-- ----------------------------
ALTER TABLE "public"."category" ADD CONSTRAINT "name" UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table customer
-- ----------------------------
ALTER TABLE "public"."customer" ADD CONSTRAINT "pk_customer" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table oauth_access_token
-- ----------------------------
ALTER TABLE "public"."oauth_access_token" ADD CONSTRAINT "oauth_access_token_pkey" PRIMARY KEY ("authentication_id");

-- ----------------------------
-- Primary Key structure for table oauth_client_details
-- ----------------------------
ALTER TABLE "public"."oauth_client_details" ADD CONSTRAINT "oauth_client_details_pkey" PRIMARY KEY ("client_id");

-- ----------------------------
-- Primary Key structure for table oauth_client_token
-- ----------------------------
ALTER TABLE "public"."oauth_client_token" ADD CONSTRAINT "oauth_client_token_pkey" PRIMARY KEY ("authentication_id");

-- ----------------------------
-- Primary Key structure for table payment
-- ----------------------------
ALTER TABLE "public"."payment" ADD CONSTRAINT "pk_payment" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table product
-- ----------------------------
ALTER TABLE "public"."product" ADD CONSTRAINT "pk_product" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table product_detials
-- ----------------------------
ALTER TABLE "public"."product_detials" ADD CONSTRAINT "pk_product_detials" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table purchase
-- ----------------------------
ALTER TABLE "public"."purchase" ADD CONSTRAINT "pk_purchase" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table shipping
-- ----------------------------
ALTER TABLE "public"."shipping" ADD CONSTRAINT "pk_shipping" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table stock_details
-- ----------------------------
ALTER TABLE "public"."stock_details" ADD CONSTRAINT "pk_stock_details" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table stock_in
-- ----------------------------
ALTER TABLE "public"."stock_in" ADD CONSTRAINT "pk_stock_in" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table transaction
-- ----------------------------
ALTER TABLE "public"."transaction" ADD CONSTRAINT "pk_transaction" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table transaction_details
-- ----------------------------
ALTER TABLE "public"."transaction_details" ADD CONSTRAINT "pk_transaction_details" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table user_
-- ----------------------------
ALTER TABLE "public"."user_" ADD CONSTRAINT "user_user_name" UNIQUE ("user_name");

-- ----------------------------
-- Primary Key structure for table user_
-- ----------------------------
ALTER TABLE "public"."user_" ADD CONSTRAINT "user__pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_info
-- ----------------------------
ALTER TABLE "public"."user_info" ADD CONSTRAINT "user_info_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_info_details
-- ----------------------------
ALTER TABLE "public"."user_info_details" ADD CONSTRAINT "user_info_details_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table users_authorities
-- ----------------------------
ALTER TABLE "public"."users_authorities" ADD CONSTRAINT "users_authorities_pkey" PRIMARY KEY ("user_id", "authority_id");

-- ----------------------------
-- Foreign Keys structure for table users_authorities
-- ----------------------------
ALTER TABLE "public"."users_authorities" ADD CONSTRAINT "users_authorities_authority" FOREIGN KEY ("authority_id") REFERENCES "public"."authority" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."users_authorities" ADD CONSTRAINT "users_authorities_user_" FOREIGN KEY ("user_id") REFERENCES "public"."user_" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
