INSERT INTO status (text) VALUES ('UNTOUCHED');
INSERT INTO status (text) VALUES ('STARTED');
INSERT INTO status (text) VALUES ('STOPPED');
INSERT INTO status (text) VALUES ('FINISHED');
INSERT INTO status (text) VALUES ('ABANDONED');

INSERT INTO tag (text) VALUES ('JAVA');
INSERT INTO tag (text) VALUES ('SPRING');
INSERT INTO tag (text) VALUES ('BOOT');

INSERT INTO book (title,path,status) VALUES ('JAVA BOOT ONE','SOME/PATH/ONE',1);
INSERT INTO book (title,path,status) VALUES ('SPRING BOOT TWO','SOME/PATH/TWO',2);

INSERT INTO book_status (bid,sid) VALUES (1,1);
INSERT INTO book_status (bid,sid) VALUES (2,2);

INSERT INTO book_tag (bid,tid) VALUES (1,1);
INSERT INTO book_tag (bid,tid) VALUES (1,3);
INSERT INTO book_tag (bid,tid) VALUES (2,2);
INSERT INTO book_tag (bid,tid) VALUES (2,3);