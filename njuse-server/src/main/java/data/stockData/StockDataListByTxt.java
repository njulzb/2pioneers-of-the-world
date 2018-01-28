package data.stockData;


import utility.poResultMsg.StockPOResultMsg;

import java.io.*;
import java.util.ArrayList;

/**
 * 数据文件第一行为标题行，随后的数据每行代表某只股票一天的涨跌数据，
 * 从前往后依次为：
 * 记录编号  日期（月/日/年） 开盘指数  最高指数  最低指数  收盘指数 
 * 成交量  复权后的收盘指数  股票代码  股票名称  市场名称。
 * 各变量之间 用 tab 分隔  数据文件使用 UTF8 编码，换行符为 CR 
 *
 *  serial  date open high low close
 *  volume adj close code name market
 *
 */
public class StockDataListByTxt {
    private static StockDataListByTxt instance = new StockDataListByTxt();

    public static StockDataListByTxt getInstance() {
        return instance;
    }

    private ArrayList<String> stockInfoList = new ArrayList<String>();

    private StockDataListByTxt(){
        String filePath = this.getClass().getClassLoader().getResource("data.csv").getPath();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine())!=null){
                this.stockInfoList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public StockPOResultMsg searchStockByCode(String code){
        //TODO
        for (String e:this.stockInfoList){
            String[] array = e.split("\t");
            if (code.equals(array[8])){

            }

        }


        return null;
    }



}
