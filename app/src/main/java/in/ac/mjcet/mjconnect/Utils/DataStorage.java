package in.ac.mjcet.mjconnect.Utils;

/**
 * Created by Aleem on 01-Mar-17.
 */

public class DataStorage {
    public static DataStorage dataStorage;



    public static DataStorage getInstance(){
        if(dataStorage == null){
            dataStorage = new DataStorage();
        }
        return dataStorage;
    }
}
