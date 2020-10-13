-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/MTT7P8
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.


CREATE TABLE "import_product" (
    "id" int   NOT NULL,
    "product_id" int   NOT NULL,
    "vendor_id" int   NOT NULL,
    "qty" int   NOT NULL,
    "unit_price" int   NOT NULL,
    "discount" int   NOT NULL,
    "currency_code" varchar(10)   NOT NULL,
    "status" varchar(8)   NOT NULL,
    "create_date" varchar(8)   NOT NULL,
    "create_by" int   NOT NULL,
    "modify_date" varchar(8)   NOT NULL,
    "modify_by" int   NOT NULL,
    CONSTRAINT "pk_import_product" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "stock_details" (
    "id" int   NOT NULL,
    "import_product_id" int   NOT NULL,
    "product_id" int   NOT NULL,
    "stock_in_id" in   NOT NULL,
    "unit_qty" int   NOT NULL,
    "unit_price" int   NOT NULL,
    "unit_discount" int   NOT NULL,
    "to_stock_in_qty" int   NOT NULL,
    "qty" int   NOT NULL,
    "profit_rate" int   NOT NULL,
    "price" int   NOT NULL,
    "status" varchar(10)   NOT NULL,
    "create_date" varchar(8)   NOT NULL,
    "create_by" int   NOT NULL,
    "modify_date" varchar(8)   NOT NULL,
    "modify_by" int   NOT NULL,
    CONSTRAINT "pk_stock_details" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "stock_in" (
    "id" int   NOT NULL,
    "product_id" int   NOT NULL,
    "qty" int   NOT NULL,
    "price" decimal(102)   NOT NULL,
    "discount" decimal(22)   NOT NULL,
    "profit_rate" decimal(22)   NOT NULL,
    "status" varchar(8)   NOT NULL,
    "create_date" varchar(8)   NOT NULL,
    "create_by" int   NOT NULL,
    "modify_date" varchar(8)   NOT NULL,
    "modify_by" int   NOT NULL,
    CONSTRAINT "pk_stock_in" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "transaction" (
    "id" int   NOT NULL,
    "product_id" int   NOT NULL,
    "qty" int   NOT NULL,
    "price" decimal(42)   NOT NULL,
    "discount" deciaml(22)   NOT NULL,
    "total" decimal(42)   NOT NULL,
    "status" varchar(8)   NOT NULL,
    "create_date" varchar(8)   NOT NULL,
    "create_by" int   NOT NULL,
    "modify_date" varchar(8)   NOT NULL,
    "modify_by" int   NOT NULL,
    CONSTRAINT "pk_transaction" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "transaction_details" (
    "id" int   NOT NULL,
    "transaction_id" int   NOT NULL,
    "stock_in_id" int   NOT NULL,
    "create_date" varchar(8)   NOT NULL,
    CONSTRAINT "pk_transaction_details" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "shipping" (
    "id" int   NOT NULL,
    "first_name" varchar(50)   NOT NULL,
    "last_name" varchar(50)   NOT NULL,
    "address_line1" varchar(225)   NOT NULL,
    "address_line2" varchar(225)   NOT NULL,
    "country" varchar(80)   NOT NULL,
    "state" varchar(80)   NOT NULL,
    "city" varchar(100)   NOT NULL,
    "postal_code" varchar(50)   NOT NULL,
    "phone_number" varchar(50)   NOT NULL,
    "status" varchar(10)   NOT NULL,
    "create_date" varchar(8)   NOT NULL,
    "modify_date" varchar(8)   NOT NULL,
    CONSTRAINT "pk_shipping" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "purchase" (
    "id" int   NOT NULL,
    "transaction_details_id" int   NOT NULL,
    "customer_id" int   NOT NULL,
    "shipping_id" int   NOT NULL,
    "amount" decimal(42)   NOT NULL,
    "free" decimal(22)   NOT NULL,
    "status" varchar(8)   NOT NULL,
    "create_date" varchar(8)   NOT NULL,
    "error_code" varchar(8)   NOT NULL,
    "error_message" varchar(225)   NOT NULL,
    "approval_code" varchar(10)   NOT NULL,
    "approval_status" varchar(10)   NOT NULL,
    "pg_code" varchar(10)   NOT NULL,
    "pg_error_message" varchar(225)   NOT NULL,
    "pg_approval_code" varchar(225)   NOT NULL,
    CONSTRAINT "pk_purchase" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "payment" (
    "id" int   NOT NULL,
    "purchase_id" int   NOT NULL,
    "customer_id" int   NOT NULL,
    "user_id" int   NOT NULL,
    "payment_id" varchar(225)   NOT NULL,
    "approval_status" varchar(10)   NOT NULL,
    "create_date" varchar(8)   NOT NULL,
    "create_by" int   NOT NULL,
    "modify_date" varchar(8)   NOT NULL,
    "modify_by" int   NOT NULL,
    CONSTRAINT "pk_payment" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "customer" (
    "id" int   NOT NULL,
    "first_name" varchar(50)   NOT NULL,
    "last_name" varchar(50)   NOT NULL,
    "birth_date" varchar(8)   NOT NULL,
    "contact" varchar(50)   NOT NULL,
    "email" varchar(50)   NOT NULL,
    "status" varchar(8)   NOT NULL,
    "create_date" varchar(8)   NOT NULL,
    "create_by" int   NOT NULL,
    "modify_date" varchar(8)   NOT NULL,
    "modify_by" int   NOT NULL,
    CONSTRAINT "pk_customer" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "user" (
    "id" int   NOT NULL,
    "first_name" varchar(50)   NOT NULL,
    "last_name" varchar(50)   NOT NULL,
    "birth_date" varchar(8)   NOT NULL,
    "contact" varchar(50)   NOT NULL,
    "email" varchar(50)   NOT NULL,
    "status" varchar(8)   NOT NULL,
    "create_date" varchar(8)   NOT NULL,
    "create_by" int   NOT NULL,
    "modify_date" varchar(8)   NOT NULL,
    "modify_by" int   NOT NULL,
    CONSTRAINT "pk_user" PRIMARY KEY (
        "id"
     )
);

ALTER TABLE "stock_details" ADD CONSTRAINT "fk_stock_details_import_product_id" FOREIGN KEY("import_product_id")
REFERENCES "import_product" ("id");

ALTER TABLE "stock_in" ADD CONSTRAINT "fk_stock_in_id" FOREIGN KEY("id")
REFERENCES "stock_details" ("stock_in_id");

ALTER TABLE "transaction_details" ADD CONSTRAINT "fk_transaction_details_id" FOREIGN KEY("id")
REFERENCES "purchase" ("transaction_details_id");

ALTER TABLE "transaction_details" ADD CONSTRAINT "fk_transaction_details_transaction_id" FOREIGN KEY("transaction_id")
REFERENCES "transaction" ("id");

ALTER TABLE "transaction_details" ADD CONSTRAINT "fk_transaction_details_stock_in_id" FOREIGN KEY("stock_in_id")
REFERENCES "stock_in" ("id");

ALTER TABLE "shipping" ADD CONSTRAINT "fk_shipping_id" FOREIGN KEY("id")
REFERENCES "purchase" ("shipping_id");

ALTER TABLE "purchase" ADD CONSTRAINT "fk_purchase_id" FOREIGN KEY("id")
REFERENCES "payment" ("purchase_id");

ALTER TABLE "customer" ADD CONSTRAINT "fk_customer_id" FOREIGN KEY("id")
REFERENCES "purchase" ("customer_id");

ALTER TABLE "user" ADD CONSTRAINT "fk_user_id" FOREIGN KEY("id")
REFERENCES "payment" ("user_id");

