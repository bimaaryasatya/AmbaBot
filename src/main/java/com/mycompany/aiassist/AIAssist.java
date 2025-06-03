/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aiassist;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.util.Scanner;

/**
 *
 * @author bimazznxt
 */
public class AIAssist {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Prompt: ");
            String prompt = sc.nextLine();
            String endpoint = "http://localhost:11434/api/generate";
            String jsonInputString = "{ \"model\": \"deepseek-r1:1.5b\", \"prompt\": \""+prompt+"\" }";

            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Write the request JSON
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input);
                os.flush();
            }

            // Prepare to read streaming response
            Gson gson = new Gson();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        JsonObject json = gson.fromJson(line, JsonObject.class);
                        if (json.has("response")) {
                            System.out.print(json.get("response").getAsString()); // Print token chunk
                        }
                        if (json.has("done") && json.get("done").getAsBoolean()) {
                            break;
                        }
                    } catch (JsonSyntaxException e) {
                        // Ignore malformed chunks
                    }
                }
                System.out.println(); // Add newline at end
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
