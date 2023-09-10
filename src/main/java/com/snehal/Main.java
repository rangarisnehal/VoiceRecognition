package com.snehal;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Main {
    public static void main(String[] args)
    {

        Configuration config = new Configuration();

        /*
        Search "sphinx knowledge base generator" in google to convert command.txt file into
        .dic and .lm (Dictionary and language)
         */

        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("src\\main\\resources\\1481.dic");
        config.setLanguageModelPath("src\\main\\resources\\1481.lm");

        try {
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
            speech.startRecognition(true);
            SpeechResult speechResult=null;
            while((speechResult=speech.getResult()) != null){
                String voiceCommand = speechResult.getHypothesis();

                if (voiceCommand.equalsIgnoreCase("Open Chrome")){
                    Runtime.getRuntime().exec("cmd.exe /c start chrome www.google.com");
                } else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
                    Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
                } else if (voiceCommand.equalsIgnoreCase("Open YouTube")) {
                    Runtime.getRuntime().exec("cmd.exe /c start chrome www.youtube.com");
                } else if (voiceCommand.equalsIgnoreCase("CLose YouTube")) {
                    Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
                } else if (voiceCommand.equalsIgnoreCase("Open Paint")) {
                    Runtime.getRuntime().exec("cmd.exe /c start mspaint");
                } else if (voiceCommand.equalsIgnoreCase("Close Paint")) {
                    Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM mspaint.exe");
                }else if (voiceCommand.equalsIgnoreCase("Open Word")) {
                    Runtime.getRuntime().exec("cmd.exe /c start winword");
                } else if (voiceCommand.equalsIgnoreCase("Close Word")) {
                    Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM winword.exe");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}