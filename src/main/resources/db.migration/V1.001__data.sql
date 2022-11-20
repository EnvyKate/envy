insert into crm.staff (id,uuid,name,hire_date)
values (1, 'bf2822ae-cc62-4599-95e8-bf227cadc3cf', 'Иванов Иван Иванович', '2022-01-01'),
       ();

insert into crm.customer(id,uuid,name,phone_number)
values (1,'bf2822ae-cc62-4599-95e8-bf227cadc3cf', 'Иванова', '+34246820389524'),
       ();

insert into crm.qualification(id,uuid,name,salary_rate)
values (1,'bf2822ae-cc62-4599-95e8-bf227cadc3cf', 'Тик-Токарь', 100);

insert into crm.procedure(id,uuid,name,description,duration)
values (1,'bf2822ae-cc62-4599-95e8-bf227cadc3cf', 'Обрезание', 'Берем нож и обрезаем все что висит', 10);

insert into crm.procedure_price(id,uuid,procedure_id,qualification_id,price,discount_available)
values (1,'bf2822ae-cc62-4599-95e8-bf227cadc3cf',1,1,100,true),
       ();

insert into crm.visit(id,uuid,staff_id,customer_id,procedure_id,visit_time)
values (1,'bf2822ae-cc62-4599-95e8-bf227cadc3cf',1,1,1,'2020-01-01 00:00:00'),
       ();

insert into crm.discount(id,uuid,payment_threshold,discount_value)
values (1,'bf2822ae-cc62-4599-95e8-bf227cadc3cf', 10000, 0.85 ),
       ();