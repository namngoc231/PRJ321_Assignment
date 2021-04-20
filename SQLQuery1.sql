CREATE DATABASE Project
GO
USE Project
GO

/* create Categories for cats*/
CREATE TABLE Categories 
(
	cid INT PRIMARY KEY IDENTITY,
	cname NVARCHAR(MAX) NOT NULL
)
/* create information for cats*/
CREATE TABLE Products
(
	pid INT PRIMARY KEY IDENTITY,
	pname NVARCHAR(max) NOT NULL,
	pprice FLOAT NOT NULL,
	pshortdesc NVARCHAR(max) NOT NULL,
	pdesc NVARCHAR(max) NOT NULL,
	pthumbnail VARCHAR(max) NOT NULL,
	cid INT FOREIGN KEY REFERENCES dbo.Categories(cid)
)
/*set data for Mèo Anh*/
DECLARE @cnt INT = 1;
WHILE (@cnt <= 10)
BEGIN
	INSERT INTO dbo.Products
	        (pname , pprice , pshortdesc , pdesc , pthumbnail, cid)
	VALUES  (
	          N'Mèo Anh ' + CAST(@cnt AS NVARCHAR(MAX)) , -- pname - nvarchar(max)
	          199.99 , -- pprice - float
	          N'<p>British Shorthair (hay còn gọi là Mèo Anh lông ngắn) là giống mèo cổ xưa của Vương quốc Anh. Với thân hình mũm mím, cái đầu và đôi mắt tròn xoe màu hổ phách, mèo Aln dễ dàng “đốn tim” bạn ngay từ lần đầu gặp mặt.</p>' , -- pshortdesc - nvarchar(max)
	          N'<p><strong>Mèo Anh lông ngắn</strong> (tên tiếng Anh là British shorthair, gọi tắt: mèo ALN). Mèo Anh lông ngắn ALN được du nhập vào Việt Nam vào khoảng những năm 2008 – 2010. Với đôi mắt to tròn màu hổ phách, thân hình mập mạp dễ thương, mèo lông ngắn Anh là giống mèo cảnh được ưa chuộng và nuôi phổ biến nhất hiện nay. Trong bài viết này, chúng tôi sẽ giới thiệu các thông tin cơ bản về đặc điểm, nguồn gốc, cách nuôi, chăm sóc huấn luyện mèo Aln. Bảng giá và các địa chỉ mua bán mèo Anh lông ngắn của Dogily Pet Shop ở Tphcm và Hà Nội. Mời các bạn cùng đón đọc nhé.</p>' , -- pdesc - nvarchar(max)
	          'assets/img/1-full.jpg' , -- pthumbnail - varchar(max)
	          1  -- cid - int
	        );
	SET @cnt = @cnt + 1;
END

/*set data for Mèo Ba Tư*/
DECLARE @cnt INT = 11;
WHILE (@cnt <= 50)
BEGIN
	INSERT INTO dbo.Products
	        (pname , pprice , pshortdesc , pdesc , pthumbnail, cid)
	VALUES  (
	          N'Mèo Ba Tư ' + CAST(@cnt AS NVARCHAR(MAX)) , -- pname - nvarchar(max)
	          99.99 , -- pprice - float
	          N'<p> <i>Mèo Ba Tư</i> là một trong những giống mèo cảnh được đông đảo người yêu mèo yêu mến, lựa chọn làm thú cưng trong gia đình. Sở dĩ như vậy là do ngoại hình của chúng mập mạp, đáng yêu với bộ lông vô cùng quyến rũ. Mặc dù giống mèo này chăm sóc khó khăn hơn so với những giống mèo cảnh khác nhưng do ngoại hình quá đẹp và thu hút nên ở nước ta rất nhiều bạn vẫn săn đón mèo Ba Tư. Chính vì thế, trong bài viết này, Petroom sẽ cập nhật đến bạn đầy đủ thông tin về nguồn gốc, những đặc điểm tính cách, ngoại hình cũng như cách nuôi và giá bán mèo Ba Tư.</p>' , -- pshortdesc - nvarchar(max)
	          N'<p>Ngay từ cái tên đã thể hiện xuất xứ của giống mèo này, <strong>mèo Ba Tư</strong> có nguồn gốc từ vương quốc Ba Tư cổ đại, ngày nay là đất nước Iran. Giống mèo này được coi là loài mèo bản địa tại Iran, chúng được phát hiện, chăm sóc và nuôi dưỡng bởi người dân Iran từ khá sớm. Về sau này, mèo Ba Tư đã được người Anh mang về quốc gia để nhân giống và kể từ đó, loài mèo Ba Tư phát triển mạnh mẽ, ngày càng trở nên phổ biến ở các nước Châu Âu.</p><p>Đặc biệt, vào khoảng thế kỷ XVII, nhờ vẻ ngoài cực kỳ kiêu sa, quyến rũ, mèo Ba Tư còn là một trong những thú cưng yêu thích nhất của nữ hoàng Anh. Hiện nay, thị trường có nhiều chủng loại, giống mèo Ba Tư đến từ khắp nơi trên thế giới. Tuy nhiên, những chú mèo thuần chủng Ba Tư vẫn sở hữu ngoại hình nổi trội và được yêu thích hơn cả.&nbsp;</p>' , -- pdesc - nvarchar(max)
	          'assets/img/2-full.jpg' , -- pthumbnail - varchar(max)
	          2  -- cid - int
	        );
	SET @cnt = @cnt + 1;
END

WITH r AS (SELECT ROW_NUMBER() OVER (ORDER BY pid DESC) rownum, pid, pname, pprice, pthumbnail FROM dbo.Products WHERE cid = ?) 
SELECT * FROM r WHERE r.rownum >= (? - 1) * ? + 1 AND r.rownum <= ? * ?

SELECT COUNT(*) total FROM dbo.Products WHERE cid = 1

WITH r AS (SELECT ROW_NUMBER() OVER (ORDER BY pid DESC) rownum, pid, pname, pprice, pthumbnail FROM dbo.Products) 
SELECT * FROM r WHERE r.rownum >= (? - 1) * ? + 1 AND r.rownum <= ? * ?


SELECT ROW_NUMBER() OVER (ORDER BY pid DESC) rownum, pid, pname, pprice, pthumbnail FROM dbo.Products WHERE pname LIKE ?
SELECT p.*, c.cname FROM dbo.Products p INNER JOIN dbo.Categories c ON c.cid = p.cid WHERE pid = ?

SELECT TOP 4 * FROM dbo.Products ORDER BY pid DESC

/*create user*/
CREATE TABLE Users
(
	uid INT PRIMARY KEY IDENTITY,
	fullName NVARCHAR(150) NOT NULL,
	address NVARCHAR(MAX) NOT NULL,
	userName VARCHAR(150) NOT NULL UNIQUE,
	password VARCHAR(150) NOT NULL,
	email VARCHAR(150) NOT NULL UNIQUE,
	phoneNumber VARCHAR(150) NOT NULL UNIQUE,
)

SELECT * FROM dbo.Users WHERE userName = ? AND password = ?

INSERT INTO dbo.Users(fullName, address, userName, password, email, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)

WITH r AS (SELECT ROW_NUMBER() OVER (ORDER BY pid DESC) rownum, pid, pname, pprice, pthumbnail FROM dbo.Products WHERE cid = 1) 
SELECT * FROM r WHERE r.rownum >= (1 - 1) * 6 + 1 AND r.rownum <= 1 * 6