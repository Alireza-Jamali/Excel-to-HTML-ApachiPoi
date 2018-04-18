package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.primefaces.event.FileUploadEvent;
import search.Entity;
import search.Reader;
import search.Processor;

@ManagedBean
@ViewScoped
public class ViewInteractionsHandler {

    private List<InputSharhList> inputSharhList;
    
    @PostConstruct
    public void init() {
        inputSharhList = new ArrayList<>();
    }
    public void remove(InputSharhList in) {
    
        inputSharhList.remove(in);
    }
    public void add() {  
        inputSharhList.add(new InputSharhList());
    }

    public List<InputSharhList> getInputSharhList() {
        return inputSharhList;
    }

    public String sharhResult = "";
    public String yaddashtCode;
    private Reader reader = new Reader();
    private Processor processor = new Processor();
    
    private ArrayList<Entity> entityList;
    public ArrayList<Entity> tableList;
    
    public ArrayList<Entity> getTableList() {
        return tableList;
    }

    public void setTableList(ArrayList<Entity> tableList) {
        this.tableList = tableList;
    }
    public String getYaddashtCode() {
        return yaddashtCode;
    }

    public void setYaddashtCode(String yaddashtCode) {
        this.yaddashtCode = yaddashtCode;
    }

    public String getSharhResult() {
        return sharhResult;
    }

    public void setSharhResult(String sharhResult) {
        this.sharhResult = sharhResult;
    }

    public void handleFileUpload(FileUploadEvent event) {
        sharhResult = "";
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        FileInputStream in = null;

        try {
            in = (FileInputStream) event.getFile().getInputstream();
            excelToEntities(in);
            
        } catch (IOException | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }
    
    private void excelToEntities(FileInputStream fin) throws IOException, InvalidFormatException {
     
        entityList = reader.readFromExcel(fin);
        tableList = entityList;
    }
    
    public void reset() {
    
        tableList = entityList;
        sharhResult = "";
        inputSharhList.clear();
        yaddashtCode = "";
    }
    
    public void handleSharh() {
    
        try {
  
            sharhResult = processor.sumBardashtFromSharh(entityList, inputSharhList);
            tableList = processor.getBardashtList();
            inputSharhList.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void handleYaddasht() {
        if (yaddashtCode == null || yaddashtCode.equals("")) {
            
            tableList = entityList;
  
        }else {
            tableList = processor.getEntityFromYaddasht(entityList, yaddashtCode);
        }
    }
    
}
