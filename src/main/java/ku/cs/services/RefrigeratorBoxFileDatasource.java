package ku.cs.services;

import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;

import java.io.*;

public class RefrigeratorBoxFileDatasource implements Datasource {
    private String fileDirectoryName;
    private String fileName;
    private RefrigeratorBoxList refrigeratorBoxes;

    public RefrigeratorBoxFileDatasource(String fileDirectoryName, String fileName) {
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
            RefrigeratorBox refrigeratorBox = new RefrigeratorBox(data[0].trim(),Integer.parseInt(data[1].trim()));
            refrigeratorBoxes.add(refrigeratorBox);
        }
        reader.close();
    }

    @Override
    public RefrigeratorBoxList getRefrigeratorBoxesData(){
        try {
            refrigeratorBoxes = new RefrigeratorBoxList();
            readData();
        } catch (FileNotFoundException e){
            System.err.println(this.fileName + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return refrigeratorBoxes;
    }

    @Override
    public void setRefrigeratorBoxesData(RefrigeratorBoxList refrigeratorBoxes){
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (RefrigeratorBox refrigeratorBox: refrigeratorBoxes.getRefrigeratorBoxes()){
                String line = refrigeratorBox.getBoxType() + ","
                        + refrigeratorBox.getBoxNumber() + ","
                        + refrigeratorBox.getFoods();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e){
            System.err.println("Cannot write " + filePath);
        }
    }



}