package com.cit.minin;

import com.cit.minin.service.Transcription;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Transcription transcription = Transcription.getObject();

        try (Scanner in = new Scanner(System.in)) {
            log.info("Введите фамилию: ");
            String surnameCr = in.next();

            String surnameLat1 = transcription.transcriptionWithArray(surnameCr);
            log.info("With if-else construction: " + surnameLat1);

            String surnameLat2 = transcription.transcriptionWithSwitchCase(surnameCr);
            log.info("With swith-case construction: " + surnameLat2);

            String surnameLat3 = transcription.transcriptionWithHashMap(surnameCr);
            log.info("With key-value construction: " + surnameLat3);

        } catch (Exception e) {
            log.warning(e.toString());
        }
    }
}
