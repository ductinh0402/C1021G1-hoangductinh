create database demo;
use demo;
create table products(
id int primary key auto_increment,
product_code varchar(45),
product_name varchar(45),
product_price double not null , 
product_amounts int not null, 
product_description text, 
product_status varchar(45)
);
insert into products(product_code,product_name,product_price,product_amounts,product_description,product_status) 
values ("DT001","IPHONE XS",10000000,100,"Có camara siêu rõ nét,...","100%"),
       ("DT002","IPHONE XSMAX",15000000,50,"Có camara siêu rõ nét,...","100%"),
       ("DT003","NOKIA",8000000,70,"Có camara siêu rõ nét,...","99%"),
       ("DT004","SAMSUNG A9",12000000,80,"Có camara siêu rõ nét,...","99%"),
       ("DT005","ASUS",20000000,10,"Có camara siêu rõ nét,...","100%"),
       ("DT006","VIETTELL",5000000,100,"Nghe gọi tẹc ga,...","80%");
explain select * from products where product_code="DT006";
create index products_code on products(product_code);
explain select * from products where product_name="ASUS";
explain select * from products where product_price="20000000" and  product_name="ASUS";
drop index products_code on products;
create index name_product_price on products(product_name,product_price);
drop index name_product_price on products;
create view products_view as select product_code,product_name,product_price,product_status from products;
select * from products_view;
update products_view set  product_name="NOKIA 1200" where product_code="DT003";
drop view  products_view;
 
delimiter //
create procedure all_products()
begin
select * from products;
end //
delimiter ;
call all_products();

delimiter //
create procedure add_products(
product_code varchar(45),
product_name varchar(45),
product_price double  , 
product_amounts int , 
product_description text, 
product_status varchar(45))
begin
insert into products(product_code,product_name,product_price,product_amounts,product_description,product_status) values (product_code,product_name,product_price,product_amounts,product_description,product_status);
end //
delimiter ;
call add_products("DT008","Mobile",500000,200,"Nghe gọi bền bỉ theo thời gian.","100%");
drop procedure add_products;
delimiter //
create procedure update_products(product_id int,
products_code varchar(45),
products_name varchar(45),
products_price double  , 
products_amounts int , 
products_description text, 
products_status varchar(45))
begin
update products set id=product_id,product_code=products_code,product_name=products_name,product_price=products_price,
product_amounts=products_amounts,product_description=products_description,product_status=products_status
 where id=product_id;
end //
delimiter ;
call update_products(9,"DT008","Mobile",500000,200,"Sang khoái.","100%");

delimiter //
create procedure delete_products(product_id int)
begin
delete from products where products.id=product_id;
end //
delimiter ;
call delete_products(7);
