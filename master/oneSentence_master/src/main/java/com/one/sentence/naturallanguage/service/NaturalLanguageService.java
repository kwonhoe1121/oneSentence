package com.one.sentence.naturallanguage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1beta2.AnalyzeSentimentResponse;
import com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1beta2.Document;
import com.google.cloud.language.v1beta2.EncodingType;
import com.google.cloud.language.v1beta2.Entity;
import com.google.cloud.language.v1beta2.LanguageServiceClient;
import com.google.cloud.language.v1beta2.Sentiment;
import com.google.cloud.language.v1beta2.Token;
import com.one.sentence.naturallanguage.vo.NLAnalyzeVO;

@Service
public class NaturalLanguageService {

    private static NaturalLanguageService instance = new NaturalLanguageService();
    private static LanguageServiceClient languageServiceClient;
    //싱글톤 - static 원래 붙여야함.  - service로 사용시 싱글톤 패턴 없앤다.
    public static NaturalLanguageService getInstance() {
        try {
            languageServiceClient = LanguageServiceClient.create();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return instance;
    }


    public NLAnalyzeVO analyze(String text) {

        NLAnalyzeVO nlAnalyzeVo = new NLAnalyzeVO();

        List<Token> tokenList = analyzeSyntax(text);

        for (Token token : tokenList) {
            String tag = token.getPartOfSpeech().getTag().toString();
            String content = token.getText().getContent();

            if (tag.equals("NOUN")) nlAnalyzeVo.addNouns(content);
            else if (tag.equals("ADJ")) nlAnalyzeVo.addAdjs(content);

        }

        return nlAnalyzeVo;
    }


    public List<Entity> analyzeEntities(String text) {
        try {
            Document document = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();

            AnalyzeEntitiesRequest request = AnalyzeEntitiesRequest.newBuilder()
                    .setDocument(document)
                    .setEncodingType(EncodingType.UTF16)
                    .build();

            AnalyzeEntitiesResponse response = languageServiceClient.analyzeEntities(request);

            return response.getEntitiesList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Sentiment analyzeSentiment(String text) {
        try {
            Document document = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();

            AnalyzeSentimentResponse response = languageServiceClient.analyzeSentiment(document);
            return response.getDocumentSentiment();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Token> analyzeSyntax(String text) {
        try {
            Document document = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();

            AnalyzeSyntaxRequest request = AnalyzeSyntaxRequest.newBuilder()
                    .setDocument(document)
                    .setEncodingType(EncodingType.UTF16)
                    .build();

            AnalyzeSyntaxResponse response = languageServiceClient.analyzeSyntax(request);

            return response.getTokensList();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
