select * from book_2604;

create table book_2604
 (BOOK_ID number(5), 
  BOOK_TITLE VARCHAR(20), 
  PUBLISH_DATE date);
  
insert into book_2604(BOOK_ID,BOOK_TITLE,PUBLISH_DATE)values( 100, 'c programming','11-sep-2018');
insert into book_2604(BOOK_ID,BOOK_TITLE,PUBLISH_DATE)values( 101, 'java basics','01-sep-2019');
insert into book_2604(BOOK_ID,BOOK_TITLE,PUBLISH_DATE)values( 102, 'unix fundamentals','31-dec-2020');
insert into book_2604(BOOK_ID,BOOK_TITLE,PUBLISH_DATE)values( 103, 'data structure','24-jun-2015');
commit;