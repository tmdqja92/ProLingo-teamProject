--PROLINGO_BOARD					
DROP TABLE	PROLINGO_BOARD	;			
CREATE TABLE	PROLINGO_BOARD	(			
BOARD_ID	NUMBER	PRIMARY KEY		,	--게시글 아이디
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--멤버 아이디
TITLE	VARCHAR2(100)		NOT NULL	,	--글 제목
BOARD_CONTENT	VARCHAR2(2000)		NOT NULL	,	--글 내용
WRITINGDATE	DATE	DEFAULT SYSDATE	NOT NULL	,	--작성 날짜
EDITDATE	DATE	DEFAULT SYSDATE	NOT NULL	,	--수정 날짜
HITS	NUMBER	DEFAULT '0'	NOT NULL	,	--조회수
LIKES	NUMBER	DEFAULT '0'	NOT NULL	,	--추천
DISLIKES	NUMBER	DEFAULT '0'	NOT NULL	,	--비추천
ORIGINALFILE	VARCHAR2(200)			,	--원본 파일 이름
SAVEDFILE	VARCHAR2(200)			);	--서버에 저장된 파일 이름
					
--PROLINGO_BOARD_SEQ					
DROP SEQUENCE	PROLINGO_BOARD_SEQ	;			
CREATE SEQUENCE	PROLINGO_BOARD_SEQ	;			
					
--PROLINGO_REPLY					
DROP TABLE	PROLINGO_REPLY	;			
CREATE TABLE	PROLINGO_REPLY	(			
REPLY_ID	NUMBER	PRIMARY KEY		,	--댓글 아이디
REPLY_CONTENT	VARCHAR2(600)		NOT NULL	,	--댓글 내용
BOARD_ID	NUMBER	REFERENCES PROLINGO_BOARD(BOARD_ID)	ON DELETE CASCADE	,	--댓글이 작성된 게시글 아이디
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--댓글을 작성한 유저 아이디
TARGET_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--대댓 대상
WRITINGDATE	DATE	DEFAULT 'SYSDATE'	NOT NULL	);	--댓글 작성 날짜
					
--PROLINGO_REPLY_SEQ					
DROP SEQUENCE	PROLINGO_REPLY_SEQ	;			
CREATE SEQUENCE	PROLINGO_REPLY_SEQ	;			
					
--PROLINGO_ACHIEVEMENT					
DROP TABLE	PROLINGO_ACHIEVEMENT	;			
CREATE TABLE	PROLINGO_ACHIEVEMENT	(		--시퀀스 필요하면 만드는걸로	
ACHIEVEMENT_ID	NUMBER	PRIMARY KEY	,	--업적 아이디	
ACHIEVEMENT_NAME	VARCHAR2(100)	NOT NULL	,	--업적 이름	
ACHIEVEMENT_TEXT	VARCHAR2(1000)	NOT NULL	);	--업적 내용	
					
--USER_ACHIEVE					
DROP TABLE	USER_ACHIEVE	;			
CREATE TABLE	USER_ACHIEVE	(			
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--유저 아이디
ACHIEVEMENT_ID	NUMBER	REFERENCES PROLINGO_ACHIEVEMENT(ACHIEVEMENT_ID)	ON DELETE CASCADE	,	--달성한 업적 아이디
PRIMARY KEY(USER_ID, ACHIEVEMENT_ID)				);	--복합키

COMMIT;