package server.util;

import server.model.Role;
import server.model.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

enum FieldType {
    INT("INT"), LONG("LONG"), DOUBLE("DOUBLE"), JAVALANGSTRING("JAVALANGSTRING"),
    SERVERMODELROLE("SERVERMODELROLE");

    FieldType(String s) {
    }
}

public class UserFactory {

    public static List<User> createObjects(User user, List<String> typedAppliances){
        List<User> registeredUsers = new ArrayList<>();
        typedAppliances.forEach(s -> {
            try {
                User newUserInstance = user.getClass().newInstance();
                Class<? extends User> userClass = newUserInstance.getClass();
                Field[] userFields = userClass.getDeclaredFields();

                for (Field field: userFields) {    //run through all fields and set data
                    field.setAccessible(true);
                    String fieldType = field.getType().getName().toUpperCase().replace(".", "");    //get name of field as string
                    FieldType emptyFieldType = FieldType.valueOf(fieldType);    //convert it to enum to be able to compare it in switch-case
                    try {
                        switch (emptyFieldType) {
                            case INT -> {
                                String data = getParameterPattern(field.getName())
                                                .matcher(s)
                                                .results()
                                                .map(matchResult -> matchResult.group(1))
                                                .collect(Collectors.joining("")
                                                );
                                field.setInt(newUserInstance, Integer.parseInt(data));
                            }
                            case LONG -> {
                                String data = getParameterPattern(field.getName())
                                        .matcher(s)
                                        .results()
                                        .map(matchResult -> matchResult.group(1))
                                        .collect(Collectors.joining("")
                                        );
                                field.setLong(newUserInstance, Integer.parseInt(data));
                            }
                            case DOUBLE -> {
                                String data = getParameterPattern(field.getName())
                                        .matcher(s)
                                        .results()
                                        .map(matchResult -> matchResult.group(1))
                                        .collect(Collectors.joining(""));
                                field.setDouble(newUserInstance, Double.parseDouble(data));
                            }
                            case JAVALANGSTRING -> {
                                String data = getParameterPattern(field.getName())
                                        .matcher(s)
                                        .results()
                                        .map(matchResult -> matchResult.group(1))
                                        .collect(Collectors.joining(""));
                                field.set(newUserInstance, data);
                            }
                            case SERVERMODELROLE -> {
                                String data = getParameterPattern(field.getName())
                                        .matcher(s)
                                        .results()
                                        .map(matchResult -> matchResult.group(1))
                                        .collect(Collectors.joining(""));
                                field.set(newUserInstance, Role.valueOf(data));
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Exception in ApplianceFactory.getAppliancesOfDefinedType. Invalid datatype");
                    }
                }
                registeredUsers.add(newUserInstance);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        return registeredUsers;
    }

    /**
     * @param parameterName - name of object field (the same as in XML doc)
     * @return compiled pattern
     */
    public static Pattern getParameterPattern(String parameterName) {
        return Pattern.compile("<%s>(.*?)</%s>".formatted(parameterName, parameterName));
    }
}


