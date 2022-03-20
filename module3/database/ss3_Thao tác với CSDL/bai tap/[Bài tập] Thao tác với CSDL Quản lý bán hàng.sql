use quan_li_ban_hang;
select * from customer;
insert into customer values
(1,"Minh Quan",10),
(2,"Ngoc Oanh",20),
(3,"Hong Ha",50);
select * from `order`;
insert into `order` values 
(1,"2006-3-21",null,1),
(2,"2006-3-23",null,2),
(3,"2006-3-16",null,1);

select * from product;
insert into product values 
(1,"May Giat",3),
(2,"Tu Lanh",5),
(3,"Dieu Hoa",7),
(4,"Quat",1),
(5,"Bep Dien",2);
select * from orderdetail;
SET FOREIGN_KEY_CHECKS=0;
insert into orderdetail values
 (1,1,3),
 (1,3,7),
 (1,4,2),
 (2,1,1),
 (3,1,8),
 (2,5,4),
 (2,3,3);
	-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
    select oid,odate,ototalprice from `order`;
	-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
    select customer.cid,customer.cname,product.pname from customer 
	inner join `order` on customer.cid=`order`.cid
	inner join OrderDetail on `order`.oid=OrderDetail.oid
	inner join Product on Product.pid=OrderDetail.pid;
	-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
     select * from customer 
	 where customer.cid  not in
     (select customer.cid from customer
     inner join `order` on customer.cid=`order`.cid);
	-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa
	-- đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
	-- Giá bán của từng loại được tính = odQTY*pPrice)
    select OrderDetail.oid,`order`.odate,sum(OrderDetail.odQTY*product.pprice) as "oTotalPrice"
    from customer 
    inner join  `order` on customer.cid=`order`.cid
    inner join  OrderDetail on OrderDetail.oid=`order`.oid
    inner join  product on OrderDetail.pid=product.pid
    group by OrderDetail.oid;
    
    
