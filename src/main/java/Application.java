import view.MyView;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException{
        MyView myView = new MyView();
        myView.show();
    }
}
