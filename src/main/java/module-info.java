module com.champlain.oop2.oop2assignment4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.champlain.oop2.oop2assignment4 to javafx.fxml;
    exports com.champlain.oop2.oop2assignment4;
}