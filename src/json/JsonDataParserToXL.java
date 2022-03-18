package json;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;    
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;

public class JsonDataParserToXL {

    private static JSONObject obj;

    public static void getDetailsOfKey(String key) {
        try {
            Data dataObj = new Data();
            JSONObject value = obj.getJSONObject(key);
            dataObj.setId(Integer.valueOf(key));
            dataObj.setName((String) value.get("name"));
            dataObj.setDescription((String) value.get("description"));
            dataObj.setImage((String) value.get("image"));
            JSONArray array = value.getJSONArray("attributes");
            for (int i = 0; i < array.length(); i++) {
                JSONObject tempAttribute = array.getJSONObject(i);
                String trait_type = (String) tempAttribute.get("trait_type");
                if (trait_type.equals("Regions")) {
                    dataObj.setRegions(tempAttribute.getInt("value"));
                } else if (trait_type.equals("Cities")) {
                    dataObj.setCities(tempAttribute.getInt("value"));
                } else if (trait_type.equals("Harbors")) {
                    dataObj.setHarbors(tempAttribute.getInt("value"));
                } else if (trait_type.equals("Rivers")) {
                    dataObj.setRivers(tempAttribute.getInt("value"));
                } else if (trait_type.equals("Resource")) {
                    String trait_value = (String) tempAttribute.get("value");
                    if (trait_value.equals("Coal")) {
                        dataObj.setCoal(1);
                    } else if (trait_value.equals("Wood")) {
                        dataObj.setWood(1);
                    } else if (trait_value.equals("Stone")) {
                        dataObj.setStone(1);
                    } else if (trait_value.equals("Copper")) {
                        dataObj.setCopper(1);
                    } else if (trait_value.equals("Obsidian")) {
                        dataObj.setObsidian(1);
                    } else if (trait_value.equals("Silver")) {
                        dataObj.setSilver(1);
                    } else if (trait_value.equals("Ironwood")) {
                        dataObj.setIronwood(1);
                    } else if (trait_value.equals("Cold Iron")) {
                        dataObj.setCold_Iron(1);
                    } else if (trait_value.equals("Gold")) {
                        dataObj.setGold(1);
                    } else if (trait_value.equals("Hartwood")) {
                        dataObj.setHartwood(1);
                    } else if (trait_value.equals("Diamonds")) {
                        dataObj.setDiamonds(1);
                    } else if (trait_value.equals("Sapphire")) {
                        dataObj.setSapphire(1);
                    } else if (trait_value.equals("Deep Crystal")) {
                        dataObj.setDeep_Crystal(1);
                    } else if (trait_value.equals("Ruby")) {
                        dataObj.setRuby(1);
                    } else if (trait_value.equals("Ignium")) {
                        dataObj.setIgnium(1);
                    } else if (trait_value.equals("Ethereal Silica")) {
                        dataObj.setEthereal_Silica(1);
                    } else if (trait_value.equals("True Ice")) {
                        dataObj.setTrue_Ice(1);
                    } else if (trait_value.equals("Twilight Quartz")) {
                        dataObj.setTwilight_Quartz(1);
                    } else if (trait_value.equals("Alchemical Silver")) {
                        dataObj.setAlchemical_Silver(1);
                    } else if (trait_value.equals("Adamantine")) {
                        dataObj.setAdamantine(1);
                    } else if (trait_value.equals("Mithral")) {
                        dataObj.setMithral(1);
                    } else if (trait_value.equals("Dragonhide")) {
                        dataObj.setDragonhide(1);
                    }

                } else if (trait_type.equals("Order")) {
                    dataObj.setOrder(tempAttribute.getString("value"));
                } else if (trait_type.equals("Wonder (translated)")) {
                    dataObj.setWonder(tempAttribute.getString("value"));
                }
            }
            Data.Details.add(dataObj);

        } catch (JSONException ex) {
            Logger.getLogger(JsonDataParserToXL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) throws JSONException {

        String resourceName = "G:\\Part-2\\Json_Project\\realms.json";
        FileReader reader = null;
        try {
            reader = new FileReader(resourceName);
            JSONTokener tokener = new JSONTokener(reader);
            JSONArray array = new JSONArray(tokener);
            obj = array.getJSONObject(0);
            Iterator<?> itr = obj.keys();
            List<Integer> li = new ArrayList<>();
            while (itr.hasNext()) {
                Object temp = itr.next();
                li.add(Integer.valueOf((String) temp));
            }
            Collections.sort(li);
            for (int i = 0; i < li.size(); i++) {
                getDetailsOfKey(li.get(i).toString());
            }
            XL_WRITE.writeXL();
            JOptionPane.showMessageDialog(null, "XL CreatedSuccessfully");

        } catch (FileNotFoundException | JSONException | NumberFormatException | HeadlessException e) {
            System.out.println(e + "--------------");
        }

    }

}
