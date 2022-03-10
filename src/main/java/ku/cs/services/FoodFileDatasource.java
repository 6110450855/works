package ku.cs.services;

import ku.cs.models.Food;
import ku.cs.models.FoodList;

import java.io.*;

public class FoodFileDatasource implements Datasource  {

    private String fileDirectoryName;
    private String fileName;
    private FoodList foods;

    public FoodFileDatasource(String fileDirectoryName, String fileName) {
        this.fileDirectoryName = fileDirectoryName;
        this.fileName = fileName;
        checkFileIsExisted();
    }

    private void checkFileIsExisted() {
        File file = new File(fileDirectoryName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = fileDirectoryName + File.separator + fileName;
        file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Cannot create " + filePath);
            }
        }
    }

    private void readData() throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            Food food = new Food(data[0].trim(), data[1].trim(),Double.parseDouble(data[2].trim()),data[3].trim());
            food.setBuyIn(data[4].trim());
            food.setExpire(data[5].trim());
            food.setImagePath(data[6].trim());
            foods.addFood(food);
            foods.sortExpire();
        }
        reader.close();
    }


    public FoodList getFoodsData(){
        try{
            foods = new FoodList();
            readData();
        } catch (FileNotFoundException e){
            System.err.println(this.fileName + " not found");
        }catch (IOException e){
            System.err.println("IOException from reading " + this.fileName);
        }
        return foods;
    }


    public void setFoodsData(FoodList foods) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Food food : foods.getFoods()) {
                String line = food.getFoodName() + ","
                        + food.getFoodType() + ","
                        + food.getQuantity() + ","
                        + food.getFoodUnit() + ","
                        + food.getBuyIn() + ","
                        + food.getExpire() + ","
                        + food.getImagePath();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }


    }
}
