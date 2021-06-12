package com.example.appdoctruyen.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appdoctruyen.model.TaiKhoan;
import com.example.appdoctruyen.model.Truyen;

public class DatabaseDocTruyen extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "doctruyen";
    private static String TABLE_TAIKHOAN = "taikhoan";
    private static String ID_TAI_KHOAN = "idtaikhoan";
    private static String TEN_TAI_KHOAN = "tentaikhoan";
    private static String MAT_KHAU = "matkhau";
    private static String PHAN_QUYEN = "phanquyen";
    private static String EMAIL = "email";
    private static int VERSION = 1;

    private static String TABLE_TRUYEN = "truyen";
    private static String ID_TRUYEN = "idtruyen";
    private static String TEN_TRUYEN = "tieude";
    private static String NOI_DUNG = "noidung";
    private static String IMAGE = "anh";


    private Context context;


//    public String SQLQuery1 = "CREATE TABLE "+ TABLE_TRUYEN +" ( "+ID_TRUYEN+" integer primary key AUTOINCREMENT, "
//            +TEN_TRUYEN+" TEXT UNIQUE, "
//            +NOI_DUNG+" TEXT, "
//            +IMAGE+" TEXT, "+ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +" ) REFERENCES "+
//            TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+"))";

    public String SQLQuery2 = "INSERT INTO TaiKhoan VAlUES (null,'admin','admin','admin@gmail.com',2)";
    public String SQLQuery3 = "INSERT INTO TaiKhoan VAlUES (null,'anh','anh','anh@gmail.com',2)";
    public String SQLQuery11 = "INSERT INTO TaiKhoan VAlUES (null,'anhpt','anhpt','anhpt@gmail.com',1)";

    public String SQLQuery4 = "INSERT INTO truyen VALUES (null,'Băng hỏa chí tôn ','Tại một hồ nước trong veo không một gợn sóng nằm trong lòng một khu rừng được bao quanh bởi cây cối um tùm, có thể thấy được từng đàn cá tung tăng bơi lội dưới hồ, xung quanh được bao phủ bởi một rặng liễu đang rũ xuống bờ hồ. Cảnh vật làm cho người ta trào dâng một cảm giác hiu quạnh và man mác buồn.\n" +
            "\n" +
            "Ngay tại trung tâm hồ nước này có một mái đình nhỏ, phía trên được che chắn bằng một vòm mái hình bát giác, bên trong mái đình là một hình bóng nữ nhi diện một bộ y phục màu tím, mái tóc dài buông thả xuống ngang lưng để lộ ra một màu tím nhạt khá đặc biệt. Đôi mắt long lanh vương chút u sầu, đôi tử sắc đồng tử bên trong khẽ co lại khi nhìn về phương xa. Làn da trắng mịn nhưng có chút nhợt nhạt, có lẽ là do thể chất ốm yếu từ nhỏ, đôi cánh tay mảnh khảnh bắt chéo trước bụng để lộ một thân hình gầy gò, mảnh khảnh. Thoạt nhìn qua liền có một cảm giác là một tiểu mỹ nhân nhưng nếu để ý kỹ sẽ phát hiện ra vài điểm bất thường trên cơ thể thiếu nữ này.\n" +
            "\n" +
            "“Tỷ tỷ, mẫu thân cho gọi tỷ, mau về thôi”\n" +
            "\n" +
            "Một giọng nói lảnh lót vang lên, nữ nhi tóc tím giật mình xoay người lại thì nhận ra đó là một cô bé chừng mười tuổi, mặc bộ y phục màu xanh lục tràn đầy sức sống, mái tóc màu xanh lục được thắt thành hai bím tóc hai bên trông cực kỳ đáng yêu. Hai má phúng phính đỏ ửng lên, hơi thở có chút gấp gáp, mệt nhọc, chắc là do chạy vội từ xa đến. Thân hình tròn trịa dễ thương, hoàn toàn trái ngược với người tỷ tỷ ốm yếu xanh xao của cô bé.\n" +
            "\n" +
            "Nhìn thấy bóng dáng đáng yêu đó, tử y nữ nhi liền nở một nụ cười hiền từ ấm áp. Hẳn là nàng ta cũng rất cưng chiều tiểu cô nương này.\n" +
            "\n" +
            "“Được, vậy ta cùng về gặp mẫu thân”\n" +
            "\n" +
            "Bàn chân khẽ di chuyển, thân hình mảnh mai đó liền lập tức biến mất bên trong đình, thoáng cái đã xuất hiện ngay bên cạnh tiểu cô nương kia.\n" +
            "\n" +
            "“ Tỷ tỷ, chiêu Phi Tuyết Vô Ảnh của tỷ càng lúc càng thành thục rồi đó nha, hôm nào tỷ dạy cho muội với nhé!” đôi mắt tròn xoe của tiểu cô nương nhìn vào khuôn mặt có chút mệt mỏi của tỷ tỷ nàng, ngưỡng mộ nói.\n" +
            "\n" +
            "“ Được, nhưng trước hết muội phải khai thông tất cả kinh mạch cơ bản bên trong cơ thể trước đã, nếu không sẽ không thể vận khí lực trong cơ thể để thi triển chiêu thức này được đâu” Tử y thiếu nữ cười cười nhìn tiểu cô nương vận lục y nói.\n" +
            "\n" +
            "“ Muội sẽ cố gắng, nhất định không để thua tỷ tỷ đâu” khuôn mặt xếch lên lộ vẻ đắc ý, chiếc lưỡi xinh xắn lè ra làm điệu bộ trêu chọc, cười nói.“ Được rồi, chắc chắn muội sẽ vượt qua tỷ thôi, giờ thì đi nào kẻo mẫu thân lại nổi giận thì tỷ không chịu trách nhiệm đâu” tử y nữ nhi nói.\n" +
            "\n" +
            "Tiểu cô nương với mái tóc màu xanh lục nghe vậy liền nhanh chóng gật đầu. Hai người thiếu nữ hướng về phía trung tâm của khu rừng chạy tới, trong chớp mắt cả hai đã hoàn toàn biến mất.','https://static.8cache.com/cover/eJzLyTDWL3LNKioxCk1xdrEIyU0vdS61TMotSTRzMjH3NjAr83UPtwgpyMxyjE9ODE2tNDd21rXIK7L0KrfICTNJCwoNrvAPLSjwTdat9E8OTfbJ9gm3LTe0MNDNsDAAAKayHk8=/bang-hoa-chi-ton.jpg',1)";
    public String SQLQuery5 = "INSERT INTO truyen VALUES (null,'Hộ thiên thần giáo','Trong bóng tối u tịch và nồng nặc mùi ẩm mốc tanh tưởi, tiếng gào thét khản đặc như xé vào không gian những thanh âm đau đớn đầy thống khổ. Giữa màn đêm mùa đông lạnh buốt giá, trên thân cột hình chữ “đại” (大) ướt đỏ được dựng đứng sừng sững giữa trời, có một nam nhân đang bị trói chặt bằng những bện dây gai thít sâu vào da thịt, tứ chi bị cố định bởi mấy chiếc đinh sắt hoen gỉ, đóng xuyên thủng cánh tay, bàn tay và bàn chân. Khắp cơ thể y be bét máu và chằng chịt trăm ngàn vết thương lở loét chồng chéo nhau hết sức ghê rợn. Từng nhát roi từ hai gã cai ngục liên tục giày vò dã man khiến y oằn mình quằn quại trông vô cùng thảm thương.\n" +
            "\n" +
            "Gã nam nhân ấy lúc thì nghiến răng rên xiết, lúc thì kêu rống khổ sở, có lúc lại điên dại bật cười như mê sảng. Trong tâm trí y không ngừng vang vang những câu đay nghiến chẳng khác gì gươm đao băm dầm phầm phập vào trong óc:\n" +
            "\n" +
            "- Thật nhục nhã, Lam Thiên. Ngươi đường đường là một Giáo Chủ cao quý của Hộ Thiên Thần Giáo, thế mà lại có thể làm ra thứ chuyện bại hoại như vậy. Kẻ phản bội, ngươi đáng bị chà đạp, bị đối xử như súc sinh. Ngươi càng cứng đầu, càng phải chịu khổ sở. Ngươi sẽ phải bất lực nhìn những thứ vớ vẩn ngươi cho là lý tưởng bị sụp đổ tan nát, đáng thương hại cho ngươi. Ngươi đã hối hận lắm chưa?\n" +
            "\n" +
            "Giữa cơn đau đớn thể xác đến cùng cực, nam nhân nọ vẫn nhoẻn miệng cười đầy đắc ý. Y khò khè độc thoại trong tiếng thở khó nhọc và khô rát nơi cuống họng:\n" +
            "\n" +
            "- Hối hận ư? Không hề, không bao giờ. Làm Giáo Chủ để được cái quái gì chứ? Chẳng qua chỉ muốn biến ta thành một con rối sống rẻ mạt qua ngày thôi. Ta cóc cần.\n" +
            "\n" +
            "Nói đoạn, y bất chợt gào lên:\n" +
            "\n" +
            "- Ta đang rất hài lòng đây, tới nữa đi, đánh mạnh vào! Ta bảo đánh mạnh vào!\n" +
            "Y vừa lớn giọng thách thức, vừa ha hả cười như rồ như dại. Những nhát roi thô bạo vẫn liên tục đánh xuống chan chát, từng tia máu đỏ vung vẩy tung tóe như mưa phùn, mãi một lúc rất lâu sau mới ngừng lại, không gian mới dần dần trầm lắng xuống.\n" +
            "\n" +
            "Hai dòng lệ hòa với sắc đỏ lấm lem bắt đầu chảy dài hai hàng trên gương mặt nhếch nhác rũ rượi của y.\n" +
            "\n" +
            "- Ta không hối hận - Y run rẩy rên xiết - Ta không hề hối hận. Sau ba trăm năm tồn tại vô nghĩa, ta cuối cùng cũng đã biết cái cảm giác như thế nào là... được sống…\n" +
            "\n" +
            "Đến đây, mọi thứ trước mắt gã nam nhân bỗng chốc trở nên mơ hồ. Y gục đầu thõng xuống mà bất tỉnh. Dòng ký ức mông lung của y tựa một con suối nhỏ, trôi theo cơn mộng mị vô thường chảy dần về một vùng trời xám đen trong tiềm thức.\n" +
            "\n" +
            "……….\n" +
            "\n" +
            "Những bậc thang dài vô tận mỗi lúc một tiến sâu vào trong lòng đất. Tử khí xung quanh bốc lên nồng nặc và ngột ngạt một cách khó tả, cộng thêm nhiều thứ mùi hôi thối tanh tưởi bao trùm dày đặc, có thể làm choáng váng bất kì ai chẳng may lạc lối vào chốn này. Thế mà hai gã gia đinh của nhà Lãnh Chúa họ Triệu mặt mày vẫn tỉnh táo như không. Tuy mỗi tên đều đeo một cái cũi lớn được phủ kín bằng vải đen trên vai, nhưng đôi chân chúng vẫn rảo bước cực kì nhanh nhẹn và nhẹ nhàng, trông chẳng thua kém gì những vị cao thủ sừng sỏ.\n" +
            "\n" +
            "Qua hết các bậc thang, chúng lại tiếp tục đi đến một căn hầm tối tăm chỉ có chút ánh sáng le lói từ nơi cuối đường. Dù vậy vẫn dễ dàng nhìn thấy hai bức tường hai bên treo đầy xác trẻ con, cả những cái xác còn mới, đến những cái đang phân hủy nham nhở giòi bọ. Những bộ xương khô lổn ngổn móc với nhau thành từng tụm như cách người ta móc thịt lợn trong lò mổ, trông vô cùng tởm lợm và kinh hãi.\n" +
            "\n" +
            "Nói phải kể đến nhà họ Triệu, tộc Kinh Nhân, sinh sống ở vùng lục địa Thái Bình Thượng, thuộc vương triều Ly Quốc, vốn từng có năm đời làm tướng quân trong hoàng gia, trung thành cống hiến, cúc cung tận tụy, lập nhiều đại công nên được thí thưởng biết bao bổng lộc, thụ hưởng vinh hoa phú quý dư đầy vô lượng. Tới đời thứ sáu, Triệu gia chính thức được Nữ Hoàng Ly Quốc ban đất đai, xây tặng một dinh thự cạnh bờ hồ Thủy Tiên và trở thành một vị Lãnh Chúa thực thụ, bắt đầu nắm quyền cai quản một phần của đồng bằng châu thổ Tây Bắc. Họ vẫn tiếp tục truyền thống hành hiệp trượng nghĩa từ tổ tông, tiêu diệt đảng ác, cứu tế dân nghèo trong khu vực cũng như bất kỳ nơi nào cần sự giúp đỡ. Nhờ vậy, tiếng lành càng ngày càng đồn xa, sự nể trọng dành cho Triệu gia, đặc biệt là vị đương kim Lãnh Chúa, Triệu Vĩnh Toàn mỗi lúc một to lớn. Người đời luôn gọi họ bằng những danh xưng đầy tôn kính như là Tiên nhân hoặc Thánh sống. Thế mà có mấy ai ngờ được, ẩn đằng sau bức tường thành cao quý và đáng kính kia lại tồn tại một cảnh tượng kinh hoàng đến như vậy.','https://static.8cache.com/cover/eJzLyTDWLysx9K0ICi8zMbZMSjXS9fVJ9wzIdgrOjbd0Ti3PzDePDC0o8DDIy80o8M4uDI43DbOwrEiODPCM8jIuNUy1qAjOCTR30_UvK0gq9faw0A23LTe0MNDNsDAAAKg2HhQ=/ho-thien-than-giao.jpg',1)";
    public String SQLQuery6 = "INSERT INTO truyen VALUES (null,'Ngạo thế đan thần','Giữa bầu trời mây đen nằm dày đặc, thỉnh thoảng sẽ bốc lên một tia chớp, kèm theo từng tiếng sấm rền, một trận mưa lớn sắp xảy ra.\n" +
            "\n" +
            "Bên trong Ngọa Hổ thành, Trầm Tường ngửa đầu nhìn bầu trời, thì thào nói rằng:\n" +
            "\n" +
            "- Không thể kéo dài được nữa, ta phải nhanh chóng tìm được linh dược tốt, bằng không ta khó có thể có cơ hội xoay người.\n" +
            "\n" +
            "Năm nay Trầm Tường mười sáu tuổi, thân hình so với bạn cùng lứa tuổi thì cường tráng cao lớn hơn, thân thể này cùng gương mặt tuấn tú mang theo tính trẻ con, nhìn rất là trái ngược, nhưng cặp mắt kia của hắn lại thâm thúy không tương xứng cùng tuổi tác, xem ra nhàn đến muốn thành thục hơn so với bạn cùng lứa tuổi một ít.\n" +
            "\n" +
            "Lúc này Trầm Tường muốn đi hái thuốc, mặc dù hắn là trưởng tôn tử của Trầm gia tộc, nhưng bởi vì hắn không có linh mạch, không thể trở thành một võ giả lợi hại, bởi vậy, từ nhỏ hắn đã rất chăm chỉ rèn luyện thân thể của mình, thường thường ra ngoài tiến hành các loại huấn luyện bí mật, thậm chí còn tiến hành tranh đấu với Hổ thú, tuy hắn tuổi còn trẻ, nhưng cũng từng có mấy lần trải qua sinh tử, tâm tình cùng ý chí đều hơn xa bạn cùng lứa tuổi.\n" +
            "\n" +
            "- Đây không phải là Trầm Tường sao? Sắp có mưa to, ngươi còn muốn đi rèn luyện sao?\n" +
            "Một lão quản gia đi tới nói, thấy Trầm Tường hăng hái như vậy, hắn không khỏi kính phục, nhưng trong ánh mắt càng nhiều chính là tiếc hận.\n" +
            "\n" +
            "Mỗi ngày Trầm Tường đều chăm học khổ luyện, đến nay sáu năm, nhưng vẫn dừng lại ở Phàm Võ Cảnh tầng ba, con cháu Trầm gia cùng tuổi với hắn, đại đa số đều tiến vào Phàm Võ Cảnh tầng bốn, lợi hại càng là tiến vào tầng năm.\n" +
            "\n" +
            "Tất cả những thứ này đều là bởi vì hắn không có linh mạch, cho nên mới không được gia tộc coi trọng, mà bây giờ hắn chỉ là một người rất bình thường bên trong Trầm gia.\n" +
            "\n" +
            "Tuy không có linh mạch, nhưng xưa nay Trầm Tường chưa bao giờ nhụt chí, vẫn đều đang nỗ lực rèn luyện chính mình, chí ít trong quá trình nỗ lực để hắn cảm giác mình rất phong phú.\n" +
            "\n" +
            "- Lão Mã, ta là đi hái thuốc.\n" +
            "\n" +
            "Trầm Tường chạy đến phía sau lão quản gia, cười cợt nói chuyện với hắn.\n" +
            "\n" +
            "- Vô dụng thôi, ngươi không có linh mạch, bất kể nỗ lực thế nào đều là không làm nên chuyện gì!\n" +
            "\n" +
            "Lão quản gia kia lắc đầu than thở.\n" +
            "\n" +
            "Đối với lời như vậy, Trầm Tường nghe qua vô số lần, nhưng hắn vẫn kiên trì như cũ, dù như thế nào hắn cũng sẽ không bỏ qua.\n" +
            "\n" +
            "- Tường nhi, khí trời như vậy cũng đừng đi nữa!\n" +
            "\n" +
            "Lúc này, một nam tử trung niên đi tới.\n" +
            "\n" +
            "Trầm Tường bĩu môi, nói rằng:\n" +
            "\n" +
            "- Cha, trời mưa xuống hái thuốc là một thời cơ tốt, chí ít không cần cướp đến bể đầu chảy máu cùng người khác.\n" +
            "\n" +
            "Người đàn ông trung niên này tên là Trầm Thiên Hổ, là phụ thân của Trầm Tường, là một võ giả cường đại danh chấn một phương, cũng là người có hy vọng kế thừa Trầm gia tộc trưởng đời kế tiếp nhất, tuy con trai hắn không có linh mạch, nhưng hắn vẫn cổ vũ Trầm Tường, vẫn thỉnh thoảng cho hắn một ít đan dược trân quý, chỉ bất quá vẫn là không làm nên chuyện gì.\n" +
            "\n" +
            "- Cầm.\n" +
            "\n" +
            "Trầm Thiên Hổ bất đắc dĩ nở nụ cười, vứt cho Trầm Tường một cái hộp nhỏ.\n" +
            "\n" +
            "Trầm Tường tiếp nhận cái hộp, cũng không thèm nhìn tới đồ vật bên trong, hắn biết bên trong là đan dược, cười cợt nói:\n" +
            "\n" +
            "- Đa tạ cha, như vậy ta cũng không cần đi trộm những con gà này của Mã lão đầu để bổ dưỡng thân thể.\n" +
            "\n" +
            "Điều này làm cho Mã quản gia kia mặt đầy cay đắng, hắn không nghĩ tới mình dĩ nhiên bị nhìn chằm chằm.\n" +
            "\n" +
            "Nhìn bóng lưng Trầm Tường biến mất, Trầm Thiên Hổ chỉ có thể thở dài, tuy hắn ở Trầm gia có địa vị rất cao, nhưng Trầm gia trưởng lão quản lý đối với những đan dược trân quý hi hữu này rất nghiêm khắc, hắn chỉ có thể lấy của bản thân cho Trầm Tường, nhưng cái này cũng không có tác dụng gì, bởi vì đan dược quá ít.\n" +
            "\n" +
            "Làm cha, cái nào không hy vọng nhi tử thành Long? Chỉ bất quá Trầm Thiên Hổ cũng không có cách nào, hắn chỉ có thể làm hết sức, tranh thủ đan dược cho Trầm Tường.\n','https://static.8cache.com/cover/eJzLyTDW163MTDcPSAsrt4z3qUwrSIwqs3CqqDQusTCryPbNcwtKqnANNy1ONTPPKQz0yvIJMSgKz4ysSjP2TknKdAwPDw9Nt3APq8wKMUxKCg7wMwmzLTe0MNDNsDAAAN71HwM=/ngao-the-dan-than.jpg',1)";
    public String SQLQuery7 = "INSERT INTO truyen VALUES (null,'Đan võ thần tôn','\"Vì cái gì!\"\n" +
            "\n" +
            "Theo một tiếng thê lương rống to, Diệp Tinh Hà đột nhiên mở to mắt.\n" +
            "\n" +
            "Ánh mắt lộ ra khắc cốt hận ý! Diệp Tinh Hà, Thanh Vân thành, Diệp gia, gia chủ con thứ! Từ nhỏ triển lộ thiên tài chi tư, tám tuổi câu thông thiên địa linh khí, mười tuổi ngưng tụ Đạo cung, mười ba tuổi thức tỉnh Nhân cấp cửu phẩm mệnh hồn! Thanh Vân thành chấn động! Đạo cung có hồn, là vì mệnh hồn.\n" +
            "\n" +
            "Mệnh hồn, quyết định võ giả tương lai tu vi cực cao thấp.\n" +
            "\n" +
            "Mệnh hồn đẳng cấp, từ thấp đến cao, là: Nhân, địa, thiên, thần! Diệp Tinh Hà thiên phú, chính là Thanh Vân thành trăm năm đệ nhất nhân! Càng tại nửa năm trước đó, tiến vào phạm vi ngàn dặm, quy mô lớn nhất Lăng Vân tông, trở thành đệ tử chính thức.\n" +
            "\n" +
            "Mệnh hồn của hắn, là cực kỳ hiếm thấy luyện đan loại mệnh hồn: Long Văn Tử Kim Đỉnh.\n" +
            "\n" +
            "Hắn mệnh hồn, giao phó hắn mạnh mẽ luyện đan thiên phú! Năm gần 15, liền trở thành trẻ tuổi nhất Luyện Đan sư học đồ! Tiền đồ bất khả hạn lượng! Nhưng, mười ngày trước đó, lại bị lừa gạt hồi phủ bên trong.\n" +
            "\n" +
            "Đánh vỡ Đạo cung, bóc ra mệnh hồn! Hắn nhân cấp cửu phẩm mệnh hồn, bị hắn cha ruột Diệp Tuyền, sinh sinh đào ra! Ở ngay trước mặt hắn, đại ca của hắn, Diệp Hồng, đem mệnh hồn luyện hóa! Dung nhập bản thân! Võ hồn cảnh giới tăng vọt! Mà hắn, đan điền phá toái, bản thân bị trọng thương, quẳng ngã vào trong vũng máu, chỉ còn một hơi.\n" +
            "\n" +
            "Diệp Tuyền cùng Diệp Hồng, nhìn cũng chưa từng nhìn hắn liếc mắt! Lại khi tỉnh lại, đã là thân tại địa lao.\n" +
            "\n" +
            "Cùng lúc đó, một tin tức truyền khắp Thanh Vân thành: Diệp gia con trai trưởng Diệp Hồng, ngẫu nhiên đạt được đại cơ duyên, võ hồn cảnh giới tăng lên, tăng vọt chí nhân cấp cửu phẩm! Diệp Hồng, thành là thiên tài! Mà hắn, biến thành phế nhân! Diệp Tinh Hà đem bị lãng quên, thậm chí muốn chết tại âm u trong địa lao! Địa lao cửa lớn phát ra một tiếng chói tai tiếng ma sát, \"Nha, còn chưa có chết?\n" +
            "\n" +
            "Một đầu tiện mệnh vẫn rất có thể khiêng?\"\n" +
            "\n" +
            "Một đạo tràn ngập trêu tức thanh âm vang lên.\n" +
            "\n" +
            "Một tên hoa phục thanh niên đi tới, trên dưới hai mươi tuổi, đánh giá Diệp Tinh Hà.\n" +
            "\n" +
            "Tại bên cạnh hắn, thì là một tên uy nghiêm trung niên.\n" +
            "\n" +
            "Dáng người gầy gò, khuôn mặt lạnh lẽo cứng rắn, đôi môi thật mỏng mang theo vài phần cay nghiệt.\n" +
            "\n" +
            "Diệp Tuyền! Diệp Hồng! Diệp Hồng nhìn xem Diệp Tinh Hà, khuôn mặt tràn đầy vặn vẹo hưng phấn!\"Diệp Tinh Hà, ngươi không biết đi, hiện tại ta đã là Nhân cấp cửu phẩm võ hồn, được vinh dự Thanh Vân thành đệ nhất thiên tài!\"\n" +
            "\n" +
            "Hắn phát ra đắc ý cười to: \"Mà ngươi tên tiện chủng này! Liền muốn tại địa lao bên trong vượt qua cuối đời!\"\n" +
            "\n" +
            "\"Vì cái gì?\"\n" +
            "\n" +
            "Diệp Tinh Hà ngẩng đầu lên, hắn nhìn cũng chưa từng nhìn Diệp Hồng, chẳng qua là nhìn chằm chằm Diệp Tuyền, mỏng manh hỏi.\n" +
            "\n" +
            "Diệp Tinh Hà từ Tiểu Thiên Tài, thanh danh vang dội, nhưng Diệp Tuyền đối với hắn cực kỳ lạnh lùng.\n" +
            "\n" +
            "Trong phủ, địa vị của hắn, thậm chí không như sau người.\n" +
            "\n" +
            "Tài nguyên tu luyện, cũng là cực ít.\n" +
            "\n" +
            "Mà Diệp Hồng, cơm ngon áo đẹp, lượng lớn tài nguyên trút xuống.\n" +
            "\n" +
            "Càng về sau, Diệp Tinh Hà phong mang, đã che lại Diệp Hồng.\n" +
            "\n" +
            "Diệp Tuyền đối với hắn càng càng lạnh lùng, Diệp Hồng thì nhiều lần khiêu khích.\n" +
            "\n" +
            "Diệp Tinh Hà nhớ thân tình, chủ động rời khỏi gia tộc, đi đến Lăng Vân tông.\n" +
            "\n" +
            "Không nghĩ tới, lại bị như thế đối đãi! Diệp Tuyền thanh âm lãnh khốc vô cùng: \"Rất đơn giản, bởi vì Diệp Hồng là ta con trai trưởng! Là chính thất nhi tử!\"\n" +
            "\n" +
            "\"Mà ngươi, là cái kia tiểu tiện nhân sinh ra ti tiện con thứ!\"\n" +
            "\n" +
            "Diệp Hồng cười như điên nói: \"Ngươi tiện chủng này, ngươi vừa ra đời bắt đầu, liền đã định trước, chỉ là ta một khối bàn đạp!\"\n" +
            "\n" +
            "\"Luyện hóa người khác võ hồn, nơi nào có đơn giản như vậy?\"\n" +
            "\n" +
            "\"Vì luyện hóa võ hồn của ngươi, ta tu luyện môn công pháp này ròng rã mười tám năm!\"\n" +
            "\n" +
            "Diệp Tuyền yên lặng, hiển nhiên là chấp nhận lời nói này! Diệp Tinh Hà lạnh cả người!\"Ta theo xuất sinh bắt đầu, liền nhất định là bàn đạp?\"\n" +
            "\n" +
            "Sau một khắc, Diệp Tinh Hà cười.\n" +
            "\n" +
            "Máu me đầy mặt, nụ cười dữ tợn, nhưng hắn cười cực kỳ thoải mái.\n" +
            "\n" +
            "Trong tiếng cười lớn, Diệp Tinh Hà cảm giác mình lòng tràn đầy thoải mái.\n" +
            "\n" +
            "Trước đó gông cùm xiềng xích ở hắn, khiến cho hắn không được tự do, cực kỳ khó chịu hết thảy xiềng xích, đột nhiên, đều bị đánh nát! Tiếng cười hạ xuống, hắn chật vật ngẩng đầu lên: \"Đây là ta một lần cuối cùng gọi phụ thân ngươi!\"\n" +
            "\n" +
            "\"Diệp Tuyền!\"\n" +
            "\n" +
            "\"Từ hôm nay trở đi, ngươi ta, ân đoạn nghĩa tuyệt!\"\n" +
            "\n" +
            "\"Ta từ nhỏ trong nhà, thiếu ăn thiếu mặc, địa vị còn không như sau người! Càng là nhận hết đối xử lạnh nhạt, không được ngươi nửa điểm yêu thích!\"\n" +
            "\n" +
            "\"Đạo này mệnh hồn, đủ để hoàn lại tất cả những thứ này!\"\n" +
            "\n" +
            "Diệp Tinh Hà thanh âm âm vang, tại địa lao bên trong cuồn cuộn.\n" +
            "\n" +
            "Diệp Tuyền nhìn Diệp Tinh Hà một dạng, thanh âm lạnh lẽo cứng rắn: \"Quả nhiên là nuôi không quen kẻ vô ơn bạc nghĩa, ti tiện con thứ!\"\n" +
            "\n" +
            "Dứt lời, quay người liền đi.\n" +
            "\n" +
            "Diệp Hồng cũng không rời đi Diệp Hồng bỗng nhiên khóe miệng lộ ra một vệt quỷ dị: \"Đúng rồi, Diệp Tinh Hà, ta chỗ này còn có một phong thư, ngươi có muốn hay không nghe một chút?\"\n" +
            "\n" +
            "Không đợi Diệp Tinh Hà nói chuyện, hắn liền tung ra một phong thư, chậm rãi nhớ kỹ.\n" +
            "\n" +
            "\"Diệp bá phụ ở trên, chất nữ Tình Tuyết bái lên. . .\" Diệp Tinh Hà toàn thân chấn động: \"Tình Tuyết tin?\"\n" +
            "\n" +
            "Tô Tình Tuyết.\n" +
            "\n" +
            "Chính là Diệp Tinh Hà vị hôn thê! Tô gia, chính là Lăng Vân tông nhìn môn, trước đó Diệp Tinh Hà dùng thiên tài chi tư tiến vào Lăng Vân tông, bị Tô gia gia chủ coi trọng.\n" +
            "\n" +
            "Tô Tình Tuyết cũng là lúc nào cũng chiếu cố, ôn nhu chậm rãi, ở chung hơn năm.\n" +
            "\n" +
            "Cả hai định ra đính hôn, tình cảm thâm hậu.\n" +
            "\n" +
            "Diệp Hồng khóe miệng lộ ra một vệt trêu tức, tiếp tục thì thầm: \"Gần đây, nghe nói Diệp Tinh Hà gặp đại biến, biến thành phế nhân.\n" +
            "\n" +
            "Từ xưa kết hôn, môn đăng hộ đối, nay Diệp Tinh Hà đã đến nước này, định Vô Nhan trèo cao.\"\n" +
            "\n" +
            "\"Cố hôm nay gửi thư, đính hôn như vậy coi như thôi!\"\n" +
            "\n" +
            "Từ hôn! Tô gia, từ hôn! Một phong thư bên trong, nửa phần ân cần thăm hỏi Diệp Tinh Hà đều không có! Biết được Diệp Tinh Hà biến thành phế nhân, không rõ sống chết, bọn hắn không quan tâm, không thèm để ý, ngược lại! Phản bội hắn! Người cũng không tới, chỉ đưa một phong thư đến, liền như là, nắm Diệp Tinh Hà như một con chó một dạng.\n" +
            "\n" +
            "Đuổi ra khỏi nhà! Diệp Hồng run lên trong tay tin, trêu tức cười nói: \"Diệp Tinh Hà, nghe được rồi hả?\"','https://static.8cache.com/cover/eJzLyTDWD8qLcHTJKPc2DNFNMc1P8ixxNctN99MNNqswdDEIMDLKc0oPcXbKC3IPzDayTHNKD4p3CzMPK87XNS03TE1MC3d0SavySfFPDTQJ83Tz8fVJdfa0LTe0MNDNsDAAALfgHcQ=/dan-vo-than-ton.jpg',1)";
    public String SQLQuery8 = "INSERT INTO truyen VALUES (null,'Anh hùng','Theo số học lão sư Đặng Vĩnh Xuyên một tiếng đọc lên, cả lớp ầm ầm cười to.\n" +
            "\n" +
            "Hầu như tất cả mọi người xoay qua chỗ khác nhìn thiếu niên tóc ngắn màu đen ngồi ở cuối phòng học, mà hắn chính là Mạc Phàm, một cái gia hỏa thi ra kỳ hoa mấy điểm hàng đơn vị.\n" +
            "\n" +
            "\"Mạc Phàm, ngươi phải cố gắng hướng về Mục Bạch học tập, người ta bài thi khó như thế đều thi 96 điểm, ngươi làm sao liền thi ra người cá biệt số lẻ đến đây, đừng phụ lòng tên của ngươi.\" Đặng Vĩnh Xuyên thở dài nói.\n" +
            "\n" +
            "Làm sao chính mình lớp ra một học sinh có vấn đề như thế, rõ ràng nhập học là người thứ nhất thành tích, đến cao trung liền lập tức sa đọa, thi đi ra thành tích vô cùng thê thảm, điên cuồng kéo điểm bình quân của lớp lùi về sau.\n" +
            "\n" +
            "\"Lão sư, hắn đã rất xứng đáng với tên gọi của hắn, Mạc Phàm, Mạc Phàm, chính là không tầm thường mà, hắn so với bình thường còn thấp mấy cấp, sắp thành cặn bã.\" Cái học sinh gọi là Mục Bạch nói rằng.\n" +
            "\n" +
            "\"Ha ha ha ha ha ~~~~ \"\n" +
            "\n" +
            "\"Nói thực đúng!\"\n" +
            "\n" +
            "\"Không hổ là Mục Bạch, mắng người cũng có thể không có lời thô tục, xác thực không tầm thường, cũng đã thành cặn bã!\"\n" +
            "\n" +
            "\n" +
            "Trong lớp một mảnh tiếng cười, mãi đến tận Đặng Vĩnh Xuyên bắt đầu giảng bài mọi người mới dừng lại.\n" +
            "\n" +
            "...\n" +
            "\n" +
            "\"Cái Mục Bạch này thật là ghê tởm, cho rằng lớn lên đẹp trai, thành tích tốt, biết âm nhạc liền rất đáng gờm a!\" Một cái Quan Cốc mặt than đen ngồi ở bên cạnh Mạc Phàm nói.\n" +
            "\n" +
            "\"Một tên ấu trĩ **** mà thôi.\" Mạc Phàm hoàn toàn khinh thường nói.\n" +
            "\n" +
            "\"Tan học đánh song bài đi a?\"\n" +
            "\n" +
            "\"Có việc, không đi.\"\n" +
            "\n" +
            "\"Lại đi giúp cái Doanh lão đầu kia a? Cái phá nhà tranh sau núi cũng chỉ ngươi dám đi, đúng rồi, ta lấy mấy quyển tiểu thuyết huyền huyễn, ma huyễn đến xem, trước mượn ngươi một quyển?\"\n" +
            "\n" +
            "\"Để trong bọc sách của ta, bất quá cái tên nhà ngươi ít xem những tiểu thuyết này đi, đều tẩu hỏa nhập ma.\" Mạc Phàm nói rằng.\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Đối với học sinh tới nói tiếng chuông tươi đẹp nhất tự nhiên là chuông tan học, sau khi kết thúc cả ngày khô khan chương trình học, Mạc Phàm ngáp một cái đeo bọc sách đi ra sau núi.\n" +
            "\n" +
            "Phía sau núi là học viện cửa sau, trên căn bản không có ai đi.\n" +
            "\n" +
            "Quan Cốc ngồi cùng bàn nói Doanh lão đầu chính là thủ vệ của phía sau núi học viện, trường học vì bảo đảm học sinh an toàn đồng thời cũng không cho học sinh nội trú từ phía sau núi chạy ra ngoài quán Internet suốt đêm, vì lẽ đó để Doanh lão đầu thủ ở nơi đó.\n" +
            "\n" +
            "Lão nhân vô thân vô cố(không người thân không bạn), quãng thời gian trước qua đời cũng không có người hỏi thăm, nhà trường giúp hắn qua loa xuống mồ.\n" +
            "\n" +
            "Mạc Phàm cùng Doanh lão đầu rất quen, trước khi lão đầu đi nói là để lại một vài thứ cho Mạc Phàm, Mạc Phàm đến ngày hôm nay mới nhớ tới lão nhân gia có ý tốt, liền đi nhìn nhà tranh của hắn.\n" +
            "\n" +
            "Doanh lão đầu luôn nói chính hắn là người truyền thừa của một cái nhân vật rất trâu bò nào đó trong lịch sử, trong tay có một cái nhẫn đồ cổ năm ngàn năm...\n" +
            "\n" +
            "Mạc Phàm thấy chiếc nhẫn kia, đen thui, căn bản là không giống cái gì đồ cổ, quan trọng nhất chính là Mạc Phàm kỳ thực đã sớm nắm chiếc nhẫn này đi giám định, lão bản thiếu kiên nhẫn đánh hắn ra ngoài nói đồng nhẫn đốt lò than đi ra cũng không cảm thấy ngại coi là đồ cổ tiền lời, vì lẽ đó Mạc Phàm liền cũng không còn tin tưởng Doanh lão đầu nói khoác những kia.\n" +
            "\n" +
            "Ý tốt của lão nhân gia trước khi đi, Mạc Phàm coi như là một cái kỷ niệm nhận lấy.\n" +
            "\n" +
            "Doanh lão đầu là một cái lão môn vệ rộng lượng, đối với sinh tử nhìn ra kỳ thực rất đạm bạc, Mạc Phàm cũng mong ước hắn đi tốt, tử vong không chừng server này không sống được nữa, đến server mới mở sống lại một lần nữa?\n" +
            "\n" +
            "\"Ngươi có tin hay không, ở song song cái chỗ vị diện tôn trọng khoa học này, còn có một cái ma pháp vị diện, ở nơi đó học tập không phải khoa học là ma pháp...\"\n" +
            "\n" +
            "Đây là một câu lời nói lên cơn của Doanh lão đầu thường thường sẽ nói với Mạc Phàm, vì lẽ đó sau khi Mạc Phàm nhìn thấy hắn rời đi cũng tin tưởng hắn đi những server khác mở nhân vật mới, vui vẻ sung sướng.\n" +
            "\n" +
            "Nhẫn rất dễ dàng liền tìm đến, trong hộp gỗ dưới giường trúc.\n" +
            "\n" +
            "Mạc Phàm mở ra hộp, lúc ẩn lúc hiện cảm giác có một luồng khí tức vẩn đục từ trong hộp tản mát ra, cảm giác còn rất mơ hồ, bất quá Mạc Phàm đều mười lăm, mười sáu tuổi, có thể sẽ không tin tưởng trên thế giới này thật sự có công pháp, càng sẽ không tin tưởng lời giải thích của Doanh lão mang theo nhẫn của hắn học tập công pháp là có thể cứu vớt vũ trụ.\n" +
            "\n" +
            "Nhẫn đen thui chính là chiếc nhẫn rất phổ thông, nhất định phải nói đặc biệt, chính là bên trong có tám cái lỗ rất nhỏ, thợ thủ công phổ thông đều làm được.\n" +
            "\n" +
            "Nhẫn đen thui lành lạnh lẽo, thời điểm Mạc Phàm mang theo đi lập tức cảm giác được một trận lạnh xuyên tim, Đại mùa hè dĩ nhiên một trận run cầm cập, có chút quái lạ!\n" +
            "\n" +
            "\"Quái lạ cái rắm a.\" Suy nghĩ chốc lát, Mạc Phàm liền phủ định cái ý nghĩ não tàn kia.\n" +
            "\n" +
            "Buổi tối còn muốn đi làm việc, chính một cơn buồn ngủ kéo tới, Mạc Phàm thu dọn một thoáng chiếu trúc nằm xuống ngay trong phòng, trước tiên ngủ một giấc, 10 giờ nào sẽ còn phải đi siêu thị 24h làm nhân viên mậu dịch, đến nấu đến hừng đông 6 giờ.\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Cơn buồn ngủ rất đậm, Mạc Phàm trực tiếp liền ngủ thiếp đi.\n" +
            "\n" +
            "Tà dương từ giữa khe núi tiết hạ xuống một đạo quang trượng đỏ như màu máu, nhuộm đỏ cánh rừng cây phía sau núi này, cũng nhuộm đỏ nhà tranh nho nhỏ này.\n" +
            "\n" +
            "Thật giống như là cánh cửa trong một vùng tăm tối chính đang chầm chậm đóng, hào quang trút vào trong bóng tối từng chút thu vào trong cửa, khi tà dương hoàn toàn chìm vào đến bên dưới ngọn núi bị tối tăm thống trị, một mảnh phía sau núi này giống như bị một tầng sắc thái kỳ dị bịt kín.\n" +
            "\n" +
            "Từ xa nhìn lại, vùng này thật giống là hư vô, cảnh tượng mơ mơ hồ hồ trong nước, hải thị thận lâu (ảo ảnh) dưới Huyết Dương!\n" +
            "\n" +
            "Thiếu niên ngủ say ở trong nhà tranh vẫn cứ đánh tiếng ngáy, không biết nhẫn trên ngón tay của hắn nhưng phát sinh tiếng kêu vù vù chói tai, như là đang đáp lại hô hoán của ảo ảnh chiếu rọi thế giới chân thật.\n" +
            "\n" +
            "\"Vù ~~~~~~~~~~~~~~~~~ \"\n" +
            "\n" +
            "Nó rung động, toàn bộ không gian cũng đang rung động!\n" +
            "\n" +
            "Trung học thủy nam tọa lạc ở vị trí nam sơn thành thị, toà Cao Long nam sơn này ở toà thành Hạ này.\n" +
            "\n" +
            "Đèn đuốc thành thị đã sáng choang, đường phố, cửa hàng, cao lầu, toàn bộ Đại Hạ ánh sáng lóng lánh rực rỡ yêu kiều, cơm tối lão nhân tản bộ, quảng trường bác gái múa tung, hẻm nhỏ hài tử truy đuổi, công viên tình nhân hẹn hò...\n" +
            "\n" +
            "Buổi tối cũng không có khiến mọi người mang đến bất kỳ bất an gì cùng sợ hãi, ngược lại là hưởng thụ loại tan học, tan tầm này, sau khi ăn xong nhàn nhã an nhàn, nhưng mà giả như có người nhìn chăm chú vị trí thành sơn mặt nam trung học Thủy Nam mà nói, nhất định sẽ phát hiện nguyên bản ánh đèn trường học hẳn là phải sáng lên chẳng biết lúc nào bao phủ ở trong một tầng hỗn độn!\n" +
            "\n" +
            "Không gian nguyên bản bình tĩnh như mặt nước, lúc này thời không trống rỗng đột nhiên xuất hiện một cái vòng xoáy giống như thôn phệ, càng diễn càng mạnh lại lặng yên không một tiếng động!\n" +
            "\n" +
            "Vừa là thành thị an nhàn an lành, đèn đuốc huy hoàng!\n" +
            "\n" +
            "Vừa là vòng xoáy màu đen nuốt hết nửa bên núi!\n" +
            "\n" +
            "Ở phía nam thành thị này vừa vào trong đêm mùa hạ tạo thành một bộ hình ảnh cực kỳ ngạc nhiên! ! !\n" +
            "\n" +
            "Không gian thời gian này dị biến bắt nguồn từ cái chỗ trống không cách nào dùng khoa học giải thích kia.\n" +
            "\n" +
            "Mà trung tâm thời không chỗ trống chính là nhà tranh phía sau núi...\n" +
            "\n" +
            "Vòng xoáy khổng lồ bỗng nhiên khuếch tán, tiếp sau đó tan thành mây khói, phảng phất hết thảy đều chưa từng xảy ra.\n" +
            "\n" +
            "Một cái nào đó chính đang say ngủ vẫn cứ đang làm mộng đẹp, không biết tất cả đã phát sinh thay đổi to lớn, rơi vào đến một vị diện song song khác.\n" +
            "\n" +
            "...\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Mưa cho ngày mùa hè chói chang này một cái quyền lạnh mạnh mẽ, chèn ép hung hăng kiêu ngạo.\n" +
            "\n" +
            "Sáng sớm không khí cực kỳ tốt, cửa trường học cửa hàng bánh bao nóng hổi toả ra mùi thơm mê người, từng cây từng cây bánh quẩy vàng rực rỡ càng là câu người muốn ăn.\n" +
            "\n" +
            "\"Thất thúc, sữa đậu nành bánh quẩy.\" Một cái thiếu niên có chút rối bù đặt mông ngồi ở trên cái ghế băng, nói với ông lão bán bánh quẩy.\n" +
            "\n" +
            "\"Đến đây.\" Bánh quẩy lão ông trên sữa đậu nành nhanh nhẹn, cố ý cho đựng đến tràn đầy, cười đến bóng loáng đầy mặt, \"Mạc Phàm a, các ngươi sắp sát hạch ma pháp đi, có thể phải cố gắng dụng công tranh thủ trên Ma Pháp sư trường đại học, cho gia tộc chúng ta tranh điểm ánh sáng a.\"\n" +
            "\n" +
            "Mạc Phàm sững sờ liếc mắt nhìn Thất thúc mình ở cửa trường học bán bữa sáng, cẩn thận suy nghĩ một chút, phỏng chừng là chính mình nghe lầm, liền vừa ăn vừa gật đầu.\n" +
            "\n" +
            "Ngày hôm qua ngủ đến hoa mắt váng đầu, cảm giác thật giống làm một cái mộng ngao du rất nhiều thế kỷ, tỉnh lại một khắc đó hướng về như cách một đời, không biết Đông Nam Tây Bắc, không biết sáng sớm buổi trưa.\n" +
            "\n" +
            "Mạc Phàm ăn như hùm như sói, cầm trên tay nửa cái bánh tiêu vừa muốn lên miệng, đột nhiên cảm giác bên cạnh chìm xuống, một cái nam tử hơn ba mươi tuổi hói nửa đầu ngồi ở bên cạnh, trên người tỏa ra một cỗ vị khói.\n" +
            "\n" +
            "\"Mạc Phàm, ăn điểm tâm a.\" Hói đầu nam tử cười chào hỏi với Mạc Phàm nói.\n" +
            "\n" +
            "\"Hồ Đoạn Trường, chào buổi sáng, chào buổi sáng.\" Mạc Phàm vội vàng cười chào hỏi.\n" +
            "\n" +
            "Người này chính là Hồ Đoạn Trường năm đoàn lừng lẫy có tiếng, mỗi ngày ăn mặc âu phục không vừa vặn, đẩy một cái trán ngói phát ánh sáng loáng.\n" +
            "\n" +
            "\"Ta không mang đồng hồ, mấy giờ rồi?\" Hồ Đoạn Trường lộ ra răng vàng đầy miệng hỏi.\n" +
            "\n" +
            "Mạc Phàm móc ra cái kia phá Nokia của mình nhìn một chút: \"Còn kém 15 phút vang chuông.\"\n" +
            "\n" +
            "\"Nát, không kịp, ta còn có cái ma pháp lý luận PPT không làm xong, điểm tâm không kịp ăn...\" Hồ đoạn trường lập tức lại đứng dậy, suýt chút nữa không để Mạc Phàm lệch trọng tâm đập.\n" +
            "\n" +
            "\"Lão bản, sữa đậu nành không muốn... Đi tới văn phòng quá chậm, quên đi, tiêu hao điểm ấy ma lực không đáng kể.\" Hồ đoàn trường ở nơi đó lầm bầm lầu bầu.\n" +
            "\n" +
            "Mạc Phàm lại là một trận rơi vào trong sương mù, cảm giác hồ đoạn sinh trưởng ở nói tiếng sao Hoa.\n" +
            "\n" +
            "Lúc vừa muốn cảm thấy là chính mình nghe lầm, bỗng nhiên lều che nắng cửa hàng sữa đậu nành một trận chuyển động vô cùng quỷ dị, giống như có cái đồ vật khí áp gì từ trung gian cửa hàng sữa đậu nành tuôn ra...\n" +
            "\n" +
            "Yêu gió thổi tới, thổi rối loạn tóc Mạc Phàm, vạt áo càng là phát tiếng phần phật.\n" +
            "\n" +
            "\"Phong quỹ • đi nhanh!\"\n" +
            "\n" +
            "Hồ Đoạn Trường bỗng nhiên nói lẩm bẩm, liền nhìn thấy âu phục không vừa vặn của hắn không tên rung động, như có cuồng phong rót vào.\n" +
            "\n" +
            "Cà vạt bay lượn, ống quần đong đưa, Mạc Phàm kinh hãi, này giời ạ đại sáng sớm làm sao nổi gió lên rồi a, còn cực kỳ khốc huyễn thổi đến trên người Hồ Đoạn Trường.\n" +
            "\n" +
            "\"Xèo ~~~~ \"\n" +
            "\n" +
            "Một đạo thanh quang xẹt qua, Mạc Phàm lúc ẩn lúc hiện nhìn thấy quanh thân Hồ Đoạn Trường xuất hiện một cái quỹ tích tinh quang hoa lệ, điều tinh quang quỹ tích này lóe lên một cái rồi biến mất.\n" +
            "\n" +
            "\"Mạc Phàm bạn học, lão sư đi trước một bước rồi, ngươi phải học tập thật giỏi a.\" Hồ Đoạn Trường xoay đầu lại, hắn hướng về Mạc Phàm lộ ra nụ cười tràn đầy răng vàng.\n" +
            "\n" +
            "Mạc Phàm đều nhìn ra có chút choáng váng, thời điểm còn không phản ứng lại, liền nghe thấy \"Vèo\" một tiếng!\n" +
            "\n" +
            "Hơi béo phì, hói đầu, âu phục không vừa vặn Hồ Đoạn Trường giống như mở ra phần mềm hack, theo quỹ tích yêu phong vừa nãy cuốn lên bụi mù cấp tốc lao nhanh về trường học! !\n" +
            "\n" +
            "Quá trình chạy nhanh vội cực kỳ nhanh này của hắn, cái bọn học sinh xuyên đồng phục học sinh đi bộ giống như bất động, mặc cho vị Hồ Đoạn Trường này ở trong đống bọn hắn nhanh chóng qua lại, chỉ để lại một đạo phong trần quỹ tích ngơ ngác...\n" +
            "\n" +
            "Thời gian ngăn ngắn mấy giây, Mạc Phàm thậm chí cảm giác Đoạn Trường mặt răng vàng còn ấn ở trước mặt mình, nhưng lúc này hắn đã biến mất ở nơi sâu cửa lớn trường học không thấy hình bóng.\n" +
            "\n" +
            "Bên tai còn vang vọng \"Ngươi phải học tập thật giỏi a\", người nhưng không thấy hình bóng, một nửa bánh quẩy vụn còn ở trong miệng nhai, nhai động tác nhưng im bặt đi, mà nửa cái bánh quẩy khác liền như vậy từ bàn tay Mạc Phàm rơi xuống! ! !\n" +
            "\n" +
            "Hồ Đoạn Trường, ngươi TM chính là Đoàn Dự truyền nhân a, tuyệt học Lăng Ba Vi Bộ đều xuất ra? ? ?\n" +
            "\n" +
            "...\n" +
            "\n" +
            "\"Đây là ảo giác, đây là nhất định là ảo giác.\" Quá rất lâu Mạc Phàm mới dụi dụi con mắt.\n" +
            "\n" +
            "Khẳng định là tối hôm qua ngủ không ngon, ép đến thần kinh não cái gì, không phải vậy làm sao sẽ thấy hình ảnh như vậy.\n" +
            "\n" +
            "Mau mau ăn xong điểm tâm, đến trong lớp đi bổ vừa cảm giác, ông trời, này đều cái gì quỷ a, sẽ Lăng Ba Vi Bộ hói đầu năm đoạn đoạn trường?\n" +
            "\n" +
            "Đến lớp học, vì hòa tan chính mình vừa nãy ảo giác, hắn không nói hai lời bát ở trên bàn ngủ.\n" +
            "\n" +
            "Bên tai truyền đến trước trác cái kia hai cái điển hình học phiếu nhỏ giọng nói chuyện, một cái nói: \"Mới còn lại không thời gian một tháng, nếu như thi không lên cao trung tốt có thể làm sao bây giờ a.\"\n" +
            "\n" +
            "\"Ngươi lợi hại như vậy, vững vàng tiến vào Thiên Lan ma pháp nhất trung a.\"\n" +
            "\n" +
            "\"Đâu có đâu có, ngươi mới lợi hại loại, lý luận khóa điểm cao như vậy, hầu như hêt thảy yêu ma muốn xuất ra đến ngươi đều có thể nhận thức, hơn nữa biết nhược điểm của bọn chúng là cái gì.\"\n" +
            "\n" +
            "Mạc Phàm hơi nhướng mày, này đã không phải là mình lần đầu tiên nghe được cái khái niệm ma pháp này, đến cùng chuyện gì xảy ra tới, chẳng lẽ chính mình lại ảo giác lại nghe lầm? ?\n" +
            "\n" +
            "Lão tử không cắn thuốc, liền thuốc lá đều không hút a!\n" +
            "\n" +
            "Quên đi, nhất định là chính mình ngủ không ngon.\n" +
            "\n" +
            "Mạc Phàm loại bỏ đi đối thoại của hai người bệnh thần kinh phía trước này, nhanh chóng tiến vào trong ngủ say.\n" +
            "\n" +
            "Trải qua nhiều năm đọc sách như vậy để Mạc Phàm đã học được kỹ năng cao cấp ung dung như thường một giây ngủ ở trên bàn học.\n" +
            "\n" +
            "...\n" +
            "\n" +
            "\"Các bạn học mở ra sách giáo khoa, ngày hôm nay chúng ta vẫn cứ học tập yếu lĩnh bước phóng thích đầu ma pháp, còn nhớ ta và các ngươi đã nói sao, phải hoàn thành một cái sơ cấp nhất ma pháp đầu tiên liền muốn liên kết ma pháp Tinh Tử cùng Tinh Tử trong Tinh Trần của các ngươi, như vậy mới có thể hình thành một cái tinh năng quỹ tích, ma pháp lực lượng mới có thể truyền, cái nguyên lý này ta đã nói với các ngươi rất nhiều lần, đồng thời nó cũng là muốn thi trọng điểm của các ngươi.\" Số học lão sư Tô Thanh Chí duy trì dạy học trầm bồng du dương của hắn.\n" +
            "\n" +
            "Mạc Phàm dĩ vãng đều sẽ nương theo tiếng của lão sư tiến vào mộng càng sâu, mà sau khi hắn lại một lần nữa nghe được \"Ma pháp phóng thích, Tinh Tử\" cái này mấy cái từ, hắn lập tức thức tỉnh.\n" +
            "\n" +
            "\"Mạc Phàm, cố gắng nghe giảng bài cho ta, liền còn lại cuối cùng không tới một tháng, ngươi còn như vậy hoang phế chính mình!\" Tô Thanh Chí liếc mắt liền thấy Mạc Phàm, nhất thời quát lớn nói.\n" +
            "\n" +
            "Lớp học các bạn học cũng đều xoay đầu lại, ở nơi đó lén lút cười, cười học cặn bã đã trở thành việc bọn họ thích làm nhất trong lớp.\n" +
            "\n" +
            "\"Mở ra sách giáo khoa của ngươi cho ta.\" Tô Thanh Chí tiếp tục nói.\n" +
            "\n" +
            "Mạc Phàm một trận bất đắc dĩ, mở ra sách giáo khoa của mình...\n" +
            "\n" +
            "\"Mẹ kiếp, này lại là cái gì quỷ? ?\" Mạc Phàm suýt chút nữa không mắng ra đến.\n" +
            "\n" +
            "Nguyên bản ở lớp sổ học trên những kia đồ hình, hàm số, công thức toàn bộ không thấy, đổi thành hoàn toàn xem không hiểu tinh quỹ, Tinh đồ còn có liên tuyến dường như sao băng xẹt qua, tạo thành nhìn qua như... Như... ****** lại như ma pháp trận! !\n" +
            "\n" +
            "Mạc Phàm mạnh mẽ áp chế lại nội tâm kinh ngạc của mình, sau đó lại hiểu ra cái gì.\n" +
            "\n" +
            "Chờ thời điểm lão sư số học không còn quan tâm mình, Mạc Phàm ở dưới bàn đạp một cước Quan Cốc ngồi cùng bàn mình nói: \"Ngươi làm phải không, đổi sách của ta thành món đồ gì, nhanh lấy ra sách toán học của ta.\"\n" +
            "\n" +
            "\"Đại ca, cái gì sách toán học a?\" Than đen mặt Quan Cốc một trận oan ức, chính mình không trêu ai trọc ai.\n" +
            "\n" +
            "\"Chính ngươi nhìn những đều cái gì này, mau mau, trả lại ta sách.\" Mạc Phàm mở sách bản chỉ vào những tinh quỹ kỳ quái kia, ma pháp đồ tiêu, kỳ quái chú ngân nói rằng.\n" +
            "\n" +
            "\"Mạc Phàm lão đại, đây chính là sách khóa ma pháp a. Cái gì toán học, ngươi tối hôm qua lại suốt đêm xem tiểu thuyết khoa học đi, còn nói ta xem tiểu thuyết khoa học tẩu hỏa nhập ma, chính ngươi cũng vậy.\" Quan Cốc mặt tối sầm lại nói rằng.\n" +
            "\n" +
            "Mạc Phàm nghe Quan Cốc phản bác, cằm suýt chút nữa rớt xuống đất.\n" +
            "\n" +
            "Này đều cái gì cùng cái gì a.\n" +
            "\n" +
            "\"Ngươi đừng nói hưu nói vượn.\" Mạc Phàm cả giận nói. Tiểu tử này nguỵ trang đến mức còn rất giống, vấn đề ta sẽ bệnh thần kinh tin tưởng ngươi à.\n" +
            "\n" +
            "\"Lão đại, ngươi thật xem tiểu thuyết xem điên rồi, chúng ta nơi này là thế giới phép thuật có được hay không, từ đâu tới toán học loại đồ vật mơ hồ lại huyền này, phải có nói ta con mẹ nó mỗi ngày học lý luận ma pháp tẻ nhạt như thế, Nguyên Tố Hệ, yêu ma khóa, đã sớm đi học toán học, ngữ văn những đồ vật thú vị này.\" Quan Cốc nghĩa chính ngôn từ lại nói lời nói ý vị sâu xa với Mạc Phàm.\n" +
            "\n" +
            "Mạc Phàm nhìn vẻ mặt của Quan Cốc, thời điểm tên khốn này nói ra lời nói một phen lật đổ này giời ạ dĩ nhiên không có lộ ra một điểm kẽ hở, thật giống như là một chuyện thực sự vậy.\n" +
            "\n" +
            "Ngồi cùng bàn bệnh thần kinh, hắn không chỉ có bệnh thần kinh, còn muốn đem chính mình biến thành bệnh thần kinh!\n" +
            "\n" +
            "Mỗi ngày như thế tẻ nhạt học ma pháp lý luận, Nguyên Tố Hệ, yêu ma khóa...\n" +
            "\n" +
            "Ha ha! Thiệt thòi ngươi nói ra được!\n" +
            "\n" +
            "\"Ngươi không tin, chính ngươi nghe lão sư nói chính là cái gì.\" Quan Cốc thấy vẻ mặt dị dạng của Mạc Phàm, thản nhiên nói.\n" +
            "\n" +
            "Mạc Phàm lúc này mới cẩn thận nghe lão sư số học Tô Thanh Chí nói, nhưng mà một chuỗi hỏa tinh ngữ, một chuỗi Mạc Phàm hoàn toàn nghe không hiểu danh từ thoán vào, để Mạc Phàm cảm giác cả người cũng không tốt.\n" +
            "\n" +
            "Tô Thanh Chí nửa cái tự đều không đề cập nội dung \"Hàm số, công thức\" mình quen thuộc, ngược lại vô số lần nói đến \"Tinh quỹ, Tinh đồ\" thậm chí còn nhắc tới loại hình đồ vật \"Hỏa hệ, băng hệ, thủy hệ\".\n" +
            "\n" +
            "\"Điên rồi, đều điên rồi.\"\n" +
            "\n" +
            "Mạc Phàm niềm tin là rất kiên định, hắn sẽ không tin tưởng những câu nói này.\n" +
            "\n" +
            "Tiết khóa sau chính là mình yêu thích nhất lão sư ngữ văn - Tần lão sư khóa, mỹ lệ, gợi cảm, thành thục, dịu dàng, song phong vểnh cao, mỹ mông tròn vo Tần lão sư nhất định sẽ không dùng loại chuyện hoang đường này đến lừa gạt mình!\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Sống qua lớp số học vô pháp lý giải, không bao lâu một đạo dáng người thon thả bộ váy công sở màu đen Tần lão sư đi vào phòng học.\n" +
            "\n" +
            "Nàng giống như thường ngày khẽ mỉm cười, nhất thời rọi sáng toàn bộ lớp, cả lớp bạn học nam lập tức hóa thành người bạn nhỏ vườn trẻ, tỏ rõ vẻ hứng thú chào lão sư.\n" +
            "\n" +
            "\"Chào các bạn học, ngày hôm nay chúng ta muốn giảng giải chính là lợi và hại của hắc ma pháp, mọi người hẳn phải biết hắc ma pháp tổng cộng chia làm vì là 3 cái hệ, vong linh hệ, nguyền rủa hệ, Ám Ảnh hệ, như vậy 3 cái hệ này ma pháp không cùng cấp lại là cái gì đây...\" Tần lão sư tốc độ nói nối liền, âm thanh nhu nhã tươi đẹp.\n" +
            "\n" +
            "Thường ngày Mạc Phàm đều sẽ một mặt say sưa xem cùng nghe, thế nhưng ngày hôm nay sau khi nghe xong câu nói này vẻ mặt của hắn nhưng giống như là ăn một con ruồi chết.\n" +
            "\n" +
            "Một mực bệnh thần kinh ngồi cùng bàn còn ở bên cạnh làm một cái vẻ mặt \"Ngươi xem đi, ta nói không sai\".\n" +
            "\n" +
            "Đồ phá hoại, ngươi không sai, vậy thì là lão tử có bệnh rồi!\n" +
            "\n" +
            "Không thể! !\n" +
            "\n" +
            "Mạc Phàm rốt cục nhẫn không được, mạnh mẽ từ trên cái ghế băng đứng dậy.\n" +
            "\n" +
            "\"Tần lão sư, chúng ta không phải nên học ngữ văn khóa sao?\" Mạc Phàm chất vấn.\n" +
            "\n" +
            "Ngồi cùng bàn Quan Cốc phát hiện Mạc Phàm đứng lên muốn chất vấn, muốn kéo đều kéo không được, sau khi nghe xong hắn nói càng là làm một cái \"oh my god\" động tác đập trán.\n" +
            "\n" +
            "Vừa dứt lời dưới, phòng học yên tĩnh đột nhiên cười vang lên.\n" +
            "\n" +
            "Cả lớp hơn bốn mươi học sinh đều cười đến ngã trái ngã phải, đặc biệt là cái kia Mục Bạch, hắn cười đến nước mắt đều sắp chảy ra.\n" +
            "\n" +
            "Tần lão sư cũng không có cười, nàng chỉ là đẩy kính mắt gọng vàng của mình một cái, duy trì mỉm cười dùng cặp mắt mèo mẹ trong suốt kia nhìn Mạc Phàm, nghiêm túc cẩn thận nói rằng: \"Mạc Phàm, ngươi nói ngữ văn là khoa học đi, khoa học ở đây là không tồn tại, ngươi không nên mê luyến những đồ vật không chân thực kia, mà hẳn là cố gắng chăm chú học tập ma pháp, làm một cái Ma Pháp sư với xã hội hữu dụng, biết không?\"\n" +
            "\n" +
            "Ngươi có thể tưởng tượng, một cái lão sư ngữ văn đặc biệt chân thành, nghiêm túc nói ra mấy câu nói như vậy thì vẻ mặt trên mặt người thiếu niên nào đó lại là trời đất sụp đổ thế nào sao? ? ?\n" +
            "\n" +
            "Ông trời ngươi giết ta đi! !\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Ồ, không đúng, Tần lão sư lời nói này vì sao giống Doanh lão đầu đã qua đời nói thế?\n" +
            "\n" +
            "Chẳng lẽ, thật sự có ma pháp vị diện, hơn nữa chính mình liền rơi vào trong ma pháp này vị diện? ?\n" +
            "\n" +
            "...\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Mạc Phàm vốn tưởng rằng tất cả những thứ này là mộng , nhưng đáng tiếc liên tục mấy ngày đều là như vậy.\n" +
            "\n" +
            "Hơn nữa ý thức tỉnh táo của hắn cũng tự nói với mình, đây căn bản không phải là mộng.\n" +
            "\n" +
            "Ngày thứ tư sáng sớm, hắn lần thứ hai mơ mơ hồ hồ ăn bánh quẩy ở Thất thúc gia.\n" +
            "\n" +
            "Bên cạnh hai nam học sinh đang thảo luận ma cụ, ma cụ món đồ này là cái gì Mạc Phàm là không làm rõ, nghe bọn họ khẩu khí là rất lợi hại, hơn nữa đồ vật rất đắt, sánh được một chiếc xe.\n" +
            "\n" +
            "\"Mạc Phàm, làm sao không tinh thần như thế a, nếu không thúc mua cho ngươi điểm nâng cao tinh thần, lập tức sẽ cuộc thi lớn, có thể hay không thức tỉnh trở thành Ma Pháp sư liền xem cuộc thi lần này...\" Bán bánh quẩy Thất thúc rất quan tâm Mạc Phàm nói.\n" +
            "\n" +
            "Mạc Phàm tự động đem Thất thúc nói loại bỏ thành chuyện đang tuân hỏi mình thành tích học tập.\n" +
            "\n" +
            "\"Ào ào ào vù vù ~~~~~~~~~~~~~~ \"\n" +
            "\n" +
            "Một trận kỳ dị yêu phong thổi động quán nhỏ, cuốn lên một ít bụi bặm sắp làm bẩn sữa đậu nành của Mạc Phàm, Mạc Phàm lấy tốc độ cực nhanh đem sữa đậu nành uống vào trong cổ họng, cả người có vẻ phờ phạc.\n" +
            "\n" +
            "Yêu phong càng thổi càng mạnh, Mạc Phàm thậm chí cảm giác được một cỗ kỳ quái khí áp thành xoắn ốc chuyển chậm rãi ép xuống dưới...\n" +
            "\n" +
            "Đống cỏ khô múa tung, trên đường cát bay đá chạy, các nữ sinh từng cái từng cái che lấp váy của các nàng phát sinh e thẹn tiếng kêu sợ hãi.\n" +
            "\n" +
            "Mạc Phàm đều có chút thói quen nhỏ, lại là lão sư nào đang sử dụng \"Phong quỹ\" ma pháp chạy đi, tuy rằng lần này động tĩnh hơi lớn.\n" +
            "\n" +
            "\"Ta... Ta ông trời, đó là cái gì? ?\"\n" +
            "\n" +
            "\"Má ơi, quá tuấn tú rồi!\"\n" +
            "\n" +
            "\"Cánh a, sau lưng người kia lại có cánh, siêu cấp khốc giống như đúc trong video nhìn thấy! !\"\n" +
            "\n" +
            "\"Phong Dực, cha mẹ ơi, ta lại tận mắt nhìn phong hệ cấp cao ma pháp —— Phong Dực!\"\n" +
            "\n" +
            "Xung quanh ầm ĩ khắp chốn kinh ngạc thốt lên, để Mạc Phàm không cách nào an tâm ăn điểm tâm.\n" +
            "\n" +
            "Mạc Phàm bày ra một bộ dáng dấp không cảm thấy kinh ngạc vừa ngẩng đầu, nhưng mà sau một khắc cả người hắn dường như bị chớp giật trúng đứng ngẩn ở nơi đó, cặp mắt lim dim lập tức mở rộng vô số lần cũng không còn cách nào dời tầm mắt rồi!\n" +
            "\n" +
            "Trời màu xanh thẳm, một góc phòng ốc sân thượng, tán cây đung đưa, lay động cột cờ trường học...\n" +
            "\n" +
            "Một người nam tử mặc phong bào màu trắng bạc dường như mộng ảo Tinh Linh từ những địa phương xa không thể với sượt qua người ở trên bầu trời xẹt qua một đạo đường vòng cung kinh diễm! ! !\n" +
            "\n" +
            "Thời điểm Mạc Phàm ngôi ở phòng học khắp nơi tẻ nhạt tổng hội nhìn chằm chằm mây, bầu trời, tán cây, cột cờ sau đó nhìn một ít chim nhỏ tự do bay lượn qua lại, nhưng mà hắn chưa bao giờ từng nghĩ thật sự có người có thể lưng biến ra hai cánh cực kỳ xung kích thị giác bay qua!\n" +
            "\n" +
            "Đây là hình ảnh trong phim ảnh mới tồn tại, nhưng như vậy chân thực khắc ở mi mắt mình! ! !\n" +
            "\n" +
            "\"Phong... Phong... Phong Dực!\" Mạc Phàm nhìn chằm chằm bầu trời cái nam tử một cánh tuyệt trần màu bạc, không tự chủ đọc lên tên phép thuật này.\n" +
            "\n" +
            "Không giống phong quỹ trước đó, Mạc Phàm có thể ở trong khiếp sợ cảm giác được nội tâm của mình có món đồ gì đang kịch liệt phun trào, là đang mạnh mẽ đánh vỡ nguyên bản ý nghĩ khát vọng muốn phá xác mà ra của mình!\n" +
            "\n" +
            "Đúng, mấy ngày nay hắn đều ngơ ngơ ngác ngác không thể nào tiếp thu được thay đổi tất cả này, chỉ có hiện tại hắn đột nhiên ý thức được thay đổi tất cả những thứ này dĩ nhiên khiến trái tim người cuống đập như vậy, phảng phất tình cờ gặp gỡ người nhất kiến chung tình! !\n" +
            "\n" +
            "Sau khi tất cả khiếp sợ theo thần bí nam tử bay lượn mà qua, Mạc Phàm đã ở trong lòng tự nói với mình:\n" +
            "\n" +
            "Dù cho đây là mộng, vậy cũng đợi được chính mình học được Phong Dực tự do bay trời cao lại tỉnh lại!\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Thời gian cho Mạc Phàm rất ngắn ngủi.\n" +
            "\n" +
            "Lấy thời gian ở nguyên lai thế giới của mình để tính, thi tốt nghiệp chín năm nghĩa vụ ngay hai mươi ngày sau.\n" +
            "\n" +
            "Còn lại hai mươi ngày này, Mạc Phàm chỉ làm rõ mấy cái then chốt:\n" +
            "\n" +
            "Chương trình học phân biệt có:\n" +
            "\n" +
            "Ma pháp cơ sở lý luận - từ chương trình học sắp xếp đến xem là ngữ văn\n" +
            "\n" +
            "Ma pháp tinh quỹ - hẳn là hình học\n" +
            "\n" +
            "Yêu ma khóa - hẳn là sinh vật khóa\n" +
            "\n" +
            "Ma khí ma cụ khóa - hẳn là vật lý\n" +
            "\n" +
            "Vật liệu khóa - hẳn là hóa học\n" +
            "\n" +
            "Ma pháp lịch sử cùng ma pháp địa lý khóa liền không cần giải thích thêm.\n" +
            "\n" +
            "Đương nhiên, Mạc Phàm còn giải đến một cái tin tức quan trọng nhất.\n" +
            "\n" +
            "trong bọn học sinh trên căn bản vẫn chưa có người nào có thể bắn ra pháp thuật, bởi vì trải qua chín năm ma pháp giáo dục bắt buộc này học sinh đều học lý luận, khái niệm, tài năng và kiến thức.\n" +
            "\n" +
            "Này giống như học sinh trung học ở thế giới cũ sau khi tốt nghiệp kỳ thực vẫn cứ không có kỹ năng sinh hoạt.\n" +
            "\n" +
            "Cái này đối với Mạc Phàm tới nói tuyệt đối là tin tức tốt, dù sao hắn đối với thế giới phép thuật này một chữ cũng không biết, hầu như tất cả mọi thứ đều muốn học lại từ đầu.\n" +
            "\n" +
            "Mà từ một cái học sinh ma pháp đến một cái chân chính Ma Pháp sư chuyển biến mấu chốt nhất chính là \"Ma pháp thức tỉnh\" .\n" +
            "\n" +
            "\"Ma pháp thức tỉnh\" tương tự với một loại nghi thức khai phá, ở ma pháp cao trung ở lễ khai giảng, hết thảy ma pháp học sinh tiếp thu một lần \"Ma pháp gột rửa\", cũng chính là ma pháp thức tỉnh!\n" +
            "\n" +
            "Người khác nhau thức tỉnh hệ khác nhau, Mạc Phàm từ ngồi cùng bàn Quan Cốc nơi đó hỏi thăm được, thức tỉnh hệ quá nửa là Nguyên Tố Hệ, chính là chương trình học bình thường sẽ học được: Phong hệ, Hỏa hệ, thủy hệ, quang hệ, lôi hệ, băng hệ, thổ hệ.\n" +
            "\n" +
            "Như Mạc Phàm trước đó từng thấy 《 phong quỹ 》 《 Phong Dực 》 hai cái ma pháp này phân biệt là đại khí hệ cấp thấp ma pháp cùng cấp cao ma pháp, một ít người ở mười sáu tuổi lần thứ nhất thức tỉnh chính là phong hệ nói, nỗ lực tu luyện liền có thể học được những phép thuật này.\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Vì lẽ đó, muốn trở thành Ma Pháp sư có thể bay, đầu tiên cần phải làm là thi đậu cao trung, thu được mỗi cái cao trung ma pháp học sinh đều sẽ thu được —— ma pháp thức tỉnh!\n" +
            "\n" +
            "...\n" +
            "\n" +
            "\"Mạc Phàm, ngươi sẽ không là thật sự muốn thi ma pháp cao trung, đi thức tỉnh trở thành Ma Pháp sư chứ?\" Than đen mặt Quan Cốc rất chăm chú hỏi.\n" +
            "\n" +
            "Mạc Phàm trong ấn tượng của Quan Cốc là một cái gia hỏa rất không thích học tập, đột nhiên nghiêm túc đọc ma pháp giống như hít thuốc lắc vậy, quả thực là sự tình làm người nghe kinh hãi a.\n" +
            "\n" +
            "Mạc Phàm là lười giải thích cùng chính hắn một bạn học, ngược lại chính mình là học định, nhất định phải thi đậu ma pháp cao trung, nhất định phải thu được lần kia cơ hội thức tỉnh phi thường phi thường quý giá.\n" +
            "\n" +
            "\"Bây giờ ngươi đọc cũng không hề dùng, ngươi đều bỏ xuống bao nhiêu năm bài tập, vẫn là không muốn lãng phí thời gian như vậy.\" Quan Cốc khuyên.\n" +
            "\n" +
            "Quan Cốc rất rõ ràng lần trước ma pháp thi thử Mạc Phàm mới thi 6 điểm, cùng khối thấp nhất, thành tích như vậy làm sao có khả năng thi được với ma pháp cao trung?\n" +
            "\n" +
            "Học tra* chính là học tra, cố gắng thế nào đều mộc hữu dụng a, nhận mệnh đi.\n" +
            "* Học tra: Ý muốn nói bình thường không cố gắng học. Lúc sắp tới cuối kỳ mới bắt đầu gấp gáp học.\n" +
            "\"Quan Cốc, kỳ thực ngươi hẳn là càng cố gắng học.\"\n" +
            "\n" +
            "Nghe được Quan Cốc ở bên tai mình lải nhải, Mạc Phàm cũng hơi không kiên nhẫn.\n" +
            "\n" +
            "\"Tại sao?\" Quan Cốc ta bắt được.\n" +
            "\n" +
            "\"Quan Cốc, ngươi biết mình xấu xí sao?\"\n" +
            "\n" +
            "\"Ta biết a.\" Quan Cốc một mặt chân thành thừa nhận nói.\n" +
            "\n" +
            "\"Ân, có câu nói ngươi hẳn phải biết: Người xấu nên nhiều... Ách, người xấu liền hẳn là học ma pháp!\" Mạc Phàm lời nói ý vị sâu xa nói rằng.\n" +
            "\n" +
            "\"Đi ngươi muội a!\"\n" +
            "\n" +
            "Quan Cốc nói không sai, mới hai mươi mấy ngày thiên tài gì cũng không thể bù đắp nhiều năm chương trình học như vậy, đặc biệt là cuộc thi nội dung còn hoàn toàn hai loại khái niệm.\n" +
            "\n" +
            "Mạc Phàm biết mình không nhiều lắm hi vọng, hắn bù lại tri thức không phải vì thi đậu, mà là hắn chân tâm thực lòng bị ma pháp đánh động, muốn học, muốn mạnh mẽ học!\n" +
            "\n" +
            "...\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Thời gian trôi qua rất nhanh, chừng hai mươi thiên đảo mắt đã qua.\n" +
            "\n" +
            "Mạc Phàm cũng không có từ trong cái gọi là mộng ma pháp tỉnh lại, ngược lại là chính mình cũng tin tưởng thế giới này chân thực tồn tại, đồng thời nghênh đón nguyên bản nên đối mặt thi trung học biến hóa thi trung học ma pháp!\n" +
            "\n" +
            "Thi trung học ngày ấy, người ở ngoài trường học đông như mắc cửi, bất kể là thi ma pháp vẫn là thi khoa học, gia trưởng của bọn nhỏ nhưng vẫn là lái xe lái xe, xe ba bánh xe ba bánh tới đón hài tử về nhà, bởi vì mỗi cái gia trưởng đều rất rõ ràng hài tử lần cuộc thi này liền quan đến tiền đồ của bọn họ tương lai là lái xe tới đón đời kế tiếp vẫn là giẫm xe ba bánh tới đón.\n" +
            "\n" +
            "Đi ra trường thi, Mạc Phàm nhìn ngựa xe như nước trong lòng mang theo cái kia nghi hoặc \"Vì sao ma pháp thế giới còn có ô tô, tiểu điện lừa\" đi ra, tâm tư lại rất mau trở lại về đến nội dung trong cuộc thi.\n" +
            "\n" +
            "Trải qua hơn hai mươi ngày nỗ lực học tập, Mạc Phàm đã chân chính đạt đến cảnh giới có thể nhìn hiểu cuộc thi đề mục, về phần đáp án có chính xác không —— ai, vui vẻ là được rồi.\n" +
            "\n" +
            "\"Mạc Phàm, Mạc Phàm...\" Trong đám người, một cái người đàn ông trung niên sắc mặt vàng như nghệ hướng về Mạc Phàm giơ tay lên cao.\n" +
            "\n" +
            "Mạc Phàm nhìn cái này khuôn mặt quen thuộc, có chút bất ngờ kêu một tiếng: \"Ba, ngươi làm sao đến rồi?\"\n" +
            "\n" +
            "\"Tới đón ngươi a, thi xong ngươi cũng coi như tốt nghiệp, ta cho ngươi tìm một phần việc chạy nghiệp vụ ở sát vách nội thành, ngươi rộng rãi phong thúc thúc sẽ mang ngươi, chạy cái mấy năm có kinh nghiệm là có thể nuôi chính mình rồi, số may một tháng nắm cái bốn, năm ngàn cũng không có vấn đề, sớm một chút ra làm việc cũng tốt.\" Mạc Gia Hưng nụ cười đáng yêu nói rằng.\n" +
            "\n" +
            "Thế giới thay đổi, nhưng mình nhưng vẫn là học tra, mà ba vẫn là cái này ba, Mạc Phàm có thể cảm giác được cái sợi thân thiết kia cái gì đều không thể thay đổi.\n" +
            "\n" +
            "Đi chạy nghiệp vụ việc này Mạc Gia Hưng cùng Mạc Phàm đề cập tới, giả như một tháng trước, Mạc Phàm sẽ không chút do dự lựa chọn con đường cha sắp xếp cho mình này, bởi vì vì chính mình cũng nhất định phải đi đường này, đi tới xã hội.\n" +
            "\n" +
            "Nhưng là, hiện tại hắn không cam lòng.\n" +
            "\n" +
            "Xã hội này ô tô, điện thoại di động, máy vi tính, tủ lạnh đều có, khoa học kỹ thuật sản phẩm không hề có một chút nào bởi vì ma pháp thay thế được mà thay đổi, giả như được không một cái Ma Pháp sư, như vậy ngươi liền sẽ trở thành công nhân sinh sản những thứ đồ này. Mẹ trứng, này cùng mình ở thế giới cũ khác nhau ở chỗ nào, lão tử muốn học ma pháp! !\n" +
            "\n" +
            "\"Ba, ta muốn tiếp tục học.\" Mạc Phàm trầm mặc một lúc lâu, vẫn là đem chính mình ý nghĩ trong lòng nói cho Mạc Gia Hưng.\n" +
            "\n" +
            "\"Ngươi không phải không thích học ma pháp sao?\" Mạc Gia Hưng nhíu lông mày, một mặt kỳ quái nói rằng.\n" +
            "\n" +
            "\"Ây...\" Mạc Phàm có chút đau \"bi\", món đồ này rốt cuộc muốn giải thích thế nào đây, thật giời ạ vua hố!\n" +
            "\n" +
            "Mạc Gia Hưng nhìn nhi tử mình lập tức liền tròn mười sáu tuổi, trên mặt lại treo lên nụ cười thật thà nói: \"Không có chuyện gì rồi, ba cũng sẽ không trách ngươi không cố gắng dụng công học ma pháp, người có chí riêng.\"\n" +
            "\n" +
            "\"Không phải, ta là thật sự muốn học.\"\n" +
            "\n" +
            "\"Ngươi cuộc thi có thể thi đậu sao?\" Mạc Gia Hưng hỏi.\n" +
            "\n" +
            "\"Không thể.\" Mạc Phàm rất khẳng định hồi đáp.\n" +
            "\n" +
            "Bất kể là thi văn toàn anh vẫn là thi ma pháp, Mạc Phàm đều mẹ nó thi không lên, điểm ấy không thể nghi ngờ.\n" +
            "\n" +
            "\"Cái kia không phải, không có chuyện gì rồi, tuy rằng cổ nhân thường nói: Tất cả đều hạ phẩm, chỉ có ma pháp cao, nhưng cũng có lời giải thích nghề nào cũng có trạng nguyên...\" Mạc Gia Hưng tiếp tục nói.\n" +
            "\n" +
            "Mạc Phàm nghe xong, không tự chủ phụt ra một cái.\n" +
            "\n" +
            "Hiện tại rất nhiều tin tức Mạc Phàm muốn tự động chuyển đổi, nhưng trong quá trình chuyển đổi liền để Mạc Phàm đặc biệt không nói gì, nói thí dụ như Mạc Phàm nhớ tới có một ngày lịch sử lão sư nói cho các bạn học: Quang hệ ma pháp thuỷ tổ là \"Edison\", lúc đó Mạc Phàm nội tâm thì có ngàn tỉ đệch mẹ nó đang lao nhanh!\n" +
            "\n" +
            "Mạc Gia Hưng vỗ vai Mạc Phàm, thời điểm trấn an trấn an, Mạc Gia Hưng đột nhiên phát hiện mình nhi tử duy trì trầm mặc, biểu hiện có vẻ không đúng lắm.\n" +
            "\n" +
            "Hiểu con nhất không ai bằng cha, Mạc Gia Hưng chậm rãi thu hồi nụ cười, âm thanh chuyển trầm thấp một ít nói: \"Ngươi là thật lòng?\"\n" +
            "\n" +
            "\"Ân, ta muốn đạt được cái cơ hội thức tỉnh kia, tuy rằng ta biết hiện tại hối hận đã chậm, nhưng ta thật sự nghĩ kỹ hiếu học, muốn trở thành một Ma Pháp sư.\" Mạc Phàm rất thành khẩn nói rằng.\n" +
            "\n" +
            "Mạc Gia Hưng duy trì trầm mặc chốc lát.\n" +
            "\n" +
            "Mạc Phàm cũng không nói gì thêm.\n" +
            "\n" +
            "\"Thật sự muốn học?\" Mạc Gia Hưng lại một lần nữa xác nhận một lần.\n" +
            "\n" +
            "\"Thật sự.\" Mạc Phàm không hề có một chút do dự gật đầu.\n" +
            "\n" +
            "Khởi đầu Mạc Phàm cũng cảm thấy đó là nhất thời kích động, nhưng nhanh một tháng trôi qua, cái kia Phong Dực ma pháp mang cho Mạc Phàm nội tâm sôi trào cùng xao động từ đầu đến cuối không có làm lạnh xuống, chính mình không có đùa giỡn, là thật là muốn học!\n" +
            "\n" +
            "\"Vậy cũng tốt, ta nghĩ nghĩ biện pháp.\" Mạc Gia Hưng cũng không có nói thêm nữa.\n" +
            "\n" +
            "\"Ba, ta ở trường cao trung Thiên Lan ma pháp tìm một phần việc làm tạm thời, trông giữ thư viện, ngày kia liền đi làm.\" Mạc Phàm nói rằng.\n" +
            "\n" +
            "Nếu quyết định muốn học ma pháp, Mạc Phàm sẽ không có dự định bởi vì vì chính mình là học tra mà từ bỏ, có thể hay không để cho chính mình trên ma pháp cao trung thu được lần cơ hội thức tỉnh trở thành Ma Pháp sư liền xem cha bên này, mà chính mình đối với tri thức thiếu thốn là cần dựa vào chính mình nỗ lực đi bổ sung, vì lẽ đó ở dưới tình huống biết rõ mình không có một chút hi vọng thi đậu ma pháp cao trung, Mạc Phàm sớm tìm phần việc không tồi này.\n" +
            "\n" +
            "Tiền lương hầu như không có, lo ăn lo ở mà thôi, nhưng đối với Mạc Phàm tới nói nhưng thật sự rất trọng yếu, trong thư viện hắn có thể tìm được nhiều đồ vật mình cần bù lại hơn.\n" +
            "\n" +
            "Mạc Gia Hưng ngẩn người, nghĩ đến hắn cũng không biết là nguyên nhân gì thay đổi ý nghĩ của con trai mình, thế nhưng hắn nếu một lòng cầu ma, chính mình lại có cái gì không đáng cao hứng đây, dù sao xã hội này chung quy là Ma Pháp sư mới có địa vị chân chính, chạy nghiệp vụ cả đời lại có thêm phòng có xe, cũng không làm ra nổi giá trị bằng một cái Ma Pháp sư từ trường học ma pháp tốt nghiệp ra, làm ra được việc khiến người ta tôn kính.\n" +
            "\n" +
            "\"Về nhà trước đi, về nhà nói đi.\" Mạc Gia Hưng gật gật đầu, không nói thêm gì nữa. Đối với Mạc Gia Hưng tới nói con trai này cũng không có cái gì không yên lòng, hắn vẫn không tới mười sáu tuổi, nhưng ở trong lòng hắn đã sớm trưởng thành.','https://static.8cache.com/cover/o/eJzLyTDW1zXyKzIvNQvXjS921A8rLI0qjDcOyvDx1HeEAi8jE_1IH5_U5NJM39zgUP1yQwsD3Qwg9kw2MQIAm-4TcA==/tieu-dao-tien-gioi.jpg',1)";

    public DatabaseDocTruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public void QueryData(String sql) {
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        db.execSQL(SQLQuery);
//        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);
        db.execSQL(SQLQuery11);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void AddTaiKhoan(TaiKhoan taiKhoan){
        SQLiteDatabase db = this.getWritableDatabase();

        //không thể lưu trực tiếp xuống insert nên thông qua contentvalues
        ContentValues values = new ContentValues();
        values.put(TEN_TAI_KHOAN,taiKhoan.getmTenTaiKhoan());
        values.put(MAT_KHAU,taiKhoan.getmMatKhau());
        values.put(EMAIL,taiKhoan.getmEmail());
        values.put(PHAN_QUYEN,taiKhoan.getmPhanQuyen());

        db.insert(TABLE_TAIKHOAN,null,values);
        db.close();

    }


    //Lấy tất cả tài khoản
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_TAIKHOAN , null );
        return res;
    }



    //Thêm truyện
    public void AddTruyen(Truyen truyen){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEN_TRUYEN,truyen.getTenTruyen());
        values.put(NOI_DUNG,truyen.getNoiDung());
        values.put(IMAGE,truyen.getAnh());
        values.put(ID_TAI_KHOAN,truyen.getID_TK());

        db.insert(TABLE_TRUYEN,null,values);
        db.close();
        Log.e("Add Truyện : ","Thành công");
    }

    public boolean DelTruyen(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_TRUYEN, TEN_TRUYEN + "='" + name+"'", null) > 0;
    }



    public Cursor getData1(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" DESC LIMIT 3" , null );
        return res;
    }



    public Cursor getData2(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN,null);
        return res;
    }

}
