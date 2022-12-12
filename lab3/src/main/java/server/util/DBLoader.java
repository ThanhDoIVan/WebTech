package server.util;

import server.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Class that loads XML database and parses in
 */
public class DBLoader {

    private static final String DB_FILEPATH = "./src/main/resources/usersDB.xml";
    private static final Path path = Paths.get(DB_FILEPATH);

    /**
     * Method that loads db and returns list of objects
     * @return HashMap (Key, Value) = (ApplianceType, List of appliances)
     */
    public static List<User> loadAllFromDB(){
        String dbData = readDataFromFile();   //read xml DB to String
        HashMap<String, List<String>> dividedAppliances = mapStringByApplianceTypes(dbData);
        List<User> usersList = new ArrayList<>();
        usersList.addAll(UserFactory.createObjects(new User(), dividedAppliances.get("User")));
        return usersList;
    }

    /**
     * @return String of data, read from XML
     */
    private static String readDataFromFile(){
        StringBuilder dbDataString = new StringBuilder();
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("")){
                    continue;
                }
                dbDataString.append(line.trim());
            }
            return new String(dbDataString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param dbString - parameter with all DB data
     * @return HashMap where (Key, Value) = (Appliance type, Stringified appliance data)
     */
    private static HashMap<String, List<String>> mapStringByApplianceTypes(String dbString){
        HashMap<String, List<String>> dividedAppliances = new HashMap<>();
        List<String> fieldsList = getAppliancePattern(new User()).matcher(dbString)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("User", fieldsList);
        return dividedAppliances;
    }

    private static Pattern getAppliancePattern(Object applianceClass) {
        String fullClassName = applianceClass.getClass().getName();
        String className = fullClassName.substring(fullClassName.indexOf(".") + 1);
        return Pattern.compile("<User>(.*?)</User>");
    }
}
