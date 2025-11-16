package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {

    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentPage;

    public BrowserHistory(String homepage) {
        currentPage = homepage;
        System.out.println("Browser dimulai di: " + homepage);
    }

    public void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
        System.out.println("Kunjungi: " + url);
    }

    public void back() {
        if (backStack.isEmpty()) {
            System.out.println("Tidak bisa kembali!");
            return;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        System.out.println("Kembali ke: " + currentPage);
    }

    public void forward() {
        if (forwardStack.isEmpty()) {
            System.out.println("Tidak bisa maju!");
            return;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        System.out.println("Maju ke: " + currentPage);
    }

    public void showHistory() {
        System.out.println("\n========= HISTORY =========");
        System.out.println("Back Stack   : " + backStack);
        System.out.println("Current Page : " + currentPage);
        System.out.println("Forward Stack: " + forwardStack);
        System.out.println("===========================\n");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Homepage: ");
        String home = input.nextLine();

        BrowserHistory browser = new BrowserHistory(home);

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Visit URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Show History");
            System.out.println("5. Exit");
            System.out.print("Pilih: ");

            int pilih = input.nextInt();
            input.nextLine(); // konsumsi enter

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan URL: ");
                    String url = input.nextLine();
                    browser.visit(url);
                    break;

                case 2:
                    browser.back();
                    break;

                case 3:
                    browser.forward();
                    break;

                case 4:
                    browser.showHistory();
                    break;

                case 5:
                    System.out.println("Keluar...");
                    return;

                default:
                    System.out.println("Pilihan tidak ada!");
            }
        }
    }
}
