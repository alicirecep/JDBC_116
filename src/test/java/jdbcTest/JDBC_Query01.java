package jdbcTest;

import java.sql.*;

public class JDBC_Query01 {

    // Bir JDBC sorgusu yapilmak istendiginde yapilacak ilk is
    // Database yoneticisi ile iletisime gecerek ilgili Database'in Access'lerini almak olacaktir.

    //URL: "jdbc:mysql://194.140.198.209/wonderworld_qa2";
    //USERNAME= "wonderworld_qawcollegeuser";
    //PASSWORD="1gvyfx6#Q";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        //  1. ADIM: Kullanılacak veritabanı için doğru sürücüyü ekle

        Class.forName("com.mysql.cj.jdbc.Driver");

        //  2. ADIM: Veritabani ile iletişimi başlat

        Connection connection = DriverManager.getConnection("jdbc:mysql://194.140.198.209/wonderworld_qa2",
                "wonderworld_qawcollegeuser", "1gvyfx6#Q");

        // Connection create etmek icin sadece DriverManager.getConnection() kullanmak yeterlidir.
        // Ancak biz bu create edilen connection'i bir objeye atama yapmazsak daha sonra ihtiyac halinde ona erisemeyiz.
        // En saglikli olan COnnection connection = DriverManager.getConnection() seklinde yazmaktir.


        //  3. ADIM: SQL sorgularini yonetebilmek icin bir suite hazirla


        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // Bir statement olusturabilmek icin MUTLAKA bir connection'imiz olmak zorunda.
        // Statement olusturulurken connection.createStatement(...); connection uzerinden bu yapi cretae edilir.
        // createStatement(...); icerisine ResultSet Type ve ResultSet Concurrency bilgileri girilir.
        // Bu ayarlar cok spesifik bir suit olusturmuyor isek, genelde degismez ve her yerde kulalnilan ayni ayarlamalardir.
        // Uyarı: Statement create etmek için sadece connection.createStatement(...) yeterlidir. Ancak biz bu create edilen statement'ı
        // daha sonra kullanmak için bir değişkene atadık. Bu şekilde daha sonra kullanabiliriz.


        //  4. ADIM: SQL sorgularini calistir, sonuc al, isle

        String query = "SELECT * FROM wonderworld_qa2.staff";

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();

        System.out.println(resultSet.getString("name"));

        // Bir SQL query'sini Java kodlari ile calistirmak istiyorsak o SQL kodunu ozel ayarlanmis bir suite icerisine almamiz gerekiyor.
        // Hazirladigimiz bu suit = Statement. Dolayisiyla Statement olmadan bir SQL query'sini Database'e gonderemeyiz.
        // Olusturulan statement'i kullanarak executeQuery() methodu ile SQL sorgumuzu Database'e gondeririz.
        // Yine statement ile donen ResultSet icindeki datalari islemek icin onu bir ResultSet objesine atama yapariz.
        // Elde ettigimiz Result Set icinde islem yapabilmek icin Iterator'dan yardim aliriz.

        resultSet.next();

        System.out.println(resultSet.getString("name"));

        //  5. ADIM: Database baglantisini kapat.

        resultSet.close();
        statement.close();
        connection.close();


        // Database bir yazilimin en hassas bolumudur.
        //Database baglantilari acilip sorgu gerceklestirildikten hemen sonra mutlaka kapatilmalidir.
        // Database baglantisi kurulurken gerceklestirilen sira (connection > statement > resultSet) database baglantisi kapatilirken
        // tersten isleme tabi tutulur ( resultSet > statement > connection)


    //



    }
}
