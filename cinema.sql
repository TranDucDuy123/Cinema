-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 08, 2024 lúc 08:19 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cinema`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `created_time` datetime(6) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `discount_amount` double NOT NULL,
  `final_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`id`, `created_time`, `user_id`, `price`, `discount_amount`, `final_price`) VALUES
(83, '2022-09-10 13:05:22.492430', 4, 0, 0, 0),
(84, '2022-09-10 13:07:01.371025', 29, 0, 0, 0),
(86, '2022-09-10 15:04:56.811110', 51, 0, 0, 0),
(87, '2022-09-10 15:05:46.654983', 4, 0, 0, 0),
(90, '2024-09-08 23:07:27.000000', 29, 500000, 0, 0),
(91, '2024-09-08 23:08:04.000000', 29, 500000, 0, 0),
(92, '2024-09-09 00:49:15.000000', 29, 320000, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `branch`
--

CREATE TABLE `branch` (
  `id` int(11) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `imgurl` varchar(2000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `branch`
--

INSERT INTO `branch` (`id`, `dia_chi`, `imgurl`, `name`, `phone_no`) VALUES
(1, 'Tầng 4, Mê Linh Plaza Hà Đông, Đ. Tô Hiệu, P, Hà Đông, Hà Nội', 'https://www.google.com/maps/vt/data=01jbed2RV46dgYPWYrkUjQ6y9E_UiFnVBsCgIdJWh4TGqJw3K1Qg_A4phqg094CBuRXesGa3QOof0UPRtY3zUWjOKScSn-0JuYoAlbcSKeYWV9wooMdNPaY7iL3Yd9PJjxicmzPKGds-zZRAZ9hqPRix1Trxq2vTQ7GZDWXjNJrqjn2tqL8zO0gSrZgSmarAH0jaD9Ux5tVTaZCwchq2_nNCrs2vjOU7FeXQsPRqfM3jgoYPRe43jeLkd4KGtweeXwUPgV2AeBFj9yTmjBgHSswDBrmGoJkjk-0uRIIO6LCZyMAsSW1p7-gLsUI5nJF6zWCNKmesZ3Jd3I-17zEAOz3AmLMuLkRgiFkICakIuG9B0DkjzVK2P4jN203i4DNkXTpoxKHTMv9dZG-ZoW1A9w7Q5rzSukE8Zdt3GMMei-w-THF-qL3znIiK3nQKq1_BRtnFTvhXduCYpHCo3ZvIiBz4WNKjovXd9ppG-OlRtFLYh8kYvlCKWkO0bmkBeQXoT4mqHQXm80zs_P2CB4xE3bbtoUPgaNo2-5eUcO1CPh6n3DKUdkgOIjRflGoWijmrhJO_45gguPAqZ7ZcXmY_isBf4PnWWJnzO2VAHVQwqwYIJ503CVbm3bmWoX3nVyqThCPj3fFsvjxCH-uYT0VXi3IFc02ktKuirKrsSo2rcgTcTqto0LlmkPAm34wOAr2KmMCfiqJrjKKMCn62v7WefBbU3VLI7Z8pLIgrG4l258FsyN7unVKWcVl3TVnBWp-acw9Y9AmM-nu8OzD7HSpMjJM3X28MJGj9LIIC1WsEdVL0Jhq8x9vBkY9F0RT_XTLQxbIJYa3v0B9x6KlkdOlWqTQTHvc5HQz8OV0JQYp5roWX5WcIx06_gkNOvisnf-J3aeMgzGVGs_-dZUXPwNseutiOPQXyy5NfzhZuJDOAmCJLXEAhmB6BFzFMbATI5zQ9v-D2lDvsjYq2U3Mt7Ctp6HlZVb4DGhzu7FYZkBQ11KkbQthBNKrZQ3kTiVQNNf13Osr9fIK4W6m6R3FtkxqnPshtlc-PYArGqZimsKnxgxxwt1spelowhnI55qFR9wa6UdJgeyGGRfVyfDpFiRKUkwuB7Vip?h=505&w=561&scale=1', 'HUYCINEMA Hà Đông', '0938473826'),
(2, '216 Đ. Võ Văn Ngân, Bình Thọ, Thủ Đức, Thành phố Hồ Chí Minh', 'https://www.google.com/maps/vt/data=TZeUNl_xwzxmDpHYWKkbDv_7amlZzoi4kaRvCEATRTtis3KKxsH0tcFvyiR7Gjt4G3NufaHQaPOcn3pMPNABNgbW2ZoipmmEo6PKNCFhm8CuQbuASrxxaRyviyUG78mD1AVOf1D2fJxIjyEmphS20Wo9dgRW8TJBXekAhiaiGu8g', 'HUYCINEMA Thủ Đức', '1905487'),
(3, '29 P. Liễu Giai, Ngọc Khánh, Ba Đình, Hà Nội 100000', 'https://www.google.com/maps/vt/data=yhfVddn9tdyWNfmuCzyFU_TR8pm30CLi5oeQTFnFB7qV90WT3OL_ETKkEjQjn3j6zlMuz-VSN_AgZRDCghvF5y2JCVivnwi-sOuKKWT4bSEOf0FZ2-nwoNYSRZH--yH_VpazHsQ9huADdpfR_j3ZnNMEfU_hwJXzSef8AcxHTcqA', 'HUYCINEMA Ba Đình', '1900487'),
(4, 'Phạm Hùng, Mỹ Đình, Nam Từ Liêm, Hà Nội', 'https://www.google.com/maps/vt/data=YVeSKtAT_T4Tie7xjlIh8lVV_CPmpsr36ayQG-gTEGBZtEKRSSUuLnFbj1HBbGxrYJUS3T3ib8llvuVuiSE85HJYK54JW899mhPMP0BWDwBch-utK9g-_kUPd2rsaEpMLmwUd3R9SO67_S6eUEcY0SfqeXAfB2p9NizW8eGSgD63', 'HUYCINEMA Phạm Hùng Nguyên', '19007689');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `discounts`
--

CREATE TABLE `discounts` (
  `id` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date NOT NULL,
  `is_active` bit(1) NOT NULL,
  `percentage` double DEFAULT NULL,
  `start_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `discounts`
--

INSERT INTO `discounts` (`id`, `amount`, `code`, `description`, `end_date`, `is_active`, `percentage`, `start_date`) VALUES
(1, 3, '123', 'code 123', '2024-08-31', b'1', 20, '2024-08-07'),
(2, NULL, 'SUMMERSSSS202411', NULL, '2024-08-31', b'1', 20, '2024-06-01'),
(3, 123, '12333', '12', '2024-09-20', b'1', 123, '2024-09-05'),
(4, 132, '123333', '123', '2024-09-28', b'1', 123, '2024-09-12'),
(5, 50000, 'DISCOUNT2024', 'Mã giảm giá cho sự kiện', '2024-12-31', b'1', 10, '2024-01-01'),
(6, 50000, 'DISCOUNT20241', 'Mã giảm giá cho sự kiện', '2024-12-31', b'1', 10, '2024-01-01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `feedbacks`
--

CREATE TABLE `feedbacks` (
  `id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `rated` int(11) NOT NULL,
  `reference_id` int(11) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `feedbacks`
--

INSERT INTO `feedbacks` (`id`, `content`, `rated`, `reference_id`, `type`, `user_id`) VALUES
(1, 'This is a feedback for the web service number 1.', 5, NULL, 'service', 50),
(2, '123', 5, 7, 'movie', 29);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `actors` varchar(255) DEFAULT NULL,
  `categories` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `duration` int(11) NOT NULL,
  `is_showing` int(11) NOT NULL,
  `language` varchar(255) DEFAULT NULL,
  `large_imageurl` varchar(1000) DEFAULT NULL,
  `long_description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rated` varchar(255) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `short_description` varchar(500) DEFAULT NULL,
  `small_imageurl` varchar(1000) DEFAULT NULL,
  `trailerurl` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `movie`
--

INSERT INTO `movie` (`id`, `actors`, `categories`, `director`, `duration`, `is_showing`, `language`, `large_imageurl`, `long_description`, `name`, `rated`, `release_date`, `short_description`, `small_imageurl`, `trailerurl`) VALUES
(1, 'Amy Sedaris, Jeff Goldblum, James Marsden', 'Hoạt Hình', 'Tom McGrath', 105, 1, 'Tiếng Anh với phụ đề tiếng Việt và lồng tiếng Việt', 'https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/r/s/rsz_dr-strange-980x448.jpg', 'Nhóc trùm Ted giờ đây đã trở thành một triệu phú nổi tiếng trong khi Tim lại có một cuộc sống đơn giản bên vợ anh Carol và hai cô con gái nhỏ yêu dấu. Mỗi mùa Giáng sinh tới, cả Tina và Tabitha đều mong được gặp chú Ted nhưng dường như hai anh em nhà Templeton nay đã không còn gần gũi như xưa. Nhưng bất ngờ thay khi Ted lại có màn tái xuất không thể hoành tráng hơn khi đáp thẳng máy bay trực thăng tới nhà Tim trước sự ngỡ ngàng của cả gia đình.', 'Nhóc Trùm: Nối Nghiệp Gia Đình', 'P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG', '2021-12-24', 'Nhóc trùm Ted giờ đây đã trở thành một triệu phú nổi tiếng trong khi Tim lại có một cuộc sống đơn giản bên vợ anh Carol và hai cô con gái nhỏ yêu dấu. Mỗi mùa Giáng sinh tới, cả Tina và Tabitha đều mong được gặp chú Ted', 'https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_boss_baby_2_24.12.2021_1_1_1__1.jpg', 'https://www.youtube.com/embed/Lv8nL2q8yRI'),
(2, 'Tom Hardy, Michelle Williams, Woody Harrelson, Naomie Harris', 'Hành Động, Khoa Học Viễn Tưởng, Phiêu Lưu, Thần thoại', 'Andy Serkis', 100, 1, 'Tiếng Anh - Phụ đề Tiếng Việt', 'https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/b/l/blackpink-rolling_1_.jpg', 'Siêu bom tấn #VENOM: LET THERE BE CARNAGE hứa hẹn trận chiến khốc liệt nhất giữa Venom và kẻ thù truyền kiếp, Carnage.', 'Venom: Đối Mặt Tử Thù', 'C13 - PHIM CẤM KHÁN GIẢ DƯỚI 13 TUỔI', '2021-12-10', 'Siêu bom tấn #VENOM: LET THERE BE CARNAGE hứa hẹn trận chiến khốc liệt nhất giữa Venom và kẻ thù truyền kiếp, Carnage.', 'https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_venom_121121_1__1.jpg', 'https://www.youtube.com/embed/EVWdzVtSh1I'),
(3, 'Keanu Reeves, Carrie-Anne Moss, Yahya Abdul-Mateen II, Jessica Henwick, Jonathan Groff, Neil Patrick Harris, Priyanka Chopra Jonas và Christina Ricci', 'Hành Động, Khoa Học Viễn Tưởng', 'Lana Wachowski', 148, 1, 'Tiếng Anh - Phụ đề Tiếng Việt, Phụ đề Tiếng Hàn', 'https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/b/l/blackpink-rolling_1_.jpg', 'Ma Trận: Hồi Sinh là phần phim tiếp theo rất được trông đợi của loạt phim “Ma Trận” đình đám, đã góp phần tái định nghĩa thể loại phim khoa học viễn tưởng. Phần phim mới nhất này đón chào sự trở lại của cặp đôi Keanu Reeves và Carrie-Anne Moss với vai diễn biểu tượng đã làm nên tên tuổi của họ, Neo và Trinity. Ngoài ra, phim còn có sự góp mặt của dàn diễn viên đầy tài năng gồm Yahya Abdul-Mateen II, Jessica Henwick, Jonathan Groff, Neil Patrick Harris, Priyanka Chopra Jonas và Christina Ricci.', 'Ma Trận: Hồi Sinh', 'C18 - PHIM CẤM KHÁN GIẢ DƯỚI 18 TUỔI', '2021-12-24', 'Sau 20 năm, siêu phẩm ma trận đã trờ lại với người xem, Neo is back! Liệu đây có phải phần kết cho franchise này', 'https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_matrix_4_1__1.jpg', 'https://www.youtube.com/embed/l2UTOJC5Tbk'),
(4, 'Wasabi Mizuta, Megumi Oohara, Yumi Kakazu, Subaru Kimura, Tomokazu Seki', 'Hài, Hoạt Hình', 'Ryuichi Yagi, Takashi Yamazaki', 96, 1, 'Tiếng Nhật - Phụ đề Tiếng Việt; Lồng tiếng', 'https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/d/o/doreamon.jpg', 'Một ngày nọ, Nobita vô tình tìm thấy chú gấu bông cũ, món đồ chơi chất chứa bao kỉ niệm cùng người bà đáng kính. Với khát khao “muốn gặp bà lần nữa”, Nobita đã trở về quá khứ bằng cổ máy thời gian, bất chấp sự phản đối của Doraemon. Dù ngạc nhiên, bà vẫn tin cậu thiếu niên lớn tướng trước mặt mình là cháu mình. Trước nguyện vọng tha thiết “mong được thấy cháu dâu một lần”, chuyến phiêu lưu của Doraemon và Nobita bắt đầu. Nobita muốn cho bà xem đám cưới của mình, nhưng đúng ngày thành hôn với Shizuka, chú rể Nobita lại trốn mất? Jaian và Suneo chạy đôn chạy đáo tìm bạn, còn Shizuka vẫn tin tưởng chờ đợi Nobita. Để thực hiện nguyện vọng của bà, đáp lại niềm tin của gia đình, bạn bà và Shizuka yêu quý, Nobita sẽ cùng Doraemon du hành vượt thời gian. Họ sẽ mang đến cho chúng ta một câu chuyện cảm động đến rơi lệ về quan hệ con người, kết nối giữa quá khứ, hiện tại và tương lai.', 'Doraemon: Ôi Bạn Ơi 2', 'P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG', '2024-05-27', 'Một ngày nọ, Nobita vô tình tìm thấy chú gấu bông cũ, món đồ chơi chất chứa bao kỉ niệm cùng người bà đáng kính. Với khát khao “muốn gặp bà lần nữa”, Nobita đã trở về quá khứ bằng cổ máy thời gian, bất chấp sự phản đối của Doraemon', 'https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_doremon_2_1__1.jpg', 'https://www.youtube.com/embed/GXnOs4Hj8MA'),
(5, 'Ansel Elgort, Rachel Zegler, Ariana DeBose, David Alvarez, Mike Faist, Josh Andrés Rivera, Ana Isabelle, Corey Stoll, Brian d’Arcy James, Rita Moreno', 'Nhạc kịch, Tình cảm', 'Steven Spielberg', 156, 1, 'Tiếng Anh - Phụ đề Tiếng Việt', 'https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/w/s/wss_sneak_980x448.jpg', 'Được đạo diễn bởi đạo diễn gạo cội từng giành giải Oscar Steven Spielberg, cùng kịch bản bởi biên kịch từng giành giải Pulitzer Prize và giải Tony Award, Tony Kushner, “Câu chuyện phía Tây” kể lại câu chuyện tình yêu kinh điển của Tony và Maria, giữa sự giằng xé của tình yêu trẻ tuổi và sự ngăn cấm, thù hằn ở thành phố NewYork những năm 1950.', 'Câu Chuyện Phía Tây', 'C16 - PHIM CẤM KHÁN GIẢ DƯỚI 16 TUỔI', '2021-12-24', '“Câu chuyện phía Tây” kể lại câu chuyện tình yêu kinh điển của Tony và Maria, giữa sự giằng xé của tình yêu trẻ tuổi và sự ngăn cấm, thù hằn ở thành phố NewYork những năm 1950', 'https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_wss_1200x1800__1.jpg', 'https://www.youtube.com/embed/QPvqV71P0Fo'),
(6, 'JISOO, JENNIE, ROSÉ, LISA', 'Phim tài liệu', 'Su Yee Jung, Oh Yoon-Dong', 99, 1, 'Tiếng Hàn - Phụ đề tiếng Việt', 'https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/b/l/blackpink-rolling_1_.jpg', 'Nhóm nhạc nữ được yêu thích toàn cầu, BLACKPINK sẽ kỷ niệm năm thứ 5 hoạt động của nhóm với việc phát hành BLACKPINK THE MOVIE, đây cũng như là món quà đặc biệt dành tặng cho các BLINK— fandom của BLACKPINK — bộ phim sẽ tái hiện một cách sống động những kỷ niệm không thể quên cùng những màn trinh diễn đầy cuồng nhiệt đúng tinh thần lễ hội.', 'BlackPink The Movie', 'P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG', '2021-12-24', 'Nhóm nhạc nữ được yêu thích toàn cầu, BLACKPINK sẽ kỷ niệm năm thứ 5 hoạt động của nhóm với việc phát hành BLACKPINK THE MOVIE', 'https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_blackpink_vie_2_1__1.jpg', 'https://www.youtube.com/embed/Q_rK9UlUN-Q'),
(7, 'Tom Holland, Zendaya, Benedict Cumberbatch, Jacob Batalon, Jon Favreau', 'Hành Động, Phiêu Lưu', 'Jon Watts', 149, 1, 'Tiếng Anh - Phụ đề Tiếng Việt', 'https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/r/s/rsz_dr-strange-980x448.jpg', 'Lần đầu tiên trong lịch sử điện ảnh của Người Nhện, thân phận người hàng xóm thân thiện bị lật mở, khiến trách nhiệm làm một Siêu Anh Hùng xung đột với cuộc sống bình thường và đặt người anh quan tâm nhất vào tình thế nguy hiểm. Khi anh nhờ đến giúp đỡ của Doctor Strange để khôi phục lại bí mật, phép thuật đã gây ra lỗ hổng thời không, giải phóng những ác nhân mạnh mẽ nhất từng đối đầu với Người Nhện từ mọi vũ trụ. Bây giờ, Peter sẽ phải vượt qua thử thách lớn nhất của mình, nó sẽ thay đổi không chỉ tương lai của chính anh mà còn là tương lai của cả Đa Vũ Trụ.', 'Người Nhện: Không Còn Nhà', 'C13 - PHIM CẤM KHÁN GIẢ DƯỚI 13 TUỔI', '2021-12-17', 'Đa vũ trụ được mở ra, những kẻ phản diện nào sẽ trạm chán spidey, cùng đón xem nhá', 'https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/s/n/snwh_poster_bluemontage_4x5fb_1__1.jpg', 'https://www.youtube.com/embed/daHCu_jU5mQ'),
(10, 'gsgs', 'sgsdg', 'sgsg', 100, 1, 'English', 'sgsg', 'dsfg', 'Rừng ', '15', '2024-01-10', 'sdgsg', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Ryssebergen_2012b.jpg/1200px-Ryssebergen_2012b.jpg', '435546'),
(11, 'Quang Tuấn, NSND Kim Xuân, Nam Thư', 'kinh dị', 'Lưu Thành Luân', 120, 1, 'English', 'https://cdn.moveek.com/storage/media/cache/short/657927b0a2639977829433.jpeg', 'Nam về quê để lo đám tang cho bố sau cái chết kinh hoàng của ông, trong khi phải che giấu bạn gái đang mang thai. Nam mơ thấy gia đình bị giết sau khi mai táng bố, và Mít – con chó trắng của gia đình có biểu hiện kì lạ. Ông Quyết, bà Thúy, và bà Liễu thì tin vào thầy cúng, còn Nam nghi ngờ về lò mổ chó truyền thống của gia đình và phải điều tra để giải quyết sự kiện kỳ lạ đang diễn ra.', 'Quỷ Cẩu', '18', '2025-02-13', '- Horror', 'https://cdn.moveek.com/storage/media/cache/short/657927b0a2639977829433.jpeg', 'https://www.youtube.com/watch?v=m1yZFJ1ykw4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `author_name` varchar(255) DEFAULT NULL,
  `content` text NOT NULL,
  `content_1` text DEFAULT NULL,
  `content_2` text DEFAULT NULL,
  `image_file` longtext DEFAULT NULL,
  `news_type` int(11) NOT NULL,
  `published_date` date DEFAULT NULL,
  `title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reset_password_token`
--

CREATE TABLE `reset_password_token` (
  `id` int(11) NOT NULL,
  `expiry_date` datetime(6) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `reset_password_token`
--

INSERT INTO `reset_password_token` (`id`, `expiry_date`, `token`, `user_id`) VALUES
(7, '2024-01-07 17:43:34.919000', 'GDZSKEoyWZKoCVjNcjzG69wS41ZvEU', 4),
(8, '2022-09-10 15:24:16.341000', '9T1PGMgULouRKaYcfalNtHg7K7DXnY', 50),
(9, '2022-09-10 12:03:13.471000', 'z5GJE9hNjl6orKlSqfZLeJzQ1XXgfk', 29);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_CLIENT'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room`
--

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `imgurl` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `total_area` double NOT NULL,
  `branch_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `room`
--

INSERT INTO `room` (`id`, `capacity`, `imgurl`, `name`, `total_area`, `branch_id`) VALUES
(1, 40, 'http://hdradio.vn/upload/hinhanh/Cinema-tong-hop/cinema-thiet-ke/Cinema-kd100/cinema-hdradio.jpg', 'Phòng 101', 80, 4),
(24, 0, 'https://news.samsung.com/vn/samsung-tai-dinh-nghia-trai-nghiem-xem-phim-tai-rap-voi-man-hinh-onyx-cinema-led-moi', 'Phòng 450', 80, 3),
(26, 128, '', '104', 80, 1),
(28, 0, 'http://hdradio.vn/upload/hinhanh/Cinema-tong-hop/cinema-thiet-ke/Cinema-kd100/cinema-hdradio.jpg', '100', 120, 3),
(29, 0, 'http://hdradio.vn/upload/hinhanh/Cinema-tong-hop/cinema-thiet-ke/Cinema-kd100/cinema-hdradio.jpg', '100', 100, 1),
(30, 128, 'http://hdradio.vn/upload/hinhanh/Cinema-tong-hop/cinema-thiet-ke/Cinema-kd100/cinema-hdradio.jpg', '103', 100, 2),
(31, 112, 'http://hdradio.vn/upload/hinhanh/Cinema-tong-hop/cinema-thiet-ke/Cinema-kd100/cinema-hdradio.jpg', '205', 100, 3),
(32, 122, '', '100', 100, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `schedule`
--

CREATE TABLE `schedule` (
  `id` int(11) NOT NULL,
  `price` double NOT NULL,
  `start_date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `branch_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `schedule`
--

INSERT INTO `schedule` (`id`, `price`, `start_date`, `start_time`, `branch_id`, `movie_id`, `room_id`) VALUES
(32, 75000, '2022-09-09', '11:25:00', 3, 4, 24),
(34, 70000, '2022-09-11', '03:50:00', 1, 4, 29),
(35, 75000, '2022-09-11', '10:00:00', 1, 7, 26),
(36, 750000, '2022-09-12', '18:00:00', 1, 5, 26),
(37, 750000, '2022-09-10', '23:50:00', 1, 3, 26),
(38, 70000, '2022-09-10', '16:00:00', 3, 1, 24),
(39, 75000, '2022-09-10', '18:20:00', 1, 2, 29),
(40, 75000, '2022-09-10', '09:15:00', 1, 4, 26),
(41, 70000, '2022-09-12', '21:25:00', 1, 4, 29),
(42, 700000, '2022-10-21', '10:13:00', 4, 7, 1),
(43, 100000, '2024-12-18', '08:46:00', 3, 7, 24),
(44, 100000, '2024-12-26', '22:48:00', 2, 7, 32),
(45, 80000, '2024-11-07', '11:50:00', 1, 3, 26);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `seat`
--

CREATE TABLE `seat` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `room_id` int(11) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `is_vip` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `seat`
--

INSERT INTO `seat` (`id`, `name`, `room_id`, `is_active`, `is_vip`) VALUES
(241, 'A1', 1, b'1', b'0'),
(242, 'A2', 1, b'1', b'0'),
(243, 'A3', 1, b'1', b'0'),
(244, 'A4', 1, b'1', b'0'),
(245, 'A5', 1, b'1', b'0'),
(246, 'A6', 1, b'1', b'0'),
(247, 'A7', 1, b'1', b'0'),
(248, 'A8', 1, b'1', b'0'),
(249, 'A9', 1, b'1', b'0'),
(250, 'A10', 1, b'1', b'0'),
(251, 'A11', 1, b'1', b'0'),
(252, 'A12', 1, b'1', b'0'),
(253, 'A13', 1, b'1', b'0'),
(254, 'A14', 1, b'1', b'0'),
(255, 'A15', 1, b'1', b'0'),
(256, 'A16', 1, b'1', b'0'),
(257, 'B1', 1, b'1', b'0'),
(258, 'B2', 1, b'1', b'0'),
(259, 'B3', 1, b'1', b'0'),
(260, 'B4', 1, b'1', b'0'),
(261, 'B5', 1, b'1', b'0'),
(262, 'B6', 1, b'1', b'0'),
(263, 'B7', 1, b'1', b'0'),
(264, 'B8', 1, b'1', b'0'),
(265, 'B9', 1, b'1', b'0'),
(266, 'B10', 1, b'1', b'0'),
(267, 'B11', 1, b'1', b'0'),
(268, 'B12', 1, b'1', b'0'),
(269, 'B13', 1, b'1', b'0'),
(270, 'B14', 1, b'1', b'0'),
(271, 'B15', 1, b'1', b'0'),
(272, 'B16', 1, b'1', b'0'),
(273, 'C1', 1, b'1', b'0'),
(274, 'C2', 1, b'1', b'0'),
(275, 'C3', 1, b'1', b'1'),
(276, 'C4', 1, b'1', b'1'),
(277, 'C5', 1, b'1', b'1'),
(278, 'C6', 1, b'1', b'1'),
(279, 'C7', 1, b'1', b'1'),
(280, 'C8', 1, b'1', b'1'),
(281, 'C9', 1, b'1', b'1'),
(282, 'C10', 1, b'1', b'1'),
(283, 'C11', 1, b'1', b'1'),
(284, 'C12', 1, b'1', b'1'),
(285, 'C13', 1, b'1', b'1'),
(286, 'C14', 1, b'1', b'1'),
(287, 'C15', 1, b'1', b'0'),
(288, 'C16', 1, b'1', b'0'),
(289, 'D1', 1, b'1', b'0'),
(290, 'D2', 1, b'1', b'0'),
(291, 'D3', 1, b'1', b'1'),
(292, 'D4', 1, b'1', b'1'),
(293, 'D5', 1, b'1', b'1'),
(294, 'D6', 1, b'1', b'1'),
(295, 'D7', 1, b'1', b'1'),
(296, 'D8', 1, b'1', b'1'),
(297, 'D9', 1, b'1', b'1'),
(298, 'D10', 1, b'1', b'1'),
(299, 'D11', 1, b'1', b'1'),
(300, 'D12', 1, b'1', b'1'),
(301, 'D13', 1, b'1', b'1'),
(302, 'D14', 1, b'1', b'1'),
(303, 'D15', 1, b'1', b'0'),
(304, 'D16', 1, b'1', b'0'),
(305, 'E1', 1, b'1', b'0'),
(306, 'E2', 1, b'1', b'0'),
(307, 'E3', 1, b'1', b'1'),
(308, 'E4', 1, b'1', b'1'),
(309, 'E5', 1, b'1', b'1'),
(310, 'E6', 1, b'1', b'1'),
(311, 'E7', 1, b'1', b'1'),
(312, 'E8', 1, b'1', b'1'),
(313, 'E9', 1, b'1', b'1'),
(314, 'E10', 1, b'1', b'1'),
(315, 'E11', 1, b'1', b'1'),
(316, 'E12', 1, b'1', b'1'),
(317, 'E13', 1, b'1', b'1'),
(318, 'E14', 1, b'1', b'1'),
(319, 'E15', 1, b'1', b'0'),
(320, 'E16', 1, b'1', b'0'),
(321, 'F1', 1, b'1', b'0'),
(322, 'F2', 1, b'1', b'0'),
(323, 'F3', 1, b'1', b'1'),
(324, 'F4', 1, b'1', b'1'),
(325, 'F5', 1, b'1', b'1'),
(326, 'F6', 1, b'1', b'1'),
(327, 'F7', 1, b'1', b'1'),
(328, 'F8', 1, b'1', b'1'),
(329, 'F9', 1, b'1', b'1'),
(330, 'F10', 1, b'1', b'1'),
(331, 'F11', 1, b'1', b'1'),
(332, 'F12', 1, b'1', b'1'),
(333, 'F13', 1, b'1', b'1'),
(334, 'F14', 1, b'1', b'1'),
(335, 'F15', 1, b'1', b'0'),
(336, 'F16', 1, b'1', b'0'),
(337, 'G1', 1, b'1', b'0'),
(338, 'G2', 1, b'1', b'0'),
(339, 'G3', 1, b'1', b'1'),
(340, 'G4', 1, b'1', b'1'),
(341, 'G5', 1, b'1', b'1'),
(342, 'G6', 1, b'1', b'1'),
(343, 'G7', 1, b'1', b'1'),
(344, 'G8', 1, b'1', b'1'),
(345, 'G9', 1, b'1', b'1'),
(346, 'G10', 1, b'1', b'1'),
(347, 'G11', 1, b'1', b'1'),
(348, 'G12', 1, b'1', b'1'),
(349, 'G13', 1, b'1', b'1'),
(350, 'G14', 1, b'1', b'1'),
(351, 'G15', 1, b'1', b'0'),
(352, 'G16', 1, b'1', b'0'),
(353, 'H1', 1, b'1', b'0'),
(354, 'H2', 1, b'1', b'0'),
(355, 'H3', 1, b'1', b'1'),
(356, 'H4', 1, b'1', b'1'),
(357, 'H5', 1, b'1', b'1'),
(358, 'H6', 1, b'1', b'1'),
(359, 'H7', 1, b'1', b'1'),
(360, 'H8', 1, b'1', b'1'),
(361, 'H9', 1, b'1', b'1'),
(362, 'H10', 1, b'1', b'1'),
(363, 'H11', 1, b'1', b'1'),
(364, 'H12', 1, b'1', b'1'),
(365, 'H13', 1, b'1', b'1'),
(366, 'H14', 1, b'1', b'1'),
(367, 'H15', 1, b'1', b'0'),
(368, 'H16', 1, b'1', b'0'),
(3921, 'A1', 24, b'1', b'0'),
(3922, 'A2', 24, b'1', b'0'),
(3923, 'A3', 24, b'1', b'0'),
(3924, 'A4', 24, b'1', b'0'),
(3925, 'A5', 24, b'1', b'0'),
(3926, 'A6', 24, b'1', b'0'),
(3927, 'A7', 24, b'1', b'0'),
(3928, 'A8', 24, b'1', b'0'),
(3929, 'A9', 24, b'1', b'0'),
(3930, 'A10', 24, b'1', b'0'),
(3931, 'A11', 24, b'1', b'0'),
(3932, 'A12', 24, b'1', b'0'),
(3933, 'A13', 24, b'1', b'0'),
(3934, 'A14', 24, b'1', b'0'),
(3935, 'A15', 24, b'1', b'0'),
(3936, 'A16', 24, b'1', b'0'),
(3937, 'B1', 24, b'1', b'0'),
(3938, 'B2', 24, b'1', b'0'),
(3939, 'B3', 24, b'1', b'0'),
(3940, 'B4', 24, b'1', b'0'),
(3941, 'B5', 24, b'1', b'0'),
(3942, 'B6', 24, b'1', b'0'),
(3943, 'B7', 24, b'1', b'0'),
(3944, 'B8', 24, b'1', b'0'),
(3945, 'B9', 24, b'1', b'0'),
(3946, 'B10', 24, b'1', b'0'),
(3947, 'B11', 24, b'1', b'0'),
(3948, 'B12', 24, b'1', b'0'),
(3949, 'B13', 24, b'1', b'0'),
(3950, 'B14', 24, b'1', b'0'),
(3951, 'B15', 24, b'1', b'0'),
(3952, 'B16', 24, b'1', b'0'),
(3953, 'C1', 24, b'1', b'0'),
(3954, 'C2', 24, b'1', b'0'),
(3955, 'C3', 24, b'1', b'0'),
(3956, 'C4', 24, b'1', b'0'),
(3957, 'C5', 24, b'1', b'0'),
(3958, 'C6', 24, b'1', b'0'),
(3959, 'C7', 24, b'1', b'0'),
(3960, 'C8', 24, b'1', b'0'),
(3961, 'C9', 24, b'1', b'0'),
(3962, 'C10', 24, b'1', b'0'),
(3963, 'C11', 24, b'1', b'0'),
(3964, 'C12', 24, b'1', b'0'),
(3965, 'C13', 24, b'1', b'0'),
(3966, 'C14', 24, b'1', b'0'),
(3967, 'C15', 24, b'1', b'0'),
(3968, 'C16', 24, b'1', b'0'),
(3969, 'D1', 24, b'1', b'0'),
(3970, 'D2', 24, b'1', b'0'),
(3971, 'D3', 24, b'1', b'0'),
(3972, 'D4', 24, b'1', b'0'),
(3973, 'D5', 24, b'1', b'1'),
(3974, 'D6', 24, b'1', b'1'),
(3975, 'D7', 24, b'1', b'1'),
(3976, 'D8', 24, b'1', b'1'),
(3977, 'D9', 24, b'1', b'1'),
(3978, 'D10', 24, b'1', b'1'),
(3979, 'D11', 24, b'1', b'1'),
(3980, 'D12', 24, b'1', b'1'),
(3981, 'D13', 24, b'1', b'0'),
(3982, 'D14', 24, b'1', b'0'),
(3983, 'D15', 24, b'1', b'0'),
(3984, 'D16', 24, b'1', b'0'),
(3985, 'E1', 24, b'1', b'0'),
(3986, 'E2', 24, b'1', b'0'),
(3987, 'E3', 24, b'1', b'0'),
(3988, 'E4', 24, b'1', b'0'),
(3989, 'E5', 24, b'1', b'1'),
(3990, 'E6', 24, b'1', b'1'),
(3991, 'E7', 24, b'1', b'1'),
(3992, 'E8', 24, b'1', b'1'),
(3993, 'E9', 24, b'1', b'1'),
(3994, 'E10', 24, b'1', b'1'),
(3995, 'E11', 24, b'1', b'1'),
(3996, 'E12', 24, b'1', b'1'),
(3997, 'E13', 24, b'1', b'0'),
(3998, 'E14', 24, b'1', b'0'),
(3999, 'E15', 24, b'1', b'0'),
(4000, 'E16', 24, b'1', b'0'),
(4001, 'F1', 24, b'1', b'0'),
(4002, 'F2', 24, b'1', b'0'),
(4003, 'F3', 24, b'1', b'0'),
(4004, 'F4', 24, b'1', b'0'),
(4005, 'F5', 24, b'1', b'0'),
(4006, 'F6', 24, b'1', b'0'),
(4007, 'F7', 24, b'1', b'0'),
(4008, 'F8', 24, b'1', b'0'),
(4009, 'F9', 24, b'1', b'0'),
(4010, 'F10', 24, b'1', b'0'),
(4011, 'F11', 24, b'1', b'0'),
(4012, 'F12', 24, b'1', b'0'),
(4013, 'F13', 24, b'1', b'0'),
(4014, 'F14', 24, b'1', b'0'),
(4015, 'F15', 24, b'1', b'0'),
(4016, 'F16', 24, b'1', b'0'),
(4017, 'G1', 24, b'1', b'0'),
(4018, 'G2', 24, b'1', b'0'),
(4019, 'G3', 24, b'1', b'0'),
(4020, 'G4', 24, b'1', b'0'),
(4021, 'G5', 24, b'1', b'0'),
(4022, 'G6', 24, b'1', b'0'),
(4023, 'G7', 24, b'1', b'0'),
(4024, 'G8', 24, b'1', b'0'),
(4025, 'G9', 24, b'1', b'0'),
(4026, 'G10', 24, b'1', b'0'),
(4027, 'G11', 24, b'1', b'0'),
(4028, 'G12', 24, b'1', b'0'),
(4029, 'G13', 24, b'1', b'0'),
(4030, 'G14', 24, b'1', b'0'),
(4031, 'G15', 24, b'1', b'0'),
(4032, 'G16', 24, b'1', b'0'),
(4033, 'H1', 24, b'1', b'0'),
(4034, 'H2', 24, b'1', b'0'),
(4035, 'H3', 24, b'1', b'0'),
(4036, 'H4', 24, b'1', b'0'),
(4037, 'H5', 24, b'1', b'0'),
(4038, 'H6', 24, b'1', b'0'),
(4039, 'H7', 24, b'1', b'0'),
(4040, 'H8', 24, b'1', b'0'),
(4041, 'H9', 24, b'1', b'0'),
(4042, 'H10', 24, b'1', b'0'),
(4043, 'H11', 24, b'1', b'0'),
(4044, 'H12', 24, b'1', b'0'),
(4045, 'H13', 24, b'1', b'0'),
(4046, 'H14', 24, b'1', b'0'),
(4047, 'H15', 24, b'1', b'0'),
(4048, 'H16', 24, b'1', b'0'),
(4177, 'A1', 26, b'1', b'0'),
(4178, 'A2', 26, b'1', b'0'),
(4179, 'A3', 26, b'1', b'0'),
(4180, 'A4', 26, b'1', b'0'),
(4181, 'A5', 26, b'1', b'0'),
(4182, 'A6', 26, b'1', b'0'),
(4183, 'A7', 26, b'1', b'0'),
(4184, 'A8', 26, b'1', b'0'),
(4185, 'A9', 26, b'1', b'0'),
(4186, 'A10', 26, b'1', b'0'),
(4187, 'A11', 26, b'1', b'0'),
(4188, 'A12', 26, b'1', b'0'),
(4189, 'A13', 26, b'1', b'0'),
(4190, 'A14', 26, b'1', b'0'),
(4191, 'A15', 26, b'1', b'0'),
(4192, 'A16', 26, b'1', b'0'),
(4193, 'B1', 26, b'1', b'0'),
(4194, 'B2', 26, b'1', b'0'),
(4195, 'B3', 26, b'1', b'0'),
(4196, 'B4', 26, b'1', b'0'),
(4197, 'B5', 26, b'1', b'0'),
(4198, 'B6', 26, b'1', b'0'),
(4199, 'B7', 26, b'1', b'0'),
(4200, 'B8', 26, b'1', b'0'),
(4201, 'B9', 26, b'1', b'0'),
(4202, 'B10', 26, b'1', b'0'),
(4203, 'B11', 26, b'1', b'0'),
(4204, 'B12', 26, b'1', b'0'),
(4205, 'B13', 26, b'1', b'0'),
(4206, 'B14', 26, b'1', b'0'),
(4207, 'B15', 26, b'1', b'0'),
(4208, 'B16', 26, b'1', b'0'),
(4209, 'C1', 26, b'1', b'0'),
(4210, 'C2', 26, b'1', b'0'),
(4211, 'C3', 26, b'1', b'0'),
(4212, 'C4', 26, b'1', b'0'),
(4213, 'C5', 26, b'1', b'0'),
(4214, 'C6', 26, b'1', b'0'),
(4215, 'C7', 26, b'1', b'0'),
(4216, 'C8', 26, b'1', b'0'),
(4217, 'C9', 26, b'1', b'0'),
(4218, 'C10', 26, b'1', b'0'),
(4219, 'C11', 26, b'1', b'0'),
(4220, 'C12', 26, b'1', b'0'),
(4221, 'C13', 26, b'1', b'0'),
(4222, 'C14', 26, b'1', b'0'),
(4223, 'C15', 26, b'1', b'0'),
(4224, 'C16', 26, b'1', b'0'),
(4225, 'D1', 26, b'1', b'0'),
(4226, 'D2', 26, b'1', b'0'),
(4227, 'D3', 26, b'1', b'0'),
(4228, 'D4', 26, b'1', b'0'),
(4229, 'D5', 26, b'1', b'0'),
(4230, 'D6', 26, b'1', b'0'),
(4231, 'D7', 26, b'1', b'0'),
(4232, 'D8', 26, b'1', b'0'),
(4233, 'D9', 26, b'1', b'0'),
(4234, 'D10', 26, b'1', b'0'),
(4235, 'D11', 26, b'1', b'0'),
(4236, 'D12', 26, b'1', b'0'),
(4237, 'D13', 26, b'1', b'0'),
(4238, 'D14', 26, b'1', b'0'),
(4239, 'D15', 26, b'1', b'0'),
(4240, 'D16', 26, b'1', b'0'),
(4241, 'E1', 26, b'1', b'0'),
(4242, 'E2', 26, b'1', b'0'),
(4243, 'E3', 26, b'1', b'0'),
(4244, 'E4', 26, b'1', b'0'),
(4245, 'E5', 26, b'1', b'1'),
(4246, 'E6', 26, b'1', b'1'),
(4247, 'E7', 26, b'1', b'1'),
(4248, 'E8', 26, b'1', b'1'),
(4249, 'E9', 26, b'1', b'1'),
(4250, 'E10', 26, b'1', b'1'),
(4251, 'E11', 26, b'1', b'1'),
(4252, 'E12', 26, b'1', b'1'),
(4253, 'E13', 26, b'1', b'1'),
(4254, 'E14', 26, b'1', b'0'),
(4255, 'E15', 26, b'1', b'0'),
(4256, 'E16', 26, b'1', b'0'),
(4257, 'F1', 26, b'1', b'0'),
(4258, 'F2', 26, b'1', b'0'),
(4259, 'F3', 26, b'1', b'0'),
(4260, 'F4', 26, b'1', b'0'),
(4261, 'F5', 26, b'1', b'0'),
(4262, 'F6', 26, b'1', b'0'),
(4263, 'F7', 26, b'1', b'0'),
(4264, 'F8', 26, b'1', b'0'),
(4265, 'F9', 26, b'1', b'0'),
(4266, 'F10', 26, b'1', b'0'),
(4267, 'F11', 26, b'1', b'0'),
(4268, 'F12', 26, b'1', b'0'),
(4269, 'F13', 26, b'1', b'0'),
(4270, 'F14', 26, b'1', b'0'),
(4271, 'F15', 26, b'1', b'0'),
(4272, 'F16', 26, b'1', b'0'),
(4273, 'G1', 26, b'1', b'0'),
(4274, 'G2', 26, b'1', b'0'),
(4275, 'G3', 26, b'1', b'0'),
(4276, 'G4', 26, b'1', b'0'),
(4277, 'G5', 26, b'1', b'0'),
(4278, 'G6', 26, b'1', b'0'),
(4279, 'G7', 26, b'1', b'0'),
(4280, 'G8', 26, b'1', b'0'),
(4281, 'G9', 26, b'1', b'0'),
(4282, 'G10', 26, b'1', b'0'),
(4283, 'G11', 26, b'1', b'0'),
(4284, 'G12', 26, b'1', b'0'),
(4285, 'G13', 26, b'1', b'0'),
(4286, 'G14', 26, b'1', b'0'),
(4287, 'G15', 26, b'1', b'0'),
(4288, 'G16', 26, b'1', b'0'),
(4289, 'H1', 26, b'1', b'0'),
(4290, 'H2', 26, b'1', b'0'),
(4291, 'H3', 26, b'1', b'0'),
(4292, 'H4', 26, b'1', b'0'),
(4293, 'H5', 26, b'1', b'0'),
(4294, 'H6', 26, b'1', b'0'),
(4295, 'H7', 26, b'1', b'0'),
(4296, 'H8', 26, b'1', b'0'),
(4297, 'H9', 26, b'1', b'0'),
(4298, 'H10', 26, b'1', b'0'),
(4299, 'H11', 26, b'1', b'0'),
(4300, 'H12', 26, b'1', b'0'),
(4301, 'H13', 26, b'1', b'0'),
(4302, 'H14', 26, b'1', b'0'),
(4303, 'H15', 26, b'1', b'0'),
(4304, 'H16', 26, b'1', b'0'),
(4433, 'A1', 28, b'1', b'0'),
(4434, 'A2', 28, b'1', b'0'),
(4435, 'A3', 28, b'1', b'0'),
(4436, 'A4', 28, b'1', b'0'),
(4437, 'A5', 28, b'1', b'0'),
(4438, 'A6', 28, b'1', b'0'),
(4439, 'A7', 28, b'1', b'0'),
(4440, 'A8', 28, b'1', b'0'),
(4441, 'A9', 28, b'1', b'0'),
(4442, 'A10', 28, b'1', b'0'),
(4443, 'A11', 28, b'1', b'0'),
(4444, 'A12', 28, b'1', b'0'),
(4445, 'A13', 28, b'1', b'0'),
(4446, 'A14', 28, b'1', b'0'),
(4447, 'A15', 28, b'1', b'0'),
(4448, 'A16', 28, b'1', b'0'),
(4449, 'B1', 28, b'1', b'0'),
(4450, 'B2', 28, b'1', b'0'),
(4451, 'B3', 28, b'1', b'0'),
(4452, 'B4', 28, b'1', b'0'),
(4453, 'B5', 28, b'1', b'0'),
(4454, 'B6', 28, b'1', b'0'),
(4455, 'B7', 28, b'1', b'0'),
(4456, 'B8', 28, b'1', b'0'),
(4457, 'B9', 28, b'1', b'0'),
(4458, 'B10', 28, b'1', b'0'),
(4459, 'B11', 28, b'1', b'0'),
(4460, 'B12', 28, b'1', b'0'),
(4461, 'B13', 28, b'1', b'0'),
(4462, 'B14', 28, b'1', b'0'),
(4463, 'B15', 28, b'1', b'0'),
(4464, 'B16', 28, b'1', b'0'),
(4465, 'C1', 28, b'1', b'0'),
(4466, 'C2', 28, b'1', b'0'),
(4467, 'C3', 28, b'1', b'0'),
(4468, 'C4', 28, b'1', b'0'),
(4469, 'C5', 28, b'1', b'0'),
(4470, 'C6', 28, b'1', b'0'),
(4471, 'C7', 28, b'1', b'0'),
(4472, 'C8', 28, b'1', b'0'),
(4473, 'C9', 28, b'1', b'0'),
(4474, 'C10', 28, b'1', b'0'),
(4475, 'C11', 28, b'1', b'0'),
(4476, 'C12', 28, b'1', b'0'),
(4477, 'C13', 28, b'1', b'0'),
(4478, 'C14', 28, b'1', b'0'),
(4479, 'C15', 28, b'1', b'0'),
(4480, 'C16', 28, b'1', b'0'),
(4481, 'D1', 28, b'1', b'0'),
(4482, 'D2', 28, b'1', b'0'),
(4483, 'D3', 28, b'1', b'0'),
(4484, 'D4', 28, b'1', b'0'),
(4485, 'D5', 28, b'1', b'0'),
(4486, 'D6', 28, b'1', b'0'),
(4487, 'D7', 28, b'1', b'0'),
(4488, 'D8', 28, b'1', b'0'),
(4489, 'D9', 28, b'1', b'0'),
(4490, 'D10', 28, b'1', b'0'),
(4491, 'D11', 28, b'1', b'0'),
(4492, 'D12', 28, b'1', b'0'),
(4493, 'D13', 28, b'1', b'0'),
(4494, 'D14', 28, b'1', b'0'),
(4495, 'D15', 28, b'1', b'0'),
(4496, 'D16', 28, b'1', b'0'),
(4497, 'E1', 28, b'1', b'0'),
(4498, 'E2', 28, b'1', b'0'),
(4499, 'E3', 28, b'1', b'0'),
(4500, 'E4', 28, b'1', b'1'),
(4501, 'E5', 28, b'1', b'1'),
(4502, 'E6', 28, b'1', b'1'),
(4503, 'E7', 28, b'1', b'1'),
(4504, 'E8', 28, b'1', b'1'),
(4505, 'E9', 28, b'1', b'1'),
(4506, 'E10', 28, b'1', b'1'),
(4507, 'E11', 28, b'1', b'1'),
(4508, 'E12', 28, b'1', b'1'),
(4509, 'E13', 28, b'1', b'1'),
(4510, 'E14', 28, b'1', b'0'),
(4511, 'E15', 28, b'1', b'0'),
(4512, 'E16', 28, b'1', b'0'),
(4513, 'F1', 28, b'1', b'0'),
(4514, 'F2', 28, b'1', b'0'),
(4515, 'F3', 28, b'1', b'0'),
(4516, 'F4', 28, b'1', b'1'),
(4517, 'F5', 28, b'1', b'1'),
(4518, 'F6', 28, b'1', b'1'),
(4519, 'F7', 28, b'1', b'1'),
(4520, 'F8', 28, b'1', b'1'),
(4521, 'F9', 28, b'1', b'1'),
(4522, 'F10', 28, b'1', b'1'),
(4523, 'F11', 28, b'1', b'1'),
(4524, 'F12', 28, b'1', b'1'),
(4525, 'F13', 28, b'1', b'1'),
(4526, 'F14', 28, b'1', b'0'),
(4527, 'F15', 28, b'1', b'0'),
(4528, 'F16', 28, b'1', b'0'),
(4529, 'G1', 28, b'1', b'0'),
(4530, 'G2', 28, b'1', b'0'),
(4531, 'G3', 28, b'1', b'0'),
(4532, 'G4', 28, b'1', b'0'),
(4533, 'G5', 28, b'1', b'0'),
(4534, 'G6', 28, b'1', b'0'),
(4535, 'G7', 28, b'1', b'0'),
(4536, 'G8', 28, b'1', b'0'),
(4537, 'G9', 28, b'1', b'0'),
(4538, 'G10', 28, b'1', b'0'),
(4539, 'G11', 28, b'1', b'0'),
(4540, 'G12', 28, b'1', b'0'),
(4541, 'G13', 28, b'1', b'0'),
(4542, 'G14', 28, b'1', b'0'),
(4543, 'G15', 28, b'1', b'0'),
(4544, 'G16', 28, b'1', b'0'),
(4545, 'H1', 28, b'1', b'0'),
(4546, 'H2', 28, b'1', b'0'),
(4547, 'H3', 28, b'1', b'0'),
(4548, 'H4', 28, b'1', b'0'),
(4549, 'H5', 28, b'1', b'0'),
(4550, 'H6', 28, b'1', b'0'),
(4551, 'H7', 28, b'1', b'0'),
(4552, 'H8', 28, b'1', b'0'),
(4553, 'H9', 28, b'1', b'0'),
(4554, 'H10', 28, b'1', b'0'),
(4555, 'H11', 28, b'1', b'0'),
(4556, 'H12', 28, b'1', b'0'),
(4557, 'H13', 28, b'1', b'0'),
(4558, 'H14', 28, b'1', b'0'),
(4559, 'H15', 28, b'1', b'0'),
(4560, 'H16', 28, b'1', b'0'),
(4561, 'A1', 29, b'1', b'0'),
(4562, 'A2', 29, b'1', b'0'),
(4563, 'A3', 29, b'1', b'0'),
(4564, 'A4', 29, b'1', b'0'),
(4565, 'A5', 29, b'1', b'0'),
(4566, 'A6', 29, b'1', b'0'),
(4567, 'A7', 29, b'1', b'0'),
(4568, 'A8', 29, b'1', b'0'),
(4569, 'A9', 29, b'1', b'0'),
(4570, 'A10', 29, b'1', b'0'),
(4571, 'A11', 29, b'1', b'0'),
(4572, 'A12', 29, b'1', b'0'),
(4573, 'A13', 29, b'1', b'0'),
(4574, 'A14', 29, b'1', b'0'),
(4575, 'A15', 29, b'1', b'0'),
(4576, 'A16', 29, b'1', b'0'),
(4577, 'B1', 29, b'1', b'0'),
(4578, 'B2', 29, b'1', b'0'),
(4579, 'B3', 29, b'1', b'0'),
(4580, 'B4', 29, b'1', b'0'),
(4581, 'B5', 29, b'1', b'0'),
(4582, 'B6', 29, b'1', b'0'),
(4583, 'B7', 29, b'1', b'0'),
(4584, 'B8', 29, b'1', b'0'),
(4585, 'B9', 29, b'1', b'0'),
(4586, 'B10', 29, b'1', b'0'),
(4587, 'B11', 29, b'1', b'0'),
(4588, 'B12', 29, b'1', b'0'),
(4589, 'B13', 29, b'1', b'0'),
(4590, 'B14', 29, b'1', b'0'),
(4591, 'B15', 29, b'1', b'0'),
(4592, 'B16', 29, b'1', b'0'),
(4593, 'C1', 29, b'1', b'0'),
(4594, 'C2', 29, b'1', b'0'),
(4595, 'C3', 29, b'1', b'0'),
(4596, 'C4', 29, b'1', b'0'),
(4597, 'C5', 29, b'1', b'0'),
(4598, 'C6', 29, b'1', b'0'),
(4599, 'C7', 29, b'1', b'0'),
(4600, 'C8', 29, b'1', b'0'),
(4601, 'C9', 29, b'1', b'0'),
(4602, 'C10', 29, b'1', b'0'),
(4603, 'C11', 29, b'1', b'0'),
(4604, 'C12', 29, b'1', b'0'),
(4605, 'C13', 29, b'1', b'0'),
(4606, 'C14', 29, b'1', b'0'),
(4607, 'C15', 29, b'1', b'0'),
(4608, 'C16', 29, b'1', b'0'),
(4609, 'D1', 29, b'1', b'0'),
(4610, 'D2', 29, b'1', b'0'),
(4611, 'D3', 29, b'1', b'0'),
(4612, 'D4', 29, b'1', b'0'),
(4613, 'D5', 29, b'1', b'0'),
(4614, 'D6', 29, b'1', b'1'),
(4615, 'D7', 29, b'1', b'1'),
(4616, 'D8', 29, b'1', b'1'),
(4617, 'D9', 29, b'1', b'1'),
(4618, 'D10', 29, b'1', b'1'),
(4619, 'D11', 29, b'1', b'1'),
(4620, 'D12', 29, b'1', b'0'),
(4621, 'D13', 29, b'1', b'0'),
(4622, 'D14', 29, b'1', b'0'),
(4623, 'D15', 29, b'1', b'0'),
(4624, 'D16', 29, b'1', b'0'),
(4625, 'E1', 29, b'1', b'0'),
(4626, 'E2', 29, b'1', b'0'),
(4627, 'E3', 29, b'1', b'0'),
(4628, 'E4', 29, b'1', b'0'),
(4629, 'E5', 29, b'1', b'0'),
(4630, 'E6', 29, b'1', b'1'),
(4631, 'E7', 29, b'1', b'1'),
(4632, 'E8', 29, b'1', b'1'),
(4633, 'E9', 29, b'1', b'1'),
(4634, 'E10', 29, b'1', b'1'),
(4635, 'E11', 29, b'1', b'1'),
(4636, 'E12', 29, b'1', b'0'),
(4637, 'E13', 29, b'1', b'0'),
(4638, 'E14', 29, b'1', b'0'),
(4639, 'E15', 29, b'1', b'0'),
(4640, 'E16', 29, b'1', b'0'),
(4641, 'F1', 29, b'1', b'0'),
(4642, 'F2', 29, b'1', b'0'),
(4643, 'F3', 29, b'1', b'0'),
(4644, 'F4', 29, b'1', b'0'),
(4645, 'F5', 29, b'1', b'0'),
(4646, 'F6', 29, b'1', b'1'),
(4647, 'F7', 29, b'1', b'1'),
(4648, 'F8', 29, b'1', b'1'),
(4649, 'F9', 29, b'1', b'1'),
(4650, 'F10', 29, b'1', b'1'),
(4651, 'F11', 29, b'1', b'1'),
(4652, 'F12', 29, b'1', b'0'),
(4653, 'F13', 29, b'1', b'0'),
(4654, 'F14', 29, b'1', b'0'),
(4655, 'F15', 29, b'1', b'0'),
(4656, 'F16', 29, b'1', b'0'),
(4657, 'G1', 29, b'0', b'0'),
(4658, 'G2', 29, b'1', b'0'),
(4659, 'G3', 29, b'1', b'0'),
(4660, 'G4', 29, b'1', b'0'),
(4661, 'G5', 29, b'1', b'0'),
(4662, 'G6', 29, b'1', b'0'),
(4663, 'G7', 29, b'1', b'0'),
(4664, 'G8', 29, b'1', b'0'),
(4665, 'G9', 29, b'1', b'0'),
(4666, 'G10', 29, b'1', b'0'),
(4667, 'G11', 29, b'1', b'0'),
(4668, 'G12', 29, b'1', b'0'),
(4669, 'G13', 29, b'1', b'0'),
(4670, 'G14', 29, b'1', b'0'),
(4671, 'G15', 29, b'1', b'0'),
(4672, 'G16', 29, b'0', b'0'),
(4673, 'H1', 29, b'0', b'0'),
(4674, 'H2', 29, b'0', b'0'),
(4675, 'H3', 29, b'1', b'0'),
(4676, 'H4', 29, b'1', b'0'),
(4677, 'H5', 29, b'1', b'0'),
(4678, 'H6', 29, b'1', b'0'),
(4679, 'H7', 29, b'1', b'0'),
(4680, 'H8', 29, b'1', b'0'),
(4681, 'H9', 29, b'1', b'0'),
(4682, 'H10', 29, b'1', b'0'),
(4683, 'H11', 29, b'1', b'0'),
(4684, 'H12', 29, b'1', b'0'),
(4685, 'H13', 29, b'1', b'0'),
(4686, 'H14', 29, b'1', b'0'),
(4687, 'H15', 29, b'0', b'0'),
(4688, 'H16', 29, b'0', b'0'),
(4689, 'A1', 30, b'1', b'0'),
(4690, 'A2', 30, b'1', b'0'),
(4691, 'A3', 30, b'1', b'0'),
(4692, 'A4', 30, b'1', b'0'),
(4693, 'A5', 30, b'1', b'0'),
(4694, 'A6', 30, b'1', b'0'),
(4695, 'A7', 30, b'1', b'0'),
(4696, 'A8', 30, b'1', b'0'),
(4697, 'A9', 30, b'1', b'0'),
(4698, 'A10', 30, b'1', b'0'),
(4699, 'A11', 30, b'1', b'0'),
(4700, 'A12', 30, b'1', b'0'),
(4701, 'A13', 30, b'1', b'0'),
(4702, 'A14', 30, b'1', b'0'),
(4703, 'A15', 30, b'1', b'0'),
(4704, 'A16', 30, b'1', b'0'),
(4705, 'B1', 30, b'1', b'0'),
(4706, 'B2', 30, b'1', b'0'),
(4707, 'B3', 30, b'1', b'0'),
(4708, 'B4', 30, b'1', b'0'),
(4709, 'B5', 30, b'1', b'0'),
(4710, 'B6', 30, b'1', b'0'),
(4711, 'B7', 30, b'1', b'0'),
(4712, 'B8', 30, b'1', b'0'),
(4713, 'B9', 30, b'1', b'0'),
(4714, 'B10', 30, b'1', b'0'),
(4715, 'B11', 30, b'1', b'0'),
(4716, 'B12', 30, b'1', b'0'),
(4717, 'B13', 30, b'1', b'0'),
(4718, 'B14', 30, b'1', b'0'),
(4719, 'B15', 30, b'1', b'0'),
(4720, 'B16', 30, b'1', b'0'),
(4721, 'C1', 30, b'1', b'0'),
(4722, 'C2', 30, b'1', b'0'),
(4723, 'C3', 30, b'1', b'0'),
(4724, 'C4', 30, b'1', b'0'),
(4725, 'C5', 30, b'1', b'0'),
(4726, 'C6', 30, b'1', b'0'),
(4727, 'C7', 30, b'1', b'0'),
(4728, 'C8', 30, b'1', b'0'),
(4729, 'C9', 30, b'1', b'0'),
(4730, 'C10', 30, b'1', b'0'),
(4731, 'C11', 30, b'1', b'0'),
(4732, 'C12', 30, b'1', b'0'),
(4733, 'C13', 30, b'1', b'0'),
(4734, 'C14', 30, b'1', b'0'),
(4735, 'C15', 30, b'1', b'0'),
(4736, 'C16', 30, b'1', b'0'),
(4737, 'D1', 30, b'1', b'0'),
(4738, 'D2', 30, b'1', b'0'),
(4739, 'D3', 30, b'1', b'0'),
(4740, 'D4', 30, b'1', b'0'),
(4741, 'D5', 30, b'1', b'1'),
(4742, 'D6', 30, b'1', b'1'),
(4743, 'D7', 30, b'1', b'1'),
(4744, 'D8', 30, b'1', b'1'),
(4745, 'D9', 30, b'1', b'1'),
(4746, 'D10', 30, b'1', b'1'),
(4747, 'D11', 30, b'1', b'1'),
(4748, 'D12', 30, b'1', b'1'),
(4749, 'D13', 30, b'1', b'0'),
(4750, 'D14', 30, b'1', b'0'),
(4751, 'D15', 30, b'1', b'0'),
(4752, 'D16', 30, b'1', b'0'),
(4753, 'E1', 30, b'1', b'0'),
(4754, 'E2', 30, b'1', b'0'),
(4755, 'E3', 30, b'1', b'0'),
(4756, 'E4', 30, b'1', b'0'),
(4757, 'E5', 30, b'1', b'1'),
(4758, 'E6', 30, b'1', b'1'),
(4759, 'E7', 30, b'1', b'1'),
(4760, 'E8', 30, b'1', b'1'),
(4761, 'E9', 30, b'1', b'1'),
(4762, 'E10', 30, b'1', b'1'),
(4763, 'E11', 30, b'1', b'1'),
(4764, 'E12', 30, b'1', b'1'),
(4765, 'E13', 30, b'1', b'0'),
(4766, 'E14', 30, b'1', b'0'),
(4767, 'E15', 30, b'1', b'0'),
(4768, 'E16', 30, b'1', b'0'),
(4769, 'F1', 30, b'1', b'0'),
(4770, 'F2', 30, b'1', b'0'),
(4771, 'F3', 30, b'1', b'0'),
(4772, 'F4', 30, b'1', b'0'),
(4773, 'F5', 30, b'1', b'1'),
(4774, 'F6', 30, b'1', b'1'),
(4775, 'F7', 30, b'1', b'1'),
(4776, 'F8', 30, b'1', b'1'),
(4777, 'F9', 30, b'1', b'1'),
(4778, 'F10', 30, b'1', b'1'),
(4779, 'F11', 30, b'1', b'1'),
(4780, 'F12', 30, b'1', b'1'),
(4781, 'F13', 30, b'1', b'0'),
(4782, 'F14', 30, b'1', b'0'),
(4783, 'F15', 30, b'1', b'0'),
(4784, 'F16', 30, b'1', b'0'),
(4785, 'G1', 30, b'1', b'0'),
(4786, 'G2', 30, b'1', b'0'),
(4787, 'G3', 30, b'1', b'0'),
(4788, 'G4', 30, b'1', b'0'),
(4789, 'G5', 30, b'1', b'0'),
(4790, 'G6', 30, b'1', b'0'),
(4791, 'G7', 30, b'1', b'0'),
(4792, 'G8', 30, b'1', b'0'),
(4793, 'G9', 30, b'1', b'0'),
(4794, 'G10', 30, b'1', b'0'),
(4795, 'G11', 30, b'1', b'0'),
(4796, 'G12', 30, b'1', b'0'),
(4797, 'G13', 30, b'1', b'0'),
(4798, 'G14', 30, b'1', b'0'),
(4799, 'G15', 30, b'1', b'0'),
(4800, 'G16', 30, b'1', b'0'),
(4801, 'H1', 30, b'1', b'0'),
(4802, 'H2', 30, b'1', b'0'),
(4803, 'H3', 30, b'1', b'0'),
(4804, 'H4', 30, b'1', b'0'),
(4805, 'H5', 30, b'1', b'0'),
(4806, 'H6', 30, b'1', b'0'),
(4807, 'H7', 30, b'1', b'0'),
(4808, 'H8', 30, b'1', b'0'),
(4809, 'H9', 30, b'1', b'0'),
(4810, 'H10', 30, b'1', b'0'),
(4811, 'H11', 30, b'1', b'0'),
(4812, 'H12', 30, b'1', b'0'),
(4813, 'H13', 30, b'1', b'0'),
(4814, 'H14', 30, b'1', b'0'),
(4815, 'H15', 30, b'1', b'0'),
(4816, 'H16', 30, b'1', b'0'),
(4817, 'A1', 31, b'0', b'0'),
(4818, 'A2', 31, b'0', b'0'),
(4819, 'A3', 31, b'0', b'0'),
(4820, 'A4', 31, b'1', b'0'),
(4821, 'A5', 31, b'1', b'0'),
(4822, 'A6', 31, b'1', b'0'),
(4823, 'A7', 31, b'1', b'0'),
(4824, 'A8', 31, b'1', b'0'),
(4825, 'A9', 31, b'1', b'0'),
(4826, 'A10', 31, b'1', b'0'),
(4827, 'A11', 31, b'1', b'0'),
(4828, 'A12', 31, b'1', b'0'),
(4829, 'A13', 31, b'1', b'0'),
(4830, 'A14', 31, b'0', b'0'),
(4831, 'A15', 31, b'0', b'0'),
(4832, 'A16', 31, b'0', b'0'),
(4833, 'B1', 31, b'0', b'0'),
(4834, 'B2', 31, b'1', b'0'),
(4835, 'B3', 31, b'1', b'0'),
(4836, 'B4', 31, b'1', b'0'),
(4837, 'B5', 31, b'1', b'0'),
(4838, 'B6', 31, b'1', b'0'),
(4839, 'B7', 31, b'1', b'0'),
(4840, 'B8', 31, b'1', b'0'),
(4841, 'B9', 31, b'1', b'0'),
(4842, 'B10', 31, b'1', b'0'),
(4843, 'B11', 31, b'1', b'0'),
(4844, 'B12', 31, b'1', b'0'),
(4845, 'B13', 31, b'1', b'0'),
(4846, 'B14', 31, b'1', b'0'),
(4847, 'B15', 31, b'1', b'0'),
(4848, 'B16', 31, b'0', b'0'),
(4849, 'C1', 31, b'1', b'0'),
(4850, 'C2', 31, b'1', b'0'),
(4851, 'C3', 31, b'1', b'0'),
(4852, 'C4', 31, b'1', b'0'),
(4853, 'C5', 31, b'1', b'0'),
(4854, 'C6', 31, b'1', b'0'),
(4855, 'C7', 31, b'1', b'0'),
(4856, 'C8', 31, b'1', b'0'),
(4857, 'C9', 31, b'1', b'0'),
(4858, 'C10', 31, b'1', b'0'),
(4859, 'C11', 31, b'1', b'0'),
(4860, 'C12', 31, b'1', b'0'),
(4861, 'C13', 31, b'1', b'0'),
(4862, 'C14', 31, b'1', b'0'),
(4863, 'C15', 31, b'1', b'0'),
(4864, 'C16', 31, b'1', b'0'),
(4865, 'D1', 31, b'1', b'0'),
(4866, 'D2', 31, b'1', b'0'),
(4867, 'D3', 31, b'1', b'0'),
(4868, 'D4', 31, b'1', b'0'),
(4869, 'D5', 31, b'1', b'0'),
(4870, 'D6', 31, b'1', b'0'),
(4871, 'D7', 31, b'1', b'1'),
(4872, 'D8', 31, b'1', b'0'),
(4873, 'D9', 31, b'1', b'1'),
(4874, 'D10', 31, b'1', b'0'),
(4875, 'D11', 31, b'1', b'1'),
(4876, 'D12', 31, b'1', b'0'),
(4877, 'D13', 31, b'1', b'0'),
(4878, 'D14', 31, b'1', b'0'),
(4879, 'D15', 31, b'1', b'0'),
(4880, 'D16', 31, b'1', b'0'),
(4881, 'E1', 31, b'1', b'0'),
(4882, 'E2', 31, b'1', b'0'),
(4883, 'E3', 31, b'1', b'0'),
(4884, 'E4', 31, b'1', b'0'),
(4885, 'E5', 31, b'1', b'0'),
(4886, 'E6', 31, b'1', b'0'),
(4887, 'E7', 31, b'1', b'1'),
(4888, 'E8', 31, b'1', b'0'),
(4889, 'E9', 31, b'1', b'1'),
(4890, 'E10', 31, b'1', b'0'),
(4891, 'E11', 31, b'1', b'1'),
(4892, 'E12', 31, b'1', b'0'),
(4893, 'E13', 31, b'1', b'0'),
(4894, 'E14', 31, b'1', b'0'),
(4895, 'E15', 31, b'1', b'0'),
(4896, 'E16', 31, b'1', b'0'),
(4897, 'F1', 31, b'1', b'0'),
(4898, 'F2', 31, b'1', b'0'),
(4899, 'F3', 31, b'1', b'0'),
(4900, 'F4', 31, b'1', b'0'),
(4901, 'F5', 31, b'1', b'0'),
(4902, 'F6', 31, b'1', b'0'),
(4903, 'F7', 31, b'1', b'1'),
(4904, 'F8', 31, b'1', b'0'),
(4905, 'F9', 31, b'1', b'1'),
(4906, 'F10', 31, b'1', b'0'),
(4907, 'F11', 31, b'1', b'1'),
(4908, 'F12', 31, b'1', b'0'),
(4909, 'F13', 31, b'1', b'0'),
(4910, 'F14', 31, b'1', b'0'),
(4911, 'F15', 31, b'1', b'0'),
(4912, 'F16', 31, b'1', b'0'),
(4913, 'G1', 31, b'0', b'0'),
(4914, 'G2', 31, b'1', b'0'),
(4915, 'G3', 31, b'1', b'0'),
(4916, 'G4', 31, b'1', b'0'),
(4917, 'G5', 31, b'1', b'0'),
(4918, 'G6', 31, b'1', b'0'),
(4919, 'G7', 31, b'1', b'0'),
(4920, 'G8', 31, b'1', b'0'),
(4921, 'G9', 31, b'1', b'0'),
(4922, 'G10', 31, b'1', b'0'),
(4923, 'G11', 31, b'1', b'0'),
(4924, 'G12', 31, b'1', b'0'),
(4925, 'G13', 31, b'1', b'0'),
(4926, 'G14', 31, b'1', b'0'),
(4927, 'G15', 31, b'1', b'0'),
(4928, 'G16', 31, b'0', b'0'),
(4929, 'H1', 31, b'0', b'0'),
(4930, 'H2', 31, b'0', b'0'),
(4931, 'H3', 31, b'0', b'0'),
(4932, 'H4', 31, b'1', b'0'),
(4933, 'H5', 31, b'1', b'0'),
(4934, 'H6', 31, b'1', b'0'),
(4935, 'H7', 31, b'1', b'0'),
(4936, 'H8', 31, b'1', b'0'),
(4937, 'H9', 31, b'1', b'0'),
(4938, 'H10', 31, b'1', b'0'),
(4939, 'H11', 31, b'1', b'0'),
(4940, 'H12', 31, b'1', b'0'),
(4941, 'H13', 31, b'1', b'0'),
(4942, 'H14', 31, b'0', b'0'),
(4943, 'H15', 31, b'0', b'0'),
(4944, 'H16', 31, b'0', b'0'),
(4945, 'A1', 32, b'1', b'0'),
(4946, 'A2', 32, b'1', b'0'),
(4947, 'A3', 32, b'1', b'0'),
(4948, 'A4', 32, b'1', b'0'),
(4949, 'A5', 32, b'1', b'0'),
(4950, 'A6', 32, b'1', b'0'),
(4951, 'A7', 32, b'1', b'0'),
(4952, 'A8', 32, b'1', b'0'),
(4953, 'A9', 32, b'1', b'0'),
(4954, 'A10', 32, b'1', b'0'),
(4955, 'A11', 32, b'1', b'0'),
(4956, 'A12', 32, b'1', b'0'),
(4957, 'A13', 32, b'1', b'0'),
(4958, 'A14', 32, b'1', b'0'),
(4959, 'A15', 32, b'1', b'0'),
(4960, 'A16', 32, b'1', b'0'),
(4961, 'B1', 32, b'1', b'0'),
(4962, 'B2', 32, b'1', b'0'),
(4963, 'B3', 32, b'1', b'0'),
(4964, 'B4', 32, b'1', b'0'),
(4965, 'B5', 32, b'1', b'0'),
(4966, 'B6', 32, b'1', b'0'),
(4967, 'B7', 32, b'1', b'0'),
(4968, 'B8', 32, b'1', b'0'),
(4969, 'B9', 32, b'1', b'0'),
(4970, 'B10', 32, b'1', b'0'),
(4971, 'B11', 32, b'1', b'0'),
(4972, 'B12', 32, b'1', b'0'),
(4973, 'B13', 32, b'1', b'0'),
(4974, 'B14', 32, b'1', b'0'),
(4975, 'B15', 32, b'1', b'0'),
(4976, 'B16', 32, b'1', b'0'),
(4977, 'C1', 32, b'1', b'0'),
(4978, 'C2', 32, b'1', b'0'),
(4979, 'C3', 32, b'1', b'0'),
(4980, 'C4', 32, b'1', b'0'),
(4981, 'C5', 32, b'1', b'0'),
(4982, 'C6', 32, b'1', b'0'),
(4983, 'C7', 32, b'1', b'0'),
(4984, 'C8', 32, b'1', b'0'),
(4985, 'C9', 32, b'1', b'0'),
(4986, 'C10', 32, b'1', b'0'),
(4987, 'C11', 32, b'1', b'0'),
(4988, 'C12', 32, b'1', b'0'),
(4989, 'C13', 32, b'1', b'0'),
(4990, 'C14', 32, b'1', b'0'),
(4991, 'C15', 32, b'1', b'0'),
(4992, 'C16', 32, b'1', b'0'),
(4993, 'D1', 32, b'1', b'0'),
(4994, 'D2', 32, b'1', b'0'),
(4995, 'D3', 32, b'1', b'0'),
(4996, 'D4', 32, b'1', b'0'),
(4997, 'D5', 32, b'1', b'0'),
(4998, 'D6', 32, b'1', b'0'),
(4999, 'D7', 32, b'1', b'0'),
(5000, 'D8', 32, b'1', b'0'),
(5001, 'D9', 32, b'1', b'0'),
(5002, 'D10', 32, b'1', b'0'),
(5003, 'D11', 32, b'1', b'0'),
(5004, 'D12', 32, b'1', b'0'),
(5005, 'D13', 32, b'1', b'0'),
(5006, 'D14', 32, b'1', b'0'),
(5007, 'D15', 32, b'1', b'0'),
(5008, 'D16', 32, b'1', b'0'),
(5009, 'E1', 32, b'1', b'0'),
(5010, 'E2', 32, b'1', b'0'),
(5011, 'E3', 32, b'1', b'0'),
(5012, 'E4', 32, b'1', b'0'),
(5013, 'E5', 32, b'1', b'0'),
(5014, 'E6', 32, b'1', b'0'),
(5015, 'E7', 32, b'1', b'1'),
(5016, 'E8', 32, b'1', b'1'),
(5017, 'E9', 32, b'1', b'1'),
(5018, 'E10', 32, b'1', b'1'),
(5019, 'E11', 32, b'1', b'1'),
(5020, 'E12', 32, b'1', b'0'),
(5021, 'E13', 32, b'1', b'0'),
(5022, 'E14', 32, b'1', b'0'),
(5023, 'E15', 32, b'1', b'0'),
(5024, 'E16', 32, b'1', b'0'),
(5025, 'F1', 32, b'1', b'0'),
(5026, 'F2', 32, b'1', b'0'),
(5027, 'F3', 32, b'1', b'0'),
(5028, 'F4', 32, b'1', b'0'),
(5029, 'F5', 32, b'1', b'0'),
(5030, 'F6', 32, b'1', b'0'),
(5031, 'F7', 32, b'1', b'0'),
(5032, 'F8', 32, b'1', b'0'),
(5033, 'F9', 32, b'1', b'0'),
(5034, 'F10', 32, b'1', b'0'),
(5035, 'F11', 32, b'1', b'0'),
(5036, 'F12', 32, b'1', b'0'),
(5037, 'F13', 32, b'1', b'0'),
(5038, 'F14', 32, b'1', b'0'),
(5039, 'F15', 32, b'1', b'0'),
(5040, 'F16', 32, b'1', b'0'),
(5041, 'G1', 32, b'0', b'0'),
(5042, 'G2', 32, b'1', b'0'),
(5043, 'G3', 32, b'1', b'0'),
(5044, 'G4', 32, b'1', b'0'),
(5045, 'G5', 32, b'1', b'0'),
(5046, 'G6', 32, b'1', b'0'),
(5047, 'G7', 32, b'1', b'0'),
(5048, 'G8', 32, b'1', b'0'),
(5049, 'G9', 32, b'1', b'0'),
(5050, 'G10', 32, b'1', b'0'),
(5051, 'G11', 32, b'1', b'0'),
(5052, 'G12', 32, b'1', b'0'),
(5053, 'G13', 32, b'1', b'0'),
(5054, 'G14', 32, b'1', b'0'),
(5055, 'G15', 32, b'1', b'0'),
(5056, 'G16', 32, b'0', b'0'),
(5057, 'H1', 32, b'0', b'0'),
(5058, 'H2', 32, b'0', b'0'),
(5059, 'H3', 32, b'1', b'0'),
(5060, 'H4', 32, b'1', b'0'),
(5061, 'H5', 32, b'1', b'0'),
(5062, 'H6', 32, b'1', b'0'),
(5063, 'H7', 32, b'1', b'0'),
(5064, 'H8', 32, b'1', b'0'),
(5065, 'H9', 32, b'1', b'0'),
(5066, 'H10', 32, b'1', b'0'),
(5067, 'H11', 32, b'1', b'0'),
(5068, 'H12', 32, b'1', b'0'),
(5069, 'H13', 32, b'1', b'0'),
(5070, 'H14', 32, b'1', b'0'),
(5071, 'H15', 32, b'0', b'0'),
(5072, 'H16', 32, b'0', b'0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ticket`
--

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `qr_imageurl` varchar(255) DEFAULT NULL,
  `bill_id` int(11) DEFAULT NULL,
  `schedule_id` int(11) NOT NULL,
  `seat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ticket`
--

INSERT INTO `ticket` (`id`, `qr_imageurl`, `bill_id`, `schedule_id`, `seat_id`) VALUES
(112, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 83, 39, 4616),
(113, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 83, 39, 4617),
(114, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 83, 39, 4618),
(115, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 83, 39, 4602),
(116, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 83, 39, 4601),
(117, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 83, 39, 4600),
(118, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 84, 39, 4619),
(119, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 84, 39, 4635),
(120, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 84, 39, 4651),
(122, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 86, 39, 4647),
(123, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 86, 39, 4663),
(124, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 87, 39, 4648),
(125, 'https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8', 87, 39, 4649),
(128, 'https://example.com/qr-image', 90, 44, 4989),
(129, 'https://example.com/qr-image', 90, 44, 4988),
(130, 'https://example.com/qr-image', 90, 44, 4987),
(131, 'https://example.com/qr-image', 90, 44, 4986),
(132, 'https://example.com/qr-image', 90, 44, 4985),
(133, 'https://example.com/qr-image', 91, 44, 4990),
(134, 'https://example.com/qr-image', 91, 44, 4991),
(135, 'https://example.com/qr-image', 91, 44, 5008),
(136, 'https://example.com/qr-image', 91, 44, 4992),
(137, 'https://example.com/qr-image', 91, 44, 5007),
(138, 'https://example.com/qr-image', NULL, 43, 3934),
(139, 'https://example.com/qr-image', NULL, 43, 3933),
(140, 'https://example.com/qr-image', NULL, 43, 3931),
(141, 'https://example.com/qr-image', NULL, 43, 3932);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `full_name`, `password`, `phone`, `username`) VALUES
(4, 'Pham Hung Admin', '$2a$10$Vdh/3KR3VjtYrEeceDdu4u9LOj1aR79AeAiHn8FYwgzHdj7A4tyGi', '0748965222', 'hungpham28092003@gmail.com'),
(25, 'hunglLL', '$2a$10$5T4twSXVChF0qMrzQADG/.K8/He2aewMkGzHS.pcJjPXlJZMctuHm', '0906458725', 'hungpham28@gmail.com'),
(26, 'Pham Hung Ha', '$2a$10$OX/AxTFN8k56OGzcLHSdUOC1ljoGeTbAZy3XFYCyGcR/hW9p4LlXO', '0906458725', 'hungpham284@gmail.com'),
(27, 'hung nguyen', '$2a$10$xn1thBMlgLGPPEiucdZH0.h./NrUMX6sd6gVpXtrerqJwAjAO/9.G', NULL, 'hung@gmail.com'),
(29, 'ADMIN', '$2a$10$zrJUHGHpuXN6hf3x.9ndvek3kAm.RFBuChUe3uw9fsJ..fmOIjXAe', NULL, 'admin@gmail.com'),
(40, 'Nguyễn Nguyên', '$2a$10$UuKZgsrsoy2vLxYLPIqaLefB.Nz0dWYcwokpi5o0Cbj76iqrjtCZG', '0748946515', 'nguyen@gmail.com'),
(41, 'Pham Hung Hoa', '$2a$10$Tc13rwpItn2PqC6tPbYuYeoYizm3Q/4pASQSiH2yBjUX8kCITDDgy', '0748965222', 'conghuy@gmail.com'),
(42, 'Pham Hung Ha', '$2a$10$ocm.1RWUECwA8uUbaqBLLeFUVgxa2wJtYvHvrYUy5j59eVu0HGqfS', '0748946515', 'admin2@gmail.com'),
(43, 'hung', '$2a$10$sapoCQfFaXbqoMgIMIOJAO7tW3FqpEbe/oxHQ3jSb7w7TPcGbRus.', '0906458725', 'hungpham23@gmail.com'),
(44, 'Nguyễn Nguyên', '$2a$10$4Jzn0sWvYDGkZ4HKCPv7auSxqIiME7XPJqjjaCqXU7xDaqy23YUY.', '0777465394', 'conghuy23@gmail.com'),
(45, 'ABC EEE', '$2a$10$heS7M99UBE6rfAAuWNXeZOgOB7KyPzHCLIvzjp/inx6YzndpXNecO', '1234567890', 'Goo@gmail.com'),
(46, 'ádasd', '$2a$10$byjEucVB8Tg5IQtbCvYj3uCrUcb0az7BfkWnjTDylxkNuVPmveH22', '0748965222', 'ggg2n@gmail.com'),
(47, 'Pham Hung Ha', '$2a$10$4tOfSHDmJ9LrYyUgQ3NQFOZa5db3GTyoF91TN2cC96DcsMlrXc2zy', '0748965222', 'adm2@gmail.com'),
(48, 'Pham Hung', '$2a$10$lKWRClnpJSolvM8KGrz0Ieh.lsq4vEZbws7xI/.BstkpmSzCCIssK', '0748965222', 'admin46@gmail.com'),
(49, 'Pham Hung Ha', '$2a$10$ucCX/bPF8.e7aW6Rm8sXu.RdQshq8bj53PdYYnVOOD2hoEwGp29JC', '0906458725', 'hung003@gmail.com'),
(50, 'quay', '$2a$10$q0tpne695ylFWIthEkgA.u6kfeoRqb1hOIv.0OhZylaV.JrFugcLK', '0748946515', 'anhemnhaquay113@gmail.com'),
(51, 'Pham Hung Ha', '$2a$10$bMyIVi4kbplX7HB8zzxYo.7IbWtA134kX4VQy6MmtbHTYSu8Kd95K', '1234567890', 'hungpham@gmail.com'),
(52, 'nguyenanhnguyen2805@gmail.com', '$2a$10$x2LRc2gavwnaUJYqQ2ZQ0u2k7FHcObYgKGHCjYErVUAWFRl9JTyfu', '6346543643', 'nguyenanhnguyen2805@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(4, 1),
(4, 2),
(25, 1),
(26, 1),
(27, 1),
(29, 1),
(29, 2),
(40, 1),
(41, 1),
(42, 1),
(42, 2),
(43, 1),
(44, 1),
(45, 1),
(46, 1),
(48, 1),
(48, 2),
(50, 1),
(51, 1),
(52, 1),
(52, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_points`
--

CREATE TABLE `user_points` (
  `id` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqhq5aolak9ku5x5mx11cpjad9` (`user_id`);

--
-- Chỉ mục cho bảng `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `discounts`
--
ALTER TABLE `discounts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_bc29q3wh0lqhy0k84bx3afk08` (`code`);

--
-- Chỉ mục cho bảng `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `reset_password_token`
--
ALTER TABLE `reset_password_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf2tlmidtga0ohscum2abphe9o` (`user_id`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3mf32q0hwpnmu7rf58gjtjrmj` (`branch_id`);

--
-- Chỉ mục cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4ak7m8did07y741qbt2mm45c0` (`branch_id`),
  ADD KEY `FKa6hosaihwhtb3scvamdyh9mlv` (`movie_id`),
  ADD KEY `FKh2hdhbss2x31ns719hka6enma` (`room_id`);

--
-- Chỉ mục cho bảng `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd7f42843rt05tt66t6vcb7s9u` (`room_id`);

--
-- Chỉ mục cho bảng `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf9rrxu78kmw44u3xfarqpaa2r` (`bill_id`),
  ADD KEY `FKdmmaqgvu0kjjlpsivmgnvurl5` (`schedule_id`),
  ADD KEY `FKqahao9a85drt47ikjp0b8syvh` (`seat_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`);

--
-- Chỉ mục cho bảng `users_roles`
--
ALTER TABLE `users_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`);

--
-- Chỉ mục cho bảng `user_points`
--
ALTER TABLE `user_points`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK483n1vbpcmhfb34012chx3nd3` (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT cho bảng `branch`
--
ALTER TABLE `branch`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `discounts`
--
ALTER TABLE `discounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `feedbacks`
--
ALTER TABLE `feedbacks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `room`
--
ALTER TABLE `room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT cho bảng `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT cho bảng `seat`
--
ALTER TABLE `seat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5073;

--
-- AUTO_INCREMENT cho bảng `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=142;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT cho bảng `user_points`
--
ALTER TABLE `user_points`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `FKqhq5aolak9ku5x5mx11cpjad9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `reset_password_token`
--
ALTER TABLE `reset_password_token`
  ADD CONSTRAINT `FKf2tlmidtga0ohscum2abphe9o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FK3mf32q0hwpnmu7rf58gjtjrmj` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `FK4ak7m8did07y741qbt2mm45c0` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKa6hosaihwhtb3scvamdyh9mlv` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKh2hdhbss2x31ns719hka6enma` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `FKd7f42843rt05tt66t6vcb7s9u` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `FKdmmaqgvu0kjjlpsivmgnvurl5` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKf9rrxu78kmw44u3xfarqpaa2r` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKqahao9a85drt47ikjp0b8syvh` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

--
-- Các ràng buộc cho bảng `user_points`
--
ALTER TABLE `user_points`
  ADD CONSTRAINT `FK483n1vbpcmhfb34012chx3nd3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
