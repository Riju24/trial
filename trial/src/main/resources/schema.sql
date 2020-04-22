create table USER (
			id varchar(4) primary key,
			name varchar(50) not null,
			password varchar(20) not null
		);
					
insert into user ('1000','JPP','Jp@1234');
insert into user ('1234','ABCD','Ab@1234');
insert into user ('2345','BS','bs@1234');
insert into user ('1478','ASDF','As@1234');

Select * from user;
