package com.example.javavol2;

import java.util.Scanner;

public class aplikasiTodolist {
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        viewShowTodo();

    }

    /**
     * Menampilkan Todo List
     */
    public static void showTodo(){
        for(var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i+1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodo(){
        model[0] = "Aku belajar java";
        model[1] = "Aku belajar membuat aplikasi todo list";
        showTodo();
    }

    /**
     * Menambah todo list
     */
    public static void addTodo(String todo){
        //check model is full?
        var isFull = true;
        for (var i = 0; i < model.length; i++){
            if (model[i]==null){
                //model is not null
                isFull = false;
                break;
            }
        }

        if (isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (var i=0 ; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        //add new todo
        for (var i = 0 ; i < model.length; i++){
            if (model[i]== null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodo(){
        for (var i = 0; i < 30 ; i++){
            addTodo("Todo ke " + i);
        }
        showTodo();
    }

    /**
     * Menghapus todo list
     */
    public static boolean removeTodo(Integer number){
        if ((number-1) >= model.length){
            return false;
        }else if (model[number - 1]==null){
            return false;
        }else {
            for (int i = (number-1); i < model.length; i++){
                if (i == (model.length - 1)){
                    model[i] = null;
                }else {
                    model[i] = model[i+1]; //data ke i+1 akan bergeser menempati data di i
                }
            }
            return true;
        }
    }
    public static void testRemoveTodo(){
        for (var i = 0; i < 10 ; i++){
            addTodo("Todo ke " + (i+1));
        }
        var result  = removeTodo(10);
        System.out.println(result);
        showTodo();
    }

    /**
     * Input aplikasi todo list
     */
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
    public static void testInput(){
        var data =  input("Nama");
        System.out.println("Hi" + data);
    }

    /**
     * View Show todo list
     */
    public static void viewShowTodo(){
       while (true){
           showTodo();

           System.out.println("MENU : ");
           System.out.println("1. Tambah");
           System.out.println("2. Hapus");
           System.out.println("3. Keluar");

           var input = input("Pilih");
           if (input.equals("1")){
               viewAddTodo();
           }else if(input.equals("2")){
               viewRemoveTodo();
           }else if(input.equals("3")){
               break;
           }else {
               System.out.println("Pilihan tidak tersedia");
           }
       }

    }

    public static void testViewShowTodo(){
        addTodo("Satu");
        addTodo("Dua");
        addTodo("Tiga");

        viewShowTodo();
    }

    /**
     * View add todo list
     */
    public static void viewAddTodo(){
        System.out.println("Menambah todolist");
        var todo = input("Todo (x jika batal)");
        if (todo.equals("x")){
            //batal
        }else {
            addTodo(todo);
        }
    }

    public static void testViewAddTodo(){
        addTodo("Satu");
        addTodo("Dua");

        viewAddTodo();
        showTodo();
    }
    /**
     * View remove todo list
     */
    public static void viewRemoveTodo(){
        System.out.println("Menghapus todolist");

        var number = input("Todo (x jika batal)");
        if (number.equals("x")){
            //batal
        }else {
            boolean success= removeTodo(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus : "+ number);
            }
        }
    }

    public static void testViewRemoveTodo(){

        addTodo("Satu");
        addTodo("Dua");
        addTodo("Tiga");
        showTodo();

        viewRemoveTodo();
        showTodo();
    }
}
