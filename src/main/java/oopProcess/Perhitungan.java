/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopProcess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author dania
 */
public class Perhitungan {
    private List<Integer> nilaiInput = new ArrayList<>();
    
    // 1. Method Private Untuk Mengisi Data List Input Random
    private void initNilai(){
        int n = 25;
        int max = 10;
        for (int i = 0; i < n; i++) {
            nilaiInput.add(new Random().nextInt(max));
        }
    }
    
    // 2. Method Untuk Memfilter Nilai Duplikasi
    private List<Integer> filterDuplicate(){
        System.out.print("Input List : ");
        for (int i = 0; i < nilaiInput.size(); i++) {
            System.out.print(nilaiInput.get(i) + ", ");
        }
        System.out.println();
        return nilaiInput.stream().distinct().collect(Collectors.toList());
    }
    
    // 3. Method Untuk Menghitung Masing Masing Jumlah Nilai Dulikasi (Dari Proses No 2)
    private Map<Integer, Integer> countDuplicate(){
        int temp = 0;
        Map<Integer, Integer> valMap = new HashMap<>();
        List<Integer> newNoDuplicate = filterDuplicate();
        for (int i = 0; i < newNoDuplicate.size(); i++) {
            for (int j = 0; j < nilaiInput.size(); j++) {
                if(newNoDuplicate.get(i) == nilaiInput.get(j)){
                    temp += 1;
                }
            }
            valMap.put(newNoDuplicate.get(i), temp);
            temp = 0;
        }
        return valMap;
    }
    
    // 4. Method Private Untuk Mengurutkan Nilai List Yang Telah di Hitung Duplikasinya
    private void listSequence(){
        Map<Integer, Integer> newValMap = countDuplicate();
        System.out.println("Output : ");
        for (Map.Entry<Integer, Integer> me : newValMap.entrySet()) {
            System.out.println(me.getKey() +" : "+ me.getValue());
        }
    }
    
    // 5. Method Public Mengambil Nilai Akhir Process 4
    public Perhitungan(){
        initNilai();
        listSequence();
    }
}
