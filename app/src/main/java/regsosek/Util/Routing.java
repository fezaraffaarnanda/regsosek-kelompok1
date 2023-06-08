package regsosek.Util;

public class Routing {
    AppManager appManager;

    public Routing(AppManager appManager){
        this.appManager = appManager;
    }

    public void showScreen(int screenIndex) {
        for (int i = 0; i < appManager.ui.bgPanel.length; i++) {
            if (i == screenIndex) {
                appManager.ui.bgPanel[i].setVisible(true);
            } else {
                if (appManager.ui.bgPanel[i] != null) {
                    appManager.ui.bgPanel[i].setVisible(false);
                }
            }
        }
    }   
}
