package com.company;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main extends javafx.application.Application {
    static double javaListTime;
    static double newListTime;
    static double javaArrayListTime;
    static double javaHashSetTime;
    static double javaTreeSetTime;

    public static void main(String[] args) {
        LinkedListN<String> testList = new LinkedListN<>();
        LinkedList<String> linkedList = new LinkedList<>();
        HashSet<String> hashSet = new HashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();
        TreeSet<String> treeSet = new TreeSet<>();
        String[] add = new String[0];
        int k = 0;
        // Рандом для заполнения файла числами
//        File file = new File("C:\\Users\\Radians\\IdeaProjects\\LinkedList\\src\\com\\company\\file.txt");
//        int min = 1;
//        int max = 1000;
//        int diff = max - min;
//        Random random = new Random();
//        try (OutputStream outputStream = new FileOutputStream(file)) {
//            for (int i = 0; i < 70000; i++) {
//                if (i == 69999) {
//                    String max1 = Integer.toString(random.nextInt(diff + 1));
//                    byte[] data = max1.getBytes(StandardCharsets.UTF_8);
//                    outputStream.write(data);
//                    break;
//                } else {
//                    String max1 = Integer.toString(random.nextInt(diff + 1)) + ",";
//                    byte[] data = max1.getBytes(StandardCharsets.UTF_8);
//                    outputStream.write(data);
//                }
//            }
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
        // Сравнение коллекций
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Radians\\IdeaProjects\\LinkedList\\src\\com\\company\\file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                add = line.split(",");
                long timeTestListn = System.currentTimeMillis();
                for (String sss : add) {
                    testList.add(sss);
                }
                newListTime = System.currentTimeMillis() - timeTestListn;
                System.out.println("New LinkedList time add = " +  (System.currentTimeMillis() - timeTestListn));
                long timeJavaList = System.currentTimeMillis();
                Collections.addAll(linkedList, add);
                javaListTime = System.currentTimeMillis() - timeJavaList;
                System.out.println("Java LinkedList time add= " +  (System.currentTimeMillis() - timeJavaList));
                long timeJavaArrayList = System.currentTimeMillis();
                Collections.addAll(arrayList, add);
                javaArrayListTime = System.currentTimeMillis() - timeJavaArrayList;
                System.out.println("Java ArrayList time add = " +  (System.currentTimeMillis() - timeJavaArrayList));
                long timeJavaTreeSet = System.currentTimeMillis();
                Collections.addAll(treeSet, add);
                javaTreeSetTime = System.currentTimeMillis() - timeJavaTreeSet;
                System.out.println("Java TreeSet time add= " +  (System.currentTimeMillis() - timeJavaTreeSet));
                long timeJavaHashSet = System.currentTimeMillis();
                Collections.addAll(hashSet, add);
                javaHashSetTime = System.currentTimeMillis() - timeJavaHashSet;
                System.out.println("Java HashSet time add= " +  (System.currentTimeMillis() - timeJavaHashSet));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        testList.size();
        testList.set(1,"dd");
        //Время выполнения методов
        long timeJavaListadd = System.currentTimeMillis();
        testList.add(57000, "ddd");
        System.out.println("New java list time insert = " +  (System.currentTimeMillis() - timeJavaListadd));
        long timeJavaListAdd2 = System.currentTimeMillis();
        linkedList.add(57000, "ddd");
        System.out.println("Java list time insert = " +  (System.currentTimeMillis() - timeJavaListAdd2));
        long timeJavaArrayListAdd2 = System.currentTimeMillis();
        arrayList.add(57000, "ddd");
        System.out.println("Java ArrayList time insert = " +  (System.currentTimeMillis() - timeJavaArrayListAdd2));
        long timeJavaListToArray = System.currentTimeMillis();
        testList.toArray();
        System.out.println("New java list time toArray = " +  (System.currentTimeMillis() - timeJavaListToArray));
        long timeJavaListToArray2 = System.currentTimeMillis();
        linkedList.toArray();
        System.out.println("Java list time toArray = " +  (System.currentTimeMillis() - timeJavaListToArray2));
        long timeJavaListToString = System.currentTimeMillis();
        testList.toString();
        System.out.println("New java list time toString = " +  (System.currentTimeMillis() - timeJavaListToString));
        long timeJavaListToString2 = System.currentTimeMillis();
        linkedList.toString();
        System.out.println("Java list time toString = " +  (System.currentTimeMillis() - timeJavaListToString2));
        long timeJavaListget = System.currentTimeMillis();
        linkedList.get(2000);
        System.out.println("Java list time get = " +  (System.currentTimeMillis() - timeJavaListget));
        long timeJavaListget2 = System.currentTimeMillis();
        testList.get(2000);
        System.out.println("New java list time get = " +  (System.currentTimeMillis() - timeJavaListget2));
        long timeJavaListForeach = System.currentTimeMillis();
        for (String str : linkedList) {
        }
        System.out.println("Java list time foreach = " +  (System.currentTimeMillis() - timeJavaListForeach));
        long timeJavaListForeach2 = System.currentTimeMillis();
        for (String str2 : testList) {
        }
        System.out.println("New java list time foreach = " +  (System.currentTimeMillis() - timeJavaListForeach2));
        long timeJavaListClear = System.currentTimeMillis();
        linkedList.clear();
        System.out.println("Java list time remove = " +  (System.currentTimeMillis() - timeJavaListClear));
        long timeJavaListClear2 = System.currentTimeMillis();
        testList.clear();
        System.out.println("New java list time remove = " +  (System.currentTimeMillis() - timeJavaListClear2));
        Application.launch(args);


    }
    // Диаграмма
    @Override
    public void start(Stage primaryStage) {

        PieChart pieChart = new PieChart();
        PieChart.Data slice1 = new PieChart.Data("New LinkedList "+newListTime +" "+"milliseconds", newListTime);
        PieChart.Data slice2 = new PieChart.Data("Java LinkedList "+javaListTime+" "+"milliseconds", javaListTime);
        PieChart.Data slice3 = new PieChart.Data("ArrayList "+javaArrayListTime+" "+"milliseconds", javaArrayListTime);
        PieChart.Data slice4 = new PieChart.Data("HashSet "+javaHashSetTime+" "+"milliseconds", javaHashSetTime);
        PieChart.Data slice5 = new PieChart.Data("TreeSet "+javaTreeSetTime+" "+"milliseconds", javaTreeSetTime);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);

        pieChart.setLegendSide(Side.LEFT);

        primaryStage.setTitle("Time to add the same number of items to the collection");
        StackPane root = new StackPane(pieChart);
        Scene scene = new Scene(root, 800, 400);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
