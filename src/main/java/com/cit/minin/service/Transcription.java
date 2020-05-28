package com.cit.minin.service;


import java.util.HashMap;
import java.util.Map;

public class Transcription {
    private final String[] RUS = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п",
            "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "ъ", "ы", "ь", "э", "ю", "я"};
    private final String[] ENG = {"a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l", "m", "n", "o", "p",
            "r", "s", "t", "y", "f", "h", "ch", "ch", "sh", "'", "y", "'", "e", "y", "ya"};
    private final Map<String, String> hashMapLetter = new HashMap<>();
    private static Transcription transcription;

    private Transcription() {
        for (int i = 0; i < RUS.length; i++) {
            hashMapLetter.put(RUS[i], ENG[i]);
        }
    }

    public static Transcription getObject() {
        if (transcription == null) {
            transcription = new Transcription();
            return transcription;
        } else {
            return transcription;
        }
    }

    /**
     * Поиск и замена символов с помощью конструкции if-else
     *
     * @param surnameCr Фамилия на кириллице
     * @return Фамилия на латинице
     */
    public String transcriptionWithArray(String surnameCr) {
        String surnameLat = "";

        // Переводим все символы в нижний регистр, что бы не хранить буквы верхнего и нижнего решистра
        surnameCr = nameToLoverCase(surnameCr);

        for (int i = 0; i < surnameCr.length(); i++) {
            // В случае если символ или цифра встретится
            boolean error = false;

            // Формировнание фамилии на латинице
            for (int j = 0; j < RUS.length; j++) {
                if (surnameCr.substring(i, i + 1).equals(RUS[j])) {
                    surnameLat = surnameLat.concat(ENG[j]);
                    error = false;
                    break;
                } else {
                    error = true;
                }
            }
            // Если была введена цифра или символ
            if (error) {
                return "Фамилия введена не правильно !!!";
            }
        }

        // Первую букву в верхний регистр
        return surnameLat.substring(0, 1).toUpperCase() + surnameLat.substring(1);
    }

    /**
     * Поиск и замена символов с помощью конструкции switch-case
     *
     * @param surnameCr Фамилия на кириллице
     * @return Фамилия на латинице
     */
    public String transcriptionWithSwitchCase(String surnameCr) {
        surnameCr = nameToLoverCase(surnameCr);
        String surnameLat = "";

        for (int i = 0; i < surnameCr.length(); i++) {
            switch (surnameCr.substring(i, i + 1)) {
                case "а":
                    surnameLat = surnameLat.concat("a");
                    break;
                case "б":
                    surnameLat = surnameLat.concat("b");
                    break;
                case "в":
                    surnameLat = surnameLat.concat("v");
                    break;
                case "г":
                    surnameLat = surnameLat.concat("g");
                    break;
                case "д":
                    surnameLat = surnameLat.concat("d");
                    break;
                case "е":
                    surnameLat = surnameLat.concat("e");
                    break;
                case "ё":
                    surnameLat = surnameLat.concat("e");
                    break;
                case "ж":
                    surnameLat = surnameLat.concat("zh");
                    break;
                case "з":
                    surnameLat = surnameLat.concat("z");
                    break;
                case "и":
                    surnameLat = surnameLat.concat("i");
                    break;
                case "й":
                    surnameLat = surnameLat.concat("i");
                    break;
                case "к":
                    surnameLat = surnameLat.concat("k");
                    break;
                case "л":
                    surnameLat = surnameLat.concat("l");
                    break;
                case "м":
                    surnameLat = surnameLat.concat("m");
                    break;
                case "н":
                    surnameLat = surnameLat.concat("n");
                    break;
                case "о":
                    surnameLat = surnameLat.concat("o");
                    break;
                case "п":
                    surnameLat = surnameLat.concat("p");
                    break;
                case "р":
                    surnameLat = surnameLat.concat("r");
                    break;
                case "с":
                    surnameLat = surnameLat.concat("s");
                    break;
                case "т":
                    surnameLat = surnameLat.concat("t");
                    break;
                case "у":
                    surnameLat = surnameLat.concat("u");
                    break;
                case "ф":
                    surnameLat = surnameLat.concat("f");
                    break;
                case "х":
                    surnameLat = surnameLat.concat("kh");
                    break;
                case "ц":
                    surnameLat = surnameLat.concat("ts");
                    break;
                case "ч":
                    surnameLat = surnameLat.concat("ch");
                    break;
                case "ш":
                    surnameLat = surnameLat.concat("sh");
                    break;
                case "щ":
                    surnameLat = surnameLat.concat("shch");
                    break;
                case "ъ":
                    surnameLat = surnameLat.concat("ie");
                    break;
                case "ы":
                    surnameLat = surnameLat.concat("y");
                    break;
                case "ь":
                    surnameLat = surnameLat.concat("");
                    break;
                case "э":
                    surnameLat = surnameLat.concat("e");
                    break;
                case "ю":
                    surnameLat = surnameLat.concat("iu");
                    break;
                case "я":
                    surnameLat = surnameLat.concat("ia");
                    break;
                default:
                    return "Фамилия введена не правильно !!!";
            }
        }
        return surnameLat.substring(0, 1).toUpperCase() + surnameLat.substring(1);
    }

    /**
     * Поиск и замена символов исользуя отношение ключ-значения
     *
     * @param surnameCr Фамилия на кириллице
     * @return Фамилия на латинице
     */
    public String transcriptionWithHashMap(String surnameCr) {
        surnameCr = nameToLoverCase(surnameCr);
        String surnameLat = "";

        for (int i = 0; i < surnameCr.length(); i++) {
            String valLat = hashMapLetter.get(surnameCr.substring(i, i + 1));
            if (valLat == null) {
                return "Фамилия введена не правильно !!!";
            } else {
                surnameLat = surnameLat.concat(valLat);
            }
        }
        // Первую букву в верхний регистр
        return surnameLat.substring(0, 1).toUpperCase() + surnameLat.substring(1);
    }


    /**
     * Перевод фамилии в нижний регистр
     * @param subname Фамилия
     * @return Фамилия в нижнем регистре
     */
    private String nameToLoverCase(String subname) {
        return subname.toLowerCase();
    }
}
