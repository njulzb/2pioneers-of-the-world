package UI.aaManager;

import UI.mainUI.MainStage;
import UI.marketTemUI.MarketTemMainUI;
import UI.stockUI.StockSelectUI;
import UI.welcomeUI.WelcomeMainUI;

public class WelcomeManager {
    private WelcomeMainUI ui ;

    public WelcomeManager( WelcomeMainUI ui ) {
        this.ui=ui;
    }



    public void callFunction_stockMessage(){
        MainStage.getInstance().changePaneWithNavigation(new StockSelectUI());
    }
    public void callFunction_marketThermometer(){
        MainStage.getInstance().changePaneWithNavigation(new MarketTemMainUI(null));
    }

}
