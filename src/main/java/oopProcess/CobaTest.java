/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
/**
 *
 * @author dania
 */
public class CobaTest {
    public static void main(String[] args) {
        System.out.println("Learning Array List");
        System.out.println("-------------------");
        List<Integer> ListNilai = new ArrayList<>();
        List<Integer> listMatch = new ArrayList<>();
        int n = 200;
        int max = 30;
        int nMatch = 50;
        int maxMatch = 20;
        for (int i = 0; i < n; i++) {
            ListNilai.add(new Random().nextInt(max));
        }
        
        for (int i = 0; i < nMatch; i++) {
            listMatch.add(new Random().nextInt(maxMatch));
        }
        
        // Clear Duplicate
        List<Integer> ListNilai2 = ListNilai.stream().distinct().collect(Collectors.toList());
        List<Integer> listMatch2 = listMatch.stream().distinct().collect(Collectors.toList());
        
        // Result List Nilai and Match
        System.out.print("List Nilai NonDuplicate : ");
        for (int i = 0; i < ListNilai2.size(); i++) {
            System.out.print(ListNilai2.get(i) + ", ");
        }
        System.out.println();
        System.out.print("List Match NonDuplicate : ");
        for (int i = 0; i < listMatch2.size(); i++) {
            System.out.print(listMatch2.get(i) + ", ");
        }
        System.out.println();
        
        // Call Function/Procedure ListNilaiTerdaftar
        List<Integer> finalResult = getListNilaiTerdaftar(ListNilai2, listMatch2);
        
        // Call Final Result
        System.out.print("List Result : ");
        for (int i = 0; i < finalResult.size(); i++) {
            System.out.print(finalResult.get(i) + ", ");
        }
        
        // return nilai dari method getListNilaiTerdaftar
        // dimana membandingkan nilai2 yang ada di listMatch terhadap ListNilai
        // tampilkan / return list angka yang hanya ada pada ListNilai   
    }
    
    private static List<Integer> getListNilaiTerdaftar(List<Integer> ListNilaiTemp, List<Integer> ListMatchTemp) {
        
        // Bandingkan Antara ListNilai dan ListMatch
        List<Integer> newCheck = new ArrayList<>();
        for (int i = 0; i < ListMatchTemp.size(); i++) {
            for (int j = 0; j < ListNilaiTemp.size(); j++) {
                if(ListMatchTemp.get(i) == ListNilaiTemp.get(j)){
                    newCheck.add(ListMatchTemp.get(i));
                }
            }
        }
        
        return newCheck;
    }
}
