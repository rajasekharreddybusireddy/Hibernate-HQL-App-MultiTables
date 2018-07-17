# Hibernate-HQL-App-MultiTables
This application contains HQL queries to retrieve data from multiple using joins

#Create Below Tables in Database before executing the application

#Change Database credentials in hibernate.cfg.xml

--Create Authors_tbl
CREATE TABLE AUTHORS_TBL
  (
    author_id    NUMBER(10) NOT NULL,
    AUTHOR_NAME  VARCHAR2(50) NOT NULL,
    AUTHOR_EMAIL VARCHAR2(50),
    PRIMARY KEY(author_id)
  );
  
  
#Create Book_tbl
CREATE TABLE BOOK_TBL
  (
    BOOK_ID    NUMBER(10) NOT NULL,
    BOOK_NAME  VARCHAR2(50) NOT NULL,
    BOOK_PRICE number(10,2),
    author_id number(10),
    PRIMARY KEY (BOOK_ID),
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES       AUTHORS_TBL(AUTHOR_ID)
  );

#Inserting data into authors_tbl
insert into authors_tbl values(101,'Rod Johnson','rjohn@in.com'); 
insert into authors_tbl values(102,'Gaven King','gavenk@in.com');
insert into authors_tbl values(103,'Cathie Sierra','csr@in.com');  

#Inserting data into book_tbl
insert into book_tbl values(201,'Spring',1000.00,101);
insert into book_tbl values(202,'Hibernate',600.00,102);
insert into book_tbl values(203,'Spring Boot',1200.00,101);
insert into book_tbl values(204,'JPA',500.00,102);
insert into book_tbl values(205,'JSE',160.00,103);
