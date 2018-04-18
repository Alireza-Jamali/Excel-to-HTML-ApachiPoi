package search;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import view.InputSharhList;

/**
 *
 * @author AezA
 */
public class Processor {

    private ArrayList<Entity> bardashtList;
    public String sumBardashtFromSharh(ArrayList<Entity> list, List<InputSharhList> inputSharh) {
        
        bardashtList = new ArrayList<>();
        double sum = 0d;
        for(Entity entity : list) {
            
            String sharhCell = entity.getSharh();
            sharhCell = arabicToEnglish(sharhCell);
            for (InputSharhList sharhList : inputSharh) {

                String userInput = sharhList.getValue();
                if(sharhCell != null && (sharhCell.contains(userInput.trim())
                        || sharhCell.contains(invert(userInput.trim()))
                        || sharhCell.replace("-", "").contains(userInput.trim())
                        || sharhCell.replace("-", "").contains(invert(userInput.trim())))
                        || sharhCell.contains(invert(new StringBuilder(userInput).insert(4, "-").insert(8, "-").insert(17, "-").toString()))) {

                    sum += entity.getBardasht();
                    bardashtList.add(entity);
                    break;
                }
            }
        }
        
        return NumberFormat.getInstance().format(sum);
    }
    public ArrayList<Entity> getEntityFromYaddasht(ArrayList<Entity> list, String inputYaddasht) {
    
        ArrayList<Entity> entityList = new ArrayList<>();
        for(Entity entity : list) {
        
            String yad = entity.getYaddasht();
            if(yad != null && yad.contains(inputYaddasht)) {
     
                entityList.add(entity);
            }
        }
        return entityList;
    }
    public ArrayList<Entity> getBardashtList() {
    
        return bardashtList;
    }
    
    private String invert(String txt) {
    
        String kk = "";
        try {
            String[] s = txt.split("-");
            String[] ss = new String[s.length];
            int k = s.length - 1;
            for (int i = 0; i < s.length; i++) {
                
                ss[i] = s[k--];
            }
            for (String n : ss) {
                
                kk += n + "-";
            }
        } catch (Exception e) {/*no problem*/}
        return kk.replaceFirst(".$", "");
    }
    
    private String arabicToEnglish(String s) {

        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {

                case '\u0660':
                    s = s.replace(s.substring(i, i + 1), "0");
                    break;
                case '\u0661':
                    s = s.replace(s.substring(i, i + 1), "1");
                    break;
                case '\u0662':
                    s = s.replace(s.substring(i, i + 1), "2");
                    break;
                case '\u0663':
                    s = s.replace(s.substring(i, i + 1), "3");
                    break;
                case '\u0664':
                    s = s.replace(s.substring(i, i + 1), "4");
                    break;
                case '\u0665':
                    s = s.replace(s.substring(i, i + 1), "5");
                    break;
                case '\u0666':
                    s = s.replace(s.substring(i, i + 1), "6");
                    break;
                case '\u0667':
                    s = s.replace(s.substring(i, i + 1), "7");
                    break;
                case '\u0668':
                    s = s.replace(s.substring(i, i + 1), "8");
                    break;
                case '\u0669':
                    s = s.replace(s.substring(i, i + 1), "9");
                    break;
                case '\u06F0':
                    s = s.replace(s.substring(i, i + 1), "0");
                    break;
                case '\u06F1':
                    s = s.replace(s.substring(i, i + 1), "1");
                    break;
                case '\u06F2':
                    s = s.replace(s.substring(i, i + 1), "2");
                    break;
                case '\u06F3':
                    s = s.replace(s.substring(i, i + 1), "3");
                    break;
                case '\u06F4':
                    s = s.replace(s.substring(i, i + 1), "4");
                    break;
                case '\u06F5':
                    s = s.replace(s.substring(i, i + 1), "5");
                    break;
                case '\u06F6':
                    s = s.replace(s.substring(i, i + 1), "6");
                    break;
                case '\u06F7':
                    s = s.replace(s.substring(i, i + 1), "7");
                    break;
                case '\u06F8':
                    s = s.replace(s.substring(i, i + 1), "8");
                    break;
                case '\u06F9':
                    s = s.replace(s.substring(i, i + 1), "9");
                    break;
            }
        }
        return s;
    }
}