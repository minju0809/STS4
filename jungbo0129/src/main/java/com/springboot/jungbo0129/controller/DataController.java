package com.springboot.jungbo0129.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@Controller
public class DataController {

  @GetMapping("/dataXML")
  public String dataXML() throws Exception {

    String urlStr = "https://apis.data.go.kr/1383000/gmis/mtpcltFamSpcnServiceV2/getMtpcltFamSpcnListV2";
    String serviceKey = "Rlv%2FLwLil1lc5xKQg7CBwm%2BcvuksrkTpcQuQozGJvXsRYmOryjgMjlL4ou%2BfxTjfI%2F%2BJAO7uBo1vVrIWnAhSmQ%3D%3D";
    String pageNo = "1";
    String numOfRows = "229";
    String type = "xml";

    StringBuilder urlBuilder = new StringBuilder(urlStr);
    urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
    urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8"));
    urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); // 229
    urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8"));
    URL url = new URL(urlBuilder.toString());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Content-type", "application/json");
    System.out.println("Response code: " + conn.getResponseCode());
    BufferedReader rd;
    if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
      rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    } else {
      rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    }
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
      sb.append(line);
    }
    rd.close();
    conn.disconnect();
    System.out.println(sb.toString());

    Node data1 = null;
    Node data2 = null;
    Node data3 = null;
    Node data4 = null;
    Node data5 = null;
    Node data6 = null;
    Node data7 = null;
    Node data8 = null;

    try {
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

      FileOutputStream output = new FileOutputStream("./ApiExplorer");
      output.write(sb.toString().getBytes("UTF-8")); // 전체 데이터 읽어 오기
      output.close();

      Document doc = dBuilder.parse("./ApiExplorer");
      doc.getDocumentElement().normalize();

      Element body = (Element) doc.getElementsByTagName("body").item(0);
      Element items = (Element) body.getElementsByTagName("items").item(0);

      for (int i = 0; i < 229; i++) {
        Element item = (Element) items.getElementsByTagName("item").item(i);

        data1 = item.getElementsByTagName("cnterNm").item(0);
        data2 = item.getElementsByTagName("cnterChNm").item(0);
        data3 = item.getElementsByTagName("roadNmAddr").item(0);
        data4 = item.getElementsByTagName("lat").item(0);
        data5 = item.getElementsByTagName("lot").item(0);
        data6 = item.getElementsByTagName("hmpgAddr").item(0);
        // data7 = item.getElementsByTagName("ctpvNm").item(0);
        // data8 = item.getElementsByTagName("sggNm").item(0);

        String strData1 = data1.getChildNodes().item(0).getNodeValue();
        String strData2 = data2.getChildNodes().item(0).getNodeValue();
        String strData3 = data3.getChildNodes().item(0).getNodeValue();
        String strData4 = data4.getChildNodes().item(0).getNodeValue();
        String strData5 = data5.getChildNodes().item(0).getNodeValue();
        String strData6 = data6.getChildNodes().item(0).getNodeValue();
        // String strData7 = data7.getChildNodes().item(0).getNodeValue();
        // String strData8 = data8.getChildNodes().item(0).getNodeValue();

        System.out.println(
            "==>" + (i + 1) + "번 : " + strData1 + " " + strData2 + " " + strData3 + " " + strData4 + " " + strData5
                + " " + strData6);
        // CompanyVo vo = new CompanyVo();

        // vo.setAddr(strData1);
        // vo.setCpNm(strData2);
        // vo.setCsNm(strData3);
        // vo.setLat(strData4);
        // vo.setLongi(strData5);
        // vo.setStatUpdateDatetime(strData6);
        // System.out.println(i+"번 데이터 입력");
        // service.companyInsert(vo);

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:/main.do";
  }

  @GetMapping("/dataJSON")
  public String dataJSON() throws Exception {

    String urlStr = "https://apis.data.go.kr/1383000/gmis/mtpcltFamSpcnServiceV2/getMtpcltFamSpcnListV2";
    String serviceKey = "Rlv%2FLwLil1lc5xKQg7CBwm%2BcvuksrkTpcQuQozGJvXsRYmOryjgMjlL4ou%2BfxTjfI%2F%2BJAO7uBo1vVrIWnAhSmQ%3D%3D";
    String pageNo = "1";
    String numOfRows = "229";
    String type = "json";

    StringBuilder urlBuilder = new StringBuilder(urlStr);
    urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
    urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8"));
    urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); // 229
    urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8"));
    URL url = new URL(urlBuilder.toString());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Content-type", "application/json");
    System.out.println("Response code: " + conn.getResponseCode());
    BufferedReader rd;
    if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
      rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    } else {
      rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    }
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
      sb.append(line);
    }
    rd.close();
    conn.disconnect();
    System.out.println(sb.toString());

    try {

      JSONParser jsonParser = new JSONParser();

      JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());
      JSONObject response = (JSONObject) jsonObject.get("response");
      JSONObject body = (JSONObject) response.get("body");
      JSONObject items = (JSONObject) body.get("items");
      JSONArray InfoArray = (JSONArray) items.get("item");

      System.out.println("* items *");

      for (int i = 0; i < InfoArray.size(); i++) {

        System.out.println("=items_" + i + "===========================================");

        // 배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
        JSONObject object = (JSONObject) InfoArray.get(i);

        // JSON name으로 추출
        System.out.println("Info: cnterNm==>" + object.get("cnterNm"));
        System.out.println("Info: cnterChNm==>" + object.get("cnterChNm"));
        System.out.println("Info: roadNmAddr==>" + object.get("roadNmAddr"));

      }
    } catch (

    Exception e) {
      e.printStackTrace();
    }
    return "redirect:/main.do";
  }
}
