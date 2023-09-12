INSERT INTO UserTable (ID, Name, Email)
VALUES('6bd469de-0f57-44fc-96fc-8db56187c094', 'Prod User 1', 'pu1@email.com');

INSERT INTO UserTable (ID, Name, Email)
VALUES('6bd469de-0f57-44fc-96fc-8db56134c094', 'Prod User 2', 'pu2@email.com');

INSERT INTO UserTable (ID, Name, Email)
VALUES('6bd469de-0f57-44fc-96fc-8db12187c094', 'Prod User 3', 'pu3@email.com');

INSERT INTO Questions (ID, Author, Content)
VALUES('6bd434de-0f57-44fc-96fc-8db12187c094', '6bd469de-0f57-44fc-96fc-8db56187c094', 'Question 1')
;

INSERT INTO Answers (ID, Question, Author, Content)
VALUES('6bd341de-0f57-44fc-96fc-8db12187c094', '6bd434de-0f57-44fc-96fc-8db12187c094',
'6bd469de-0f57-44fc-96fc-8db56134c094', 'Answer 1');

INSERT INTO Upvotes (ID, Answer, AnswerAuthor, Author)
VALUES('6bd341de-0f57-99fc-97fc-8db12187c094', '6bd341de-0f57-44fc-96fc-8db12187c094',
'6bd469de-0f57-44fc-96fc-8db56134c094', '6bd469de-0f57-44fc-96fc-8db12187c094');
