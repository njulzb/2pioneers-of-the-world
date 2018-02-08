package data.marketData;

import vo.StockItem;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class MarketDataListByTxt {

    private ArrayList<StockItem> stockItemArrayList = new ArrayList<>();
    private static MarketDataListByTxt instance = new MarketDataListByTxt();

    public static MarketDataListByTxt getInstance(){
        return instance;
    }

    private MarketDataListByTxt(){
        String filePath = this.getClass().getClassLoader().getResource("data.csv").getPath();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line =bufferedReader.readLine();//跳过第一行;

            while ((line = bufferedReader.readLine())!=null){
                this.stockItemArrayList.add(new StockItem(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到昨天和今天的交易记录
     * @param today
     * @return
     */
    public ArrayList<StockItem> getItemsAtDay(Date today){
        ArrayList<StockItem> resultList = new ArrayList<>();
        for (StockItem eItem : this.stockItemArrayList) {
            if (eItem.getDate().equals(today)){
                resultList.add(eItem);
            }
        }
        return resultList;
    }
}
